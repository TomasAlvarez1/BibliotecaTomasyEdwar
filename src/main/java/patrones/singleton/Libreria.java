package patrones.singleton;
import java.util.ArrayList;
import java.util.List;
import patrones.DAO.*;
/**
 *
 * @author tomas
 */
public class Libreria {
    private static Libreria instancia;
    private List<Libro> libros;
    

    private Libreria() {
        libros = new ArrayList<>();
    }
    
    public static Libreria getInstancia() {
        if (instancia == null) {
            instancia = new Libreria();
        }
        return instancia;
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    
    public boolean comprobarDisponibilidadLibro(String titulo){
        for(Libro libro: libros){
            if (libro.getTitulo().equals(titulo) && libro.Disponible()) {
                return false;
            }
            
        }
        return true;
    }
    
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }
}
