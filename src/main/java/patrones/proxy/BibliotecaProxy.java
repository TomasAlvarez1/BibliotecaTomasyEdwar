package patrones.proxy;
import Socio.Socio;
import Vip.Vip;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tomas
 */
public interface BibliotecaProxy {
    void registrarSocioOvip(String nombre, int id);
    void modificarSocioOvip(String nombre, int id);
    void eliminarSocioOvip(String nombre);
    void verListaSociosOvip();
    void solicitarLibroOrevista(String nombre, String libro);
    void buscarLibroOrevista(String revista);
}
