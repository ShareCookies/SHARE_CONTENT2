重入锁：
	public class ReentrantLock ..{
		public ReentrantLock(boolean fair) {
			sync = fair ? new FairSync() : new NonfairSync();
		}
		public void lock() {
			sync.lock();
		}
		//为什么锁要最终释放：
			//但ReentrantLock中lock方法可以被同一线程多次调用，
				重入锁对于同一线程获取会进行计数自增，
					计数表示当前锁被重复获取的次数，
			
			//释放时，传给同步器的释放方法参数为1，即只进行一次释放
				锁释放时当计数等于0时表示锁已经成功释放。
				
			//所以lock的次数要与unlock的次数一样
		public void unlock() {
			sync.release(1);
		}
	}
抽象队列同步器：	
	//抽象队列同步器
	public abstract class AbstractQueuedSynchronizer .. {
		// 独占式获取同步状态，//即独占式让当前线程持有锁
		//抽象队列定义的模板方法
		// 解析：AbstractQueuedSynchronizer队列同步器原理.txt goto：独占式同步状态获取与释放
		public final void acquire(int arg) {
			if (!tryAcquire(arg) &&
				acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
				selfInterrupt();
		}
		
		
		// 尝试独占式设置同步状态
		//使用acquire方法需要实现的方法
		protected boolean tryAcquire(int arg) {
			throw new UnsupportedOperationException();
		}
		// 独占式的释放同步状态，
			//该方法会在释放同步状态之后，将同步队列中第一个节点包含的线程唤醒
		//抽象队列定义的模板方法
		public final boolean release(int arg) {
			if (tryRelease(arg)) {
				Node h = head;
				if (h != null && h.waitStatus != 0)
					unparkSuccessor(h);
				return true;
			}
			return false;
		}
		//独占式释放同步状态
		//使用release方法需要实现的方法
		protected boolean tryRelease(int arg) {
			throw new UnsupportedOperationException();
		}
	}
重入锁实现的同步器：
	/**
     * Base of synchronization control for this lock. Subclassed
     * into fair and nonfair versions below. Uses AQS state to
     * represent the number of holds on the lock.
     */
	//同步器
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        /**
         * Performs {@link Lock#lock}. The main reason for subclassing
         * is to allow fast path for nonfair version.
         */
        abstract void lock();

        /**
         * Performs non-fair tryLock.  
		 tryAcquire is implemented in subclasses, but both need nonfair try for trylock method.
         */
		
		// 获取同步状态，为0则尝试快速让线程持有锁
		// acquires表示状态值(要获取次数)，一般都为1
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
			//可重入实现
			//该方法增加了同个线程再次获取同步状态的处理逻辑：
				//通过判断当前线程是否为获取锁的线程来 决定获取操作是否成功，
				//如果是获取锁的线程再次请求，则将同步状态值进行增加并返回 true，表示获取同步状态成功。
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
			//可以看到，该方法将同步状态是否为0作为最终释放的条件，
			//当同步状态为0时，将占有线程设置为null，并返回true，表示释放成功
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        protected final boolean isHeldExclusively() {
            // While we must in general read state before owner,
            // we don't need to do so to check if current thread is owner
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        // Methods relayed from outer class

        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        final int getHoldCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        final boolean isLocked() {
            return getState() != 0;
        }

        /**
         * Reconstitutes the instance from a stream (that is, deserializes it).
         */
        private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }
	
    /**
     * Sync object for non-fair locks
     */
非公平同步器
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = 7316153563782823691L;

        /**
         * Performs lock.  
		 Try immediate barge, backing up to normal acquire on failure.
		 尝试立刻驳船(获取同步状态),失败则回到常规的同步状态获取方式来获取同步状态
         */
        final void lock() {
			//快速获取锁：通过cas尝试把状态设为1 成功则只能当前线程访问
            if (compareAndSetState(0, 1))
				// 就是标记下当前持有锁的线程是谁
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }
		
        protected final boolean tryAcquire(int acquires) {
            return nonfairTryAcquire(acquires);
        }
    }
    /**
     * Sync object for fair locks
     */
公平同步器
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -3000897897090466540L;

        final void lock() {
            acquire(1);
        }

        /**
         * Fair version of tryAcquire.  Don't grant access unless
         * recursive call or no waiters or is first.
		 
         */
        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
				// 公平与非公平获取锁的实现：
					// 与非公平锁对比判断条件多了 hasQueuedPredecessors()方法，
					// 即同步队列中当前节点是否有前驱节点的判断，
					// 如果该方法返回true，则表示有线程比当前线程更早地请求获取锁，
					// 因此需要等待前驱线程获取并释 放锁之后才能继续获取锁。
						//？那前驱线程会怎么和什么时候被唤醒了(同步队列线程如何被唤醒？)
                if (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
    }
附：
	protected final boolean compareAndSetState(int expect, int update) {
        // See below for intrinsics setup to support this
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }