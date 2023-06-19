package N3_SNIPPETS;

import java.util.Date;

public class newDate {
    public static void main(String[] args) {

        // ? how much time is necessary for the operations

        System.out.println(new Date());

        String str1 = "";
        for (int i = 0; i < 10000; i++) {
            System.out.print(str1 + i +" ");
        }
        System.out.println();
        System.out.println(new Date());


    }
}
