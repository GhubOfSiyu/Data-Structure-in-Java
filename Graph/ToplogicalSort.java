package Graph;
import java.util.*;
 class Graph {
	LinkedList<Integer> adj[];
	Graph(int num) {
		adj = new LinkedList[num];
		for(int i=0; i<num; i++) { // need initlize linkedlist
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
}
 
public class ToplogicalSort {
	
	
	public ToplogicalSort(Graph graph) {
		this.graph = graph;
	}
	private Graph graph;
	
	
	public void topSort() {
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<graph.adj.length; i++) {
			recur(stack, i, set);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
			System.out.println(" ");
		}
	}
	
	public void recur(Stack<Integer> stack, int i, HashSet<Integer> set) {
		if(set.contains(i)) return;
		set.add(i);
		for(Integer j : graph.adj[i]) {
			recur(stack, j, set);
		}
		stack.push(i);
	}

	public static void main(String args[]) {
		
		 Graph g = new Graph(6);
	        g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	     ToplogicalSort ts = new ToplogicalSort(g);
	     ts.topSort();
	}
}