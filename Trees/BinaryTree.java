package Trees;
import java.util.*;
public class BinaryTree<E> extends AbstractBinaryTree<E>{
	public static class TreeNode<E> implements Node<E> {
		private E e;
		private TreeNode<E> left;
		private TreeNode<E> right;
		private TreeNode<E> parent;
		TreeNode(E e, TreeNode<E> parent, TreeNode<E> left, TreeNode<E> right) {
			this.e = e;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		TreeNode(E e) {
			this(e, null, null, null);
		}
		
	}
	protected TreeNode<E> createNode(E e, TreeNode<E> p, TreeNode<E> l, TreeNode<E> r) {
		return new TreeNode<E>(e, p, l, r);
	}
	
	protected TreeNode<E> root = null;
	private int size = 0;
	
	
	public int size() { return size;}
	public TreeNode<E> root() { return root;}
	public TreeNode<E> parent(TreeNode<E> p) {return p.parent;}
	
	public TreeNode<E> left(TreeNode<E> p) {return p.left;}
	
	public TreeNode<E> right(TreeNode<E> p)  {return p.right;}
	
	public TreeNode<E> addRoot(E e) throws IllegalStateException {
		if(root() != null) throw new IllegalStateException("root exist");
		root = createNode(e, null, null, null);
		size++;
		return root;
	}
	public TreeNode<E> addLeft(TreeNode<E> p, E e)
			throws IllegalArgumentException {
		if(left(p) != null) throw new IllegalStateException("righ child exist");
		p.left = createNode(e, p, null, null);
		size++;
		return p.left;
	}
	
	public TreeNode<E> addRight(TreeNode<E> p, E e)
			throws IllegalArgumentException {
		if(right(p) != null) throw new IllegalStateException("righ child exist");
		p.right = createNode(e, p, null, null);
		size++;
		return p.right;
	}
	public E set(TreeNode<E> p, E e) throws IllegalArgumentException {
		if(p == null) throw new IllegalArgumentException("node not exist");
		E tmp = p.e;
		p.e = e;
		return tmp;
	}
	
	public void attach(TreeNode<E> p, BinaryTree<E> t1,
			 BinaryTree<E> t2) throws IllegalArgumentException {
		if(!isExternal(p)) throw new IllegalArgumentException("p not external");
		TreeNode<E> r1 = t1.root(), r2 = t2.root();
		if(r1 != null) {
			p.left = r1;
			r1.parent = p;
		}
		if(r2 != null) {
			p.right = r2;
			r2.parent = p;
		}
		size += t1.size() + t2.size();
		t1.root = t2.root = null;
		t1.size = t2.size = 0;
	}
	
	public E remove(TreeNode<E> p) throws IllegalArgumentException {
		if(numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
		if(p == null) throw new IllegalArgumentException("p is null");
		TreeNode<E> parent = p.parent;
		TreeNode<E> child = null;
		if(p.left != null) child = p.left;
		else if(p.right != null) child = p.right;
		if(child != null) child.parent = parent;
		if(parent == null) {
			root = child;
		}
		else {
			if(parent.left == p) parent.left = child;
			else parent.right = child;
		}
		size--;
		E tmp = p.e;
		p.left = p.right = p.parent = null;
		return tmp;
	}
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	public Iterator<TreeNode<E>> nodes() {
		return preorder().iterator();
	}
	
	private class ElementIterator implements Iterator<E> {	
		Iterator<TreeNode<E>> node_iter = nodes();
		public boolean hasNext() {return node_iter.hasNext();}
		public E next() {return node_iter.next().e;}
		public void remove() {node_iter.remove();}
	}
	public Iterable<TreeNode<E>> preorder() {
		ArrayList<TreeNode<E>> list = new ArrayList<>();
		helper(root, list);
		return list;
	}
	
	public void helper(TreeNode<E> n, ArrayList<TreeNode<E>> list) {
		if(n == null) return;
		list.add(n);
		helper(n.left, list);
		helper(n.right, list);
	}
	
}