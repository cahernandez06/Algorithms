package ALGO_Lab08;

public class MinStack {

	Integer[] enhancedStack;
	Integer[] minStack;
	int top = 0;
	int topMinStack = 0;
	int size;
	
	public MinStack(int size) {
		this.size = size;
		this.top = -1;
		this.topMinStack = -1;
		this.enhancedStack = new Integer[size];
		this.minStack = new Integer[size];
	}
	
	public void push(int item) {
		int len = enhancedStack.length;
		if( top == len-1) {
			System.out.println("Stack limit reached!");
			return;
		}
		top++;
		enhancedStack[top]=item;
		System.out.println("Pushed: "+item);
		//New minimum validation
		if (topMinStack==-1 || item < minStack[topMinStack]) {
			topMinStack++;
			minStack[topMinStack]=item;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("No items in Stack");
			return -1;
		}
		//if it was the minimum at top of Auxiliar Stack, pop it
		if (enhancedStack[top]==minStack[topMinStack]) {
			topMinStack--;
		}
		System.out.println("Poped: "+enhancedStack[top]);
		return enhancedStack[top--];
	}
	
	public int min() {
		return minStack[topMinStack];
	}
	

	public boolean isEmpty() {
		if (top==-1)
			return true;
		else
			return false;
	}
	
	public int peek() {
		
		if(isEmpty()) {
			return -1;
		}
		return enhancedStack[top];
	}
	
	public int size() {
		return top+1;
	}
	
	public static void main(String[] args){
		MinStack myEnhStack = new MinStack(5);
		
		myEnhStack.push(5);
		myEnhStack.push(4);
		myEnhStack.push(3);
		System.out.println("Minimum in Stack is: "+myEnhStack.min());
		myEnhStack.pop();
		System.out.println("New Minimum in Stack is: "+myEnhStack.min());
	}

}