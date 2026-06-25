package betr.intern.repository;

import betr.intern.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
  private final List<Order> orders = new ArrayList<>();
  private long currentOrderId = 1;

  public Order save(Order order) {
    orders.add(order);
    return order;
  }

  public long getNextOrderId() {
    return currentOrderId++;
  }

  public List<Order> findAll() {
    return new ArrayList<>(orders);
  }

  public Optional<Order> findById(Long id) {
    return orders.stream().filter(o -> o.getOrderId().equals(id)).findFirst();
  }
}
