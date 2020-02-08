package Point11_Fibo_Iterative;

import java.io.IOException;
import org.springframework.util.StopWatch;

public class FiboIterative {
	
	public static int fibo_iterative(int n) {
		int x = 0;
		int y = 1;
		int acum = 0;
		
		if (n < 1)
			return x;
		if (n < 2)
			return y;
		for (int i = 2; i <= n; i++) {
			acum = x+y;
			x = y;
			y = acum;
		}
		return acum;
	}

	public static void main(String[] args) throws IOException {
		int test = 7; 

		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("Fibonacci of: " + test + " is: " + fibo_iterative(test));
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Total time: fibo_iterative is=" + totaltime);
	}
	
}
