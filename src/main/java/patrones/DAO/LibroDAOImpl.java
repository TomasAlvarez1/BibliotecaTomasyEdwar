package patrones.DAO;

import adts.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomas
 */
public class LibroDAOImpl implements LibrosDAO {

    private List<Libro> libros;

    public LibroDAOImpl() {
        this.libros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public void modificarLibro(Libro libro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                break;
            }
        }
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(libros);
    }

}
