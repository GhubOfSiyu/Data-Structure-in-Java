package List_Iterator;

public class ArrayList<E> {
	
	private int size = 0;
	private E[] data;
	public ArrayList() {
		data = new (E[])Object[size];
	}
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public add(int index, E e) throws IndexOutOfBoudsException {
		checkIndex(index);
		if(size == data.length) throws new new Exception;
		for(i=size; i>index; i++) {
			data[i] = data[i-1];
		}
		data[index] = e;
		size++;

	}
	public set(int index, E e) {
		checkIndex(index);
		data[index] = e;
	}
	public remove(int index) {
		checkIndex(index);
		for(int i=index; i<data.length-1; i++) {
			data[i] = data[i+1];
		}
		size--;
	}
	public get(int index) {
		checkIndex(index);
		return data[index];
	}


}