package betr.intern;

public class Product {
  private final String name;
  private final String category;
  private final double price;

  public Product(final String name, final String category, final double price) {
    this.name = name;
    this.category = category;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }
}
