package N3_SNIPPETS;

public class Char_Array_To_String {
    public static void main(String[] args) {
        char[] array = {'c','o','d','i','n','g'};
        String text = new String(array);
        System.out.println(text);



        char[] array2 = {'p','r','o','g','r','a','m','m','i','n','g'};
        String text2 = String.valueOf(array2);
        System.out.println(text2);
    }
}
