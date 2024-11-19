package droids;



public class Droid {
    protected String name;
    protected int health;
    protected int damage;
    private String maxHealth;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = Integer.toString(health);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int getHit(int damage) {

        this.health -= damage;

        if (health < 0) {
            health = 0;
        }

        return damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }



    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    @Override
    public String toString() {
        return this.name + " health = [" + this.health + " / " + this.maxHealth + "]";
    }
}
