import java.util.ArrayList;
import java.util.List;

/*
 * Your Tasks:
 * 1. Read the problem description and inheritance hierarchy diagram in the instructions.
 * 2. Add the necessary subclasses and implement the required methods.
 * 3. Study tests in TestExpressions.java to understand what's required to help your implementation. 
 */

public class ExpressionCollector { 

	/*
	 * Your Task:
	 * Declare attribute(s) to store the list of Expression objects of this collector.
	 */

	/**
	 * Initialize an expression collector which stores an empty collection of expressions.  
	 */
	List<Expression> list;
	Object value;
	
	ExpressionCollector() {
		/* Your Task */
		list = new ArrayList<Expression>();
	}

	/**
	 * Add a new expression.
	 * @param e an expression
	 */
	void addExpression(Expression e) { 
		
		this.list.add(e);
		/* Your Task */
	}

	/**
	 * Add a new expression.
	 * @param left integer value of the left operand 
	 * @param op operator (i.e., "+", "-", "*", ">", "<", "==")
	 * @param right integer value of the right operand
	 */
	void addExpression(int left, String op, int right) {
		/* Your Task */
		// Hint: Depending on the operator given (e.g., +), create the corresponding expression object
		// (e.g., Addition) and add it to the collector.
		
		if(op.contentEquals("+")) {
			Expression e = new Addition(left, right);
			this.list.add(e);
		}
		else if(op.contentEquals("-")) {
		
			Expression e = new Subtraction(left, right);
			this.list.add(e);
		}
		else if(op.contentEquals("*")) {
			Expression e = new Multiplication(left, right);
			this.list.add(e);
		}
		else if(op.contentEquals(">")) {
			Expression e = new GreaterThan(left, right);
			this.list.add(e);
		}
		else if(op.contentEquals("<")) {
			Expression e = new  LessThan(left, right);
			this.list.add(e);
		}
		else {
			Expression e = new  Equal(left, right);
			this.list.add(e);
		}
		
	
	}

	/**
	 * If this collector is AddAll or TimesAll, then all stored expressions must be integer expressions
	 * (i.e., Addition, Subtraction, Multiplication).
	 * If this collection is ConjoinAll or DisjoinAll, then all stored expressions must be boolean expressions
	 * (i.e., GreaterThan, LessThan, Equal)
	 * @return whether it is possible to evaluate the stored collection of expressions.   
	 */
	boolean isTypeCorrect() {
		int i = 0;
		int b = 0;
		for(Expression e: this.list) {
			if(e instanceof Addition || e instanceof Subtraction || e instanceof Multiplication) {
				i++;
			}
			else if(e instanceof GreaterThan || e instanceof LessThan || e instanceof Equal) {
				b++;
			}
		}
		
		if(i == list.size() || b == list.size()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Given that this expression collector is type correct (see `isTypeCorrect()`),
	 * evaluate it. Store the evaluation result so that it can be returned by `getValue()`. 
	 */
	void evaluate() {
		/* Your Task */ 
		// Hint: Leave this empty and override it in all subclasses such as AddAll and ConjoinAll.
	}

	/**
	 * Get the result of the latest evaluation (i.e., after the latest call to `evaluate()`).
	 * @return the last evaluation result.
	 */
	Object getValue() {
		/* Your Task */
		evaluate();
		return this.value;
	}
	
	/**
	 * Obtain the list of stored expressions.
	 * @return all stored expressions as an array
	 */
	Expression[] getExpressions() {
		/* Your Task */
		Expression[]  e = new Expression[this.list.size()];
		for(int i = 0; i < e.length; i ++) {
			e[i] = this.list.get(i);
		}
		return e;
	}

	/**
	 * Override the equals method. Two expression collectors are equals if:
	 * 1) They are both type correct 2) Their evaluation results are identical
	 * @return whether or not the two expression collectors are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if(isTypeCorrect() && ((ExpressionCollector)(obj)).isTypeCorrect() && this.value == ((ExpressionCollector)(obj)).getValue()) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
