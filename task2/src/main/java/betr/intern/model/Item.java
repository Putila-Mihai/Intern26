package betr.intern.model;

public class Item {
  private Long id;
  private String name;
  private String details;

  private double price;

  private Category
      category; // fiecare item apartine unei categorii, relatia definita este many to one

  public Item() {}

  public Item(Long id, String name, String details, double price, Category category) {
    this.id = id;
    this.details = details;
    this.name = name;

    this.price = price;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return java.util.Objects.equals(id, item.id);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id);
  }
}
