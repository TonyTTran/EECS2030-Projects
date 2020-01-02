
public class DisjoinAll extends ExpressionCollector {
	void evaluate() {
		
		Boolean x = false;
		
			
			for(Expression e: super.list) {
				e.evaluate();
				x = x || (Boolean)e.getValue();
				
				
			}
			super.value = x;
			
		}
		
	

}
