package Point13_Count0s1sArray;

import org.springframework.util.StopWatch;

public class Count0s1s {
	
	public static void count0s1s(int[] A, int lower, int upper) {
		int mid = 0;
		
		if (lower > upper) {
			//System.out.println("The Array A must contain only 0s or only 1s, so the quantity is: " + A.length);
			return;  //did not found combinations of 0s or 1s
		}
		mid = (upper+lower)/2;
		if ((mid > 0)&&(A[mid] == 1) && (A[mid-1] == 0))  //Limit element found!
			System.out.println("There are: " + (mid) + " 0's and " + (A.length-mid) + " 1's");
		if (A[mid] == 0) //Still 0's so go to right
			count0s1s(A, mid+1, upper);
		else
			count0s1s(A, lower, mid-1);
		
	}

	public static void main(String[] args) {
		int[] A = {0,0,1,1,1};

		StopWatch sw = new StopWatch();
		sw.start();
		count0s1s(A,0,A.length-1);
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Total time: Count 0s and 1s is=" + totaltime);
	}

}
