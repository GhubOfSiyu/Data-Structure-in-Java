package Fundamental_Data_Structures;
import java.util.*;
class Stack<E> {
	private LinkedList<E> head = new LinkedList<E>();
	public boolean isEmpty() {return head.size() == 0;}
	public int size() {return head.size();}
	public void push(E e) {head.addFirst(e);}
	public E pop() {return head.removeFirst();}
	public E top() {return head.getFirst();}
}