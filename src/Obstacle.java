public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int reward;
    private int defHealth;

    public Obstacle(int id, String name, int damage, int health,int reward,int defHealth) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defHealth = defHealth;
        this.reward = reward;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
