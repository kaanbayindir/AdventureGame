import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){

        System.out.println("Welcome to Adventure Game");
        System.out.println("Please enter a name:");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName());
        System.out.println("Please pick a chracter type:");
        player.selectChar();
        Location location = null;
        while(true) {
        player.printInfo();
        System.out.println("############### Areas ################");
        System.out.println("");
        System.out.println("1 - Safe House ----> Safe Zone");
        System.out.println("2 - Tool Store ----> You can buy weapon or armor");
        System.out.println("3 - Cave ----------> Prize <Food> Watch out for zombies.");
        System.out.println("4 - Forest --------> Prize <Firewood> Watch out for vampires.");
        System.out.println("5 - River- --------> Prize <Water> Watch out for bears.");
        System.out.println("0 - Quit");
        System.out.println("");
        System.out.println("Please choose a area");
        int selectLoc = input.nextInt();
        switch (selectLoc) {
            case 0:
                location = null;
                break;
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new ToolStore(player);
                break;
            case 3:
                location = new Cave(player);
                break;
            case 4:
                location = new Forest(player);
                break;
            case 5:
                location = new River(player);
                break;
            default:
                System.out.println("Try again");
                break;
            }

            if(location == null) {
                System.out.println("See you coward");
                break;
            }
            if (location.onLocation() == false) {

                System.out.println("GAME OVER!");
                break;
            }


        }


    }

}
