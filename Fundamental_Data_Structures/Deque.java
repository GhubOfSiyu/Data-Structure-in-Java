package Fundamental_Data_Structures;
public class Deque<E> {
	private DoublyLinkedList<E> dq = new DoublyLinkedList<>();
	public boolean isEmpty() {return dq.size() == 0;}
	public int size() {return dq.size();}
	public void addFirst(E e) {dq.addFirst(e);}
	public void addLast(E e) {dq.addLast(e);}
	public E removeFirst(E e) {return dq.removeFirst();}
	public E removeLast(E e) {return dq.removeLast();}
;	public E first() {return dq.first();}
	public E last() {return dq.last();}
}
