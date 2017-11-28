package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class DivideTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private DivideTwoNumbersTogether div;
	
	@Before
	public void setUp() {
		stack= new Stack<Double>();
		div = new DivideTwoNumbersTogether(stack);
	}

	@Test
	public void goDoIt_divides_the_first_number_by_the_second_numbers_together() {
		//Arrange
		stack.push(8.0);
		stack.push(4.0);
		//Act
		div.goDoIt();
		//Assert
		assertThat(stack.peek()).isEqualTo(2.0);
	}
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {
		// Arrange
		
		stack.push(8.0);
		stack.push(2.0);
		div.goDoIt();	
		// Act
		// this takes 
		div.undo(stack);
		// Assert
		// this is what we expect the test to return when we 'undo'
		// 
		assertThat(stack.pop()).isEqualTo(2.0);
		assertThat(stack.pop()).isEqualTo(8.0);
	}
	
	@Test
	public void empty_stack_causes_goDoIt_to_throw_EmptyStackException() {
		// Arrange
		boolean exceptionCaught = false;
		// Act
		try {
			div.goDoIt();
		} catch (EmptyStackException ese) {
			exceptionCaught = true;
		}
		//Assert
		assertThat(exceptionCaught).isTrue();
	}
	@Test
	public void null_stack_causes_NullPointerException_in_goDoIt() {
		//Arrange
		div= new DivideTwoNumbersTogether(null);
		try {
			//Act
			div.goDoIt();
			//Assert
			fail("Somehow, this did not throw an NPE.");
		}catch(NullPointerException npe) {
			
		}
		
	}
}
