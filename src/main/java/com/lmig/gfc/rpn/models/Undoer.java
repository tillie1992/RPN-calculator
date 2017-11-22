package com.lmig.gfc.rpn.models;

import java.util.Stack;

public interface Undoer {
	
	//declared the method 
	//communicating the minimum expectation of the behavior of the class
	public void undo(Stack<Double>stack);

}
