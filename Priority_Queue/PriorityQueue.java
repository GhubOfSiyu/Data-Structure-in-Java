package Priority_Queue;
import java.util.*;
public class PriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
	public PriorityQueue() { super(); }
	public PriorityQueue(Comparator<K> comp) { super(comp); }
	protected int parent(int j) {return (j-1)/2;}
	protected int left(int j) {return j * 2 + 1;}
	protected int right(int j) {return j * 2 + 2;}
	protected boolean hasLeft(int j) {return left(j) < size;}
	protected boolean hasRight(int j) {return right(j) < size;}
	protected void swap(int i, int j) {
		Entry<K,V> tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j,  tmp);
	}
	protected void upheap(int j) {
		while(j > 0) {
			int tmp = parent(j);
			if(compare(heap.get(j), heap.get(parent(j)))  > 0) break;
			swap(j, parent(j));
			j = tmp;
		}
	}
	protected void downheap(int j) {
		while(hasLeft(j)) {
			int min = left(j);
			if(hasRight(j)) {
				min = compare(heap.get(min), heap.get(right(j))) > 0 ? right(j) : min;
			}
			if(compare(heap.get(j), heap.get(min)) > 0) swap(j, min);
			else break;
			j = min;
		}
	}
	
	public int size(){return size;}
	public Entry<K,V> top() {return size == 0 ? null : heap.get(0);}
	public Entry<K,V> insert(K key, V value) {
		heap.add(new PQEntry<K,V>(key, value));
		upheap(heap.size()-1);
		return null;
	}
	public Entry<K,V> remove() {
		if(heap.isEmpty()) return null;
		Entry<K,V> tmp = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size()-1);
		downheap(0);
		return tmp;
		
	}
}