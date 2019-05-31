package main;

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


public class PrettyPrinter extends AbstractInterpreter implements Analysis {

	private int nbIndent = 0;

	private void print(String s) {
		String indent = "";
		for (int i = 0; i < nbIndent; i++) {
			indent += "  ";
		}
		System.out.print(indent + s);
	}

	@Override
	public void caseAAssignment(AAssignment node) {
		print("");
		node.getVar().apply(this);
		System.out.print("= ");
		node.getRhs().apply(this);
	}

	@Override
	public void caseABinexpression(ABinexpression node) {
		System.out.print("( ");
		node.getLExp().apply(this);
		node.getOperator().apply(this);
		node.getRExp().apply(this);
		System.out.print(")");
	}

	@Override
	public void caseABlock(ABlock node) {
		System.out.println("{");
		nbIndent++;
		for (PStatement p : node.getStatement()) {
			p.apply(this);
			System.out.println("");
		}	
		nbIndent--;
		print("}");
	}

	@Override
	public void caseAConditional(AConditional node) {
		print("if ");
		node.getCond().apply(this);
		System.out.print(" ");
		node.getThenpart().apply(this);
		if (node.getElsepart() != null) {
			System.out.println();
			print("else ");
			node.getElsepart().apply(this);;
		}
	}

	@Override
	public void caseAEqualOperatorlogique(AEqualOperatorlogique node) {
		System.out.print("== ");
	}

	@Override
	public void caseAInfOperatorlogique(AInfOperatorlogique node) {
		System.out.print("< ");
	}

	@Override
	public void caseAIntegervalue(AIntegervalue node) {
		System.out.print(node.getNumber());
	}

	@Override
	public void caseAMinusOperatorarith(AMinusOperatorarith node) {
		System.out.print("- ");
	}

	@Override
	public void caseAMultiplierOperatorarith(AMultiplierOperatorarith node) {
		System.out.print("* ");
	}

	@Override
	public void caseAPlusOperatorarith(APlusOperatorarith node) {
		System.out.print("+ ");
	}

	@Override
	public void caseAPrintS(APrintS node) {
		print("print( ");
		node.getValue().apply(this);
		System.out.print(")");
	}

	@Override
	public void caseAReadS(AReadS node) {
		print("read( ");
		node.getVar().apply(this);
		System.out.print(")");
	}

	@Override
	public void caseASupOperatorlogique(ASupOperatorlogique node) {
		System.out.print("> ");
	}

	@Override
	public void caseAVariableref(AVariableref node) {
		System.out.print(node.getIdentifier());
	}

	@Override
	public void caseAWhileS(AWhileS node) {
		print("while ");
		node.getCond().apply(this);
		System.out.print(" ");
		node.getBody().apply(this);
	}

	@Override
	public void caseADiviserOperatorarith(ADiviserOperatorarith node) {
		System.out.print("/ ");
	}

	@Override
	public void caseAModuloOperatorarith(AModuloOperatorarith node) {
		System.out.print("% ");
	}
}