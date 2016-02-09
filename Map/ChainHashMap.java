package Map;
import java.util.*;

public class ChainHashMap<K,V> extends AbstractHashMap<K,V>{
	private UnsortedTableMap<K,V> table[];
	public ChainHashMap(int capacity, int prime) {super(capacity, prime);}
	public ChainHashMap(int capacity) {super(capacity);}
	public ChainHashMap() {super();}
	protected void createTable() {
		table = (UnsortedTableMap<K,V>[])new UnsortedTableMap[capacity];
	}
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K,V> bucket = table[h];
		if(bucket == null) return null;
		return bucket.get(k);
		
	}
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K,V> bucket = table[h];
		if(bucket == null) return null;
		int oldSize = bucket.size();
		V v = bucket.remove(k);
		size -= (bucket.size() - oldSize);
		return v;
	}
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K,V> bucket = table[h];
		if(bucket == null) bucket = table[h] = new UnsortedTableMap<K,V>();
		int oldSize = bucket.size();
		V v = bucket.put(k,v);
		size += (bucket.size() - oldSize);
		return v;
		
		
	}
	public Iterable entrySet() {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(); 
		for (int h=0; h < capacity; h++)
			if (!isAvailable(h)) buffer.add(table[h]); 
		return buffer;
	}
}