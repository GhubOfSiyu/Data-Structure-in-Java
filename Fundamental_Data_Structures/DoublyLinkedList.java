package Fundamental_Data_Structures;

public class DoublyLinkedList<E> {
	private static class Node<E> {
		public E val;
		public Node<E> next;
		public Node<E> prev;
		public Node(E e, Node<E> pre, Node<E> next) {
			val = e;
			this.next = next;
			this.prev = pre;
		}
		public Node(E e) {
			this(e, null, null);
		}
		public Node() {
			this(null, null, null);
		}
	}
	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		tail = new Node<E>(null, header, null);
		header.next = tail;
	}

	private Node<E> header = null;
	private Node<E> tail = null;
	private int size = 0;
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public E first() {return size == 0 ? null : header.next.val;}
	public E last() {return size == 0 ? null : tail.prev.val;}
	public void addFirst(E e) {
		addBetween(e, header, header.next);
	}
	public void addLast(E e) {
		addBetween(e, tail.prev, tail);
	}
	public E removeFirst() {
		if(size == 0) return null;
		return remove(header.next);
	}
	public E removeLast() {
		if(size == 0) return null;
		return remove(tail.prev);
	}

	public void addBetween(E e, Node<E> pre, Node<E> suc) {
		Node<E> newNode = new Node<E>(e, pre, suc);
		pre.next = newNode;
		suc.prev = newNode;
		size++;
	}
	public E remove(Node<E> n) {
		if(n == null) return null;
		Node<E> pre = n.prev;
		Node<E> next = n.next;
		E e = n.val;
		if(pre != null) pre.next = next;
		if(next != null) next.prev = pre;
		size--;
		return e;
	}

	public String toString() {
		String result = "";
		if(size == 0) return result;
		Node<E> head = header.next;
		while(head != tail) {
			result += ((head.val) + " ");
			head = head.next;
		}
		return result;
	}


}