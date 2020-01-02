/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict = new WordDefinitionPair[MAX_CAPACITY];

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
		for (int ct = 0; ct < count; ct++) {
			WordDefinitionPair pair = this.dict[ct];
			if (pair.getWord().equals(word)) {
				return (String) pair.getDefinition();
			}
		}
		throw new WordNotInDictionaryException("");
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {

		if (count == dict.length) {

			throw new DictionaryFullException();

		}

		WordDefinitionPair[] dictCopy;
		dictCopy = new WordDefinitionPair[count + 1];

		for (int i = 0; i < count; i++) {

			if (((String) (dict[i].getWord())).equals(word)) {

				throw new WordAlreadyExistsInDictionaryException();

			}

			dictCopy[i] = dict[i];

		}

		dictCopy[count] = new WordDefinitionPair(word, definition);
		count++;
		for (int i = 0; i < count; i++) {

			dict[i] = dictCopy[i];

		}

//dict[count] = dictCopy[count];

		// TODO Auto-generated method stub

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub

		String def = "";
		String temp = "";
		int index = 0;
		boolean wordInDict = false;
		for (int i = 0; i < count; i++) {

			if (((String) (dict[i].getWord())).equals(word)) {

				wordInDict = true;
				temp = (String) (dict[i].getWord());
				index = i;
				def = (String) (dict[i].getDefinition());

			}

		}
		if (!wordInDict) {

			throw new WordNotInDictionaryException();

		}

		WordDefinitionPair[] wdp = new WordDefinitionPair[count - 1];
		int j = 0;
		for (int i = 0; i < count; i++) {

			if (index != i) {

				wdp[j] = dict[i];
				j++;

			}

		}

		dict[count - 1] = null;

		for (int i = 0; i < count - 1; i++) {

			dict[i] = wdp[i];

		}

		count--;

		return def;
	}

	@Override
	public String[] getWords() {
		// TODO Auto-generated method stub
		String[] wordList = new String[count];
		for (int i = 0; i < count; i++) {

			wordList[i] = (String) dict[i].getWord();

		}

		return wordList;
	}

	@Override
	public String[] getDefinitions() {
		// TODO Auto-generated method stub
		String[] defList = new String[count];
		for (int i = 0; i < count; i++) {

			defList[i] = (String) dict[i].getDefinition();

		}
		return defList;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub
		WordDefinitionPair[] w = new WordDefinitionPair[count];

		for (int i = 0; i < count; i++) {

			w[i] = dict[i];

		}

		return w;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
