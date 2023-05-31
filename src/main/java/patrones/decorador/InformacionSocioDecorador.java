/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones.decorador;
import Socio.Socio;
/**
 *
 * @author tomas
 */
public class InformacionSocioDecorador extends SocioDecorador{
    
    public InformacionSocioDecorador(IdecoradorSocio socioDecorador){
        super(socioDecorador);
    }
    
    @Override
    public void notificarLibro(Socio s){
        SocioDecorador.notificarLibro(s);
        agregarNotificacion(s);
    }
    
    public void agregarNotificacion(Socio s){
        System.out.println("Se notifico al cliente " + s.getNombre() + " la entrga del prestamo del libro " + s.getLibro());
    }
}
