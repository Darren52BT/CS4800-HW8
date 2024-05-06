public class InsertMoneyState implements StateOfVendingMachine{
    public Snack selectedSnack;

    public InsertMoneyState(Snack selectedSnack){
        this.selectedSnack = selectedSnack;
    }

    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        //does nothing, they have to cancel to go back idle
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double money ) {
        //if money is equal to or over snack price,  transition to dispense state
        if(money >=this.selectedSnack.getPrice()){
            vendingMachine.setState(new DispenseSnackState(this.selectedSnack));
            System.out.println("Going from insertMoney to dispense");
            return;
        }
        //otherwise stay here
        System.out.println("Still in insert money state");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        //refund money and go back to idle
        vendingMachine.refundMoney();
        vendingMachine.setState(new IdleState());
        System.out.println("Canceled, moving from insertMoney to idle state");
    }

    @Override
    public Snack dispenseSnack(VendingMachine vendingMachine) {
        return null;
    }
}
