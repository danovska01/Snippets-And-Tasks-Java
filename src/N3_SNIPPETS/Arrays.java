package N3_SNIPPETS;

public class Arrays {
    public static void main(String[] args) {
        //Convert String to String Array
        String input = "Hello,World,OpenAI";
        String[] stringArray = input.split(",");
        System.out.println(java.util.Arrays.toString(stringArray));

        // String to array
        String st = String.join(",", stringArray);
        System.out.println(st);

        // Another way to convert String to String Array
        char[] charArray = input.toCharArray();
        String[] stringArray2 = new String[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            stringArray2[i] = String.valueOf(charArray[i]);
        }
        for (String str : stringArray2) {
            System.out.print(str);
        }
        System.out.println();

        //String to array of integers
        String [] str = {"123", "345", "437", "894"};
        int size = str.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        String output= java.util.Arrays.toString(arr);
        output=output.substring(1, output.length()-1);
        System.out.println(output);




    }


}
