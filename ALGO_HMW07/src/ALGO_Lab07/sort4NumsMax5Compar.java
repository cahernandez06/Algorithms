package ALGO_Lab07;

import java.io.IOException;

public class sort4NumsMax5Compar{

	
	public static int[] swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		return A;
		
	}
	
	public static int[] sort4 (int[] A) {
		int[] B = new int[4];
		int X=0,Y=1,W=2,Z=3;
		
		if (A[X] > A[Y]) 
			A = swap(A,X,Y);
		if (A[W] > A[Z]) 
			A = swap(A,W,Z);
		if (A[X] > A[W]) 
			A = swap(A,X,W);
		if (A[Y] > A[Z]) 
			A = swap(A,Y,Z);
		if (A[Y] > A[W]) 
			A = swap(A,Y,W);
		return A;
	}
				
	public static void main(String[] args) throws IOException {
        //int[] A = {1,2,3,4};
    	//int[] A = {1,3,2,4};
    	//int[] A = {1,4,2,3};
    	//int[] A = {2,3,1,4};
    	//int[] A = {2,4,1,3};
    	int[] A = {3,4,1,2};
    	
        A = sort4(A);  
        System.out.print("Sorted Array A is: [");
        for (int i=0;i < 4;i++)
        	System.out.print(A[i]+",");
        System.out.println("]");
    }

}
