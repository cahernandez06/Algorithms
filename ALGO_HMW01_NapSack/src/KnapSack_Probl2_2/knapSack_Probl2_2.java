package KnapSack_Probl2_2;

import java.io.*;
import java.util.*;

public class knapSack_Probl2_2 {

    public static List<Integer> knapsack(List<Integer> items, List<Integer> values, List<Integer> weights, int maxWeight) {
        // Inner class for items
    	class Item{
    		Integer item;
    		Integer value;
    		Integer weight;
    		
    		public Item(Integer item,Integer value,Integer weight) {
    			this.item=item;
    			this.value=value;
    			this.weight=weight;
    		}
    	}
    	class compareByValue implements Comparator<Item>{
    		public int compare(Item item1, Item item2) {
    			return item1.value-item2.value;
    		}	
    	}
    	class compareByWeight implements Comparator<Item>{
    		public int compare(Item item1, Item item2) {
    			return item1.weight-item2.weight;
    		}	
    	}
    	
    	List<Item> itemList=new ArrayList<Item>();
    	List<Integer> ans= new ArrayList<Integer>();
    	
    	for (int i=0;i < items.size();i++) {
    		Item tmpItem=new Item(items.get(i),values.get(i),weights.get(i));
    		itemList.add(tmpItem);
    	}
    		
    	Comparator<Item> c = Collections.reverseOrder(new compareByValue()); 
    	Collections.sort(itemList,c);
    	
    	//Having items sorted by value iterates filling the knapsack until reach the top
    	int capAvailable=maxWeight;
    	int i=0;
    	while (capAvailable-itemList.get(i).weight >= 0) {
    		ans.add(i);
    		capAvailable = capAvailable-itemList.get(i).weight;
    		i++;
    	}
    	return ans;
    }

	public static void main(String[] args) throws IOException {
		List<Integer> ans= new ArrayList<Integer>();;
		int W = 4; //Maximum weight the knapsack can carry

        List<Integer> S = new ArrayList<Integer>(); //Items
        S.add(0);
        S.add(1);
        S.add(2);
        
        List<Integer> v = new ArrayList<Integer>(); //Values of items
        v.add(2);
        v.add(2);
        v.add(3);
        
        List<Integer> w = new ArrayList<Integer>(); //Weights of items
        w.add(2);
        w.add(1);
        w.add(4);
        
        ans = knapsack(S,v,w,W);
        
        System.out.println("Result: " + ans);

    }
}