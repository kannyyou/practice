package Q4_11_Random_Node;

/**
 * Random Node: You are implementing a binary search tree class from scratch, 
 * which, in addition to insert, find and delete, has a method getRandomNode() 
 * which returns a random node from the tree. All nodes should be equally likely to be chosen. 
 * 
 * Design  and implement an algorithm to getRandomNode and explain how you would implement the rest of the methods.
 * 
 * @author changhun
 *
 */
public class Question {

	public static void main(String[] args) {
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			Tree tree = new Tree();
			int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				tree.insertInOrder(x);
			}
			int d = tree.getRandomNode().data;
			counts[d]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
	}

}
