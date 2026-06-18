package betr.intern.Repos.BasicRepos;

import betr.intern.Model.ShoppingCart;
import betr.intern.Repos.IRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ShoppingCartRepo implements IRepository<ShoppingCart> {
    Set<ShoppingCart> shoppingCarts;
    public ShoppingCartRepo() {
        shoppingCarts = new HashSet<>();
    }
    @Override
    public Set<ShoppingCart> getAll() {
        return Set.of();
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        try {
            if (shoppingCarts.contains(shoppingCart))
                throw new RuntimeException("shoppingCart already exists");
            if (shoppingCart.equals(null))
                throw new NullPointerException("shoppingCart is null");
            shoppingCarts.add(shoppingCart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return shoppingCart;
    }

    @Override
    public void remove(ShoppingCart shoppingCart) {
        try {
            Optional<ShoppingCart> shoppingCartToRemove = Optional.of(this.get(Optional.of(shoppingCart).stream().findFirst().orElseThrow()));
            shoppingCarts.remove(shoppingCartToRemove.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        try {
            ShoppingCart shoppingCartToRemove = shoppingCarts.stream()
                    .filter(i -> i.id().equals(shoppingCart.id()))
                    .findFirst()
                    .orElseThrow();
            remove(shoppingCartToRemove);
            add(shoppingCart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart get(ShoppingCart shoppingCart) {
        return shoppingCarts.stream().filter(i -> i.id().equals(shoppingCart.id())).findFirst().orElseThrow();
    }
}
