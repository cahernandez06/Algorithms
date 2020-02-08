package ALGO_Lab15;

class Knapsackv2 
{ 
  
    // A utility function that returns maximum of two integers 
     static int max(int a, int b) { return (a > b)? a : b; } 
       
     // Returns the maximum value that can be put in a knapsack of capacity W 
     static int knapSack(int W, int wt[], int val[], int n) 
     { int tmpVal = 0;
        // Base Case 
    if (n == 0 || W == 0) 
        return 0; 
       
    // If weight of the nth item is more than Knapsack capacity W, then 
    // this item cannot be included in the optimal solution 
    if (wt[n-1] > W) { 
    	tmpVal = knapSack(W, wt, val, n-1);
    	System.out.println(tmpVal + ", ");
       return tmpVal;
    }
       
    // Return the maximum of two cases:  
    // (1) nth item included  
    // (2) not included 
    else { tmpVal = max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
	       System.out.print(tmpVal + ", ");
    	   return tmpVal;}
      } 
     
     // Driver program to test above function 
     public static void main(String args[]) 
     { 
     int val[] = new int[]{1, 2, 3, 4}; 
     int wt[] = new int[]{2, 3, 4, 5}; 
     int  W = 5; 
     int n = val.length;
     System.out.println("Version 2 – Subset: Knapsack problem with maximum benefit"); 
     System.out.println(knapSack(W, wt, val, n)); 
     } 
 } 