package cn.young22.dsa.appendixC;

public class SuitDemo {
	private enum Suit{
		CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");
		
		private final String color;
		
		private Suit(String suitColor){
			color = suitColor;
		}
		
		public String getColor(){
			return color;
		}
	}
	
	public static void main(String[] args){
		for(Suit suit : Suit.values()){
			System.out.println(suit + " are " + suit.getColor() + 
					" and have an ordinal value of " + 
					suit.ordinal());
		} // end for
	} // end main
} // end SuitDemo
