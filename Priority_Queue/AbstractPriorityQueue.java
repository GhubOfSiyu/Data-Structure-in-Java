package Priority_Queue;
import java.util.*;
interface PriorityQueueInterface<K,V> {
	int size();
	boolean isEmpty();
	Entry<K,V> insert(K k, V v);
	Entry<K,V> remove();
	Entry<K,V> top();
}

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueueInterface<K,V> {
	protected static class PQEntry<K,V> implements Entry<K,V> {
		K key;
		V val;
		public PQEntry(K key, V value) {
			this.key = key;
			this.val = value;
		}
		public K getKey() {return key;}
		public V getValue() {return val;}
		public void setKey(K key){this.key = key;}
		public void setValue(V val) {this.val = val;}
	}
	
	protected static class DefaultComparator<K> implements Comparator<K>{
		public int compare(K k1, K k2) {
			Comparable v1 = (Comparable)k1;
			
			if(v1.compareTo(k2) > 0) return 1;
			else if (v1.compareTo(k2) < 0) return -1;
			else return 0;
		}
	}
	
	protected int size = 0;
	private Comparator<K> comp;
	protected AbstractPriorityQueue(Comparator<K> k) {comp = k;}
	protected AbstractPriorityQueue() {this(new DefaultComparator<K>());}
	public boolean isEmpty() {return size == 0;}
	public int compare(Entry<K,V> e1, Entry<K,V> e2) {
		return comp.compare(e1.getKey(), e2.getKey());
	}	
	
}