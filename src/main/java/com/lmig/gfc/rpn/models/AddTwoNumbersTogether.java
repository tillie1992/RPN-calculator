package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class AddTwoNumbersTogether extends TwoNumberCalculator  implements Undoer{
	public AddTwoNumbersTogether(Stack<Double> stack) {
		super(stack);
	}
	

	@Override
	protected double doMath(double first, double second) {
		return second + first;
	}
	
	
	}


