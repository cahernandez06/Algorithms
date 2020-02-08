package ALGO_Lab07;

import java.util.Arrays;

import runtime.Sorter;

public class RareSort {

	public class QuickSort extends Sorter{

		public QuickSort() {
			super();
		}
		
		@Override
		public int[] sort(int[] arr) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public static int[] rareSort(int[] A) {
		int n = A.length;
		int[] B = new int[A.length];
		
		QuickSort ss = new QuickSort();
		ss.sort(A);
		
		B[0] = A[0];       //Smallest integer goes to position 0
		B[1] = A[n-1];     //Largest integer goes to position 1
		B[2] = A[1];       //2nd smallest integer goes to position 2
		B[3] = A[n-2];     //2nd largest integer goes to position 3
		for  (int i = 2; i < n-2; i++) 
			B[i+2] = A[i];
		
		return B;
	}
	
	public static void main(String[] args){
		int[] test = {1,2,17,-4,-6,8};
		
		System.out.println(Arrays.toString(rareSort(test)));
		
	}
}
