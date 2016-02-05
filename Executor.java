//import java.util.*;
import List_Iterator.*;
import Trees.*;
import Fundamental_Data_Structures.*;
public class Executor {
	public static void main(String[] args) {
		BinaryTree<Integer> btree = new BinaryTree<>();
		BinaryTree.TreeNode<Integer> n1 = btree.addRoot(1);
		BinaryTree.TreeNode<Integer> n2 = btree.addLeft(n1, 2);
		btree.addRight(n1, 3);
		for(Integer i : btree) {
			System.out.println(i);
		}
		
		
	}
} 