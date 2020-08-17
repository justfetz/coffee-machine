package machine;
import java.util.Scanner;

public class CoffeeMaker {

    private int milk;
    private int water;
    private int coffee;
    private int cups;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public CoffeeMaker(int milk, int water, int coffee, int cups, int money) {
        this.milk = milk;
        this.water = water;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }


    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {

        this.milk = milk;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        if(water < 0) {
            this.water =0;
        }
        this.water = water;

    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }


    public void buyEspresso() {
        System.out.println("I have enough resources, making you a coffee!");
        this.money += 4;
        if(this.getMoney()< 0) {
            this.setMoney(0);
        }
        this.water -= 250;
        if (this.getWater()< 0) {
            this.setWater(0);
        }
        this.coffee -= 16;
        if (this.getCoffee() < 0) {
            this.setCoffee(0);
        }
        this.cups -=1;
        if (this.getCups() < 0) {
            this.setCups(0);
        }
    }

    public void buyCappuccino() {
        System.out.println("I have enough resources, making you a coffee!");
        this.money += 6;
        if (this.getMoney() < 0) {
            this.setMoney(0);
        }
        this.milk -= 100;
        if(this.getMilk() < 0) {
            this.setMilk(0);
        }
        this.water -= 200;
        if(this.getWater() < 0) {
            this.setWater(0);
        }
        this.coffee -= 12;
        if (this.getCoffee()<0) {
            this.setCoffee(0);
        }
        this.cups-=1;
        if (this.getCups()< 0) {
            this.setCups(0);
        }
    }

    public void buyLatte() {
        System.out.println("I have enough resources, making you a coffee!");
        this.money += 7;
        if (this.getMoney()< 0) {
            this.setMoney(0);
        }
        this.milk -= 75;
        if (this.getMilk() < 0) {
            this.setMilk(0);
        }
        this.water -= 350;
        if (this.getWater() < 0) {
            this.setWater(0);
        }
        this.coffee -= 20;
        if (this.getCoffee()< 0) {
            this.setCoffee(0);
        }
        this.cups-=1;
        if (this.getCups() < 0) {
            this.setCups(0);
        }

    }

    public void buy(int choice) {
        switch (choice) {
            case 1:
                buyEspresso();
                toString();
                break;
            case 2:
                buyLatte();
                toString();
                break;
            case 3:
                buyCappuccino();
                toString();
                break;
            default:
                break;
        }

    }

    public void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int waterAdd = scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkAdd = scan.nextInt();
        System.out.println("Write how many grams of coffee do you want to add:");
        int coffeeAdd = scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsAdd = scan.nextInt();
        this.water += waterAdd;
        this.milk += milkAdd;
        this.coffee += coffeeAdd;
        this.cups += cupsAdd;
        //System.out.println(this.toString());
        //System.exit(0);
        displayMenu();
    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        this.money=0;
        //System.out.println(this.toString());
        displayMenu();
        //System.exit(0);

    }

    public void displayMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = s.nextLine();
            if (action.equals("buy")) {
                selectType();
            } else if (action.equals("fill")) {
                fill();
            } else if (action.equals("take")) {
                take();
            } else if (action.equals("remaining")) {
                System.out.println(this.toString());
            } else if (action.equals("exit")) {
                System.exit(0);
            }

    }

    public static boolean haveEnough(int needed, int milkAmount, int coffeeAmount, int waterAmount) {
        if (needed == 0) {
            return true;
        } else if ((needed * 200) > waterAmount) {
            return false;
        } else if ((needed * 100) > milkAmount) {
            return false;
        } else if ((needed * 12) > coffeeAmount) {
            return false;
        }
        return true;
    }
    /*For the espresso,
     the coffee machine needs 250 ml of water
     and 16 g of coffee beans.
     It costs $4.

     For the latte,
     the coffee machine needs 350 ml of water,
     75 ml of milk,
     and 20 g of coffee beans.
     It costs $7.

     And for the cappuccino,
      the coffee machine needs 200 ml of water,
      100 ml of milk,
      and 12 g of coffee.
      It costs $6.*/

    public String displayViolations(int type) {
        switch (type) {
            //espresso
            case 1:
                if (this.getWater() < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.getCoffee() < 16) {
                    System.out.println("Sorry, not enough coffee!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                //latte
            case 2:
                if (this.getWater()<350) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.getMilk()<75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.getCoffee()<20) {
                    System.out.println("Sorry, not enough coffee!");
                }   else {
                    System.out.println("I have enough resources, making you a coffee!");

                }

                //cappucino
            case 3:
                if (this.getWater() < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.getMilk() < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.getCoffee() < 12) {
                    System.out.println("Sorry, not enough coffee!");
                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                }

            default:
                break;
        }
return "";
    }

    public boolean checkAmount(int type) {
        switch (type) {
            //espresso
            case 1:
                if (this.getWater() < 250) {

                    return false;

                } else if (this.getCoffee() < 16) {
                        return false;
                    } else {
                        return true;
                    }
                //latte
            case 2:
                if (this.getWater()<350) {
                    return false;
                } else if (this.getMilk()<75) {
                    return false;
                } else if (this.getCoffee()<20) {
                    return false;
                }   else {
                    return true;
                }

            //cappucino
                case 3:
                    if (this.getWater() < 200) {
                        return false;
                    } else if (this.getMilk() < 100) {
                        return false;
                    } else if (this.getCoffee() < 12) {
                        return false;
                    }else {
                        return true;
                    }

            default:
                break;
        }
        return true;
    }

    public void selectType() {
        Scanner s = new Scanner(System.in);
        System.out.println("What do you want to buy?");
        System.out.println("1 - espresso");
        System.out.println("2 - latte");
        System.out.println("3 - cappuccino");
        System.out.println("back - to main menu");
        String selection = s.nextLine();
        int x =0;
        if(selection.equals("back") ) {
            displayMenu();
        } else {
            x = Integer.parseInt(selection);
        }

            boolean b = checkAmount(x);
            if (b) {
                buy(x);

            } else {
                System.out.println(displayViolations(x));
            }

        //System.exit(0);
        displayMenu();
    }


    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                this.getWater() +  " of water\n" +
                milk + " of milk\n" +
                coffee + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                "$" + money + " of money";

    }
}
