import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int coin;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int defaultHealth;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();
        System.out.println("--------------------------------------------------------------");

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gameChar: charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "- Character: "  + gameChar.getName() +
                    "\t Damage: " + gameChar.getDamage() +
                    "\t Health: " + gameChar.getHealth() +
                    "\t Coin: " + gameChar.getCoin());
        }
        System.out.println("--------------------------------------------------------------");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Try again");
                selectChar();
                break;
        }

    }
    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefaultHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
        this.setCharName(gameChar.getName());


    }

    public void printInfo(){
        System.out.println("Your Weapon: " + this.getInventory().getWeapon().getName() + " , " +
                "\t Your Damage: " + getTotalDamage() + " , " +
                "\t Your Armor: " + this.getInventory().getArmor().getName() + " , " + " Block: " + this.getInventory().getArmor().getBlock() +  " , " +
                "\t Your Health: " + this.getHealth()+ " ," +
                "\t Your Coin: " + this.getCoin());

    }


    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health =0;
        }
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
