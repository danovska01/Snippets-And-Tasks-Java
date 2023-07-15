package N5_TEST_TASKS_IT;

import java.util.Scanner;

public class _S6_Card_Strength_Program {
    //Write a program that reads three characters separated by space – each one - the strength of a card.
    // Possible inputs are from 2..9 or T, J, Q, K, A. If the input is invalid the program must output the following :
    // “Invalid cards given!”. The inputs are infinite. The program must stop when the cards are in ascending order.
    // Finally, the pro-gram must output the number of tries.
    //Example (program output is in bold):
    //Example (program output is in bold):
    //3 4 2
    //J 2 6
    //1 T K
    //Invalid cards given!
    //P J K
    //Invalid cards given!
    //2 9 J

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tryCount = 0;

        String prevCard = null;
        String currCard = scanner.next();

        while (true) {
            String nextCard = scanner.next();

            if (!isValidCard(currCard) || !isValidCard(nextCard)) {
                System.out.println("Invalid cards given!");
                return;
            }

            tryCount++;

            if (prevCard != null && compareCards(prevCard, currCard) > 0) {
                break;
            }

            prevCard = currCard;
            currCard = nextCard;
        }

        System.out.println("Number of tries: " + tryCount);
    }

    private static boolean isValidCard(String card) {
        String validCards = "23456789TJQKA";
        return validCards.contains(card);
    }

    private static int compareCards(String card1, String card2) {
        String validCards = "23456789TJQKA";
        return validCards.indexOf(card1) - validCards.indexOf(card2);
    }
}
