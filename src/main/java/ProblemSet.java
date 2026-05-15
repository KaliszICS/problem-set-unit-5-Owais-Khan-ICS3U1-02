import java.util.Scanner;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ProblemSet {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Text Analyzer.\nPlease enter a sentence or paragraph:\n");
		String userInput = input.nextLine().toLowerCase();

		int characters = userInput.length();
		int spaceCount = 0;
		int vowelCount = 0;

		for (int i = 0; i < userInput.length(); i++) {
			char letter = userInput.charAt(i);

			if ("aeiou".indexOf(letter) > -1) {
				vowelCount++;
			}
			else if (letter == ' ') {
				spaceCount++;
			}
		}

		String[] words = userInput.split(" ");

		int wordCount = words.length;

		shortestWordsLength = words[0].length();
		shortestWords.add(words[0]);

		double averageLength = (double)(characters-spaceCount)/wordCount; // placeholder
		int sentenceCount = userInput.split("[.?!]").length;


		System.out.println("Total Characters:" + characters
						   + "\nTotal Words:" + wordCount
						   + "\nTotal Vowels:" + vowelCount
						   + "\nTotal Spaces:" + spaceCount);

		System.out.println("\nWord Frequency:\n");
		for (String word: frequencies.keySet()) {
			System.out.println(word + " - " + frequencies.get(word));
		}

		System.out.println("Longest Word: " + findLongestWord(words)
						   + "\nShortest Word: " + shortestWords.toString()
						   + "\nAverage Word Length: " + averageLength
						   + "\nNumber of Sentences: " + sentenceCount
						   + "\nUnique Words: " + frequencies.size()
		);

	}

	public static String findLongestWord(String[] words) {
		ArrayList<String> longestWords = new ArrayList<String>();
		int longestWordsLength = 0;
		for (String word: words) {
			if (word.length() > longestWordsLength) {
					longestWordsLength = word.length();
					longestWords.clear();;
					longestWords.add(word);
			} else if (word.length() == longestWordsLength) {
				longestWords.add(word);
			}
		}

		return longestWords.toString().replaceAll("[\\[\\]]", "");
	}

	public static String findShortestWord(String[] words) {
		ArrayList<String> shortestWords = new ArrayList<String>();
		int shortestWordsLength;

		for (String word: words) {
			if (word.length() < shortestWordsLength) {
					shortestWordsLength = word.length();
					shortestWords.clear();;
					shortestWords.add(word);
			} else if (word.length() == shortestWordsLength) {
				shortestWords.add(word);
			}
		}
		return shortestWords.toString().replaceAll("[\\[\\]]", "");
	}

	public static HashMap<String, Integer> printFrequencies(words) {
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
		}
		return frequencies;
	}
}

