
public class AddAll extends ExpressionCollector {
	@Override
	void evaluate() {
			Integer sum = 0;
			for(Expression e : super.list) {
				e.evaluate();
				sum += (Integer)(e.getValue());
			}
		
		
	
			super.value = sum;
		}
	}


