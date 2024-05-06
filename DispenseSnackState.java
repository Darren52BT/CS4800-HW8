public class DispenseSnackState implements StateOfVendingMachine{

    Snack selectedSnack;
    public DispenseSnackState(Snack selectedSnack){
        this.selectedSnack = selectedSnack;
    }


    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
    //does nothing
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double money) {
        //does nothing
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        //does nothing
    }

    @Override
    public Snack dispenseSnack(VendingMachine vendingMachine) {

        Snack snack =  vendingMachine.getHandler().dispenseSnack(selectedSnack.getName(), vendingMachine.getProvidedMoney());
        System.out.println("Your change is " + (vendingMachine.getProvidedMoney() - this.selectedSnack.getPrice()));

        vendingMachine.subtractFromMoney(vendingMachine.getProvidedMoney());
        vendingMachine.setState(new IdleState());
        System.out.println("Going from dispense to idle state");
       return snack;
    }


}
