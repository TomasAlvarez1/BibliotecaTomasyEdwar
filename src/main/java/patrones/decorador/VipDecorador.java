package patrones.decorador;

import Vip.Vip;

/**
 *
 * @author tomas
 */
public class VipDecorador implements IdecoradorVip{
    protected IdecoradorVip VipDecorador;
    
    public VipDecorador(IdecoradorVip VipDecorador){
        this.VipDecorador = VipDecorador;
    }
    
    @Override
    public void notificarRevista(Vip v) {
        this.VipDecorador.notificarRevista(v);
    }
}
