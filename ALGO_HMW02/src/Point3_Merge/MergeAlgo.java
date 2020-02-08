package Point3_Merge;

import java.io.IOException;

public class MergeAlgo {
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int index1=0;
		int index2=0;
		int index3=0;
		int max=arr1.length+arr2.length;
		int[] arrA;
		int[] arrB;
		int[] arrC = new int[max];
		
		if (arr1.length > arr2.length) {
			arrA = arr2;
			arrB = arr1;
		}else if (arr1.length < arr2.length){
			arrA = arr1;
			arrB = arr2;
		}else { //equal length
			if (arr1[0] < arr2[0]) {
				arrA = arr1;
				arrB = arr2;
			}else {
				arrA = arr2;
				arrB = arr1;
			}
		}
		
		for (int i=0;i < max;i++) {
			if (index1 < arrA.length && arrA[index1] <= arrB[index2]) {
				arrC[index3] = arrA[index1];
				index3+=1;
				index1+=1;
			}else {
				arrC[index3] = arrB[index2];
				index3+=1;
				index2+=1;
			}
		}
		return arrC;
	}
	public static void main(String[] args) {
		int[] arr1 = {1,4,5,8,17};
		int[] arr2 = {2,4,8,11,13,21,23,25};
		int[] arr3 = new int[arr1.length+arr2.length];
		
		arr3 = merge(arr1,arr2);
		for (int i=0;i < arr3.length;i++)
			System.out.println(arr3[i]);
	}
}
