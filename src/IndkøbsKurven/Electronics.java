package IndkøbsKurven;

public class Electronics extends Product {
    private int warrantyNoOfMonths;
    public Electronics(String name, double price, int warrantyNoOfMonths) {
        super(name, price);
        this.warrantyNoOfMonths = warrantyNoOfMonths;
    }
  @Override
  public String toString() {
                return getName() + ", " + "Months of Warranty: " + warrantyNoOfMonths + ": " + getPrice() + " euro";
  }
}
