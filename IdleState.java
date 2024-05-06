public class IdleState implements StateOfVendingMachine{

    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        Snack snack = vendingMachine.findSnack(snackName);
        if(snack != null &&snack.getQuantity() > 0 ){
            System.out.println("We have " + snackName + ". Transitioning from idle to insertMoney state");
            vendingMachine.setState(new InsertMoneyState(snack));
        } else{
            System.out.println("We do not have " + snackName);
        }
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double money) {
        //does nothing
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        //does nothing since we're already in idle
    }

    @Override
    public Snack dispenseSnack(VendingMachine vendingMachine) {
        //does nothing
        return null;
    }
}
