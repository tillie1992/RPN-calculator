package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class AddTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private AddTwoNumbersTogether add;
	
	@Before
	public void setUp() {
		stack= new Stack<Double>();
		add = new AddTwoNumbersTogether(stack);
	}

	@Test
	public void goDoIt_add_the_first_and_second_numbers_together() {
		//Arrange
		stack.push(3.0);
		stack.push(4.0);
		//Act
		add.goDoIt();
		//Assert
		assertThat(stack.peek()).isEqualTo(7.0);
	}
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {
		// Arrange
		
		stack.push(4.0);
		stack.push(2.0);
		add.goDoIt();	
		// Act
		// this takes 
		add.undo(stack);
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
			add.goDoIt();
		} catch (EmptyStackException ese) {
			exceptionCaught = true;
		}
		//Assert
		assertThat(exceptionCaught).isTrue();
	}
	@Test
	public void null_stack_causes_NullPointerException_in_goDoIt() {
		//Arrange
		add= new AddTwoNumbersTogether(null);
		try {
			//Act
			add.goDoIt();
			//Assert
			fail("Somehow, this did not throw an NPE.");
		}catch(NullPointerException npe) {
			
		}
		
	}
}

