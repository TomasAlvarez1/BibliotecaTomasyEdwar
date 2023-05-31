package Vip;
import java.util.ArrayList;
import patrones.observador.IaccionesObservador;

/**
 *
 * @author tomas
 */
public class Vip implements IaccionesObservador{
    private ArrayList<String> RevistaPrestados = new ArrayList<>();
    String nombre;
    String Revista;
    int id;

    public Vip(String nombre, String Revista, int id) {
        this.nombre = nombre;
        this.Revista = Revista;
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getRevista() {
        return Revista;
    }

    
    @Override
    public void añadirUsuario(String nombre, int id) {
        System.out.println("Se añadio un nuevo vip " + nombre + ", con numero de identidad " + id);
    }

    public void VerusuariosRegistrados(String nombre, int id) {
        System.out.println(nombre);
    }
    
    @Override
    public void eliminarUsuario(String nombre) {
        System.out.println("Se elimino el VIP " + nombre);
    }

    @Override
    public void notificar(String libro) {
        System.out.println("La revista " + libro + " ya está disponible. ¡Ven a recogerlo!");
    }

    @Override
    public void recibirLibro(String libro, String nombre) {
        System.out.println("Se recibió la revista " + libro + " a nombre de " + nombre);
    }
    
    @Override
    public String toString() {
        return "Vip nombre: " + nombre + " ,identificacion: " + id ;
    }
}
