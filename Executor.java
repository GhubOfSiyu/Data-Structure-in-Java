import java.util.*;
import Fundamental_Data_Structures.*;
public class Executor {
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
		list.addFirst(1);
		System.out.println(list);
		list.addFirst(2);
		System.out.println(list);
		list.rotate();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		
	}
} 