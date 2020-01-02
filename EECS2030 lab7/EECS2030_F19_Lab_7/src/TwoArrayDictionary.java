/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	String[] words = new String[MAX_CAPACITY];
	String[] definitions = new String[MAX_CAPACITY];

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0 ? true : false;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub
		boolean wordIsReal = false;
		int index = 0;
		for (int i = 0; i < count; i++) {

			if (words[i].equals(word)) {

				index = i;
				wordIsReal = true;
				break;
			}

		}

		if (!wordIsReal) {

			throw new WordNotInDictionaryException();
		}

		return definitions[index];
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		// TODO Auto-generated method stub
		if (count == MAX_CAPACITY) {

			throw new DictionaryFullException();

		}

		for (int i = 0; i < count; i++) {

			if (words[i].equals(word)) {

				throw new WordAlreadyExistsInDictionaryException();
			}

		}

		words[count] = word;
		definitions[count] = definition;
		count++;

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub

		boolean wordInDictionary = false;
		int index = 0;
		String defCopy = "";
		for (int i = 0; i < count; i++) {

			if (words[i].equals(word)) {

				wordInDictionary = true;
				index = i;
				defCopy = definitions[i];

			}

		}

		if (!wordInDictionary) {

			throw new WordNotInDictionaryException();

		}

		String[] w = new String[count - 1];

		String[] d = new String[count - 1]; // changed t 1 less

		int j = 0;
		// words[] = null;
		// definitions[index] = null;

		for (int i = 0; i < count; i++) {

			if (index != i) {

				w[j] = words[i];
				d[j] = definitions[i];

				j++;

			}

		}
		words[count - 1] = null;
		definitions[count - 1] = null;

		for (int i = 0; i < count - 1; i++) {

			words[i] = w[i];
			definitions[i] = d[i];

		}

		count--;

		return defCopy;

	}

	@Override
	public String[] getWords() {
		// TODO Auto-generated method stub

		String[] wordList = new String[count];

		for (int i = 0; i < count; i++) { // changed to -1 from count

			wordList[i] = words[i];

		}

		return wordList;
	}

	@Override
	public String[] getDefinitions() {
		// TODO Auto-generated method stub

		String[] defList = new String[count];

		for (int i = 0; i < count; i++) {

			defList[i] = definitions[i];

		}

		return defList;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub

		WordDefinitionPair[] w = new WordDefinitionPair[count];

		for (int i = 0; i < count; i++) {

			w[i] = new WordDefinitionPair(words[i], definitions[i]);

		}

		return w;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
