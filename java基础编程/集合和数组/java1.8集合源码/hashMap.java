前言：
	什么是Hash表：
		1. 哈希表是基于哈希函数建立的一种映射表。
			就当作它是一个数组就好
		2. hash函数根据key(hashCode)计算出应该存储在哈希表上那个位置.
			就是hash值取余 数组大小 得到的值就是这个元素要存在数组的那个位置
总结：
	新增：（简版）
		1. 获取key的hash。
		
		2. 找key在哈希表数组上的位置
			tab[i = (n - 1) & hash] //找插入数据的hash在数组中位//(n - 1) & hash 等于hash % n 
				
		2.1 当key对应位置无值时，插入元素。
		2.2 当key对应位置有值时：
			1. if 如果key与旧key是一样的则覆盖插入。
				如何判断是一样的：两key的hash相等 且(两key内存地址一样或equal对比相等)
				if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
			2. else if // 如果旧节点是红黑树节点，则直接在树中插入(or更新键值对)
				else if (p instanceof TreeNode)
					// 如果当前的bucket里面已经是红黑树的话，执行红黑树的添加操作
					e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);						
				
			3. else // 把节点往链表中插入 or 更新键值对，
			//(当链表长度过长时，链表可能会转为红黑树)
			
				for (int binCount = 0;; ++binCount)
				{
					//下个链节点为空插入
					if ((e = p.next) == null)
					{
						p.next = newNode(hash, key, value, null);
						// 扩容或红黑树化
						if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
							treeifyBin(tab, hash);
						break;
					}
					//和下个链接点等则替换
					if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
						break;
					p = e;
				}


	附：
		hashmap知识点总结.txt
源码：		
新增：
	public V put(K key, V value) {
		return putVal(hash(key), key, value, false, true);
	}
	
	1. 插入键值对时，先获取key的hash。
		static final int hash(Object key) {
			int h;
			return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		}
		Object自带hashCode方法：
			* @return  a hash code value for this object.
			* (This is typically implemented by converting the internal address of the object into an integer 
				所以可理解为hashcode为内存地址，但不同对象可能有同个hashcode
			public native int hashCode();
			jvm为对象生成的关键码值(hashCode散列值),关键码值是根据一定的规则将与对象相关的信息（比如对象的存储地址，对象的字段等）映射成一个数值，这个数值称作为散列值。
				
			https://louluan.blog.csdn.net/article/details/41547649?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control
		^ (h >>> 16)
			https://www.cnblogs.com/chuijingjing/p/9405598.html
			https://www.cnblogs.com/yesiamhere/p/6675067.html
			无符号右移，异或
	2. 找key在哈希表数组上的位置
		/**
		 * Implements Map.put and related methods.
		 *
		 * @param hash hash for key
		 * @param key the key
		 * @param value the value to put
		 * @param onlyIfAbsent if true, don't change existing value
		 * @param evict if false, the table is in creation mode.
		 * @return previous value, or null if none
		 */
		 
		final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
				Node<K,V>[] tab; Node<K,V> p; int n, i;
				// 1. 如果表为空，初始化hash表(就是一个数组)
				if ((tab = table) == null || (n = tab.length) == 0)
					n = (tab = resize()).length;
/*
	tab[i = (n - 1) & hash] //找插入数据的hash在数组中位置(就是找当前要插入的数据应该在哈希表中的位置)
		(n - 1) & hash 等于hash % n 
		？？？
		https://blog.csdn.net/argleary/article/details/100940228
		https://blog.csdn.net/q2365921/article/details/96031412?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
*/
				//2 插入
				//2.1 当key对应位置无值时，插入元素。
				// 
				if ((p = tab[i = (n - 1) & hash]) == null)
					tab[i] = newNode(hash, key, value, null);
				//2.2 当key对应位置有值时：
				else {
					Node<K,V> e; K k;
					/*
					2.2.1 if 如果key与旧key是一样的则覆盖插入。
						如何判断是一样的：
							两key的hash相等 且(两key内存地址一样或equal对比相等)
						是否覆盖插入操作是在最后的if中。
					*/
					if (p.hash == hash &&
						((k = p.key) == key || (key != null && key.equals(k))))
						e = p;
					
					//2.2.2 如果是红黑树节点，执行红黑树的添加操作(直接在树中插入 or 更新键值对)
					else if (p instanceof TreeNode)
						e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
					
					//2.2.3 此时通过链表来解决hash冲突
					else {
						// 不断遍历链表,直到把节点往链表中插入 or 更新键值对
						// 当链表长度过长时，链表可能会转为红黑树
						for (int binCount = 0; ; ++binCount) {
							//插入 //p链节点下个节点为null则，元素插入到下个节点
							if ((e = p.next) == null) {
								p.next = newNode(hash, key, value, null);
								//扩容
								//当链表长度大于树形阈值，扩容为红黑树
								//static final int TREEIFY_THRESHOLD = 8;树形阈值
								// 当前链?
								if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
									//替换给定哈希索引处 bin 中的所有链接节点，除非表太小，在这种情况下改为调整大小。
									treeifyBin(tab, hash);
								break;
							}
							//替换 
							//p下个链节点，key与旧key是同元素，则覆盖插入。
							//附1：覆盖插入代码指，跳出循环value在下面的if中赋值。
							//附2：是否同元素判断同上
							if (e.hash == hash &&
								((k = e.key) == key || (key != null && key.equals(k))))
								break;
							p = e;
						}
					}
					//有存在对应key的映射，把值插入其中。
					if (e != null) { // existing mapping for key
						V oldValue = e.value;
						if (!onlyIfAbsent || oldValue == null)
							e.value = value;
						//空实现，LinkedHashMap的专用回调方法	
						afterNodeAccess(e);
						return oldValue;
					}
				}
				
				++modCount;
				//在hashmap中新增一个值后，
				//当大小大于阈值时，扩容
				if (++size > threshold)
					resize();
				//空实现，LinkedHashMap的专用回调方法
				// Callbacks to allow LinkedHashMap post-actions
				afterNodeInsertion(evict);
				return null;							
			}
