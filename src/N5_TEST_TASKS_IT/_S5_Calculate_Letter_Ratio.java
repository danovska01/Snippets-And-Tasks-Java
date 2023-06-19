package N5_TEST_TASKS_IT;

public class _S5_Calculate_Letter_Ratio {

    //Write a method that takes a String variable that holds some text. The method
    //must return the ratio between all upper case letters and all lower case letters in the text.
    //For example if there are 75 lower case letters and 25 upper case letters, the ratio is 3:1.
    public static String calculateLetterRatio(String text) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            }
        }

        if (lowercaseCount == 0) {
            return "No lowercase letters found.";
        }

        double ratio = (double) uppercaseCount / lowercaseCount;
        return "Ratio: " + uppercaseCount + ":" + lowercaseCount + " (" + ratio + ")";
    }

    public static void main(String[] args) {
        String text = "Hello World! How Are You?";
        String ratio = calculateLetterRatio(text);
        System.out.println(ratio);
    }
}
