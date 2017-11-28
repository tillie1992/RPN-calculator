package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class AbsoluterOfOneNumberTests {
	private Stack<Double> stack;
	private AbsoluterOfOneNumber abs;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		abs = new AbsoluterOfOneNumber(stack);
	}

	@Test
	public void goDoIt_replaces_neg_number_on_stack_with_positive_number() {
		// Every unit test has 3 parts:

		// Arrange:
		// getting everything set up to run the method

		stack.push(-4.5);
		// Act:
		// call the method you want to test. Generally one line
		// of code.
		abs.goDoIt();

		// Assert:
		// checking the result
		// import from assertions.assertThat
		assertThat(stack.peek()).isEqualTo(4.5);
	}

	@Test
	public void goDoIt_leaves_positve_number_on_stack_with_positive_number() {
		// Every unit test has 3 parts:

		// Arrange:
		// getting everything set up to run the method

		stack.push(4.5);
		// Act:
		// call the method you want to test. Generally one line
		// of code.
		abs.goDoIt();

		// Assert:
		// checking the result
		// import from assertions.assertThat
		assertThat(stack.peek()).isEqualTo(4.5);
	}

	@Test
	public void undo_returns_the_stack_to_the_previous_state() {
		// Arrange
		// put -999 on to the stack
		stack.push(-999.0);
		abs.goDoIt();
		// Act
		// this changes the number on the stack to +999
		abs.undo(stack);
		// Assert
		// this is what we expect the test to return when we 'undo'
		// the +999
		assertThat(stack.peek()).isEqualTo(-999.0);
	}

	@Test
	public void empt_stack_causes_goDoIt_to_throw_EmptyStackException() {
		// Arrange
		// Already arranged because stack is empty
		// Act
		try {
			abs.goDoIt();
			// Assert
			fail("Did not throw an EmptStackException");
		} catch (EmptyStackException ese) {

		}

	}

	@Test
	public void empty_stack_causes_goDoIt_to_throw_EmptyStackException() {
		// Arrange
		boolean exceptionCaught = false;
		// Act
		try {
			abs.goDoIt();
		} catch (EmptyStackException ese) {
			exceptionCaught = true;
		}
		//Assert
		assertThat(exceptionCaught).isTrue();
	}
	@Test
	public void null_stack_causes_NullPointerException_in_goDoIt() {
		//Arrange
		abs= new AbsoluterOfOneNumber(null);
		try {
			//Act
			abs.goDoIt();
			//Assert
			fail("Somehow, this did not throw an NPE.");
		}catch(NullPointerException npe) {
			
		}
		
	}
}
