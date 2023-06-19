package N3_SNIPPETS;

public class Chars {
    public static void main(String[] args) {

        System.out.println("num is: ");
    char num = '7';
        System.out.println(num);
        System.out.println((int)num);

        System.out.println("num1 is: ");
        int num1= '7';
        System.out.println(num1);
        System.out.println((char) num1);

        System.out.println("seven is: ");
        //The easiest way to convert a single character to the integer it represents is to subtract the value of '0' .
        // If we take '3' (ASCII code 51) and subtract '0' (ASCII code 48), we'll be left with the integer 3 , which is what we want.
        char seven = '7';
        int numberSeven= seven-'0';
        System.out.println(numberSeven);


        char ch = 'a';
        String x = String.valueOf(ch);
        System.out.println(x);

        char c = 'a';
        String s = Character.toString(c);
        System.out.println(s);



    }
}
