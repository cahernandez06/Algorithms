package SubsetSumsK;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSumsK {
	
	static List<Integer> tmpPerm = new ArrayList<Integer>(0);

	public static List<List<Integer>> powerSet(List<Integer> X) {
	    List<List<Integer>> P = new ArrayList<List<Integer>>();
	    List<Integer> S = new ArrayList<Integer>(0); 
	    Integer x=0;
	    P.add(S); 

	    while (!X.isEmpty()) {
	    	x = X.get(0);
	    	X.remove(0);
	        int pSize = P.size();
	        for (int i=0; i < pSize; i++) {
	            List<Integer> f = P.get(i);
	            List<Integer> T = new ArrayList<Integer>(f);
	            T.add(x);
	            P.add(T);
	        }
	    }
	    return P;
	}
	
	public static List<Integer> elimExceededVals(List<Integer> X, int k) {
		//k is greater than all elements in X, no need to eliminate
		if (X.get(X.size()-1) < k) {
			return X;
		}
		List<Integer> Y = new ArrayList<Integer>(0);
		//Could be improved with a binary search, but cost of copy is the same
		for (Integer x:X) {
			if (x < k)
				Y.add(x);
		}
		return Y;
	}
	
	public static boolean permSumsK(List<Integer> Y, int k) {
		int runningSum = 0;
		
		for (int i:Y) {
			runningSum += i;
			//If sum is greater than k, stops the loop to save time
			if (runningSum > k)
				break;
		}
		
		if (runningSum == k)
			return true;
		else 
			return false;
	}
	
	public static boolean findSubSetSumK(List<Integer> X, int k){
		List<List<Integer>> P = new ArrayList<List<Integer>>();
		List<Integer> Y = new ArrayList<Integer>(0);
		
		boolean boFound = false;
		
		//Step 1: sort the List
		Collections.sort(X);
		//Step 2: Eliminates greater values
		Y = elimExceededVals(X,k);
		//Step 3: Obtain the powerSet of Y
		P = powerSet(Y);
		//Step 4: Loop to check if any permutation sums k
		for (List<Integer> currPerm:P) 
			if (currPerm.size() > 1 && permSumsK(currPerm,k)) {
				boFound = true;
				tmpPerm = currPerm;
				break;
			}
		return boFound;
	}
	
	public static void main(String[] args) throws IOException {
		List<Integer> test = new ArrayList<Integer>();
		int targetSum = 10;

        test.add(0);
        test.add(4);
        test.add(1);
        test.add(3);
        test.add(2);
        
        if (findSubSetSumK(test,targetSum)) {
        	System.out.println("There is a permutation summing: " + targetSum);
        	for (int i:tmpPerm)
				System.out.printf("%d,",i);
        }
        else
        	System.out.println("No permutations summing: " + targetSum);
	}

}
