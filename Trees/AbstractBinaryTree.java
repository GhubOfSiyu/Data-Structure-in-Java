package Trees;
import java.util.*;

interface BinaryTreeInterface<E> extends Tree<E> {
	Node<E> left(Node<E> p) throws IllegalArgumentException;
	Node<E> right(Node<E> p) throws IllegalArgumentException;
	Node<E> sibling(Node<E> p) throws IllegalArgumentException;

}

abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTreeInterface<E> {
	public Node<E> sibling(Node<E> n) throws IllegalArgumentException {
		if(n == null) throw new IllegalArgumentException("node not exist");
		if(n == root()) return null;
		return n == right(parent(n)) ? left(parent(n)) : right(parent(n));
	}
	
	public int numChildren(Node<E> n) throws IllegalArgumentException {
		if(n == null) throw new IllegalArgumentException("node not exist");
		return (left(n) == null ? 0 : 1) + (right(n) == null ? 0 : 1);
	}
	
	public Iterable<Node<E>> children(Node<E> n) {
		java.util.ArrayList<Node<E>> list = new java.util.ArrayList<>();
		if(left(n) != null) list.add(left(n));
		if(right(n) != null) list.add(right(n));
		return list;
		
	}
}