package Map;
import java.util.*;
import Priority_Queue.*;
public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
	protected int capacity;
	protected int size;
	private int prime;
	private long scale, shift;
	public AbstractHashMap(int capacity, int prime) {
		this.capacity = capacity;
		this.prime = prime;
		Random rand = new Random();
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
		createTable();
		
	}
	
	public AbstractHashMap(int capacity) {
		this(capacity, 109345121);
	}
	
	public AbstractHashMap() {
		this(17);
	}
	
	public int size() {
		return size;
	}
	public V get(K k) {
		return bucketGet(hashValue(k), k);
	}
	public V remove(K k) {
		return bucketRemove(hashValue(k), k);
	}
	public V put(K k, V val) {
		 V answer = bucketPut(hashValue(k), k, val);
		 if(size >= 0.75 * capacity) {
			 resize(2 * capacity -1);
		 }
		 return answer;
	}
	
	private int hashValue(K k) {
		return (int)((Math.abs((k.hashCode() * scale) + shift)) % prime) % capacity;
	}
	private void resize(int newCap) {
		ArrayList<Entry<K,V>> tmp = new ArrayList<>(capacity);
		for(Entry<K,V> e : entrySet()) {
			tmp.add(e);
		}
		capacity = newCap;
		createTable();
		size = 0;
		for(Entry<K,V> e : tmp) {
			put(e.getKey(), e.getValue());
		}
	}
	
	protected abstract void createTable();
	protected abstract V bucketGet(int h, K k);
	protected abstract V bucketPut(int h, K k, V v);
	protected abstract V bucketRemove(int h, K k);
	
}