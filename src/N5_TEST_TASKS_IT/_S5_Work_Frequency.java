package N5_TEST_TASKS_IT;

import java.util.HashMap;
import java.util.Map;

public class _S5_Work_Frequency {
    public static String findMostFrequentWord(String text) {

        //Write a method that takes a String variable that holds some text. The text
        //contains words that are separated by a single space. The method must return the most
        //frequent word from the text.

        // Split the text into individual words
        String[] words = text.split(" ");

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Count the frequency of each word
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Find the most frequent word
        String mostFrequentWord = "";
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentWord = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostFrequentWord;
    }

    public static void main(String[] args) {
        String text = "apple banana apple banana apple orange";
        String mostFrequent = findMostFrequentWord(text);
        System.out.println("Most frequent word: " + mostFrequent);
    }
}
