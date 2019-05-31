package main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import tp6.analysis.Analysis;
import tp6.node.AAssignment;
import tp6.node.ABinexpression;
import tp6.node.ABlock;
import tp6.node.AConditional;
import tp6.node.ADiviserOperatorarith;
import tp6.node.AEqualOperatorlogique;
import tp6.node.AInfOperatorlogique;
import tp6.node.AIntegervalue;
import tp6.node.AMinusOperatorarith;
import tp6.node.AModuloOperatorarith;
import tp6.node.AMultiplierOperatorarith;
import tp6.node.APlusOperatorarith;
import tp6.node.APrintS;
import tp6.node.AReadS;
import tp6.node.ASupOperatorlogique;
import tp6.node.AVariableref;
import tp6.node.AWhileS;
import tp6.node.PStatement;


public class Evaluator extends AbstractInterpreter implements Analysis {

	private String variableRef = "";
	private Stack<Double> values = new Stack<Double>();
	private HashMap<String, Double> valuesDictionnary = new HashMap<String, Double>();

	@Override
	public void caseAAssignment(AAssignment node) {
		node.getVar().apply(this);
		String var = variableRef;
		node.getRhs().apply(this);
		valuesDictionnary.put(var, values.pop());
	}

	@Override
	public void caseABinexpression(ABinexpression node) {
		node.getRExp().apply(this);
		node.getLExp().apply(this);
		node.getOperator().apply(this);
	}

	@Override
	public void caseABlock(ABlock node) {
		for (PStatement p : node.getStatement()) {
			p.apply(this);
		}
	}

	@Override
	public void caseAConditional(AConditional node) {
		node.getCond().apply(this);
		if (values.pop() == 1)
			node.getThenpart().apply(this);
		else 
			node.getElsepart().apply(this);
	}

	@Override
	public void caseAEqualOperatorlogique(AEqualOperatorlogique node) {
		values.push( (values.pop().equals(values.pop())) ? 1.0 : 0.0);
	}

	@Override
	public void caseAInfOperatorlogique(AInfOperatorlogique node) {
		values.push( (values.pop() < values.pop()) ? 1.0 : 0.0);
	}

	@Override
	public void caseAIntegervalue(AIntegervalue node) {
		values.push((double) Integer.parseInt(node.getNumber().getText()));
	}

	@Override
	public void caseAMinusOperatorarith(AMinusOperatorarith node) {
		values.push(values.pop() - values.pop());
	}

	@Override
	public void caseAMultiplierOperatorarith(AMultiplierOperatorarith node) {
		values.push(values.pop() * values.pop());
	}

	@Override
	public void caseAPlusOperatorarith(APlusOperatorarith node) {
		values.push(values.pop() + values.pop());
	}

	@Override
	public void caseAPrintS(APrintS node) {
		node.getValue().apply(this);
		System.out.println(values.pop());
	}

	@Override
	public void caseAReadS(AReadS node) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir " + node.getVar().toString() + " : " );
		valuesDictionnary.put(node.getVar().toString(), sc.nextDouble());
	}

	@Override
	public void caseASupOperatorlogique(ASupOperatorlogique node) {
		values.push( (values.pop() > values.pop()) ? 1.0 : 0.0);
	}

	@Override
	public void caseAVariableref(AVariableref node) {
		variableRef = node.getIdentifier().toString();
		if (valuesDictionnary.containsKey(variableRef))
			values.push(valuesDictionnary.get(variableRef));
		else 
			values.push(0.0);
	}

	@Override
	public void caseAWhileS(AWhileS node) {
		node.getCond().apply(this);
		while (values.pop() == 1) {
			node.getBody().apply(this);
			node.getCond().apply(this);
		}
	}

	@Override
	public void caseADiviserOperatorarith(ADiviserOperatorarith node) {
		values.push(values.pop() / values.pop());
	}

	@Override
	public void caseAModuloOperatorarith(AModuloOperatorarith node) {
		values.push(values.pop() % values.pop());
	}
}