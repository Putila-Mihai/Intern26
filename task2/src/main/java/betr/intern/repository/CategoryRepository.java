package betr.intern.repository;

import betr.intern.model.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository {
    private final List<Category> categories = new ArrayList<>();
    private long currentId = 1;

    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(currentId++);
            categories.add(category);
        } else {
            deleteById(category.getId());
            categories.add(category);
        }
        return category;
    }

    public List<Category> findAll() {
        return new ArrayList<>(categories);
    }

    public Optional<Category> findById(Long id) {
        return categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        categories.removeIf(c -> c.getId().equals(id));
    }
}
