package N5_TEST_TASKS_IT;

public class _S4_Print_Rectangular_Frame {
    //Write a method that takes an array of strings and prints them one per
    //line in a rectangular frame.
    //For example: The list {“Hello”, “World”, “in”, “a”, “frame”} gets printed as:
    public static void printRectangularFrame(String[] words) {
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        int horizontalBorderLength = maxLength + 4; // Add 4 for padding and border characters

        printHorizontalBorder(horizontalBorderLength);
        for (String word : words) {
            printLineWithPadding(word, maxLength);
        }
        printHorizontalBorder(horizontalBorderLength);
    }

    private static void printHorizontalBorder(int length) {
        System.out.println("*".repeat(length));
    }

    private static void printLineWithPadding(String word, int maxLength) {
        int padding = maxLength - word.length();
        System.out.println("* " + word + " ".repeat(padding) + " *");
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "World", "in", "a", "frame"};
        printRectangularFrame(words);
    }

}
