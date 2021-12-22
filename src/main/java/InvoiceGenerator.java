import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceGenerator {

    private final InvoiceProductGenerator invoiceProductGenerator;
    private final DataValidator dataValidator;

    public InvoiceGenerator() {
        this.dataValidator = new DataValidator();
        this.invoiceProductGenerator = new InvoiceProductGenerator();
    }

    public Invoice generate(List<Product> productList, BigDecimal discount) {
        BigDecimal totalPrice = productList.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        dataValidator.validate(productList, discount, totalPrice);
        List<InvoiceProduct> invoiceProductList = productList.stream().map((product -> invoiceProductGenerator.generate(product, totalPrice, discount))).collect(Collectors.toList());
        return new Invoice(invoiceProductList, discount, totalPrice);
    }
}
