package patrones.decorador;

import Vip.Vip;

/**
 *
 * @author tomas
 */
public class NotificarVipCelular implements IdecoradorVip{
    @Override
    public void notificarRevista(Vip v) {
        System.out.println("_______________________________");
        System.out.println("¡Nueva notificacion de SMS!");
        System.out.println("Señor Vip: " + v.getNombre());
        System.out.println("Tiene un dia para devolver el libro " + v.getRevista());
    }
}
