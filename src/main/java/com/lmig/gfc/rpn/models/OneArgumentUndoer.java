package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class OneArgumentUndoer implements Undoer {
	private double first;

	public OneArgumentUndoer(double first) {
		this.first = first;

	}

	public void undo(Stack<Double> stack) {

		// the stack.pop gets rid of the return
		stack.pop();
		// put one value back on
		parentUndo(stack);
	}

	protected void parentUndo(Stack<Double> stack) {

		stack.push(first);
	}

}
