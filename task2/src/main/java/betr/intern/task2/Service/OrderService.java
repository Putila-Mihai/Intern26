package betr.intern.task2.Service;

import betr.intern.task2.Model.Order;
import betr.intern.task2.Model.ShoppingCart;
import betr.intern.task2.Repos.BasicRepos.OrderRepository;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OrderService {
    OrderRepository orderRepository;
    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    public Order addOrder(final ShoppingCart shoppingCart) {
        return orderRepository.add(new Order(OffsetDateTime.now(), shoppingCart.items()));
    }

    public void printOrderDetails(final Order order) {
        System.out.println("\n--------Order Details-------");
        System.out.println("Date purchased: " + order.datePurchased().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        order.items().forEach((key, value) -> System.out.println("Item: " + key.name() + " " + "quantity: " + value + "..........$" + key.price()));
    }
}
