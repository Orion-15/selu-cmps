public class IntStack {
	//Stack Vars
	int top;
	int[] intStack = new int[20];

//inception
	public void init(){
		top =-1; 
	}

//Pushing Var into stack
	public void push(int item) {
		top++;
		intStack[top] = item;
	}

//Removing from stack
	public int pop() {
		int item;
		item = intStack[top];
		top--;
		return item;
	}

// Check if empty (lack of stack)
	public boolean isEmpty(){
		boolean answer = false;
		if(top == -1) { answer = true;}
		return answer;
	}
	
}
