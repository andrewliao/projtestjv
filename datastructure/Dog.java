package datastructure;

public class Dog extends Pet{
	public static void main(String[] args) {
		char c = '1';
		System.out.println(Character.getNumericValue(c) + 3);
		
	}
	
	public static double prefixExpr (String expr) {
		//this stores all the non operations operands
		MyStack<Double> variables = new MyStack<Double>();
		for(int i = expr.length() - 1; i > -1; i--) {
			//if the character at index i is not an operator we will push it to the stack
			if(expr.charAt(i) != '+' || expr.charAt(i) != '-' || expr.charAt(i) != '*' || expr.charAt(i) != '/' ) {
				variables.push(Character.getNumericValue(expr.charAt(i)));
			} else {
				//if the character at index i is an operator we will pop two elements at the stack and
				//complete the operation indicated by the operand located at index i
				if(expr.charAt(i) == '+') {
					int combinedOperands = variables.pop() + variables.pop();
					variables.push(combinedOperands);
				} else if(expr.charAt(i) == '-') {
					int combinedOperands = variables.pop() - variables.pop();
					variables.push(combinedOperands);
				} else if(expr.charAt(i) == '*') {
					int combinedOperands = variables.pop() * variables.pop();
					variables.push(combinedOperands);
				} else if(expr.charAt(i) == '/') {
					int combinedOperands = variables.pop() / variables.pop();
					variables.push(combinedOperands);
				}
			}
		} 
		//at the end we should just have one value in the stack which we will pop as this is the final result of the prefix operation
		return variables.pop();
		
	}
}
