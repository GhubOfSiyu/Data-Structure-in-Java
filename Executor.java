//import java.util.*;
import List_Iterator.*;
import Fundamental_Data_Structures.*;
public class Executor {
	public static void main(String[] args) {
		//CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		//ArrayList<Integer> list = new ArrayList<>();
		list.addFirst(1);
		//System.out.println(list);
		list.addFirst(2);
		//System.out.println(list);
		list.addFirst(3);
		//System.out.println(list);
		for(Integer i : list.elements()) {
			System.out.println(i);
		}
		
	}
} 