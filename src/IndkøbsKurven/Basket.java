package IndkøbsKurven;

import java.util.ArrayList;
import java.util.List;

public class Basket {
private List<Product> products;

public Basket() {
    this.products = new ArrayList<>();
}

    public void addProduct(Product product) {
    products.add(product);
    }

    public void printAll(){
    double total = 0;

        System.out.println("Basket");
        for (Product product : products) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Total: " + total);
    }
}
