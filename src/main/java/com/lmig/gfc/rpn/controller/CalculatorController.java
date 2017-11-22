package com.lmig.gfc.rpn.controller;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lmig.gfc.rpn.models.AddTwoNumbersTogether;
import com.lmig.gfc.rpn.models.DivideTwoNumbersTogether;
import com.lmig.gfc.rpn.models.ExponentiateTwoNumbers;
import com.lmig.gfc.rpn.models.MultiplyTwoNumbersTogether;
import com.lmig.gfc.rpn.models.OneArgumentUndoer;
import com.lmig.gfc.rpn.models.PushUndoer;
import com.lmig.gfc.rpn.models.SubtractTwoNumbersTogether;
import com.lmig.gfc.rpn.models.TwoNumberCalculator;
import com.lmig.gfc.rpn.models.Undoer;

@Controller
public class CalculatorController {
	private Stack<Double> stack;
	private Stack<Undoer> undoers;

	public CalculatorController() {
		stack = new Stack<Double>();
		undoers=new Stack<Undoer>();
	}

	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stack", stack);
		
		mv.addObject("hasTwoOrMoreNumbers", stack.size() >= 2);
		mv.addObject("hasUndoer", undoers.size() > 0);
		mv.setViewName("calculator");
		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		stack.push(value);
		undoers.push (new PushUndoer());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	@PostMapping("/divide")
	public ModelAndView divideTwoNumbers() {
		DivideTwoNumbersTogether divider= new DivideTwoNumbersTogether(stack);
		return doOperation(divider);
	}
	@PostMapping("/multiply")
	public ModelAndView multiplyTwoNumbers() {
		MultiplyTwoNumbersTogether multiplier= new MultiplyTwoNumbersTogether(stack);
		return doOperation(multiplier);
	}
	@PostMapping("/add")
	public ModelAndView addTwoNumbers() {
		AddTwoNumbersTogether adder= new AddTwoNumbersTogether(stack);
		return doOperation(adder);
	}

	@PostMapping("/minus")
	public ModelAndView subtractTwoNumbers() {
		SubtractTwoNumbersTogether subtract=new SubtractTwoNumbersTogether(stack);
		return doOperation(subtract);
	}
	@PostMapping("/exponentiate")
	public ModelAndView exponentiateTwoNumbers() {
		ExponentiateTwoNumbers exponentiate = new ExponentiateTwoNumbers(stack);
		return doOperation(exponentiate);
	}
	@PostMapping("/undo")
	public ModelAndView undo() {
		ModelAndView mv=new ModelAndView();
		Undoer undoer =undoers.pop();
		undoer.undo(stack);
		
		mv.setViewName("redirect:/");
		return mv;
		
	}
	
	@PostMapping("/abs")
	public ModelAndView absoluteValue() {
		double value=stack.pop();
		//taking the 'new OneArgumentUndoer' and putting into the undoers stack
		undoers.push(new OneArgumentUndoer(value));
	//	double result=Math.abs(value);
		if(value<0) {
			value=-1 * value;
			}
		stack.push(value);
		
			
	ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/");
	return mv;
}
	private ModelAndView doOperation(TwoNumberCalculator calcy) {
		calcy.goDoIt();
		undoers.push(calcy);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/");
	return mv;
		
	}
}
