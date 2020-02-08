package Point8_UniqueRdmArray;

import org.springframework.util.StopWatch;

public class UniqueRdmArray {

	public static int[] UniqueRdmArray(int n) {
		int tmpNumber = 0;
		int i = 0;
		boolean boExists = false;
		int[] tmpArray = new int[n];
		
		for (i=0;i < n; i++) {
			tmpNumber = (int) (Math.random()*100);
			boExists = false;
			//Checks if number doesn't exists already
			for (int j=0; j < i; j++) {
				if (tmpNumber==tmpArray[j]) {
					boExists = true;
					break;
				}
			}
			//If exists, try again for the same position
			if (boExists)
				i -= 1;
			else
				tmpArray[i] = tmpNumber;
		}
		System.out.println("Number of Iterations: " + i);
		return tmpArray;
	}
	
	public static void main(String[] args) {
		int n = 7; 
		int[] ansArray;

		StopWatch sw = new StopWatch();
		sw.start();
		ansArray = UniqueRdmArray(n);
		System.out.println("Unique random Array: " );
		for (int i=0;i < n;i++)
			System.out.println("Element: " + i + " : " + ansArray[i]);
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Total time: Unique random Array is=" + totaltime);
	}

}