附：
红黑树解决hash冲突：
    /**
     * The table, initialized on first use, and resized as necessary. 
	 When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     */
	 //节点数组，hashmap中用他来存放元素
    transient Node<K,V>[] table;
	/**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     */
    static final int MIN_TREEIFY_CAPACITY = 64;
    /**
	 * 替换给定哈希索引处 bin 中的所有链接节点，除非表太小，在这种情况下改为调整大小。
     * Replaces all linked nodes in bin at index for given hash unless
     * table is too small, in which case resizes instead.
     */
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
		//链表长度大于8且hashtable的长度大于64
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
		//链表红黑树化
        else if ((e = tab[index = (n - 1) & hash]) != null) {
			// do while走完仅是把链表上节点替换为树节点
			// hd根节点 // t1 保存前置节点的
            TreeNode<K,V> hd = null, tl = null;
            do {
				//生成树节点
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
			//红黑树化
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }
	TreeNode<K,V> replacementTreeNode(Node<K,V> p, Node<K,V> next) {
        return new TreeNode<>(p.hash, p.key, p.value, next);
    }
	static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next) {
            super(hash, key, val, next);
        }
	}
	/**
	?
	 * Forms tree of the nodes linked from this node.
	 ？HashMap红黑树树化过程
						https://www.cnblogs.com/finite/p/8251587.html
			

	 */
	final void treeify(Node<K,V>[] tab) {
		TreeNode<K,V> root = null;
		for (TreeNode<K,V> x = this, next; x != null; x = next) {
			next = (TreeNode<K,V>)x.next;
			x.left = x.right = null;
			if (root == null) {
				x.parent = null;
				x.red = false;
				root = x;
			}
			else {
				K k = x.key;
				int h = x.hash;
				Class<?> kc = null;
				for (TreeNode<K,V> p = root;;) {
					int dir, ph;
					K pk = p.key;
					if ((ph = p.hash) > h)
						dir = -1;
					else if (ph < h)
						dir = 1;
					else if ((kc == null &&
							  (kc = comparableClassFor(k)) == null) ||
							 (dir = compareComparables(kc, k, pk)) == 0)
						dir = tieBreakOrder(k, pk);

					TreeNode<K,V> xp = p;
					if ((p = (dir <= 0) ? p.left : p.right) == null) {
						x.parent = xp;
						if (dir <= 0)
							xp.left = x;
						else
							xp.right = x;
						root = balanceInsertion(root, x);
						break;
					}
				}
			}
		}
		moveRootToFront(tab, root);
	}

hashmap扩容：？
	/**
	 * The table, initialized on first use, and resized as
	 * necessary. When allocated, length is always a power of two.
	 * (We also tolerate length zero in some operations to allow
	 * bootstrapping mechanics that are currently not needed.)
	 */
	/*
		表，在第一次使用时初始化，并根据需要调整大小。
		transient:
			属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
	*/

	transient Node<K,V>[] table;
	/**
     * The bin count threshold for using a tree rather than list for a
     * bin.  Bins are converted to trees when adding an element to a
     * bin with at least this many nodes. The value must be greater
     * than 2 and should be at least 8 to mesh with assumptions in
     * tree removal about conversion back to plain bins upon
     * shrinkage.
     */
    static final int TREEIFY_THRESHOLD = 8;
	/**
     * The next size value at which to resize (capacity * load factor).
     * 要调整大小的下一个大小值（容量*负载系数）
     * @serial
     */
    // (The javadoc description is true upon serialization.
    // Additionally, if the table array has not been allocated, this
    // field holds the initial array capacity, or zero signifying
    // DEFAULT_INITIAL_CAPACITY.)
    int threshold;	
	/**
     * The number of key-value mappings contained in this map.
     */
    transient int size;
	/**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
		最大容量，10亿
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;
	/**
     * The default initial capacity - MUST be a power of two.
	 默认初始容量， 16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	/**
	 * Initializes or doubles table size.  If null, allocates in
	 * accord with initial capacity target held in field threshold.
	 * Otherwise, because we are using power-of-two expansion, the
	 * elements from each bin must either stay at same index, or move
	 * with a power of two offset in the new table.
	 *
		将表格大小初始化或加倍。
		如果为空，则根据字段阈值中保留的初始容量目标进行分配。
		否则，因为我们使用的是二次幂展开，所以每个容器中的元素必须保持在相同的索引中，或者在新表中以二次幂偏移量移动。
	 * @return the table
	 */
	//初始化或加倍表大小。
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
		//旧hashmap容量大于0
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
			// 旧hashmap容量大于16，且扩大2倍还小于最大容量，则新阈值翻倍
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
		//旧阈值大0，
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
		// 使用默认的初始容量
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {//新阈值为空，则为其计算赋值
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
		//初始化hash表
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
		//翻倍hash表
        if (oldTab != null) {
			//遍历旧hash表
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
					//置空旧hash表
                    oldTab[j] = null;
					//无下个元素，即仅一个元素。
                    if (e.next == null)
						//旧hash表元素赋值到新hash表
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
						//树节点元素重赋值？
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
						//链表重新赋值到新hashmap？
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
//?
https://blog.csdn.net/u010425839/article/details/106620440/
https://blog.csdn.net/zhxue123/article/details/8648413
https://www.cnblogs.com/lukelook/p/11275003.html
https://blog.csdn.net/u014683368/article/details/81124138
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

