package Trees;
import java.util.*;


interface Tree<E> extends Iterable<E> {
	Node<E> root();
	Node<E> parent(Node<E> n);
	Iterable<Node<E>> children (Node<E> n) throws IllegalArgumentException;
	int numChildren(Node<E> n) throws IllegalArgumentException;
	boolean isInternal(Node<E> n) throws IllegalArgumentException;
	boolean isExternal(Node<E> n) throws IllegalArgumentException;
	boolean isRoot(Node<E> n) throws IllegalArgumentException;
	int size();
	boolean isEmpty();
	Iterator<E> iterator();
}


abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Node<E> n) {return numChildren(n) > 0; }
	public boolean isExternal(Node<E> n) {return numChildren(n) == 0;}
	public boolean isRoot(Node<E> n) {return root() == n;}
	public boolean isEmpty() {return size() == 0;}
	public int depth(Node<E> n) {
		int cnt = 0;
		while(parent(n) != root()) {
			n = parent(n);
			cnt++;
		}
		return cnt;
	}
	public int height(Node<E> n) {
		int h = 0;
		for(Node<E> c: children(n)) {
			h = Math.max(height(c) + 1, h);
		}
		return h;
	}
}


