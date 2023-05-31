package patrones.decorador;

import Socio.Socio;

/**
 *
 * @author tomas
 */
public class NotificarSocioCorreo implements IdecoradorSocio{
     public void notificarLibro(Socio s) {
        System.out.println("_______________________________");
        System.out.println("¡Nueva notificacion de correo!");
        System.out.println("Señor Socio: " + s.getNombre());
        System.out.println("Tiene un dia para devolver el libro " + s.getLibro());
    }
}
