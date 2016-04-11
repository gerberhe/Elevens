/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("4", "Clubs", 4);
		Card card2 = new Card("Ace", "Hearts", 10);
		Card card3 = new Card("4", "Clubs", 4);
		
		if (card1.matches(card3)) {
			System.out.println("NICE!");
		} else {
			System.out.println("NOT NICE!");
		}
	}
}
