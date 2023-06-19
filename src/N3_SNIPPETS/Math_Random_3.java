package N3_SNIPPETS;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Math_Random_3 {
    public static void main(String[] args) {

        Random random = new Random();

        //Generate Number Between 1 and 10
        //It should be noted that the .nextInt() method generates numbers with origin zero.
        System.out.println("Generate Number Between 1 and 10:");
        System.out.println(random.nextInt(9) + 1);
        System.out.println(random.nextInt(10));
       //-----------------------------------------------------------------

        System.out.println("Generate random number:");
        System.out.println(random.nextInt());
        System.out.println();
        //-----------------------------------------------------------------

        System.out.println("Generate 5 random numbers:");
        random.ints(5).forEach( num -> System.out.println(num));
        System.out.println();
        //-----------------------------------------------------------------

        //Generate 5 numbers between 1 and 10. The output above is the result of calling .ints() passing three parameters:
        System.out.println("Generate 5 numbers between 1 and 10:");
        random.ints(5,1,10)
                .forEach(num -> System.out.println(num));
        System.out.println();
        //-----------------------------------------------------------------

        //10 random numbers between 10 and 20
        System.out.println("Generate 5 random numbers between 10 and 20");
            random.doubles(5, 10.00d,20.00d)
                    .forEach(num -> System.out.println(num));
        System.out.println();
        //-----------------------------------------------------------------

        //generate five random numbers between 10.00 and 20.00
        System.out.println("Generate 5 random numbers between 10.00 and 20.00");
        List<Double> prices = random.doubles(5, 10.00d,20.00d)
                .boxed()
                .collect(Collectors.toList());
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(prices.get(i));
        }
        System.out.println();





    }
}