
public class TimesAll extends ExpressionCollector {
	void evaluate() {
		
				
			Integer sum = 1;
			for(Expression e: super.list) {
				e.evaluate();
				sum *= (Integer)e.getValue();
				
			}
		
			super.value = sum;
		}
	}


