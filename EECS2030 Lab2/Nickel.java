package eecs2030.lab2;

import java.util.Objects;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;
	
	public Nickel(int year) {
		if (year < 1858) {
			throw new IllegalArgumentException("Year must be greater than 1858");
			
		}
		else {
			this.year = year;
		}
		
		
	}
	public int issueYear() {
		return this.year;
	}
	
	public int compareTo(Nickel other) {
		if(this.year > other.year) {
			return this.year - other.year;
		}
		else if (this.year < other.year) {
			return this.year - other.year;
		}
		else {
			return 0;
			
		}
	}
	public boolean equals (Object obj) {
		if (obj != null && (obj.getClass() == this.getClass())) {
			return true;
			
		}
		else {
			return false;
		}
	}
	public int hashCode() {
		return Objects.hash(this.year);
	}


}
