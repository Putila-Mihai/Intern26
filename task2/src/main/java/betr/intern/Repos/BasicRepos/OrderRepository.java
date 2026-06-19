package betr.intern.Repos.BasicRepos;

import betr.intern.Model.Order;
import betr.intern.Repos.IRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OrderRepository implements IRepository<Order> {
    Set<Order> orders;
    
    public OrderRepository(final Set<Order> orders) {
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
    public Order add(final Order order) {
        if (find(order).isPresent()) {
            throw new RuntimeException("Order already exists");
        }
        orders.add(order);
        return order;
    }

    @Override
    public void remove(final Order order) {
        find(order).ifPresentOrElse(orders::remove, () -> {
            throw new RuntimeException("Order to be removed does not exist");
        });
    }

    @Override
    public Order update(final Order order) {
        try {
            remove(order);
            add(order);
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public Optional<Order> find(final Order order) {
        return orders.stream().filter(i -> i.id().equals(order.id())).findFirst();
    }
}
