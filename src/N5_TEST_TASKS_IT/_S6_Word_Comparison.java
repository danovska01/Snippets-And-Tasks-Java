package N5_TEST_TASKS_IT;

import java.util.*;

//Write a function that takes a 2 String variables that hold some text.
// The program must output all the words that appear in the first text but not in the second one.
//The words are separated only with space.
//Example :
//Simple sentence that is first.
//Another sentence that is second.
//Output:
//The words are : Simple, first.

public class _S6_Word_Comparison {
    public static void compareWords(String text1, String text2) {
        String[] words1 = text1.split(" ");
        String[] words2 = text2.split(" ");

        Set<String> uniqueWords1 = new HashSet<>(Arrays.asList(words1));
        Set<String> uniqueWords2 = new HashSet<>(Arrays.asList(words2));

        uniqueWords1.removeAll(uniqueWords2);

        System.out.print("The words are: ");
        for (String word : uniqueWords1) {
            System.out.print(word + ", ");
        }
    }

    public static void main(String[] args) {
        String text1 = "Simple sentence that is first.";
        String text2 = "Another sentence that is second.";

        compareWords(text1, text2);
    }
}
