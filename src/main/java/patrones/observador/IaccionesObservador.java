
package patrones.observador;

/**
 *
 * @author tomas
 */
public interface IaccionesObservador {
    void añadirUsuario(String nombre, int id);
    void eliminarUsuario(String nombre);
    void notificar(String libro);
    void recibirLibro(String libro, String nombre);
}
