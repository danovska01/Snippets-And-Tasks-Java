package N3_SNIPPETS;

public class Char_To_String {
    public static void main(String[] args) {

        String string1 = Character.toString('c');
        String string2 = new Character('c').toString();
        String string3 = String.valueOf('c');

        System.out.println(string1+ string2+ string3);
    }
}
