package N5_TEST_TASKS_IT;

public class _S6_Analyse_Text {
    public static void main(String[] args) {
        //Write a function that takes a String variable that holds some text. The pro-gram must output the length
        // of the longest sentence in a text and the number of sentences. It's given that each sentence start with
        // capital letter and there are no other capital letter words in each sentence.
        //Example :
        //Today is a good day for test. Sun is shining. The students are happy. The birds are blue.
        //Output:
        //Today is a good day for test.
        //4 sentences in the text.

        String text = "Today is a good day for test. Sun is shining. The students are happy. The birds are blue.";
        analyzeSentences(text);
    }

    public static void analyzeSentences(String text) {
        String[] sentences = text.split("\\.");

        int longestSentenceLength = 0;
        String longestSentence = "";
        int sentenceCount = 0;

        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                sentenceCount++;
                if (sentence.length() > longestSentenceLength) {
                    longestSentenceLength = sentence.length();
                    longestSentence = sentence;
                }
            }
        }

        System.out.println("Longest sentence: " + longestSentence);
        System.out.println(sentenceCount + " sentences in the text.");
    }
    }

