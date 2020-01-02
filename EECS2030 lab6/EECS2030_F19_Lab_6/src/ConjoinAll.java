
public class ConjoinAll extends ExpressionCollector {
	@Override
	void evaluate() {
		

			Boolean x = true;
			for(Expression e: super.list) {
				e.evaluate();
				x = x && (Boolean)e.value;
		}
			super.value = x;
		}		
		
	}


