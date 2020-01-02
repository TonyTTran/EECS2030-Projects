package eecs2030.lab2;


/*
 * NOTE TO STUDENTS: The four methods you need to complete can 
 * be found at the end of this file.
 */



public class Domino implements Comparable<Domino> {

	/**
	 * The smallest possible value for a side of a domino.
	 */
	public static final int MIN_VALUE = 0;
	
	/**
	 * The largest possible value for a side of a domino. 
	 */
	public static final int MAX_VALUE = 6;

	/**
	 * The two values on the domino.
	 */
	private int val1;
	private int val2;

	
	public Domino() {
		this(0, 0);
	}

	
	public Domino(int value1, int value2) {
		if (!isValueOK(value1) || !isValueOK(value2)) {
			throw new IllegalArgumentException();
		}
		this.val1 = value1;
		this.val2 = value2;
	}

	
	public Domino(Domino other) {
		this(other.val1, other.val2);
	}

	
	private static boolean isValueOK(int value) {
		return value >= MIN_VALUE && value <= MAX_VALUE;
	}
	
	
	@Override
	public int hashCode() {
		return this.getSmallerValue() + 11 * this.getLargerValue();
	}
	

	@Override
	public String toString() {
		return "[" + this.getSmallerValue() + " : " + this.getLargerValue() + "]";
	}
	
	
	/*
	 * You need to implement the four methods below. Both compareTo and equals 
	 * should make use of getSmallerValue and getLargerValue.
	 */
	
	
	public int getSmallerValue() {
		if (this.val1 > this.val2) {
			return val2;
		}
		else if ( this.val1 < this.val2){
			return val1;
		}
		else {
			return val1;
		}
	}

	
	public int getLargerValue() {
		if (this.val1 > this.val2) {
			return val1;
		}
		else if ( this.val1 < this.val2){
			return val2;
		}
		else {
			return val1;
		}
	}

	
	@Override
	public int compareTo(Domino other) {
		if(this.getSmallerValue() == other.getSmallerValue() && (this.getLargerValue() == other.getLargerValue())) {
			return 0;
		}
		else if (this.getSmallerValue() < other.getSmallerValue() || (this.getSmallerValue() == other.getSmallerValue() && (this.getLargerValue() < other.getLargerValue()))) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj != null && (obj.getClass() == this.getClass())) {
			Domino temp = (Domino)obj;
			
			if(this.getSmallerValue() == temp.getSmallerValue() && (this.getLargerValue() == temp.getLargerValue())){
				return true;
			}
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
	}
	

	
}