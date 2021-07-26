public V put(K key, V value) {
	Entry<K,V> t = root;
	// 初始化根节点
	if (t == null) {
		compare(key, key); // type (and possibly null) check

		root = new Entry<>(key, value, null);
		size = 1;
		modCount++;
		return null;
	}
	int cmp;
	Entry<K,V> parent;
	// split comparator and comparable paths
	Comparator<? super K> cpr = comparator;
	// 通过比较器插入
	if (cpr != null) {
		do {
			parent = t;
			cmp = cpr.compare(key, t.key);
			if (cmp < 0)
				t = t.left;
			else if (cmp > 0)
				t = t.right;
			else
				return t.setValue(value);
		} while (t != null);
	}
	// 自然顺序比较，有相等就替换值返回。
	else {
		if (key == null)
			throw new NullPointerException();
		@SuppressWarnings("unchecked")
			Comparable<? super K> k = (Comparable<? super K>) key;
		do {
			parent = t;
			cmp = k.compareTo(t.key);
			if (cmp < 0)
				t = t.left;
			else if (cmp > 0)
				t = t.right;
			else
				return t.setValue(value);
		} while (t != null);
	}
	Entry<K,V> e = new Entry<>(key, value, parent);
	// 比较后，插入。
	if (cmp < 0)
		parent.left = e;
	else
		parent.right = e;
	// 维护红黑树性质
	fixAfterInsertion(e);
	size++;
	modCount++;
	return null;
}
/** From CLR */
//恢复插入后搜索树的红黑性质。
	首先，要确定当结点z被插人并着为红色后，红黑性质中有哪些不能继续保持。
	仅可能被破坏的就是性质2和性质4。
	如果性质2被破坏，其原因为z是根结点且是红结点。
	如果性质4被破坏，其原因为z和z. p都是红结点。
						
private void fixAfterInsertion(Entry<K,V> x) {
	//为什么上红色。因为上红色简单如要维护性质黑节点个数相同。此时叶节点黑色被破坏了
	//这里怎么没有红黑树叶节点的概念了？红黑树叶节点干嘛用了？
	x.color = RED;
	//修复性质4
	while (x != null && x != root && x.parent.color == RED) {
		if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
			Entry<K,V> y = rightOf(parentOf(parentOf(x)));
			if (colorOf(y) == RED) {
				setColor(parentOf(x), BLACK);
				setColor(y, BLACK);
				setColor(parentOf(parentOf(x)), RED);
				x = parentOf(parentOf(x));
			} else {
				if (x == rightOf(parentOf(x))) {
					x = parentOf(x);
					rotateLeft(x);
				}
				setColor(parentOf(x), BLACK);
				setColor(parentOf(parentOf(x)), RED);
				rotateRight(parentOf(parentOf(x)));
			}
		} else {
			Entry<K,V> y = leftOf(parentOf(parentOf(x)));
			if (colorOf(y) == RED) {
				setColor(parentOf(x), BLACK);
				setColor(y, BLACK);
				setColor(parentOf(parentOf(x)), RED);
				x = parentOf(parentOf(x));
			} else {
				if (x == leftOf(parentOf(x))) {
					x = parentOf(x);
					rotateRight(x);
				}
				setColor(parentOf(x), BLACK);
				setColor(parentOf(parentOf(x)), RED);
				rotateLeft(parentOf(parentOf(x)));
			}
		}
	}
	//修复性质2
	root.color = BLACK;
}






  Balancing operations.
     Implementations of rebalancings during insertion and deletion are slightly different than the CLR version.  
Rather than using dummy  nilnodes, we use a set of accessors that deal properly with null.  
They are used to avoid messiness surrounding nullness checks in the main algorithms.