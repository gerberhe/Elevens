/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
	
	static String[] ranks = {"Four", "Ace", "Seven", "Jack", "Nine"};
	static String[] suits = {"Clubs", "Hearts", "Diamonds", "Spades", "Clubs"};
	static int[] values = {4, 11, 7, 10, 9};

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck deck1 = new Deck(ranks, suits, values);
		Card dealt = deck1.deal();
		System.out.println(dealt.toString());
	}
}
