package N5_TEST_TASKS_IT;

import java.util.Scanner;

public class _S6_Card_Game {

    // Write a program that reads two characters separated by space – each one -
    //the strength of a card. Possible inputs are from 2..9 or T, J, Q, K, A. If the input is in-
    //valid the program must output the following : “Invalid cards given!”. The inputs are
    //infinite. The program must stop when two aces (A) are given. Finally, the program
    //must ouput the number of tries.
    //Example (program output is in bold):
    //3 4
    //J 2
    //1 T
    //Invalid cards given!

    //A A
    //Number of tries : 3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tries = 0;

        while (true) {
            String input = scanner.nextLine();
            tries++;

            if (input.equals("A A")) {
                System.out.println("Number of tries: " + tries);
                break;
            }

            String[] cards = input.split(" ");

            if (cards.length != 2 || !isValidCard(cards[0]) || !isValidCard(cards[1])) {
                System.out.println("Invalid cards given!");
            }
        }

        scanner.close();
    }

    public static boolean isValidCard(String card) {
        return card.matches("[2-9TJQKA]");
    }
}
