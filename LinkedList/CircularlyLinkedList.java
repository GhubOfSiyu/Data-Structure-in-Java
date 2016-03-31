package Fundamental_Data_Structures;
public class CircularlyLinkedList<E> {
	private static class Node<E> {
		public E val;
		public Node<E> next;
		public Node(E e, Node<E> next) {
			val = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e, null);
		}
	}

	private Node<E> tail = null;
	private int size = 0;
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public E first() {return tail == null ? null : tail.next.val;}
	public E last() {return tail == null ? null : tail.val;}
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		if(tail == null) {
			tail = newNode;
			tail.next = tail;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		size++;
	}
	public void addLast(E e) {
		addFirst(e);
		rotate();
	}
	public E removeFirst(){
		if(tail == null) return null;
		E val = tail.next.val;
		if(tail == tail.next) 
			tail = null;
		else 
			tail.next = tail.next.next;
		size--;
		return val; 
	}
	public void rotate() {
		if(tail == null) return;
		tail = tail.next;
	}

	public String toString() {
		String result = "";
		if(tail == null) return result;
		Node<E> head = tail.next;
		while(head != tail) {
			result += ((head.val) + " ");
			head = head.next;
		}
		result += ((tail.val));
		return result;
	}
}