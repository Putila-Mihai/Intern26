package betr.intern.Repos.BasicRepos;

import betr.intern.Model.ShoppingCart;
import betr.intern.Repos.IRepository;

import java.util.Set;

public class ShoppingCartRepo implements IRepository<ShoppingCart> {

    @Override
    public Set<ShoppingCart> getAll() {
        return Set.of();
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public void remove(ShoppingCart shoppingCart) {

    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart get(ShoppingCart shoppingCart) {
        return null;
    }
}
