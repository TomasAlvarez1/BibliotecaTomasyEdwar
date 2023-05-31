package patrones.decorador;
import Vip.Vip;
/**
 *
 * @author tomas
 */
public class InformacionVipDecorador extends VipDecorador{
    public InformacionVipDecorador(IdecoradorVip VipDecorador){
        super(VipDecorador);
    }
    
    @Override
    public void notificarRevista(Vip v){
        VipDecorador.notificarRevista(v);
        agregarNotificacion(v);
    }
    
    public void agregarNotificacion(Vip v){
        System.out.println("Se notifico al cliente " + v.getNombre() + " la entrga del prestamo de la resvista " + v.getRevista());
    }
}
