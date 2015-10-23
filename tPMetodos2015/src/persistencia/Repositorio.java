package persistencia;

import java.util.List;

public interface Repositorio<E> {
	void save(E objeto);
    void delete(E objeto);
    E getById(int id);
    List<E> getAll();
    void saveAll(List<E> lista);
    void update(E objeto);
}
