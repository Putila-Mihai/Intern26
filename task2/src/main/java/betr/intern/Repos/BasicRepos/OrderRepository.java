package betr.intern.Repos.BasicRepos;

import betr.intern.Model.Order;
import betr.intern.Repos.IRepository;

import java.util.Set;

public class OrderRepository implements IRepository<Order> {
    @Override
    public Set<Order> getAll() {
        return Set.of();
    }

    @Override
    public Order add(Order order) {
        return null;
    }

    @Override
    public void remove(Order order) {

    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order get(Order order) {
        return null;
    }
}
