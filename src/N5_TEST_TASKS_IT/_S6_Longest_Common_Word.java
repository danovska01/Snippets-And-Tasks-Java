package N5_TEST_TASKS_IT;

import java.util.*;

public class _S6_Longest_Common_Word {
    //Write a function that takes a 3 String variables that hold some text. The program must output the longest word that appears in all the three texts.
    // The words are separated only with space.
    //Example :
    //Simple sentence that is first.
    //Another one that is second.
    //Third sentence that is last.
    //Output:
    //The word is : that.
    public static String findLongestCommonWord(String text1, String text2, String text3) {
        String[] words1 = text1.split(" ");
        String[] words2 = text2.split(" ");
        String[] words3 = text3.split(" ");

        // Create a set to store words from the first text
        Set<String> commonWords = new HashSet<>(Arrays.asList(words1));

        // Iterate over words from the second text and retain only common words
        commonWords.retainAll(Arrays.asList(words2));

        // Iterate over words from the third text and retain only common words
        commonWords.retainAll(Arrays.asList(words3));

        String longestWord = "";
        int maxLength = 0;

        // Iterate over the common words and find the longest word
        for (String word : commonWords) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        String text1 = "Simple sentence that is first.";
        String text2 = "Another one that is second.";
        String text3 = "Third sentence that is last.";

        String longestWord = findLongestCommonWord(text1, text2, text3);

        System.out.println("The word is: " + longestWord);
    }
}
