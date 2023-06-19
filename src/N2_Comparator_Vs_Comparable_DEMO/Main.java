package N2_Comparator_Vs_Comparable_DEMO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hero hero1= new Hero("HeroA", 200, 1);
        Hero hero2= new Hero("HeroB", 500, 9);
        Hero hero3= new Hero("HeroC", 140, 3);
        Hero hero4= new Hero("HeroD", 140, 12);

        List<Hero> heroesList = new ArrayList<>();
        heroesList.add(hero1);
        heroesList.add(hero2);
        heroesList.add(hero3);
        heroesList.add(hero4);


        System.out.println("Sorted by power, and if powers are equal, sorted by name:");
        Collections.sort(heroesList); // sort by power - and if powers are equal, sort by name
        for(Hero hero: heroesList){
            System.out.println(hero.getName() + " is with power: " + hero.getPower());
        }
        System.out.println();


        System.out.println("Sorted by health:");
        Comparator healthComparator = new HeroHealthComparator();// sort by health
        Collections.sort(heroesList, healthComparator);
        for(Hero hero: heroesList){
            System.out.println(hero.getName() + " is with health: " + hero.getHealth());
        }
        System.out.println();

        System.out.println("Sorted by name:");
        Comparator nameComparator = new HeroNameComparator();
        Collections.sort(heroesList, nameComparator);
        for(Hero hero: heroesList){
            System.out.println(hero.getName() + " is with name: " + hero.getName()); //sort by name
        }
        System.out.println();
    }
}
