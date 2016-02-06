//import java.util.*;
import List_Iterator.*;
import Trees.*;
import Fundamental_Data_Structures.*;
import Priority_Queue.*;
public class Executor {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.insert(10, "a");
		pq.insert(1, "b");
		pq.insert(3, "fe");
		System.out.println(pq.remove().getKey());
		System.out.println(pq.remove().getKey());
		System.out.println(pq.remove().getKey());
		System.out.println(pq.remove());

	}
} 