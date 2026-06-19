package betr.intern.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final Long orderId;
    private final LocalDateTime datePurchased;
    private final List<OrderItem> items;
    private final double totalPrice;


    public Order(Long orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
        this.datePurchased = LocalDateTime.now();


        this.totalPrice = items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    public Long getOrderId() {
        return orderId;
    }

    public LocalDateTime getDatePurchased() {
        return datePurchased;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void printOrderDetail() {

        System.out.println("Detalii Comanda  " + orderId);
        System.out.println("Data achizitiei: " + datePurchased);

        for (OrderItem orderItem : items) {
            System.out.println("- " + orderItem);
        }
        System.out.printf("Total Comanda: %.2f RON\n", totalPrice);
    }
}