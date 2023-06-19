package N2_Comparator_Vs_Comparable_DEMO;

public class Hero implements Comparable <Hero>{
    private String name;
    private int power;
    private int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Hero(String name, int power, int health) {
        this.name = name;
        this.power = power;
        this.health = health;
    }


    @Override
    public int compareTo(Hero otherHero) {

        int result = Integer.compare(this.getPower(), otherHero.getPower());
        if(result==0){
            result=this.getName().compareTo(otherHero.getName());
        }
        return result;
    }
}
