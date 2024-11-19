package droids;



public class Ares extends Droid {
    private int protection;
    private final double defKoef = 0.2;

    public Ares(String name, int health, int damage, int protection) {
        super(name, health, damage);
        this.protection = protection;
    }

    public int getHit(int damage) {
        int actualDamage = damage - (int) (protection * defKoef);

        if (actualDamage < 0) {
            actualDamage = 0;
        }

        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        return actualDamage;
    }

    public int getDamage() {
        return this.damage;
    }

}