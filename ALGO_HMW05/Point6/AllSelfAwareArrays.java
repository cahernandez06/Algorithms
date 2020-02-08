package Point6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllSelfAwareArrays {

	private static List<String> allPermuts = new ArrayList<String>();

	public static void findAllSelfAwareArrays(int n){
		String strA = "";
		boolean boFound = false;
		
		//Step 1: populate an String with all possible n numbers
		for (int i=0; i < n; i++)
			strA = strA + i;

		//Step 2: Obtain all permutations of strA
		allPermuts = Permuts.allPermutations(strA);

		//Step 3: to check, one by one, if it it self-aware Array
		for (String currPerm:allPermuts) 
			//Prints each self-aware array found
			if (SelfAwareArray.isSelfAwareArray(currPerm)) {
				boFound = true;
				System.out.print("Self-aware array: "); 
				System.out.println(currPerm);

			}
		//Step 4: If no self-aware arrays found at all, print message
		if (!boFound)
			System.out.println("No self aware arrays found!");
	}
	
	public static void main(String[] args) throws IOException {
		int n = 4;
        
        findAllSelfAwareArrays(n);
	}

}
