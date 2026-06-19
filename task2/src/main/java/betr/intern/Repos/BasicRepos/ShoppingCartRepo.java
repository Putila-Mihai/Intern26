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
    public ShoppingCart add(final ShoppingCart shoppingCart) {
        if (find(shoppingCart).isPresent()) {
            throw new RuntimeException("ShoppingCart already exists");
        }
        shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }

    @Override
    public void remove(final ShoppingCart shoppingCart) {
        find(shoppingCart).ifPresentOrElse(shoppingCarts::remove, () -> {
            throw new RuntimeException("ShoppingCart to be removed not found");
        });
    }

    @Override
    public ShoppingCart update(final ShoppingCart shoppingCart) {
        try {
            remove(shoppingCart);
            add(shoppingCart);
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> find(final ShoppingCart shoppingCart) {
        return shoppingCarts.stream().filter(i -> i.id().equals(shoppingCart.id())).findFirst();
    }


}
