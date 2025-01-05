package IndkøbsKurven;

public class Food extends Product {
    private String expireDate;


    public Food(String name, double price, String expireDate) {
        super(name, price);
        this.expireDate = expireDate;
    }
    public String getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return getName() + ", " + "Expires: " + expireDate + ": " + getPrice() + " euro";
    }
}
