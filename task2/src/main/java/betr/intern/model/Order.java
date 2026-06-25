package betr.intern.model;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
  private final Long orderId;
  private final OffsetDateTime datePurchased;
  private final List<OrderItem> items;
  private final double totalPrice;

  public Order(Long orderId, List<OrderItem> items) {
    this.orderId = orderId;
    this.items = Collections.unmodifiableList(new ArrayList<>(items));
    this.datePurchased = OffsetDateTime.now();
    this.totalPrice = items.stream().mapToDouble(OrderItem::getSubtotal).sum();
  }

  public Long getOrderId() {
    return orderId;
  }

  public OffsetDateTime getDatePurchased() {
    return datePurchased;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void printOrderDetail() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss Z");

    System.out.println("\n--- Confirmare Comanda #" + orderId + " ---");
    System.out.println("Data tranzactiei: " + datePurchased.format(formatter));
    System.out.println("Articole cumparate:");

    for (OrderItem orderItem : items) {
      System.out.printf(
          "  - %s: %d buc. x %.2f RON (Subtotal: %.2f RON)\n",
          orderItem.getItem().getName(),
          orderItem.getQuantity(),
          orderItem.getPriceAtPurchase(),
          orderItem.getSubtotal());
    }

    System.out.println("----------------------------------");
    System.out.printf("Total achitat: %.2f RON\n", totalPrice);
    System.out.println("Va multumim ca ati cumparat de la noi!");
  }
}
