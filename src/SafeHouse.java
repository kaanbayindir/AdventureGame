public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------- You are in Safe House -------");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        System.out.println("-------- Your health is fulled -------");
        return true;
    }

    public void fullHeal(){


    }
}
