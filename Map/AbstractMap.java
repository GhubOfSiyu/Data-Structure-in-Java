package Map;
import java.util.Iterator;

import Priority_Queue.*;
public abstract class AbstractMap<K,V> implements Map<K,V> {
	public boolean isEmpty() {return size() == 0;}
	protected static class MapEntry<K,V> implements Entry<K,V> {
		private K k;
		private V v;
		public MapEntry(K k, V v) {
			this.k = k;
			this.v = v;
		}
		public K getKey() {return k;}
		public V getValue() {return v;}
		public void setKey(K k) {this.k = k;}
		public void setValue(V v) {this.v = v;}
	}
	private class keyIterator implements Iterator<K> {
		private Iterator<Entry<K,V>> entries = entrySet().iterator();
		public boolean hasNext() {return entries.hasNext();}
		public K next() {return entries.next().getKey();}
		public void remove() {entries.remove();}
	}
	private class keyIterable implements Iterable<K> {
		public Iterator<K> iterator() {return new keyIterator();}
	}	
	public Iterable<K> keySet() {return new keyIterable();}
	
	private class entryIterator implements Iterator<V> {
		private Iterator<Entry<K,V>> entries = entrySet().iterator();
		public boolean hasNext() {return entries.hasNext();}
		public V next() {return entries.next().getValue();}
		public void remove() {entries.remove();}
	}
	private class entryIterable implements Iterable<V> {
		public Iterator<V> iterator() {return new entryIterator();}
	}	
	public Iterable<V> KeySet() {return new entryIterable();}
	
}