package betr.intern.task2.Repos;

import java.util.Optional;
import java.util.Set;

public interface IRepository<T> {
    Set<T> getAll();
    T add(T t);
    void remove(T t);
    T update(T t);
    Optional<T> find(T t);
}
