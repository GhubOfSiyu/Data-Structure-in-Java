package SearchTrees;
		protected static class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>> {
			int aux = 0;
			BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rigtChild) {
				super(e, parent, leftChild, rightChild);
			}
			public int getAux() {return aux;}
			public void setAux(int value) {aux = value;}
		}

		//factory function
		protected Node<Entry<K,V> createNode(Entry<K,V> e, Node<Entry<K,V>> parent, Node<Entry<K,V>> left, Node<Entry<K,V>> right) {
			return new BSTNode<>(e, parent, left, right);
		}

		private void relink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child, boolean makeLeftChild) {
			child.setParent(parent);
			if(makeLeftChild) parent.setLeft(child);
			else parent.setRight(child);
		}

	public void rotate(Node<Entry<K,V>> x) {
		Node<Entry<K,V>> x = validate(p);
		Node<Entry<K,V>> y = x.getParent();
		Node<ENtry<K,V>> z = y.getParent();
		if(z == null) {
			root = x;
			x.setParent(null);
		}
		else  
			relink(z, x, y == z.getLeft());
		if(x == y.getLeft()) {
			relink(y, x.getRight(), true);
			relink(x, y, false);
		}
		else{
			relink(y, x.getLeft(), false);
			relink(x, y, true);
		}
	}

	public Node<Entry<K,V>>  restructure(Node<Entry<K,V>> x) {
		Node<Entry<K,V>> y = parent(x);
		Node<Entry<K,V>> z = parent(y);
		if(((x == right(y)) == ((y == right(z))) ||
			((x == left(y)) == ((y == left(z)))) {
				rotate(y);
				return y;
			}
		else {
			rotate(x);
			rotate(x);
			return x;
		}
	}
｝

public class BSTreeMap<K,V> extends AbstractSortedMap<K,V> {
	protected BalancebleBinaryTree<K,V> tree =new BalanceableBinaryTree<>();
	public TreeMap() {
		super(comp);
		tree.addRoot(null);
	}
	public TreeMap(<Comparator<K> comp) {
		super(comp);
		tree.add(null);
	}
	public int size() {return (tree.size() - 1) / 2;}
	private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
		tree.set(p, entry);
		tree.addLeft(p, null);
		tree.addRight(p, null);
	}
	protected TreeNode<Entry<K,V>> root() {return tree.root();}
	private TreeNode<Entry<K,V>> treeSearch(TreeNode<Entry<K,V>> p, K key) {
		if(isExternal(p)) return p;
		int comp = compare(key, p.getValue());
		if(comp > 0) return treeSearch(right(p), key);
		else if(comp < 0) return treeSearch(left(p), key);
		else return p;
	}
	public V get(K key) {
		TreeNode<Entry<K,V>> tn = treeSearch(root, key);
		if(isExternal(tn)) return null;
		return tn.getValue().getValue();
	}

	public V put(K key, V v) {
		TreeNode<Entry<K,V>> tn = treeSearch(root, key);
		Entry<K,V> tmp = new Entry<K,V>(k, v);
		if(isExternal(tn)) {
			expandExternal(tn, tmp);
			return null;
		else {
			V old = tn.getElement().getValue();
			tn.set(tn, tmp);
			return old;
		}
	}

	public V remove(K key) {
		TreeNode<Entry<K,V>> p = treeSearch(root, key);
		if(isExternal(tn)) return null;
		else {
			V old = p.getElement().getValue();
			if(isInternal(left(p)) && isInternal(right(p))) {
				TreeNode<Entry<K,V>> replacement = treeMax(left(p));
				set(p, replacement.getElement());
				p = replacement;
			}
		}
		TreeNode<Entry<K,V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
		TreeNode<Entry<K,V>> sib = sibling(leaf);
		remove(leaf);
		remove(p);
		rebalanceDelete(sib);
		return old;
	}

	protected TreeNode<Entry<K,V>> treeMax(TreeNode<Entry<K,V>> p) {
		TreeNode<Entry<K,V>> walk = p;
		while(!isInternal(walk)) walk = right(walk);
		return parent(walk); 
	}

	public Entry<K,V> lastEntry() {
		if(isEmptry()) return null;
		return treeMax(root()).getElement();
	}
	public Entry<K,V> floorEntry(K key) {
		TreeNode<Entry<K,V>> tn = treeSearch(root, key);
		if(isInternal(tn)) return tn;
		while(tn != root) {
			if(tn = right(parent(tn))) return parent(tn);
			else p = parent(p);
		}
		return null;
 	}
 	public Entry<K,V> lowerEntry(K key) {
 		TreeNode<Entry<K,V>> tn = treeSearch(root, key);
		if(isInternal(tn) && isInternal(left(p))) return treeMax(left(p));
		while(tn != root) {
			if(tn = left(parent(tn))) return parent(tn);
			else p = right(p);
		}
		return null;
 	}

 	public Iterable<Entry<K,V>> entrySet() {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		for (Position<Entry<K,V>> p : tree.inorder())
			if (isInternal(p)) buffer.add(p.getElement()); 
		return buffer;
	}

	public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		if(compare(fromKey, toKey) < 0) subMapRecurse(fromkey, toKey, root(), buffer);
		return buffer;
	}
	public void subMapRecurse(K fromKey, K toKey, TreeNode<Entry<K,V>> p,ArrayList<Entry<K,V>> buffer) {
		if(isInternal(p)) {
			if(compare(p.getElement(), fromKey) < 0) subMapRecurse(fromKey, toKey, right(p), buffer);
			else {
				subMapRecurse(fromKey, toKey, left(p), buffer);
				if(compare(p.getElemetn(), toKey) < 0) {
					buffer.add(p.getElement());
					subMapRecurse(fromKey, tokey, right(p), buffer);
				}
			}
		}

	}

}


public class AVLTreeMap<K,V> extends TreeMap<K,V> {
	public AVLTreMap() {super();}
	public AVLTreeMap(Comparator<K> comp) {super(comp);}
	protected int height(Position<Entry<K,V>> p) {
		return tree.getAux(p);
	}
	protected void recomputeHeight(Node<Entry<K,V>> p){

		tree.setAux(p, 1+Math.max(height(left(p)), height(right(p))));
	}

	protected boolean isBalaced(Node<ENtry<K,V>> p) {
		return Math.abs(height(left(p)) - height(right(p))) <= 1;
	}
	protected Node<Entry<K,V>> tailerChild(Node<Entry<K,V>> p) {
		if(height(left(p)) > height(right(p))) return left(p);
		if(height(left(p)) < height(right(p))) return right(p);
		if(isRoot(p)) return left(p);
		if(p == left(parent(p))) return left(p);
		else return right(p);
	}
	protected void rebalance(Node<Entry<K,V>> p) {
		int oldHeight, newHeight;
		do {
			oldHeight = height(p);
			if(!Balacned(p)) {
				p = restructure(tallerChild(tallerChild(p)));
				recomputeHeight(left(p));
				recomputeHeight(right(p));
			}
			recomputeHeight(p);
			newHeight = height(p);
			p = parent(p);
			}while(oldHeight != newHeight && p != null)
		}
	}

	protected void rebalanceInsert(Node<Entry<K,V>> p) {

		rebalance(p);
	}

	protected void rebalanceDelete(Position<Entry<K,V>> p) {
		if(!isRoot(p)) rebalance(parent(p));
	}

}