public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Welcome to Tool Store -------");
        boolean showMenu = true;
        while(showMenu) {
            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Quit");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Try again");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you later");
                    showMenu = false;
                    break;
                default:
                    System.out.println("Tekrar deneyiniz");
            }

        }
        return true;
    }

    public void printWeapon(){
        System.out.println("------ Weapons ------");
        System.out.println();
        for (Weapon w: Weapon.weapons())
              {
                  System.out.println(w.getId() + "-" + w.getName() + " <Price : " + w.getPrice() + " , Damage : " + w.getDamage());
        }

        System.out.println("0 - Quit");


    }
    public void buyWeapon(){
        int selectWeaponID = input.nextInt();

        if (selectWeaponID< 0 || selectWeaponID > Weapon.weapons().length)
        {
            System.out.println("Try again");
        }

        if (selectWeaponID != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
                    System.out.println("You don't have enough coin ");
                }
                else {
                    System.out.println( "You bought a " + selectedWeapon.getName());
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your remaining coin : " + this.getPlayer().getCoin());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    //System.out.println("Your weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("------ Armors ------");
        System.out.println();
        for (Armor a: Armor.armors())
        {
            System.out.println(a.getId() + "-" + a.getName() + " <Price : " + a.getPrice() + " , Block : " + a.getBlock());
        }
        System.out.println("0-Quit");
    }
    public void buyArmor(){
        int selectArmorID = input.nextInt();

        if (selectArmorID< 0 || selectArmorID > Armor.armors().length)
        {
            System.out.println("Try again");
        }

        if(selectArmorID != 0 ) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getCoin()) {
                    System.out.println("You don't have enough coin ");
                }
                else {
                    System.out.println( "You bought a " + selectedArmor.getName());
                    int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your remaining coin : " + this.getPlayer().getCoin());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    //System.out.println("Your weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }

        }

        }

}
