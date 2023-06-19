package N5_TEST_TASKS_IT;

public class _S4_Check_If_A_Number_Is_A_Cube {

    //Write a method that checks if a given number is a cube. A number is a
    //cube when there exists another number which on power 3 gives the input number.
    //Input: Positive integer number N;
    //Output: A message saying whether the number is a cube and which number on power
    //3 gives it.

    public static void checkCube(int number) {
        for (int i = 1; i <= number; i++) {
            if (i * i * i == number) {
                System.out.println(number + " is a cube of " + i);
                return;
            }
        }
        System.out.println(number + " is not a cube");
    }

    public static void main(String[] args) {
        checkCube(1000);
        checkCube(125);
        checkCube(25);
    }

}
