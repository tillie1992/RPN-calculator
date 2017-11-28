package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MultiplyTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private MultiplyTwoNumbersTogether mult;
	
	@Before
	public void setUp() {
		stack= new Stack<Double>();
		mult = new MultiplyTwoNumbersTogether(stack);
	}




	@Test
	public void goDoIt_multiplies_the_first_and_second_numbers_together() {
		//Arrange
		stack.push(3.0);
		stack.push(4.0);
		//Act
		mult.goDoIt();
		//Assert
		assertThat(stack.peek()).isEqualTo(12.0);
	}
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {
		// Arrange
		
		stack.push(4.0);
		stack.push(2.0);
		mult.goDoIt();	
		// Act
		// this takes 
		mult.undo(stack);
		// Assert
		// this is what we expect the test to return when we 'undo'
		// 
		assertThat(stack.pop()).isEqualTo(2.0);
		assertThat(stack.pop()).isEqualTo(4.0);
	}
	
	@Test
	public void empty_stack_causes_goDoIt_to_throw_EmptyStackException() {
		// Arrange
		boolean exceptionCaught = false;
		// Act
		try {
			mult.goDoIt();
		} catch (EmptyStackException ese) {
			exceptionCaught = true;
		}
		//Assert
		assertThat(exceptionCaught).isTrue();
	}
	@Test
	public void null_stack_causes_NullPointerException_in_goDoIt() {
		//Arrange
		mult= new MultiplyTwoNumbersTogether(null);
		try {
			//Act
			mult.goDoIt();
			//Assert
			fail("Somehow, this did not throw an NPE.");
		}catch(NullPointerException npe) {
			
		}
		
	}
}




		
		
	

