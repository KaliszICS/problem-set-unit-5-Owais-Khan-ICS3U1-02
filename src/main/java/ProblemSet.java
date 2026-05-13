import java.util.scanner;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ProblemSet {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in());
		System.out.println("Welcome to the Text Analyzer.\nPlease enter a sentence or paragraph:\n");
		String userInput = input.nextLine().toLowerCase();

		int characters = userInput.length();
		int spaces = characters - userInput.replace(" ", "").length(); // I might just use a for loop for this.
		int vowels = 0;

		for (int i = 0; i < userInput.length(); i++) {
			if ("aeiou".contains(userInput.charAt(i))) {
				vowels++;
			}
		}

		inputArray = userInput.split(" ");

		int words = inputArray.length;

		ArrayList<String> longestWords = new ArrayList<String>();
		int longestWordsLength = 0;
		ArrayList<String> shortestWords = new ArrayList<String>();
		shortestWords.add(inputArray[0]);
		int shortestWordsLength = inputArray[0].length();


		double average = (characters-spaces)/words; // placeholder
		int sentences;

		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			String word = inputArray[i];

			if (word.endsWith(".") || word.endsWith("!") || word.endsWith("?")) {
				sentences++;
			}

			char lastletter = word.charAt(word.length()-1);
			if (lastletter >= 'a' && lastletter <= 'z') {
				word = word.substring(0, word.length()-2);
			}

			map.put(key, map.getOrDefault(key, 0) + 1);
			if (word.length() > longestWordsLength) {
				longestWordsLength = word.length();
				longestWords.clear();;
				longestWords.add(word);
			} else if (word.length() == longestWordsLength) {
				longestWords.add(word);
			}

			if (word.length() < shortestWordsLength) {
				shortestWordsLength = word.length();
				shortestWords.clear();;
				shortestWords.add(word);
			} else if (word.length() == shortestWordsLength) {
				shortestWords.add(word);
			}

		}




	}

}
