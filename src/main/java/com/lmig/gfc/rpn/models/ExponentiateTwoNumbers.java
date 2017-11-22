package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class ExponentiateTwoNumbers extends TwoNumberCalculator {
		  public ExponentiateTwoNumbers(Stack<Double> stack) {
			super(stack);
			
		}

	  
	  @Override
	  protected double doMath( double first, double second) {
		  return Math.pow(first, second);
	  }
	}


