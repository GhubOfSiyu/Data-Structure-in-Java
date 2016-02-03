package Fundamental_Data_Structures;
import java.util.*;
class Queue<E> {
	private LinkedList<E> head = new LinkedList<>();
	public boolean isEmpty() {return head.size() == 0;}
	public int size() {return head.size();}
	public void enqueue(E e) {head.addLast(e);}
	public E dequeue(E e) {return head.removeFirst();}
	public E first() {return head.getFirst();}

}