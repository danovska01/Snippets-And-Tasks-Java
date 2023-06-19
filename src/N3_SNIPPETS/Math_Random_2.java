package N3_SNIPPETS;

public class Math_Random_2 {
    public static void main(String[] args) {

        // Math.random() returns a random number between 0.0-0.99.
        double rnd = Math.random();
        System.out.println("Math.random() returns a random number between 0.0-0.99: "+rnd);
        //-----------------------------------------------------------------

// rnd1 is an integer in the range 0-9 (including 9).
        int rnd1 = (int)(Math.random()*10);
        System.out.println("an integer in the range 0-9 (including 9): "+ rnd1);
        //-----------------------------------------------------------------

// rnd2 is in the range 1-10 (including 10). The parentheses are necessary!
        //int rnd2 = (int)(Math.random() * range) + min;
        int rnd2 = (int)(Math.random()*10) + 1;
        System.out.println("range 1-10 (including 10): "+ rnd2);
        //-----------------------------------------------------------------

// rnd3 is in the range 5-10 (including 10). The range is 10-5+1 = 6.
        int rnd3 = (int)(Math.random()*6) + 5;
        System.out.println("range 5-10 (including 10): " + rnd3);
        //-----------------------------------------------------------------

// rnd4 is in the range -10 up to 9 (including 9). The range is doubled (9 - -10 + 1 = 20) and the minimum is -10.
        int rnd4 = (int)(Math.random()*20) - 10;
        System.out.println("range -10 up to 9 (including 9): "+rnd4);
    }
}
