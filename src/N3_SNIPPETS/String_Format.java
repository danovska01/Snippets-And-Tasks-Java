package N3_SNIPPETS;

public class String_Format {
    public static void main(String[] args) {
        int x = 7;
        System.out.printf("%04d",x);
        System.out.println();
        System.out.printf("%02d",x);
        System.out.println();
        System.out.printf("%01d",x);
        System.out.println();
        System.out.printf("%1d",x);
        System.out.println();

        System.out.printf("%04d",x);
        System.out.println();
        System.out.printf("04%d",x);
        System.out.println();

        double y = x*1.0;
        System.out.printf("%.2f", y);
    }
}
