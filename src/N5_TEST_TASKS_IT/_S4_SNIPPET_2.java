package N5_TEST_TASKS_IT;

public class _S4_SNIPPET_2 {
    //How many times will the following loop iterate? - endless!!!!

    public static void main(String[] args) {
        int balance = 10;
        while (balance>=1){
         if(balance<9){
             continue;
         }
         balance=balance-9;
        }
    }
}
