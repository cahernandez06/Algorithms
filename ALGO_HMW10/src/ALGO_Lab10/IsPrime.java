package ALGO_Lab10;

import java.util.Scanner;

import ALGO_Lab10.AVLTree.Node;

public class IsPrime {

	public static final int MAXPRIME = 100;
	
	//isPrime routine with: O(sqrt(n))
    static boolean isPrime(int n) 
    { 
        // Base cases 
        if (n <= 1) return false; 
        if (n <= 3) return true; 
      
        if (n % 2 == 0 || n % 3 == 0) 
        	return false; 
      
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return false; 
        return true; 
    } 
  
    public static void main(String args[]) 
    {  	AVLTree t = new AVLTree();
    	Node root = null;
    	
    	//1. Step 1: run through all first MAXPRIME numbers, discarding even numbers and
    	//   checking whether the number isPrime, if so: Add it to the AVL tree
    	for (int i=1; i < MAXPRIME;i=i+2) //Discard even numbers so is O(n/2)
    		if (isPrime(i))               //isPrime with O(sqrt(n))
    			root = t.insert(root, i); //AVL guarantees balancing
    	
    	Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number to find out if it is Prime");
        int  numIsPrime = myObj.nextInt();
        
    	if(t.existsInAVL(root,numIsPrime))
            System.out.println("Yes: " + numIsPrime + " is Prime number"); 
        else
        	System.out.println("No: " + numIsPrime + " is Not a Prime number");    
    	myObj.close();
    } 
} 