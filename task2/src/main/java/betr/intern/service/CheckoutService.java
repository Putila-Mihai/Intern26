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
        
        if (cartItems.isEmpty()) {
            throw new IllegalStateException("Nu poti plasa o comanda cu un cos gol!");
        }

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

        long orderId = orderRepository.getNextOrderId();
        Order order = new Order(orderId, orderItems);
        orderRepository.save(order);

        cart.clear();
        order.printOrderDetail();

        return order;
    }
}
