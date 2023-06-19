package N3_SNIPPETS;

import java.util.stream.Stream;

public class Print_Array {

        public static void main(String[] args) {
            String[] array = {"something","fresh","hi"};
            Stream.of(array).forEach(System.out::println);
        }

}
