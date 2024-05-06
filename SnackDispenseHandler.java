public class SnackDispenseHandler {
    private Snack snack;
    private SnackDispenseHandler nextSnackHandler;

    public SnackDispenseHandler(Snack snack, SnackDispenseHandler nextHandler)
    {
        this.snack = snack;
        this.nextSnackHandler = nextHandler;
    }

    public Snack dispenseSnack(String snackName, double providedMoney){
        System.out.println("Current handler of " + this.snack.getName());
        if(this.snack.getName().equals(snackName) && providedMoney >= snack.getPrice() && snack.getQuantity() > 0){
            System.out.println("Dispensing " + snackName);
            snack.getOne();
            return snack;
        } else if (nextSnackHandler != null){
            return nextSnackHandler.dispenseSnack(snackName, providedMoney);
        } else{
            System.out.println("We're out of " + snackName);
            return snack;
        }
    }

}
