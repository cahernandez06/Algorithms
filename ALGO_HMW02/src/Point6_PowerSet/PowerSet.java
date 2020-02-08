package Point6_PowerSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
	
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
	
	public static void main(String[] args) throws IOException {
		List<Integer> test = new ArrayList<Integer>();

        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        
        for (List<Integer> s : powerSet(test)) {
            System.out.println(s);
        }
        
	}

}
