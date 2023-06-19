package N3_SNIPPETS;

public class Int_To_Char {
    public static void main(String[] args) {

        //As parameter, you will need to pass, first the number to convert,
        // and second the numeric base, 10 for decimal numbers. As a result, this method will return the number as a char.

        char char1 = Character.forDigit(3,10);
        System.out.println(char1);

    }
}
