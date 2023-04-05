import java.io.*;
import java.io.IOException;

class Tests {
	public static void main(String[] args) throws IOException {
		//Validations
		System.out.println("Validation" );
		System.out.println(validate(FileRead.returnLine(3)));





    }
	
	public static boolean validate(String eq) {
		CharStack s = new CharStack();
		char sel;	//Selection
		boolean error = false;
		// Initialize
		s.init();

	// Loop
		for(int i = 0; i < eq.length(); i++) {
			sel = eq.charAt(i);
			if(sel == '('){ s.push(sel); }
			if(sel == ')'){ s.push(sel); }
			// excess
			if(s.isEmpty() == true){
				System.out.println("Error: excess parenthesis [closed]");
				error = true;
			} else { s.pop(); }
		}	// End loop
		if(s.isEmpty() == false) {
			System.out.println("Error: excess parenthesis [open]");
			error = true;
		}
		return error;
	} // End Validation


	public static String Translate(String eq) {
		CharStack post = new CharStack(); // Postfix stack
		CharStack op = new CharStack();	  // Operation stack
		char sel, selOp;
		
		// Initalize
		post.init();
		op.init();


	// Loop
		for(int i = 0; i < eq.length(); i++) {
			sel = eq.charAt(i);

			//If num
			if(sel >= '0' && sel <= '9'){ 
				post.push(sel); 
			}
			//If operator
			else if(sel == '+' || sel == '-' || sel == '*' || sel == '/') { 
				op.push(sel); 
			}
			//if ) pop operations + push post
			else if(sel == ')' ){
				selOp = op.pop();
				post.push(selOp);
			} 
		} // end loop

	// Finish 
		while(op.isEmpty() == false){
			selOp = op.pop();
			post.push(selOp);
		}

	// Return Postfix
	return post.returnString();
	} 


	public static int Evaluate(String eq){
		IntStack s = new IntStack();
		int x, y, z, num;
		char sel;
		
		// Initialization
		s.init();

	// Loop
		for(int i = 0; i < eq.length(); i++){
			sel = eq.charAt(i);

			//if num 
			if(sel >= '0' && sel <= '9'){ 
				num = sel - '0';
				s.push(num);
			}

			//If Op, do op
				// Addition
				if(sel == '+') {
					y = s.pop();
					x = s.pop();
					z = x + y;
					s.push(z);
				}
				
				//Subtraction
				if(sel == '-') {
					y = s.pop();
					x = s.pop();
					z = x - y;
					s.push(z);
				}

				// Multiplication
				if(sel == '*') {
					y = s.pop();
					x = s.pop();
					z = x * y;
					s.push(z);
				}

				//Division
				if(sel == '/') {
					y = s.pop();
					x = s.pop();
					z = x / y;
					s.push(z);
				}
		}
		return s.pop();
	} // Evaluate
}
