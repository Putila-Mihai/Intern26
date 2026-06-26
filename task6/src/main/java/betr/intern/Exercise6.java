package betr.intern;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise6 {

  public static void run() {
    final List<Product> products =
        Arrays.asList(
            new Product("Laptop", "Electronics", 1200.0),
            new Product("Smartphone", "Electronics", 800.0),
            new Product("T-shirt", "Fashion", 25.0),
            new Product("Shoes", "Fashion", 60.0),
            new Product("Book", "Books", 15.0));

    final Map<String, Double> averagePriceByCategory =
        products.stream()
            .filter(p -> p.getPrice() <= 50.0)
            .collect(
                Collectors.groupingBy(
                    Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

    System.out.println(averagePriceByCategory);
  }
}
