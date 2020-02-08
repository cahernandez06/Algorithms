package ALGO_Lab08;

import java.util.*; 

class PushPopSeq  
{ 
  
    // Function to check validity of stack sequence  
    static boolean validateStackSequence(int pushed[], 
                                        int popped[], int len)  
    { 
  
        // maintain count of popped elements  
        int j = 0; 
  
        // an empty stack  
        Stack<Integer> st = new Stack<>(); 
        for (int i = 0; i < len; i++)  
        { 
            st.push(pushed[i]); 
            System.out.println("Push("+pushed[i]+")");
  
            // check if appended value  
            // is next to be popped out  
            while (!st.empty() && j < len &&  
                    st.peek() == popped[j])  
            { 
                st.pop(); 
                System.out.println("Pop("+popped[j]+")");
                j++; 
            } 
        } 
  
        return j == len; 
    } 
  
    // Driver code  
    public static void main(String[] args)  
    { 
        int pushed[] = {1, 2, 3, 4, 5, 6}; 
        int popped[] = {1, 5, 4, 6, 2, 3}; 
        int len = pushed.length; 
  
        System.out.println((validateStackSequence(pushed, popped, len) ? "True" : "False")); 
    } 
} 