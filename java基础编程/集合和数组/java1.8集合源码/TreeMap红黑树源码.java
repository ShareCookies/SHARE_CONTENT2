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
	//首先，要确定当结点z被插人并着为红色后，红黑性质中有哪些不能继续保持。
	//仅可能被破坏的就是性质2和性质4。
	//如果性质2被破坏，其原因为z是根结点且是红结点。
	//如果性质4被破坏，其原因为z和z. p都是红结点。
						
private void fixAfterInsertion(Entry<K,V> x) {
	//为什么上红色。因为上红色简单，如维护了黑节点个数相同性质。
	//这里怎么没有红黑树叶节点的概念了？红黑树叶节点干嘛用了？
	x.color = RED;
	//修复性质4
	while (x != null && x != root && x.parent.color == RED) {// 父节点为红破坏了红下2黑性质
		if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {//z的父节点为左节点的修复方式
			Entry<K,V> y = rightOf(parentOf(parentOf(x)));
			if (colorOf(y) == RED) { //z的叔父节点为红时
				//此时情况：z红，父为左节点且红，叔父节点红，祖父节点黑。
				//修复策略：
				//父节点上黑（红下要2黑）。叔父节点上黑色，祖父节点上红（黑节点数要一样）
				// z指针指向祖父节点（因为改变了祖父节点颜色，可能影响红下要2黑性质）
					//后面回到while重新判断是否有被破坏规则
				setColor(parentOf(x), BLACK);
				setColor(y, BLACK);
				setColor(parentOf(parentOf(x)), RED);
				x = parentOf(parentOf(x));
			} else {
				if (x == rightOf(parentOf(x))) {
				//此时情况：z红且为右节点，父为左节点且红，z叔父节点为黑(或空？)
				//修复策略：
					// z节点指针上升到父节点并左旋。
					//（
						// 首先左旋二叉搜索数性质不变。
						// 然后旋转后各分支黑节点颜色数量不变，因为z.p 完整的接管了z的左分支， 原先z的左分支就和z右分支和z.p左分支（包括z.p右分支）黑节点数同。
						// 此处左旋的目的就是把红的变为左节点，至于为什么，结合下面右旋，画图即可知。
						// 下面右旋的目的就是把，原先的父父节点拉下来，变为（黑节点的）右节点。因为这样就可使 被改变节点  变为右子节点 不会影响再上层节点的红黑树性质。即可控
					// ）
					x = parentOf(x);
					rotateLeft(x);
				}
				//此时情况：z红且为左节点，父为左节点且红，z叔父节点为空。祖父黑
					//此时一定为 祖父黑 父左红 z左红 这种情况
				//修复策略：夫变黑，祖父变红，祖父右旋。（首先颜色变后右旋修正了红下2黑，并且夫是以黑（同颜色）替换了祖父的未知。所以维持了红黑树性质。）
				setColor(parentOf(x), BLACK);
				setColor(parentOf(parentOf(x)), RED);
				rotateRight(parentOf(parentOf(x)));

			}
		} else { //z的父节点为右节点的修复方式
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


