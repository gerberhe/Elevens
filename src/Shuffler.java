import java.lang.Object;
import java.util.Arrays;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {1, 2, 3, 4};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] stack1 = new int[values.length / 2];
		int[] stack2 = new int[values.length / 2];
		
		for (int i = 0; i < values.length / 2; i++) {
			stack1[i] = values[i];
		}

		int temp = 0;
		
		for (int x = values.length / 2; x < values.length; x++) {
			stack2[temp] = values[x];
			temp = temp + 1;
		}
		
		temp = 0;
		for (int n = 0; n < values.length - 1; n += 2) {
			if (temp >= 2) {
				temp = 1;
			}
			values[n] = stack1[temp];
			values[n + 1] = stack2[temp];
			temp += 1;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		int random;
		int[] temparray = values;
		for(int x = 0; x < values.length; x++){
			random = (int) ((values.length) * Math.random());
			int temp = values[random];
			temparray[random] = values[x];
			values[x] = temp;
		}
	}
	
	public String flip() {
		if (Math.random() <= (2/3)) {
			return "heads";
		} else {
			return "tails";
		}
	}
	
	public static boolean arePermutations(int[] arr1, int[] arr2) {
		int numUnequal = 0;
		int isEqual = 0;
		int[] tempArr1 = new int[arr1.length];
		int[] tempArr2 = new int[arr2.length];
		int value = 0;
		
		tempArr1 = arr1;
		tempArr2 = arr2;
		Arrays.sort(tempArr1);
		Arrays.sort(tempArr2);
		
		if (tempArr1.length == tempArr2.length) {
			for (int x = 0; x < arr1.length; x++) {
				if (tempArr1[x] == tempArr2[x]) {
					isEqual += 1;
				}
			}
		}
		
		if (isEqual == arr1.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					numUnequal += 1;
				}
			}
		}
		
		return numUnequal == arr1.length;
	}
}
