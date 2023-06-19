package N3_SNIPPETS;

public class Reverse_String {
    public static void main(String[] args) {
        String variable = "Hey there";
        String reversed = new StringBuilder(variable).reverse().toString();
        System.out.println(reversed);
    }
}
