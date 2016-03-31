package snippet;
import java.util.*;

class PriorityQueue<E extends Comparable> {
	private ArrayList<E> buffer = new ArrayList<>();
	private int size = 0;
	private int left(int pos) {return 2*pos + 1;}
	private int right(int pos) {return 2*pos + 2;}
	private int parent(int pos) { return pos == 0 ? -1 : (pos-1)/2;}
	private void swap(int i, int j) {
		E tmp = buffer.get(i);
		buffer.set(i,buffer.get(j));
		buffer.set(j, tmp);
	}
	private void upHead(int pos) {
		while(pos > 0 && buffer.get(pos).compareTo(buffer.get(parent(pos))) < 0) {
			swap(pos, parent(pos));
			pos = parent(pos);
		}
	}
	
	private void downHeap(int pos) {
		int minPos = 0;
		while(pos < size) {
			if(left(pos) >= size && right(pos) >= size) return;
			else if(left(pos) < size && right(pos) < size) {
				minPos = buffer.get(left(pos)).compareTo(buffer.get(right(pos))) < 0 ? left(pos) : right(pos);
			}
			else minPos = left(pos) < size ? left(pos) : right(pos);
			swap(pos, minPos);
			pos = minPos;
		}
	}
	
	public void insert(E e) {
		buffer.add(e);
		upHead(buffer.size()-1);
		size++;
	}
	
	public E delete() {
		if(size == 0) return null;
		E val = buffer.get(0);
		swap(buffer.size()-1, 0);
		buffer.remove(buffer.size()-1);
		size--;
		downHeap(0);	
		return val;
	}
	
	public void print() {
		for(E e : buffer) {
			System.out.print(e);
			System.out.print(' ');
		}
	}
	
}

public class Snippet {
    public static void main(String args[]) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	pq.insert(4);
    	pq.insert(3);
    	pq.insert(2);
    	pq.insert(1);
    	pq.insert(14);
    	pq.insert(-1);
    	pq.insert(7);
    	System.out.println(pq.delete());
    	System.out.println(pq.delete());
    	System.out.println(pq.delete());
    	System.out.println(pq.delete());
    	
    }
}

