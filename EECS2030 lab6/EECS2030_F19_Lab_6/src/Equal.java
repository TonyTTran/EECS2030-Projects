
public class Equal extends Expression {

	Equal(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	@Override
	void evaluate() {
		super.value = (Boolean)(super.left == super.right);
	}

}
