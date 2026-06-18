package betr.intern.Service;

import betr.intern.Model.Order;
import betr.intern.Model.ShoppingCart;
import betr.intern.Repos.BasicRepos.OrderRepository;

import java.time.LocalDateTime;

public class OrderService {
    OrderRepository orderRepository;
    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    public Order addOrder(ShoppingCart shoppingCart) {
        return orderRepository.add(new Order(LocalDateTime.now(), shoppingCart.items()));
    }

    public void printOrderDetails(Order order) {
        System.out.println(order);
    }
}
