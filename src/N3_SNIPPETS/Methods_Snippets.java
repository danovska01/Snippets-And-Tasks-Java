package N3_SNIPPETS;

import java.util.Arrays;

public class Methods_Snippets {
    public static void main(String[] args) {
        int x = 3;
        System.out.println("Преди метода x= " +  x);
        sum (3);
        System.out.println("След метода x= " + x);
        System.out.println("СЪЩО след присвояване на стойност x=sum(x), x= " + sum(x));
        System.out.println();


        int y=10;
        System.out.println("Преди метода y= " + y);
        increment(y);
        System.out.println("След метода y= " + y);
        System.out.println();
        
        //--------------------------------------------------------------------------------

        
            int[] numbers = {2, 4, 6};
            System.out.println("Масив преди метода = " +
                    Arrays.toString(numbers));
            printNumbers(numbers);
            System.out.println("Масив след метода = " +
                    Arrays.toString(numbers));
        System.out.println();

            //------------------------------------------------------------------------

        String str = "Hello";
        System.out.println("String: Преди медод за конкатенация стрингът е: " + str);
        concatStr(str);
        System.out.println("След метода и промяната, стрингът е: " + str);
        System.out.println();

        //------------------------------------------------------------------------

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("StringBuilder: Преди медод за конкатенация стрингът е: " + sb.toString());
        concatSb(sb);
        System.out.println("След метода и промяната, стрингът е: " + sb.toString());


        
    }

    private static void concatSb(StringBuilder sb) {
        sb.append(" World");
        System.out.println("В метода, след конкатенация, стрингът става: " + sb.toString());
    }

    private static void concatStr(String str) {
        str+=" World";
        System.out.println("В метода, след конкатенация, стрингът става: " + str);
    }

    private static void printNumbers(int[] nums) {
        nums[0] = 5;
        System.out.println("Масив в метода = " +
                Arrays.toString(nums));
    }

    private static void increment(int y) {
        y++;
        System.out.println("Вътре в метода след инкрементация y = " + y);
    }

    static int sum(int x) {
        x+=10;
        System.out.println("В метода, след събиране с 10, x= " + x);
        return x;
    }
}
