import java.util.ArrayList;
import java.util.List;

/*
 * 
 * @author amandabcampos
 *
 */

public class StringCalculator {

	public static int add(String numbers) {

		if (numbers.matches("[\\s]*") || Character.toString(numbers.charAt(numbers.length() - 1)).matches("\\D$")) {
			return 0;
		}

		List<String> delimiters = new ArrayList<String>();
		delimiters.add("\n");

		if (Character.toString(numbers.charAt(0)).equals("/")) { // Format defining delimiter
			List<Integer> indexes = new ArrayList<Integer>();
			for (int i = 0; i < numbers.length(); i++) {
				if (numbers.charAt(i) == '[' || numbers.charAt(i) == ']') {
					indexes.add(i);
				}
			}

			for (int i = 0; i < indexes.size(); i += 2) {
				delimiters.add(numbers.substring(indexes.get(i) + 1, indexes.get(i + 1)));
			}
			numbers = numbers.substring(indexes.get(indexes.size() - 1) + 2);

		} else { // Format not defining delimiter: Default delimiters are newline and commas
			delimiters.add(",");
		}

		String regex = "[";
		for (String delimiter : delimiters) {
			regex += delimiter;
		}
		regex += "]+";

		if (!numbers.isBlank() && !numbers.isEmpty()) {
			String[] numbersAsString = numbers.split(regex); // error here
			int[] numbersAsInt = new int[numbersAsString.length];

			int i = 0;
			for (String numberAsString : numbersAsString) {
				try {
					numbersAsInt[i] = Integer.parseUnsignedInt(numberAsString);
				} catch (NumberFormatException e) {
					System.out.print("Negatives not allowed: ");
					System.out.println(numberAsString);
				}
				i++;
			}

			int sum = 0;
			for (int numberAsInt : numbersAsInt) {
				if (numberAsInt > 1000) {
					continue;
				} else {
					sum += numberAsInt;
				}
			}
			return sum;
		}
		return 0;
	}

}
