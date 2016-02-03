package List_Iterator;
import java.util.*;
public class ArrayList<E> implements Iterable<E>{
	private static final int CAPACITY = 2;
	private int size = 0;
	private E[] data;
	public ArrayList() {
		this(CAPACITY);
	}
	public ArrayList(int capacity) {
		data = (E[]) new Object[CAPACITY];
	}
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public void add(int index, E e) throws IndexOutOfBoundsException {
		checkIndex(index, size + 1);
		if(size == data.length) {
			resize(2 * data.length);
		}
		for(int i=size; i>index; i--) {
			data[i] = data[i-1];
		}
		data[index] = e;
		size++;

	}
	public void set(int index, E e) {
		checkIndex(index, size);
		data[index] = e;
	}
	public void remove(int index) {
		checkIndex(index, size);
		for(int i=index; i<data.length-1; i++) {
			data[i] = data[i+1];
		}
		size--;
	}
	public E get(int index) throws IndexOutOfBoundsException{
		checkIndex(index, size);
		return data[index];
	}
	public void resize(int capacity){
		E[] newAry = (E[]) new Object[capacity];
		for(int i=0; i<data.length; i++) {
			newAry[i] = data[i];
		}
		data = newAry;
	}

	public void checkIndex(int index, int size) throws IndexOutOfBoundsException{
		if(index < 0 || index > size - 1) 
			throw new IndexOutOfBoundsException("Illegal index: " + index);
	}
	
	private class ArrayIterator implements Iterator<E>{
		private int cur = 0;
		boolean flag = false;
		public boolean hasNext() {
			return cur < size;
		}
		
		public E next() throws NoSuchElementException{
			if(cur == size) throw new NoSuchElementException("No next element");
			flag = true;
			return data[cur++];		
		}
		
		public void remove() throws IllegalStateException{
			if(flag = false) throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(cur - 1);
			cur--;
			flag = false;
		}
	}
	
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	

	public String toString() {
		String result = "";
		for(int i=0; i<size; i++) {
			result += data[i] + " ";
		}
		return result;
	}

}