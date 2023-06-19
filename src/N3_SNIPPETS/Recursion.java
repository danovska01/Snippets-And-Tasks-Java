package N3_SNIPPETS;

public class Recursion {
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);

        int result1 = sum1(5, 10);
        System.out.println(result1);
    }


    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }


    public static int sum1(int start, int end) {
        if (end > start) {
            return end + sum1(start, end - 1);
        } else {
            return end;
        }
    }
}
