package snippet;
import java.util.*;

class BST<E extends Comparable> {
	private class TreeNode<E extends Comparable> {
		E val;
		int numChildren;
		TreeNode<E> left;
		TreeNode<E> right;
		TreeNode<E> parent;
		public TreeNode(E val) {
			this.val = val;
		}
	}
	
	private int size = 0;
	private TreeNode<E> root = null;
	private TreeNode<E> search(TreeNode<E> tn, E e) {
		if(tn == null) return null;
		TreeNode<E> result = tn;
		if(tn.val == e) return tn;
		else if(tn.val.compareTo(e) > 0) {
			if(tn.left != null) result = search(tn.left, e);
		}
		else {
			if(tn.right != null) result = search(tn.right, e);
		}
		
		return result;
	}
	
	private int depth(TreeNode<E> tn) {
		if(tn == null) return 0;
		return Math.max(depth(tn.left), depth(tn.right)) + 1;
	}
	
	public void insert(E e) {
		TreeNode<E> newNode = new TreeNode<>(e);
		if(root == null) root = newNode;
		TreeNode<E> pos = search(root, e);
		if(pos.val.equals(e)) return;
		if(pos.val.compareTo(e) > 0) pos.left = newNode;
		else pos.right = newNode;	
		newNode.parent = pos;
		while(pos != null) {
			pos.numChildren++;
			pos = pos.parent;
		}
	}
	
	private TreeNode findMax(TreeNode tn) {
		if(tn == null) return null;
		while(tn.right != null) {
			tn = tn.right;
		}
		return tn;
	}
	public TreeNode<E> remove(E e){
		TreeNode tn = search(root, e);
		if(tn.val != e) return null;
		if(tn.left != null && tn.right != null) {
			TreeNode max = findMax(tn.left);
			tn.val = max.val;
			tn = max;
			
		}
		
		TreeNode child = tn.left == null ? tn.right : tn.left;
		if(tn == root) {
			root = child;
		}
		else if(tn.parent.left == tn) tn.parent.left = child;
		else tn.parent.right = child;
		if(child != null) child.parent = tn.parent;
		return tn;
	}
	
	public TreeNode<E> get(E e) {
		if(root == null) return null;
		TreeNode<E> result = search(root, e);
		return result.val.equals(e) ? result : null;
	}
	
	private class posNode<E extends Comparable> {
		TreeNode<E> tn;
		int start;
		int end;
		posNode(TreeNode<E> tn, int start, int end) {
			this.tn = tn;
			this.start = start;
			this.end = end;
		}
	}
	
	public E helper(TreeNode tn, int k) {
		int left = 0, right = 0;
		if(tn.left != null) left = tn.left.numChildren + 1;
		if(tn.right != null) right = tn.right.numChildren + 1;
		if(k == left + 1) return (E)tn.val;
		if(k <= left) return helper(tn.left, k);
		else if(k<=left + right + 1) return helper(tn.right, k - left - 1);
		else return null;
	}
	
	public E findKth(int k) {
		return helper(root, k);
	}
	
	
	public void drawTree() {
		if(root == null) return;
		
		int height = depth(root) - 1;
		int e = ((int) Math.pow(2.0, (double)height)*2 -1) - 1;
		
		posNode<E> pn = new posNode<>(root, 0, e);
		LinkedList<posNode<E>> queue = new LinkedList<>();
		int cnt = 1;
		for(int i=0; i<e/2; i++) System.out.print(' ');
		System.out.print(pn.tn.val);
		for(int i=0; i<e/2; i++) System.out.print(' ');
		System.out.println();
		queue.push(pn);
		while(!queue.isEmpty()) {
			int tmp = 0;
			int init = 0;
			while(cnt-- > 0) {
				posNode pos = queue.poll();				
				int mid = (pos.start + pos.end) / 2;
				if(pos.tn.left != null) {
					posNode l = new posNode(pos.tn.left, pos.start, mid - 1);
					queue.add(l);
					tmp++;
					for(int i=0; i<(l.start + l.end)/2 - init; i++) System.out.print(' ');
					System.out.print(l.tn.val);
					for(int i=(l.start + l.end)/2 + 1; i<=l.end; i++) System.out.print(' ');
					System.out.print(' ');
					init = l.end + 2;
				}
				if(pos.tn.right != null) {
					posNode r = new posNode(pos.tn.right, mid + 1, pos.end);
					queue.add(r);
					tmp++;
					for(int i=0; i<(r.start + r.end)/2 - init; i++) System.out.print(' ');
					System.out.print(r.tn.val);
					for(int i=(r.start + r.end)/2 + 1; i<=r.end; i++) System.out.print(' ');
					System.out.print(' ');
					init = r.end + 2;
				}
				
			}
			cnt = tmp;
			System.out.println();
		}
	}
	
	
	public List<E> serilizeTree() {
		ArrayList<E> list = new ArrayList<>();
		preorder(root, list);
		for(E e: list){
			System.out.print(e);
			System.out.print(' ');
		}
		return list;
	}
	
	public void preorder(TreeNode tn, List<E> list) {
		if(tn == null) {
			list.add(null);
			return;
		}
		list.add((E)tn.val);
		preorder(tn.left, list);
		preorder(tn.right, list);
	}
	
}

public class Snippet {
    public static void main(String args[]) {
    	BST<Integer> bst = new BST<>();
    	bst.insert(3);
    	bst.insert(1);
    	bst.insert(9);
    	bst.insert(6);
    	bst.insert(4);
    	bst.insert(2);
    	bst.insert(0);
    	
    	/*
    	bst.remove(0);
    	bst.remove(3);
    	bst.remove(1);
    	bst.remove(9);
    	
    	bst.remove(6);
    	bst.remove(4);
    	bst.remove(2);
    	*/
    	System.out.println(bst.findKth(6));
    	//bst.serilizeTree();
    	bst.drawTree();
    	
    }
}

