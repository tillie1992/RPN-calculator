package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class ItDoesThePushing implements Godoer {
	private Stack<Double> stack;
	private double valueToPush;
	
	public ItDoesThePushing (Stack<Double> stack, double valueToPush) {
		this.stack= stack;
		this.valueToPush=valueToPush;
	 
	}
//is a quick check to make sure our "public void undo" is the same as in the one and two argument
	@Override
	public void undo(Stack<Double> stack) {
	stack.pop();
		
	}

@Override
public void goDoIt() {
	
	stack.push(valueToPush);
	
	
}

}
