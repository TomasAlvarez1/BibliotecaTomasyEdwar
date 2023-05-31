package patrones.DAO;

import Socio.Socio;
import java.util.List;

/**
 *
 * @author tomas
 */
public interface LibrosDAO {
   void agregarLibro(Libro libro);
    void modificarLibro(Libro libro);
    void eliminarLibro(Libro libro);
    List<Libro> obtenerTodosLosLibros(); 
}
