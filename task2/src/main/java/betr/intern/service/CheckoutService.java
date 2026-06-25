package betr.intern.service;

import betr.intern.exception.OutOfStockException;
import betr.intern.model.CartItem;
import betr.intern.model.Order;
import betr.intern.model.OrderItem;
import betr.intern.model.ShoppingCart;
import betr.intern.model.Stock;
import betr.intern.repository.OrderRepository;
import betr.intern.repository.InventoryRepository;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private final InventoryRepository inventoryRepository;
    private final OrderRepository orderRepository;

    public CheckoutService(InventoryRepository inventoryRepository, OrderRepository orderRepository) {
        this.inventoryRepository = inventoryRepository;
        this.orderRepository = orderRepository;
    }

    public Order checkout(ShoppingCart cart) {
        List<CartItem> cartItems = cart.getItems();
        validateCart(cartItems);

        List<OrderItem> orderItems = processCartItems(cartItems);
        Order order = createOrder(orderItems);

        cart.clear();
        order.printOrderDetail();

        return order;
    }

    private void validateCart(List<CartItem> cartItems) {
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalStateException("Nu poti plasa o comanda cu un cos gol!");
        }
    }

    private List<OrderItem> processCartItems(List<CartItem> cartItems) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Stock stock = inventoryRepository.findByItem(cartItem.getItem())
                    .orElseThrow(() -> new IllegalArgumentException("Produsul " + cartItem.getItem().getName() + " nu mai exista in magazin!"));

            if (!stock.hasEnoughStock(cartItem.getQuantity())) {
                throw new OutOfStockException("Checkout esuat: Stoc insuficient pentru produsul: " +
                        cartItem.getItem().getName() + ". Disponibil: " + stock.getQuantity());
            }

            stock.deductQuantity(cartItem.getQuantity());

            OrderItem orderItem = new OrderItem(
                    cartItem.getItem(),
                    cartItem.getQuantity(),
                    cartItem.getItem().getPrice()
            );
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private Order createOrder(List<OrderItem> orderItems) {
        long orderId = orderRepository.getNextOrderId();
        Order order = new Order(orderId, orderItems);
        return orderRepository.save(order);
    }
}
