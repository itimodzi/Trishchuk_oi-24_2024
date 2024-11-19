package droids;



public class Demetra extends Droid {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private final int healStreng;

    public Demetra(String name, int health, int damage, int healStreng) {
        super(name, health, damage);
        this.healStreng = healStreng;
    }

    @Override
    public int getHit(int damage) {
        int actualDamage = damage;
        
        if (actualDamage < 0) {
            actualDamage = 0;
        }
        
        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }else {
            this.getHeald();
        }

        return actualDamage;

    }

    protected void getHeald() {
        if (this.health <= 25) {
            int healChance = 50;

            if (Math.random() < (double) healChance / 100) {
                System.out.printf("ooOOOooOOOOoOO  Healing SPELL  (@_@ )\n");
                this.health += healStreng;
            }
        }
    }
    
    @Override
    public int getDamage() {
        int actualDamage = this.damage;
        return actualDamage;
    }
}

