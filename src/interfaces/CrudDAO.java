package interfaces;

import java.util.List;

public interface CrudDAO<T> {

    void guardar(T objeto);

    List<T> listar();

    void eliminar(int id);
}