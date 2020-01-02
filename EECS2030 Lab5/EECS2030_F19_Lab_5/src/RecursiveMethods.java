import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 * You may review the recording of parts of Lecture 14 (October 28): 
 * 		https://youtu.be/J2CB3QHinQU 
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticArrayHelper.
		 */

		if (n > 0) {
			int[] a = new int[n];
			a[0] = start;

			arithmeticArrayHelper(1, diff, a);

			return a;
		} else
			return new int[] {};

	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		/*
		 * Your Task
		 */

		if (i >= seq.length)
			return;

		seq[i] = seq[i - 1] + diff;

		arithmeticArrayHelper(i + 1, diff, seq);

	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */

		List<Integer> art = new ArrayList<Integer>();
		if (n == 0) {
			return art;
		}
		art.add(0, start);

		if (n == 1) {
			return art;
		}

		else {
			arithmeticListHelper(1, diff, art, n);
			return art;
		}

	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		/*
		 * Your Task
		 */
		if (i < (n)) {
			seq.add(i, seq.get(i - 1) + diff);
			arithmeticListHelper(i + 1, diff, seq, n);
		} else if (i == (n)) {
			return;
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticArrayHelper.
		 */

		if (a.length == 0 || a.length == 1 || a.length == 2) {
			return true;
		} else {
			int diff = a[1] - a[0];
			return isArithmeticArrayHelper(1, diff, a);
		}

	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		if (i != a.length - 2) {
			return (a[i + 1] - a[i] == diff && isArithmeticArrayHelper(i + 1, diff, a));
		} else {
			return (a[i + 1] - a[i] == diff);
		}

	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticListHelper.
		 */
		if (l.isEmpty() || l.size() == 1 || l.size() == 2) {
			return true;
		} else {
			int diff = l.get(1) - l.get(0);
			return isArithmeticListHelper(2, diff, l);
		}

	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * Your Task
		 */
		if ((i == l.size() - 1) && (l.get(i) - l.get(i - 1) == diff)) {
			return true;
		} else if (l.get(i) - l.get(i - 1) == diff) {
			return isArithmeticListHelper(i + 1, diff, l);
		} else {
			return false;
		}
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 * 
		 */
		int counter = 0;
		int[] answer = new int[a.length + 1];
		if (a.length == 0) {
			answer[0] = i;
			return answer;
		} else if (i >= a[a.length - 1]) {
			sortArrayHelper(answer, a, i, counter);
			answer[a.length] = i;
			return answer;
		}

		sortArrayHelper(answer, a, i, counter);
		answer[a.length] = a[a.length - 1];

		return answer;
	}

	void sortArrayHelper(int[] a, int[] b, int i, int counter) {
		if (counter == b.length) {
			return;
		} else if (b[counter] < i) {
			a[counter] = b[counter];
			counter++;
			sortArrayHelper(a, b, i, counter);
		} else {
			a[counter] = i;
			i = b[counter];
			counter++;
			sortArrayHelper(a, b, i, counter);
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		if (list.isEmpty()) {
			list.add(i);
			return list;
		}
		int counter = 0;
		intoSortedListHelper(list, i, counter);

		return list;
	}

	void intoSortedListHelper(List<Integer> list, int i, int counter) {
		if (list.size() == counter) {
			list.add(counter, i);
			return;
		} else if (list.get(counter) < i) {
			counter++;
			intoSortedListHelper(list, i, counter);
		} else {
			list.add(counter, i);
			return;
		}
	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left  an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedListsV2 method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		int rc = 0;
		int lc = 0;
		int ac = 0;
		int[] empty = {};

		int[] answer = new int[left.length + right.length];
		rc = right.length;
		if (answer.length == 0) {

			return empty;
		} else if (left.length == 0) {

			mergeSortedArraysHelper(answer, right, left, rc, lc, ac);
			return answer;
		} else if (right.length == 0) {

			return left;
		}

		mergeSortedArraysHelper(answer, right, left, rc, lc, ac);

		return answer;
	}

	void mergeSortedArraysHelper(int[] answer, int[] r, int[] l, int rc, int lc, int ac) {

		if (l.length == lc && 0 == rc) {
			return;
		} else if (l.length == 0 && rc > 0) {
			answer[ac] = r[rc - 1];
			rc--;
			ac++;
			mergeSortedArraysHelper(answer, r, l, rc, lc, ac);
		} else if (lc == l.length && rc > 0) {
			answer[ac] = r[rc - 1];
			rc--;
			ac++;
			mergeSortedArraysHelper(answer, r, l, rc, lc, ac);
		} else if (rc == 0 && l.length > lc) {
			answer[ac] = l[lc];
			lc++;
			ac++;
			mergeSortedArraysHelper(answer, r, l, rc, lc, ac);
		}

		else if (l[lc] > r[rc - 1] && rc != 0) {
			answer[ac] = r[rc - 1];
			rc--;
			ac++;
			mergeSortedArraysHelper(answer, r, l, rc, lc, ac);
		} else if (l[lc] < r[rc - 1] && lc < l.length) {
			answer[ac] = l[lc];
			lc++;
			ac++;
			mergeSortedArraysHelper(answer, r, l, rc, lc, ac);
		}

	}

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left  a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedArraysV2 method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		int temp = 0;
		int rc = 0;
		int lc = left.size();
		List<Integer> answer = new ArrayList<Integer>();
		if (left.isEmpty() && right.isEmpty()) {
			return left;
		} else if (right.isEmpty() && left.size() > 1) {
			return left;
		}
		sortedListsHelper(answer, left, right, rc, lc, temp);

		return answer;
	}

	void sortedListsHelper(List<Integer> answer, List<Integer> l, List<Integer> r, int rc, int lc, int temp) {
		if (answer.size() == (r.size() + l.size())) {
			return;

		} else if (l.isEmpty() && rc != r.size()) {
			answer.add(0, r.get(rc));
			rc++;
			sortedListsHelper(answer, l, r, rc, lc, temp);
		} else if (lc == 0 && rc < r.size()) {
			answer.add(0, r.get(rc));
			rc++;
			sortedListsHelper(answer, l, r, rc, lc, temp);
		} else if (rc == r.size() && lc > 0) {
			answer.add(0, l.get(lc - 1));
			lc--;
			sortedListsHelper(answer, l, r, rc, lc, temp);
		}

		else if (l.get(lc - 1) > r.get(rc)) {
			answer.add(0, l.get(lc - 1));
			lc--;
			sortedListsHelper(answer, l, r, rc, lc, temp);
		} else if (l.get(lc - 1) < r.get(rc)) {
			answer.add(0, r.get(rc));
			rc++;
			sortedListsHelper(answer, l, r, rc, lc, temp);
		}

	}

}
