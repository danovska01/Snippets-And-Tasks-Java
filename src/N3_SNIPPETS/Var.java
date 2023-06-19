package N3_SNIPPETS;

import java.util.HashMap;
import java.util.Map;

public class Var {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, Integer>entry : map.entrySet()){
            System.out.println(entry.getKey());
        }

        // With Var, java 11, only to reduce writing, only in this case is appropriate, with maps
        Map<String, Integer> map1 = new HashMap<>();
        for (var entry : map1.entrySet()){
            System.out.println(entry.getKey());
        }

    }
}
