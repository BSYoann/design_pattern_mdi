
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import tp6.analysis.Analysis;
import tp6.node.AAssignment;
import tp6.node.AAssignmentStatement;
import tp6.node.ABinexpression;
import tp6.node.ABinexpressionExpression;
import tp6.node.ABlock;
import tp6.node.ABlockStatement;
import tp6.node.AConditional;
import tp6.node.AConditionalStatement;
import tp6.node.ADiviserOperatorarith;
import tp6.node.AEqualOperatorlogique;
import tp6.node.AGrammar;
import tp6.node.AInfOperatorlogique;
import tp6.node.AIntegervalue;
import tp6.node.AIntegervalueUniexpression;
import tp6.node.AMinusOperatorarith;
import tp6.node.AModuloOperatorarith;
import tp6.node.AMultiplierOperatorarith;
import tp6.node.AOperatorarithOperator;
import tp6.node.AOperatorlogiqueOperator;
import tp6.node.APlusOperatorarith;
import tp6.node.APrintS;
import tp6.node.APrintSStatement;
import tp6.node.AReadS;
import tp6.node.AReadSStatement;
import tp6.node.ASupOperatorlogique;
import tp6.node.AUniexpressionExpression;
import tp6.node.AVariableref;
import tp6.node.AVariablerefUniexpression;
import tp6.node.AWhileS;
import tp6.node.AWhileSStatement;
import tp6.node.EOF;
import tp6.node.Node;
import tp6.node.PBlock;
import tp6.node.PStatement;
import tp6.node.Start;
import tp6.node.TAssign;
import tp6.node.TBlank;
import tp6.node.TCbrace;
import tp6.node.TComa;
import tp6.node.TDiv;
import tp6.node.TElse;
import tp6.node.TEqual;
import tp6.node.TIdentifier;
import tp6.node.TIf;
import tp6.node.TInf;
import tp6.node.TLPar;
import tp6.node.TMinus;
import tp6.node.TModulo;
import tp6.node.TMultiplier;
import tp6.node.TNewLine;
import tp6.node.TNumber;
import tp6.node.TObrace;
import tp6.node.TPlus;
import tp6.node.TPrint;
import tp6.node.TRPar;
import tp6.node.TRead;
import tp6.node.TSemi;
import tp6.node.TSup;
import tp6.node.TThen;
import tp6.node.TWhile;


public abstract class AbstractInterpreter implements Analysis {

	
	@Override
	public abstract void caseAAssignment(AAssignment node) ;
	@Override
	public void caseAAssignmentStatement(AAssignmentStatement node) {
		node.getAssignment().apply(this);
		
	}

	@Override
	public abstract void caseABinexpression(ABinexpression node);
	@Override
	public void caseABinexpressionExpression(ABinexpressionExpression node) {
		node.getBinexpression().apply(this);
	}

	@Override
	public abstract void caseABlock(ABlock node) ;
	
	@Override
	public void caseABlockStatement(ABlockStatement node) {
		node.getBlock().apply(this);
	}

	@Override
	public abstract void caseAConditional(AConditional node) ;
	@Override
	public void caseAConditionalStatement(AConditionalStatement node) {
		node.getConditional().apply(this);
	}

	@Override
	public abstract void caseAEqualOperatorlogique(AEqualOperatorlogique node) ;
	@Override
	public void caseAGrammar(AGrammar node) {
		for (PBlock p : node.getBlock()){
			p.apply(this);
		}
	}

	@Override
	public abstract void caseAInfOperatorlogique(AInfOperatorlogique node) ;

	@Override
	public abstract void caseAIntegervalue(AIntegervalue node) ;

	@Override
	public void caseAIntegervalueUniexpression(AIntegervalueUniexpression node) {
		node.getIntegervalue().apply(this);
	}

	@Override
	public abstract void caseAMinusOperatorarith(AMinusOperatorarith node) ;

	@Override
	public abstract void caseAMultiplierOperatorarith(AMultiplierOperatorarith node) ;

	@Override
	public void caseAOperatorarithOperator(AOperatorarithOperator node) {
		node.getOperatorarith().apply(this);
	}	

	@Override
	public void caseAOperatorlogiqueOperator(AOperatorlogiqueOperator node) {
		node.getOperatorlogique().apply(this);
	}

	@Override
	public abstract void caseAPlusOperatorarith(APlusOperatorarith node) ;
	@Override
	public abstract void caseAPrintS(APrintS node) ;

	@Override
	public void caseAPrintSStatement(APrintSStatement node) {
		node.getPrintS().apply(this);

	}

	@Override
	public abstract void caseAReadS(AReadS node);

	@Override
	public void caseAReadSStatement(AReadSStatement node) {
		node.getReadS().apply(this);
		
	}
	@Override
	public  abstract void caseADiviserOperatorarith(ADiviserOperatorarith node);

	@Override
	public abstract void caseAModuloOperatorarith(AModuloOperatorarith node) ;
	
	
	@Override
	public abstract void caseASupOperatorlogique(ASupOperatorlogique node);

	@Override
	public void caseAUniexpressionExpression(AUniexpressionExpression node) {
		node.getUniexpression().apply(this);
	}

	@Override
	public abstract void caseAVariableref(AVariableref node) ;

	@Override
	public void caseAVariablerefUniexpression(AVariablerefUniexpression node) {
		node.getVariableref().apply(this);
	}

	@Override
	public abstract void caseAWhileS(AWhileS node) ;

	@Override
	public void caseAWhileSStatement(AWhileSStatement node) {
		node.getWhileS().apply(this);
	}

	@Override
	public void caseEOF(EOF node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseStart(Start node) {
		node.getPGrammar().apply(this);
	}

	@Override
	public void caseTAssign(TAssign node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTBlank(TBlank node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTCbrace(TCbrace node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTComa(TComa node) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void caseTElse(TElse node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTEqual(TEqual node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTIdentifier(TIdentifier node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTIf(TIf node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTInf(TInf node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTLPar(TLPar node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTMinus(TMinus node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTMultiplier(TMultiplier node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTNewLine(TNewLine node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTNumber(TNumber node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTObrace(TObrace node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTPlus(TPlus node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTPrint(TPrint node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTRPar(TRPar node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTRead(TRead node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTSemi(TSemi node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTSup(TSup node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTThen(TThen node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTWhile(TWhile node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getIn(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getOut(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIn(Node node, Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOut(Node node, Object o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void caseTDiv(TDiv node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caseTModulo(TModulo node) {
		// TODO Auto-generated method stub
		
	}

}
