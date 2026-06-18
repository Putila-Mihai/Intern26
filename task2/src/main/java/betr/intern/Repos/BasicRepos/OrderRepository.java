package betr.intern.Repos.BasicRepos;

import betr.intern.Model.Order;
import betr.intern.Repos.IRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OrderRepository implements IRepository<Order> {
    Set<Order> orders;
    
    public OrderRepository(Set<Order> orders) {
        this.orders = orders;
    }
    
    public OrderRepository() {
        this.orders = new HashSet<>();
    }
    
    @Override
    public Set<Order> getAll() {
        return Set.of();
    }

    @Override
    public Order add(Order order) {
        try {
            if (orders.contains(order))
                throw new RuntimeException("order already exists");
            if (order.equals(null))
                throw new NullPointerException("order is null");
            orders.add(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public void remove(Order order) {
        try {
            Optional<Order> orderToRemove = Optional.of(this.get(Optional.of(order).stream().findFirst().orElseThrow()));
            orders.remove(orderToRemove.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Order update(Order order) {
        try {
            Order orderToRemove = orders.stream()
                    .filter(i -> i.id().equals(order.id()))
                    .findFirst()
                    .orElseThrow();
            remove(orderToRemove);
            add(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public Order get(Order order) {
        return orders.stream().filter(i -> i.id().equals(order.id())).findFirst().orElseThrow();
    }
}
