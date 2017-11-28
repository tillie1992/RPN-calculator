package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class AbsoluterOfOneNumber implements Godoer,Undoer{
	
	private Stack<Double> stack;
	private OneArgumentUndoer myundoer;
	
	public AbsoluterOfOneNumber(Stack<Double> stack) {
		this.stack=stack;
		
	}
	//this is a method 
	//the result of this method is to return the absolute value
	//there will be three unit tests for this method: 
	//one to test a positive number-this is the happy path test 
	//one to test a negative number-this is the happy path test
	//to test if the stack is empty
	public void goDoIt() {
		double value=stack.pop();
		double result= Math.abs(value);
		stack.push(result);
		myundoer= new OneArgumentUndoer(value);
	}
	//this is a method
	@Override
	public void undo(Stack<Double> stack) {
		myundoer.undo(stack);
		
		
	}

}
