
public class Addition extends Expression {

	Addition(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	void evaluate()
	{
		super.value = (Integer)(super.left + super.right);
	}
	
}
