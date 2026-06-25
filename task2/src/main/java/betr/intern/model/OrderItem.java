package betr.intern.model;

public class OrderItem {
  private final Item item;
  private final int quantity;
  private final double priceAtPurchase;

  public OrderItem(Item item, int quantity, double priceAtPurchase) {
    this.item = item;
    this.quantity = quantity;
    this.priceAtPurchase = priceAtPurchase;
  }

  public Item getItem() {
    return item;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPriceAtPurchase() {
    return priceAtPurchase;
  }

  public double getSubtotal() {
    return priceAtPurchase * quantity;
  }

  @Override
  public String toString() {
    return item.getName()
        + " x "
        + quantity
        + " (Pret achizitie: "
        + priceAtPurchase
        + " | Subtotal: "
        + getSubtotal()
        + ")";
  }
}
