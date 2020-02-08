package Point6;

public class SelfAwareArray {
	
	public static boolean isSelfAwareArray(String Array) {
		int [] ArrAux=new int[Array.length()];
		int currNum=0;
		
		for (int i=0; i < Array.length()-1; i++) {
			currNum = Integer.parseInt(Array.substring(i,i+1));
			ArrAux[currNum]++;
		}
		for (int i=0; i < Array.length()-1; i++) {
			currNum = Integer.parseInt(Array.substring(i,i+1));
			if (ArrAux[i] != currNum)
				return false;
		}
		return true;
	}

	/*public static void main(String[] args) {
		String A = "2020";

		if (isSelfAwareArray(A))
			System.out.println("Array A is Self-Aware!");
		else 
			System.out.println("Sorry Array A is NOT Self-Aware!");
		System.out.println("Number of iterations: "+k);
	}*/
}
