package IndkøbsKurven;

public class Clothes extends Product {
    private String size;
    private String color;

    public Clothes(String name,double price,String size, String color) {
        super(name,price);
        this.size = size;
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getName() + ", " + "Size: " + size +", " + color + ": " + getPrice() + " euro";
    }
}
