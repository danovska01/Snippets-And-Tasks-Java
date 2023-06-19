package N1_Iterable_And_Itarator_DEMO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameShop pulsar = new GameShop();
        List<String> games = new ArrayList<>();
        games.add("Game1");
        games.add("Game2");
        games.add("Game3");
        games.add("Game13");
        games.add("Game17");
        games.add("Game10");

        pulsar.setGames(games);

        Iterator<String> shopAssistant = pulsar.iterator();

        while (shopAssistant.hasNext()){
            System.out.println(shopAssistant.next());
        }
    }
}
