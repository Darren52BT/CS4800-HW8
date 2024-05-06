public class Snack {
    private String name;
    private double price;
    private int quantity;

    public Snack(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getOne(){
        if(this.quantity > 0){
            this.quantity--;
        }
    }


}