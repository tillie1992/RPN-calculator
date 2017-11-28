package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class SubtractTwoNumbersTogetherTests {

	private SubtractTwoNumbersTogether sub;
	private Stack<Double> dub;

	@Before
	public void setUp() {
		dub = new Stack<Double>();
		sub = new SubtractTwoNumbersTogether(dub);
	}

	@Test
	public void goDoIt_removes_two_numbers_subtracts_them_and_puts_the_result_back_on_the_stack() {

		// Arrange
		dub.push(-10.0);
		dub.push(3.0);

		sub.goDoIt();

		assertThat(dub.peek()).isEqualTo(-13.0);

	}
}
