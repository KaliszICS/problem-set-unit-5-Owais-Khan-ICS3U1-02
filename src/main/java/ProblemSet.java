import java.util.Scanner;
import java.util.ArrayList;
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

		String cleanedUserInput = userInput.replaceAll("[^a-z ]", "");  // Remvoe all non letters
		String[] words = cleanedUserInput.split(" ");
		int wordCount = words.length;

		double averageLength = (double)(cleanedUserInput.length()-spaceCount)/wordCount;  // letters/words
		int sentenceCount = userInput.split("[.?!]").length;

		// Present basic text data
		System.out.println("Total Characters: " + characters
						   + "\nTotal Words: " + wordCount
						   + "\nTotal Vowels: " + vowelCount
						   + "\nTotal Spaces: " + spaceCount);
		System.out.println("\nWord Frequency:\n");

		ArrayList<String> filteredWords = cleanWords(words);  // Remove specific common words
		HashMap<String, Integer> frequencies = getFrequencies(filteredWords);

		// Print freqencies of words
		for (String word: frequencies.keySet()) {
			System.out.println(word + " - " + frequencies.get(word));
		}

		System.out.println("\nLongest Word: " + findLongestWord(filteredWords)
						   + "\nShortest Word: " + findShortestWord(filteredWords)
						   + "\nAverage Word Length: " + averageLength
						   + "\nNumber of Sentences: " + sentenceCount
						   + "\nUnique Words: " + frequencies.size()
		);

	}

	public static String findLongestWord(ArrayList<String> filteredWords) {
		ArrayList<String> longestWords = new ArrayList<String>();
		int longestWordsLength = 0;

		for (String word: filteredWords) {
			if (word.length() > longestWordsLength) {
					longestWordsLength = word.length();  // New current longest length
					longestWords.clear();  // Remove old longest words
					longestWords.add(word);  
			} else if (word.length() == longestWordsLength) {
				longestWords.add(word);
			}
		}

		return longestWords.toString().replaceAll("[\\[\\]]", "");
	}

	public static String findShortestWord(ArrayList<String> filteredWords) {
		ArrayList<String> shortestWords = new ArrayList<String>();
		int shortestWordsLength = filteredWords.get(0).length();
		shortestWords.add(filteredWords.get(0));

		for (int i = 1; i < filteredWords.size(); i++) {
			String word = filteredWords.get(i);
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

	public static HashMap<String, Integer> getFrequencies(ArrayList<String> filteredWords) {
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		for (String word: filteredWords) {
			frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
		}
		return frequencies;
	}

	public static ArrayList<String> cleanWords(String[] words) {
		ArrayList<String> ignoredWords = new ArrayList<>();
		ArrayList<String> cleanedWords = new ArrayList<>();
		ignoredWords.add("is");
		ignoredWords.add("and");
		ignoredWords.add("the");
		ignoredWords.add("a");
		ignoredWords.add("i");
		ignoredWords.add("");
		for (String word: words) {
			if (!ignoredWords.contains(word)) {
				cleanedWords.add(word);
			}
		}
		return cleanedWords;

	}

}

