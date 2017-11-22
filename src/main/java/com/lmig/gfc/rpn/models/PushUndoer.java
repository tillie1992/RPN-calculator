package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class PushUndoer implements Undoer {
//is a quick check to make sure our "public void undo" is the same as in the one and two argument
	@Override
	public void undo(Stack<Double> stack) {
	stack.pop();
		
	}

}
