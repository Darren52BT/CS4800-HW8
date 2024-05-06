import java.lang.reflect.Array;
import java.util.ArrayList;

public class VendingMachine {

    private StateOfVendingMachine state;
    private ArrayList<Snack> snacks;
    private SnackDispenseHandler handler;
    private double providedMoney;

    public VendingMachine(ArrayList<Snack> snacks){
        this.state = new IdleState();
        this.snacks = snacks;
        this.providedMoney = 0;

        SnackDispenseHandler currChain = null;
        for ( int i = this.snacks.size() -1; i >= 0; i--){
            currChain = new SnackDispenseHandler(this.snacks.get(i), currChain);
        }
        this.handler = currChain;
    }


    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void selectSnack(String snackName){
        this.state.selectSnack(this, snackName);
    }

    public void insertMoney(double money){
        this.providedMoney += money;
        this.state.insertMoney(this, this.providedMoney);
    }

    public void dispenseSnack(){
        this.state.dispenseSnack(this);
    }



    public Snack findSnack(String name) {
        for (Snack snack : this.snacks) {
            if (snack.getName().equals(name)){
                return snack;
            }
        }
        return null;
    }

    public void refundMoney(){
        System.out.println("You are being refunded " + this.providedMoney);
        this.providedMoney = 0;
    }

    public void subtractFromMoney(double money){
        this.providedMoney -= money;
    }


    public SnackDispenseHandler getHandler() {
        return handler;
    }


    public double getProvidedMoney() {
        return providedMoney;
    }
}
