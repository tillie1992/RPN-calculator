package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class TwoArgumentUndoer extends OneArgumentUndoer{

	private double second;

	public TwoArgumentUndoer(double first, double second) {
		super(first);
		this.second = second;
	}
	
	public void undo(Stack<Double> stack) {
		
		//the stack.pop gets rid of the return
		stack.pop();
		//put two values back on
		stack.push(second);
		super.parentUndo(stack);
	
	}
	protected void parentUndo(Stack<Double> stack) {
		stack.push(second);
		super.parentUndo(stack);
	}
}
