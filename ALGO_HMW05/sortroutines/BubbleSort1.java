package sortroutines;

import java.util.Arrays;

import runtime.Sorter;

/**
 * This is the slowest version of BubbleSort
 * No optimization for already sorted arrays.
 * Doesn't take into account the fact that
 * largest elements are pushed to the right.
 *
 */
public class BubbleSort1 extends Sorter {
	
	int[] arr;
	public int[] sort(int[] array){
		this.arr = array;
		bubbleSort();
		return arr;
		
	}
	private void bubbleSort(){
		boolean needSort = false;
		int k=0;
		int len = arr.length;
		for(int i = 0; i < len; ++i) {
			for(int j = 0; j < len-1; ++j) {
				k++;
				if(arr[j]> arr[j+1]){
					needSort =  true;  //if found a single element not in correct place, is not already sorted.
					swap(j,j+1);
				}
				if (i==0 && j==len-2 && !needSort)
					i = len;
			}
		}
		System.out.println("Number of iterations BubbleSort1 is: k=" + k);
	}
	
	int[] swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
		
	}
	public static void main(String[] args){
		//int[] test = {21,13,1,-22, 51, 5, 18};
		int[] test = {-22, 1, 5, 13, 18, 21, 51};
		BubbleSort1 bs = new BubbleSort1();
		
		System.out.println(Arrays.toString(bs.sort(test)));
		
	}

}
