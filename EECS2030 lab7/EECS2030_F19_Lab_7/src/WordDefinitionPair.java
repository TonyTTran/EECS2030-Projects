
public class WordDefinitionPair {

	private String w2, d2;

	public WordDefinitionPair(String w2, String d2) {
		// TODO Auto-generated constructor stub
		this.w2 = w2;
		this.d2 = d2;

	}

	public Object getWord() {
		// TODO Auto-generated method stub
		return w2;
	}

	public Object getDefinition() {
		// TODO Auto-generated method stub
		return d2;
	}

	@Override
	public boolean equals(Object o) {

		if (o == null) {

			return false;
		}

		if (this.getClass() != o.getClass()) {

			return false;
		}

		WordDefinitionPair w = (WordDefinitionPair) o;

		String t = (String) this.getDefinition();
		String t2 = (String) w.getDefinition();

		if (!(t.equals(t2))) {

			return false;

		}

		t = (String) this.getWord();
		t2 = (String) w.getWord();

		if (!(t.equals(t2))) {

			return false;
		}
		return true;

	}

}
