package eecs2030.lab2;

import java.util.Objects;

/*
 * NOTE TO STUDENTS: The two methods you need to complete can 
 * be found at the end of this file.
 */



public class Card implements Comparable<Card> {

	/**
	 * The rank of this card. 
	 */
	private Rank rank;
	
	/**
	 * The suit of this card. 
	 */
	private Suit suit;
	
	
	public Card(Rank rank, Suit suit) {
		if (rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
	}
	
	
	public Rank rank() {
		return this.rank;
	}
	
	
	public Suit suit() {
		return this.suit;
	}
	
	
	public Colour color() {
		return this.suit.color();
	}


	@Override
	public int hashCode() {
		return Objects.hash(this.rank, this.suit);
	}
	
	
	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	


	
	/*
	 * You need to implement the compareTo and equals methods below.
	 * 
	 * For compareTo, you may compare ranks using the compareTo method 
	 * found in the Rank class. You may compare suits using the compareTo method 
	 * found in the Suit class.
	 */

	
	@Override
	public int compareTo(Card other) {
		int ans = this.rank().compareTo(other.rank);
		if (ans > 0) {
			return 1;
		}
		else if  (ans < 0) {
			return -1;
		}
		else {
			int suit = this.suit().compareTo(other.suit());
			
			if (suit > 0 ) {
				return 1;
			}
			else if (suit < 0) {
				return -1;
			}
			else {
				return 0;
			}
		}
		
		
		
		
		
		
		
	
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && (obj.getClass() == this.getClass())) {
			Card c = (Card)obj;
			
			
			if(c.suit() == this.suit() && c.rank == this.rank) {
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


