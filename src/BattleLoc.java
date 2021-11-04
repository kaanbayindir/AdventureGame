import javafx.scene.control.RadioMenuItem;

import java.util.Random;

public abstract class  BattleLoc extends Location {
    private Obstacle obstacle;
    private String reward;
    private int maxObstacle;
    public BattleLoc(Player player, String name,Obstacle obstacle,String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.reward = award;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return reward;
    }

    public void setAward(String award) {
        this.reward = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are in " + this.getName());
        System.out.println("Be careful ! " + obsNumber + " " + this.getObstacle().getName() + " is living in here !");
        System.out.println("<F>ight or <R>un");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {
                if(combat(obsNumber)) {
                    System.out.println("Fight is starting");

                    System.out.println("You defeated all enemies");
                    return true;
                }
        }

        if(this.getPlayer().getHealth() <= 0) {
            System.out.println("You died");
            return false;
        }
        else if (selectCase.equals("R")) {
            System.out.println("Coward");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for( int i = 1; i<=obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth() >0) {
                System.out.print("<A>ttack or <R>un");
                String selectCombat = input.nextLine();
                selectCombat = selectCombat.toUpperCase();
                if(selectCombat.equals("A")) {
                    System.out.println();
                    System.out.println("You hit the enemy");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("The enemy hit you");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage<0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You defeated the enemy");
                System.out.println(this.getObstacle().getReward() + " coin earned.");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getObstacle().getReward());

                System.out.println("Your coin : " + this.getPlayer().getCoin());
            }
        }
        return false;
    }
    public void afterHit(){
        System.out.println("Your Health  : "+ this.getPlayer().getHealth());
        System.out.println("Enemy Health : "+ this.obstacle.getHealth());



    }
    public void playerStats(){
        System.out.println("---------------------------------");
        System.out.println("You");
        System.out.println("---------------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor  : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block  : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Coin   : " + this.getPlayer().getCoin());

    }

    public void obstacleStats(int i){
        System.out.println("---------------------------------");
        System.out.println(i + "." + this.getObstacle().getName());
        System.out.println("---------------------------------");
        System.out.println("Health : " + this.getObstacle().getHealth());
        System.out.println("Damage : " + this.getObstacle().getDamage());
        System.out.println("Reward : " + this.getObstacle().getReward());

    }
    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
}
