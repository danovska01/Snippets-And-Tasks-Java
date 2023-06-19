package N3_SNIPPETS;

public class Math_Random_1 {
    public static void main(String[] args) {
        //Method returns a pseudorandom double type number greater than or equal to 0.0 and less than 1.0
        // Generate random number
        // Output is different everytime this code is executed
        double rand = Math.random();
        System.out.println("Random Number:" + rand);

  //-------------------------------------------------------------------------------

        // define the range
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        // generate random numbers within 1 to 10
        // both min and max are inclusive in the range
        for (int i = 0; i < 10; i++) {
            int rand1 = (int)(Math.random() * range) + min;

            // Output is different everytime this code is executed
            System.out.println(rand1);
        }
    }
}
