package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class SubtractTwoNumbersTogether extends TwoNumberCalculator implements Undoer {

	public SubtractTwoNumbersTogether(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double first, double second) {
		return second - first;
	}
}
