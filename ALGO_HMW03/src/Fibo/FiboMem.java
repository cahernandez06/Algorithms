package Fibo;


public class FiboMem {

	public static void main(String[] args) {
		// Try with fibonacci
		
		initMemory();
		System.out.printf("The fibonacci of number %d is: %d", fiboNumber, FiboMem(fiboNumber));
		
	}
	
	private static int fiboNumber = 8;
	
	private static int[] memory = new int[fiboNumber+1];
	
	private static void initMemory() {
        for (int i=0;i <= fiboNumber;i++)
        	memory[i] = 0;
	}
	
	public static int FiboMem(int value) {
		int fiboN_1 = 0;
		int fiboN_2 = 0;
		
		//Base case 
		if (value==0||value==1) {
			memory[value] = 1;
			return memory[value];
		}
		
		if (memory[value-1] != 0)
			  //It is already calculated, so, take it from memory
			fiboN_1 = memory[value-1];
		else  //Else, do the recursion
			fiboN_1 = FiboMem(value-1);
		
		if (memory[value-2] != 0)
			  //It is already calculated, so, take it from memory
			fiboN_2 = memory[value-2];
		else //Else, do the recursion
			fiboN_2 = FiboMem(value-2);
		
		memory[value] = fiboN_1 + fiboN_2;
		return fiboN_1 + fiboN_2;
	}
   
}
