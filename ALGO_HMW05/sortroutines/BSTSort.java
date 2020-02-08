package sortroutines;

import java.util.Arrays;

import runtime.Sorter;

public class BSTSort extends Sorter {

	public static int[] arr;
	public static int index=0;

	/** The tree root. */
	private Node root;

	//start with an empty tree
	public BSTSort() {
		root = null;
	}

	public int[] sort(int[] array){
		this.arr = new int[array.length];
		
		for(int i = 0; i < array.length; i++){
			this.insert(array[i]);
		}
		fillArrFromBST();
		return arr;	
	}
	
	/**
	 * fills the Array arr with the nodes of the tree in sorted order.
	 */
	public void fillArrFromBST() {
		
		if (root == null)
			System.out.println("Empty tree");
		else
			fillArrFromBST(root);
	}

	private void fillArrFromBST(Node t) {
		
		if (t != null) {
			fillArrFromBST(t.left);
			arr[index++]=t.element;
			fillArrFromBST(t.right);
		}
	}
	
	public boolean find(Integer x) {
		if(x==null) return false;
		return find(x,root);
	}
	private boolean find(Integer x, Node n){
		if(n == null) return false;
		if(n != null && n.element.equals(x)) return true;
		return (x.compareTo(n.element) < 0) ?
				find(x,n.left) :
				find(x,n.right);
		//return find(x,n.left) || find(x,n.right);
	}

	public void insert(Integer x) {
		if (root == null) {
			root = new Node(x, null, null);
		}
		else {
			Node n = root;
			boolean inserted = false;
			while(!inserted){
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.left;
					}
				}
				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
						n.right = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.right;
					}
				}
				
			}

		}
	}
	public static void main(String[] args){
		int[] test = {1, 9, 3, 8, 12, 4, 2};
		BSTSort bs = new BSTSort();
		
		System.out.println(Arrays.toString(bs.sort(test)));
		
	}

	private class Node {

		// Constructors
		Node(Integer theElement) {
			this(theElement, null, null);
		}

		Node(Integer element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
		private Integer element; // The data in the node
		private Node left; // Left child
		private Node right; // Right child
	}
}