package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class TwoArgumentUndoerTests {
	private Stack<Double> stack;
	private TwoArgumentUndoer und;
	
	@Before
	public void setUp() {
		stack= new Stack<Double>();
		und= new TwoArgumentUndoer(4,3);
	}	
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {
		// Arrange
		
		stack.push(565455.0);
		
		
		// Act
		// this takes 
		und.undo(stack);
		
		// Assert
		// this is what we expect the test to return when we 'undo'
		// 
		assertThat(stack.pop()).isEqualTo(4.0);
		assertThat(stack.pop()).isEqualTo(3.0);
	}
}
