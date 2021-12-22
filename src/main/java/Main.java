import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    private static final List<Product> productList = new ArrayList<>() {
        {
            add(new Product("TV", new BigDecimal("3999.99")));
            add(new Product("Fridge", new BigDecimal("1599.99")));
            add(new Product("Microwave oven", new BigDecimal("399.99")));
            add(new Product("PC", new BigDecimal("4599.99")));
            add(new Product("Headphones", new BigDecimal("129.99")));
        }
    };

    public static void main(String[] args) {
        Invoice invoice = invoiceGenerator.generate(productList, new BigDecimal(10));
        System.out.println(invoice);
    }
}