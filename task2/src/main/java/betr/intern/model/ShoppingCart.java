package betr.intern.model;

import betr.intern.exception.OutOfStockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {

  private final List<CartItem> items = new ArrayList<>();

  public List<CartItem> getItems() {
    return Collections.unmodifiableList(items);
  }

  public void addItem(Item item, int quantity, Stock stock) {
    if (item == null || stock == null) {
      throw new IllegalArgumentException("Produsul sau stocul nu pot fi null!");
    }
    if (!stock.getItem().equals(item)) {
      throw new IllegalArgumentException("Stocul furnizat nu corespunde acestui produs!");
    }
    if (quantity <= 0) {
      throw new IllegalArgumentException("Cantitatea de adaugat trebuie sa fie mai mare decat 0!");
    }

    int alreadyInCart = getQuantityInCart(item);
    int totalRequested = alreadyInCart + quantity;

    if (!stock.hasEnoughStock(totalRequested)) {
      throw new OutOfStockException(
          "Stoc insuficient pentru "
              + item.getName()
              + ". Stoc disponibil: "
              + stock.getQuantity()
              + ", Ai deja in cos: "
              + alreadyInCart
              + ", Cerut aditional: "
              + quantity);
    }

    Optional<CartItem> existingItem = findCartItem(item);
    if (existingItem.isPresent()) {
      existingItem.get().incrementQuantity(quantity);
    } else {
      items.add(new CartItem(item, quantity));
    }
  }

  public double getTotalPrice() {
    return items.stream().mapToDouble(CartItem::getSubtotal).sum();
  }

  public void clear() {
    items.clear();
  }

  public void printCart() {
    if (items.isEmpty()) {
      System.out.println("Cosul tau de cumparaturi este gol.");
      return;
    }

    System.out.println("\n--- Produsele din cosul tau ---");
    for (CartItem cartItem : items) {
      // Afisam detaliile fiecarei linii din cos intr-un format usor de citit
      System.out.printf(
          "  - %s: %d buc. x %.2f RON (Subtotal: %.2f RON)\n",
          cartItem.getItem().getName(),
          cartItem.getQuantity(),
          cartItem.getItem().getPrice(),
          cartItem.getSubtotal());
    }
    // Folosim getTotalPrice() care ruleaza un Stream pentru a insuma subtotalurile din mers
    System.out.printf("Valoare totala cos: %.2f RON\n", getTotalPrice());
    System.out.println("--------------------------------");
  }

  private Optional<CartItem> findCartItem(Item item) {
    return items.stream().filter(cartItem -> cartItem.getItem().equals(item)).findFirst();
  }

  private int getQuantityInCart(Item item) {
    return findCartItem(item).map(CartItem::getQuantity).orElse(0);
  }
}
