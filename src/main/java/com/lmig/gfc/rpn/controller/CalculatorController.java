package com.lmig.gfc.rpn.controller;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.AbsoluterOfOneNumber;
import com.lmig.gfc.rpn.models.AddTwoNumbersTogether;
import com.lmig.gfc.rpn.models.DivideTwoNumbersTogether;
import com.lmig.gfc.rpn.models.ExponentiateTwoNumbers;
import com.lmig.gfc.rpn.models.Godoer;
import com.lmig.gfc.rpn.models.MultiplyTwoNumbersTogether;
import com.lmig.gfc.rpn.models.OneArgumentUndoer;
import com.lmig.gfc.rpn.models.ItDoesThePushing;
import com.lmig.gfc.rpn.models.SubtractTwoNumbersTogether;
import com.lmig.gfc.rpn.models.TwoNumberCalculator;
import com.lmig.gfc.rpn.models.Undoer;

@Controller
public class CalculatorController {
	private Stack<Double> stack;
	private Stack<Godoer> undoers;
	private Stack<Godoer> redoers;

	public CalculatorController() {
		stack = new Stack<Double>();
		undoers = new Stack<Godoer>();
		redoers=new Stack<Godoer>();
	}

	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stack", stack);
		mv.addObject("hasOneOrMoreNumbers", stack.size() >= 1);
		mv.addObject("hasTwoOrMoreNumbers", stack.size() >= 2);
		mv.addObject("hasUndoer", undoers.size() > 0);
		mv.addObject("hasRedoer", redoers.size() > 0);
		mv.setViewName("calculator");
		return mv;
	}

	
	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		ItDoesThePushing pusher = new ItDoesThePushing(stack, value);
		return doOperation(pusher);
	}

	@PostMapping("/divide")
	public ModelAndView divideTwoNumbers() {
		DivideTwoNumbersTogether divider = new DivideTwoNumbersTogether(stack);
		return doOperation(divider);
	}

	@PostMapping("/multiply")
	public ModelAndView multiplyTwoNumbers() {
		MultiplyTwoNumbersTogether multiplier = new MultiplyTwoNumbersTogether(stack);
		return doOperation(multiplier);
	}

	@PostMapping("/add")
	public ModelAndView addTwoNumbers() {
		AddTwoNumbersTogether adder = new AddTwoNumbersTogether(stack);
		return doOperation(adder);
	}

	@PostMapping("/minus")
	public ModelAndView subtractTwoNumbers() {
		SubtractTwoNumbersTogether subtract = new SubtractTwoNumbersTogether(stack);
		return doOperation(subtract);
	}

	@PostMapping("/exponentiate")
	public ModelAndView exponentiateTwoNumbers() {
		ExponentiateTwoNumbers exponentiate = new ExponentiateTwoNumbers(stack);
		return doOperation(exponentiate);
	}

	@PostMapping("/undo")
	public ModelAndView undo() {
		Godoer undoer = undoers.pop();
		undoer.undo(stack);
		redoers.push(undoer);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/redo")
	public ModelAndView redo() {
		
		Godoer godoer = redoers.pop();
		godoer.goDoIt();
		undoers.push(godoer);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

		
	
	

	@PostMapping("/abs")
	public ModelAndView absoluteValue() {
		AbsoluterOfOneNumber absoluter = new AbsoluterOfOneNumber(stack);
		return doOperation(absoluter);
		
		
	}

	private ModelAndView doOperation(Godoer calcy) {
		calcy.goDoIt();
		undoers.push(calcy);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;

	}
}
