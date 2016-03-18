package Sorting;
public class Sorting {
	private static void swap(int a[], int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	

	public static void bubbleSort(int[] a){
		for(int i=0; i<a.length -1; i++) {
			for(int j=0; j<a.length-i-1; j++) {
				if(a[j] > a[j+1]) swap(a, j, j+1);
			}
		}
	}
	

	public static void selectionSort(int[] a) {
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				min = a[min] > a[j] ? j : min;
			}
			swap(a,min, i);
		}
	}
	
	public static void mergeSortRecur(int a[]) {
		mergeSortHelper(a, 0, a.length-1);
	}
	
	public static void mergeSortHelper(int a[], int i, int j) {
		if(i >= j) return;
		int mid = (i + j) / 2;
		mergeSortHelper(a, i, mid);
		mergeSortHelper(a, mid + 1, j);
		merge(a, i, mid, mid+1, j);
	}
	
	public static void merge(int a[], int i, int j, int m, int n) {
		if(i > j || m > n) return; //invalid condition
		int[] tmpAry = new int[j-i+1];
		for(int x=i; x<=j; x++) tmpAry[x-i] = a[x];
		int cur1 = 0, cur2 = m, cur3 = i;
		while(cur1 < tmpAry.length) {
			if(cur2 > n || tmpAry[cur1] <= a[cur2]) {
				a[cur3] = tmpAry[cur1++];
			}
			else {
				a[cur3] = a[cur2++];
			}
			cur3++;
		}
	}
	
	public static void mergeSortIter(int a[]) {
		for(int i = 2; i<2*a.length; i*=2) {// i < 2 * a.length
			for(int j=0; j<a.length; j += i) {
				merge(a, j, j+i/2-1, j+i/2, Math.min(a.length-1, j+i-1));
			}
		}
	}
	
	public static void quickSort(int[] a) {
		quickSortHelper(a, 0, a.length-1);
	}
	
	public static void quickSortHelper(int[] a, int i, int j) {
		if(i >= j) return;
		int pivotIndex = partition(a, i, j);
		quickSortHelper(a, i, pivotIndex - 1); // should be pivotIndex - 1 not pivotIndex
		quickSortHelper(a, pivotIndex+1, j);
	}
	
	private static int partition(int[] a, int i, int j) {
		int pivot = a[j], sm = i, cur = i, lg = j - 1;
		while(cur <= lg) {
			if(a[cur] < pivot) swap(a, cur++, sm++);
			else if(a[cur] > pivot) swap(a, cur, lg--);
			else cur++;
		}
		swap(a, cur, j);
		return cur;
	}
	
	public static void heapSort(int a[]) {
		Heap heap = new Heap();
		for(int i=0; i<a.length; i++) {
			heap.add(a[i]);
		}
		for(int i=0; i<a.length; i++){
			a[i] = heap.remove();
		}
	}
	
	private static class Map {
		int key;
		String val;
		Map(int key, String val) {
			this.key = key;
			this.val = val;
		}
	}
	
	private static class Heap{
		ArrayList<Integer> buffer = new ArrayList<>();
		private int size= 0;
		private int parent(int index) {
			if(index == 0) return index;
			return (index-1)/2;
		}
		private void swap(ArrayList<Integer> buffer, int i, int j) {
			int tmp = buffer.get(i);
			buffer.set(i, buffer.get(j));
			buffer.set(j, tmp);
		}
		private int leftChild(int index) {return 2 * index + 1;}
		private int rightChild(int index) {return 2 * index + 2;}
		
		private void upHeap(int index) {
			while((parent(index) != index) && (buffer.get(index) < buffer.get(parent(index)))) {
				swap(buffer, index, parent(index));
				index = parent(index);
			}	
		}
		
		private void downHeap(int index){
			int left = leftChild(index), right = rightChild(index);
			while((left < size || right < size)) {
				int swp = 0;
				if(left < size && right < size) swp = buffer.get(left) > buffer.get(right) ? right : left;
				else if(left < size && buffer.get(left) < buffer.get(index)) swp = left;// only small swap
				else if(right < size && buffer.get(right) < buffer.get(index)) swp = right; 
				else break;
				swap(buffer, swp, index);
				index = swp;
				left = leftChild(index);
				right = rightChild(index);
			}
		}
		
		public void add(int val) {
			buffer.add(val);
			size++;
			upHeap(size-1);
		}
		
		public Integer remove() {
			if(size == 0) return null;
			int ret = buffer.get(0);
			buffer.set(0, buffer.get(size-1));
			size--;
			downHeap(0);
			return ret;	
		}
		
	}
	
	private static class ArrayList<E> {
		private int size;
		private E[] buffer;
		ArrayList() {
			size = 0;
			
			buffer = (E[])new Object[5];
		}
		
		public void insert(E e, int index) {
			if(index < 0) return;
			if(size == buffer.length) resize();
			for(int i = size; i > index; i--) {
				buffer[i] = buffer[i-1];
			}
			buffer[index] = e;
			size++;
		}
		
		private void resize() {
			E[] tmp = (E[])new Object[size * 2];
			for(int i=0; i<size; i++) tmp[i] = buffer[i];
			buffer = tmp;
		}
		
		public void add(E e) {
			insert(e, size);
		}
		public E remove(int index) {
			if(index < 0 || index >= size) return null;
			E ret = buffer[index];
			for(int i=index; i<size-1; i++) {
				buffer[i] = buffer[i+1];
			}
			return ret;
		}
		public E get(int index) {
			if(index < 0 || index >= size) return null;
			return buffer[index];
		}
		
		public void set(int index, E e) {
			if(index < 0 || index >= size) return;
			buffer[index] = e;
		}
		
		
	}
		
	public 	static void countSort(int a[], int range){
		int[] buffer = new int[range], output = new int[a.length];
		for(int i=0; i<a.length; i++) { buffer[a[i]]++;}
		for(int i=1; i<buffer.length; i++) {buffer[i] += buffer[i-1];}
		for(int i=0; i<a.length; i++) {output[--buffer[a[i]]] = a[i];}
		for(int i=0; i<a.length; i++) {a[i] = output[i];}
	}
	
	
	public static void print(int[] a) {
		for(int i=0; i<a.length; i++) {System.out.print(a[i]);System.out.print(',');}
	}
	
	public static void main(String args[]){
		int a[]  = new int[]{9,8,7,6,5};
		//bubbleSort(a);
		//selectionSort(a);
		//mergeSortRecur(a);
		//mergeSortIter(a);
		//quickSort(a);
		//heapSort(a);
		countSort(a, 10);
		print(a);
	}
}


