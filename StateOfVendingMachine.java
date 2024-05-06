public interface  StateOfVendingMachine {

    public void selectSnack(VendingMachine vendingMachine, String snackName);
    public void insertMoney(VendingMachine vendingMachine, double money);
    public void cancel(VendingMachine vendingMachine );

    public Snack dispenseSnack(VendingMachine vendingMachine);
}
