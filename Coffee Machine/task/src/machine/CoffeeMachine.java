package machine;
import java.util.Scanner;



public class CoffeeMachine {

    public static void displayMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public static boolean haveEnough(int needed, int milkAmount, int coffeeAmount, int waterAmount) {
        if (needed == 0) {
            return true;
        } else if ((needed * 200) > waterAmount) {
            return false;
        } else if ((needed * 50) > milkAmount) {
            return false;
        } else if ((needed * 15) > coffeeAmount) {
            return false;
        }
        return true;    
    }

  /*  public void displayMenu() {
        Scanner s = new Scanner(System.in);



    } */
    public static void main(String[] args) {

        CoffeeMaker maker = new CoffeeMaker(540, 400, 120, 9, 550);
        Scanner s = new Scanner(System.in);
        displayMenu();
        while (true) {

            String action = s.nextLine();
            switch (action) {
                case "buy":
                    maker.selectType();
                    //maker.toString();
                    displayMenu();
                    break;
                case "fill":
                    maker.fill();
                    displayMenu();
                    break;
                case "take":
                    maker.take();
                    displayMenu();
                    break;
                case "remaining":
                    System.out.println(maker.toString());
                    displayMenu();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}