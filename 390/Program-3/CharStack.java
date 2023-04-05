public class CharStack {
	//Stack Vars
	int top;
	char[] stack = new char[20];

//inception
	public void init(){
		top =-1; 
	}

//Pushing Var into stack
	public void push(char item) {
		top++;
		stack[top] = item;
	}

//Removing from stack
	public char pop() {
		char item;
		item = stack[top];
		top--;
		return item;
	}

// Check if empty (lack of stack)
	public boolean isEmpty(){
		boolean answer = false;
		if(top == -1) { answer = true;}
		return answer;
	}

//Return Top
public int getTop() {
	if (!isEmpty()) {
		return stack[top];
	} else {
		System.exit(-1);
	}
	return -1;
}

// returnStack
	public String returnString() {
		String finalString = new String(stack);
		return finalString;
	}
}
