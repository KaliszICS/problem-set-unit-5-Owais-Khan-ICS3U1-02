import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Text Analyzer.\nPlease enter a sentence or paragraph:\n");
		String userInput = input.nextLine().toLowerCase();
		textAnalysis(userInput);
	}

	public static void textAnalysis(String userInput) {

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

		// Keep spaces and alphanumeric characters
		String cleanedUserInput = userInput.replaceAll("[^a-z0-9 ]+", "");
		
		String[] words = cleanedUserInput.split(" ");

		int wordCount = words.length;
		if (words.equals("")) {
			wordCount = 0;
		}
		
		double averageLength = (double)(cleanedUserInput.length()-spaceCount)/wordCount;
		int sentenceCount = userInput.split("[.?!]+").length;

		// Present basic text data
		System.out.println("\nTotal Characters: " + characters
						   + "\nTotal Words: " + wordCount
						   + "\nTotal Vowels: " + vowelCount
						   + "\nTotal Spaces: " + spaceCount);
		System.out.println("\nWord Frequency:\n");

		ArrayList<String> filteredWords = cleanWords(words);  // Remove specified common words
		HashMap<String, Integer> frequencies = getFrequencies(filteredWords);

		// Print freqencies of words
		for (String word: frequencies.keySet()) {
			System.out.println(word + " - " + frequencies.get(word));
		}

		System.out.println("Longest Word: " + findLongestWord(filteredWords)
						   + "\nShortest Word: " + findShortestWord(filteredWords)
						   + "\nAverage Word Length: " + averageLength
						   + "\nNumber of Sentences: " + sentenceCount
						   + "\nUnique Words: " + frequencies.size()
		);
	}

	public static String findLongestWord(ArrayList<String> filteredWords) {

		if (filteredWords.isEmpty()) {
        	return "";
    	}

		ArrayList<String> longestWords = new ArrayList<String>();
		int longestWordsLength = 0;  // Assume the longest word has 0 length

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

		if (filteredWords.isEmpty()) {
        	return "";
    	}

		ArrayList<String> shortestWords = new ArrayList<String>();

		// Assume the first word to be the shortest
		int shortestWordsLength = filteredWords.get(0).length();
		shortestWords.add(filteredWords.get(0));

		for (int i = 1; i < filteredWords.size(); i++) {
			String word = filteredWords.get(i);
			if (word.length() < shortestWordsLength) {
					shortestWordsLength = word.length(); // New current shortest length
					shortestWords.clear();  // Remove old shortest words
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
		for (String word: words) {
			if (!ignoredWords.contains(word)) {
				cleanedWords.add(word);
			}
		}
		return cleanedWords;

	}

}

