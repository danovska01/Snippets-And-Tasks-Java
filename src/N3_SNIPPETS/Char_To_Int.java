package N3_SNIPPETS;

public class Char_To_Int {
    public static void main(String[] args) {
        char variable1 = 'c'; // ascii number = 99
        System.out.println((int)variable1);
        System.out.println((char)99);



        int int1= Integer.parseInt(String.valueOf('1'));
        System.out.println(int1);


        int int2= Character.getNumericValue('2');
        System.out.println(int2);
    }
}
