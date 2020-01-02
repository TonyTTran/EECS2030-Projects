
public class LessThan extends Expression {

	LessThan(int left, int right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	@Override
	void evaluate() {
		super.value = (Boolean)(super.left < super.right);
	}
}
