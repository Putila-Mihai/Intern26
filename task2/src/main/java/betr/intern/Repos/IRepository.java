package betr.intern.Repos;

import java.util.List;
import java.util.Set;

public interface IRepository<T> {
    Set<T> getAll();
    T add(T t);
    void remove(T t);
    T update(T t);
    T get(T t);
}
