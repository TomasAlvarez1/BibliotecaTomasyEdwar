
package patrones.observador;

import Vip.Vip;
import Socio.Socio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tomas
 */
public class BibliotecaObservador {
     private ArrayList<IaccionesObservador> receptores = new ArrayList<>();
     private List<String> librosRegistrados = new ArrayList<>();
     
    private String ultimoRegistro;

    public  boolean comprobarSocio(String nombre) {
        for (IaccionesObservador receptor : receptores) {
            if (receptor instanceof Socio) {
                Socio socio = (Socio) receptor;
                if (socio.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    public  boolean comprobarVip(String nombre) {
        for (IaccionesObservador receptor : receptores) {
            if (receptor instanceof Vip) {
                Vip vip = (Vip) receptor;
                if (vip.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean comprobarLibro(String nombreLibro) {
        for (IaccionesObservador receptor : receptores) {
            if (receptor instanceof Socio) {
                Socio socio = (Socio) receptor;
                if (socio.getLibro().equals(nombreLibro)) {
                    librosRegistrados.add(nombreLibro);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean comprobarEstadoRevista(String nombreRevista) {
        for (IaccionesObservador receptor : receptores) {
            if (receptor instanceof Vip) {
                Vip vip = (Vip) receptor;
                if (vip.getRevista().equals("revista cientifica")) {
                    return true;
                }
            }
        }
        return false;
    }
    
     public void listarLibrosRegistrados() {
        System.out.println("Libros registrados:");
        for (String libro : librosRegistrados) {
            System.out.println(libro);
        }
     }

    public void agregarReceptor(IaccionesObservador receptor) {
        receptores.add(receptor);
    }

    public void eliminarReceptor(IaccionesObservador receptor) {
        this.receptores.remove(receptor);
    }

    public void verEliminarUsuario(String nombre) {
        for (IaccionesObservador receptor : receptores) {
            receptor.eliminarUsuario(nombre);
        }
    }

    public void verNotificar(String libro) {
        for (IaccionesObservador receptor : receptores) {
            System.out.println("El libro ya esta disponible");
            receptor.notificar(libro);
        }
    }

    public void verRecibirLibro(String libro) {
        System.out.println("Los libros son \n");
        for (IaccionesObservador receptor : receptores) {
            receptor.notificar(libro);
        }
    }
    
    public void verRecibirRevista(String revista) {
        System.out.println("Las revistas son \n");
        for (IaccionesObservador receptor : receptores) {
            receptor.notificar(revista);
        }
    }
}
