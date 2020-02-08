package Point6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permuts {
  
	private static List<String> allPermuts = new ArrayList<String>();
	
    // The main function that recursively makes all permutations of the given string.  
    // It uses data[] to store all permutations one by one 
    static void allPermutationsRec(String str, char[] data, int last, int index)  
    { 
        int length = str.length(); 
  
        // Step 1: One by one find out all permutations at the given index  and recur for the subsequent indexes 
        for (int i = 0; i < length; i++)  
        { 
  
            // Step 2: Fix the ith character at index and if this is not the last index then recursively call for higher indexes 
            data[index] = str.charAt(i); 
  
            // Step 3: Base case for recursion: If this is the last index then print the string stored in data[] 
            if (index == last) 
            	allPermuts.add(new String(data));
            else //Step 4: Recursion for next indexes
            	allPermutationsRec(str, data, last, index + 1); 
        } 
    } 
  
    // This function sorts input string, allocate memory for data(needed for allPermutationsRec()) and calls 
    // allPermutationsRec() for returns all permutations stored in allPermuts 
    static List<String> allPermutations(String str)  
    { 
        int length = str.length(); 
  
        // Step 1: Create a temp array that will be used by allPermutationsRec() 
        char[] data = new char[length + 1]; 
        char[] temp = str.toCharArray(); 
  
        // Step 2: Sort the input string  
        Arrays.sort(temp); 
        str = new String(temp); 
  
        // Step 3: Now print all permutations 
        allPermutationsRec(str, data, length - 1, 0); 
        
        // Step 4: Return all permutations found
        return allPermuts;
    } 
  
    /* Driver Code, for testing proposes
    public static void main(String[] args)  
    { 
        String str = "0123"; 
        System.out.printf("All permutations with repetition of %s are: \n", str); 
        allPermutations(str); 
    } */
} 
  