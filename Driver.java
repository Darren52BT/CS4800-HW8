import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

        ArrayList<Snack> snacks = new ArrayList<>();

        snacks.add(new Snack("Coke", 2, 5));
        snacks.add(new Snack("Pepsi", 2, 1));
        snacks.add(new Snack("Cheetos", 1.8, 10));
        snacks.add(new Snack("Doritos", 1.8, 15));
        snacks.add(new Snack("KitKat", 1.5, 8));
        snacks.add(new Snack("Snickers", 1.5, 3));


        VendingMachine vendingMachine = new VendingMachine(snacks);
        vendingMachine.selectSnack("human");
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(.5);
        vendingMachine.insertMoney(.5);
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();
        vendingMachine.selectSnack("Pepsi");
    }

}
