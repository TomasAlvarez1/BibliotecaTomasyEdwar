package adts;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @version 01
 * @author Tomas Ballesteros, Mateo Ballesteros, Edwar Carvajal y Tomas Alvarez 
 * @since 17 de marzo de 2023 
 */
public class GenericIterableResizingBag<Item> implements Iterable<Item> {
    
    /**
     * La maleta es aquella que nos permite almacenar los datos a partir de un arreglo
     * en el cual puedes volver a colocar datos sin la cuestion de eliminarlos sino
     * que permite hacer sacar un dato y volverlo a colocar dentro del arreglo 
     */
    
    /**
     * Atributos:
     * Se crea un arreglo
     * Contador de tipo Item
     */

    private Item arreglo[];
    private int contador;


    /**
     * Constructor que nos permite redimensionar e inicializar los datos creados dentro del array 
     * 
     */
    public GenericIterableResizingBag() {
        this.arreglo = (Item[]) new Object[1];
        this.contador = 0;
    }

    /**
     * Numero de elementos almacenados en la maleta. 
     * @return contaodr: que cantidad de elementos agregados
     */
    public int tamanio() {
        return contador;
    }

    /**
     * Devuelve un valor Booleano el cual indica si el Array esta lleno o no.
     *
     * @return contador y arreglo.length. Lo que hace es comparar el contador
     * con el arreglo
     */
    public boolean estaLLeno() {
        return contador == arreglo.length;
    }

    /**
     * Lo que hace es devolver el Array e indica a partir de un valor booleano
     * si la lista esta llena o no. 
     *
     * @return contador compara que la Array no sea igual a cero si es asi entonces nos dira
     * este tiene datos y devolvera true. 
     */
    public boolean estaVacio() {
        return contador == 0;
    }

    /**
     * Nos permite agregar un elemento al final de la lista y redimensioando el array 
     * @param item agregar elemento al array
     */
    public void Empacar(Item item) {
        Item dato = item;
        if (contador == arreglo.length)
            resize(arreglo.length * 2);
        arreglo[contador++] = item;                            
    }

    /**
     * Como lo dice el metodo actualiza el valor de un elemento en la posicion determinada que se le de la lista 
     * con el valor que se le asigne a dato 
     * @param pos Ingresa a la poscion del dato para remmplazarlo 
     * @param dato Nuevo valor de asignado 
     */
    public void actualizarDato(int pos, Item dato) {
        if (contador > 0 && pos >= 0 && pos < contador) {
            arreglo[pos] = dato;
        }
    }

      /**
     * Tomara la lista que se le este dando y eliminara el dato que encuentre a su izquierda 
     * @param pos El elemento de la poscion determinada 
     */
    private void correrIzq(int pos) {
        for (int i = pos; i < contador - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
        arreglo[contador - 1] = null;
    }

    /**
     * Mueve todos los elementos de la lista despues que se haya insertado 
     * un nuevo elemento a partir de la poscion que se le asigne. 
     * @param pos El emlemento que se correra a la derecha de la lista
     */
    private void correrDer(int pos) {
        for (int i = contador; i > pos; i--) {
            arreglo[i] = arreglo[i - 1];
        }
    }

    /**
     * Permite agregar cualquier elemento a una posicion determinada que asigne el usuario. 
     * @param pos Posicion escogida 
     * @param dato Es el elemento que sera asignado
     */
    public void adicionarDato(int pos, Item dato) {
        if (!estaLLeno()) {
            if (pos >= 0 && pos <= contador) {
                correrDer(pos);
                arreglo[pos] = dato;
                contador++;
            }
        }
    }

    /**
     * Agrega un elemento al principio de la lista y redimensionarla. 
     * @param dato Es el elemento que se asigna a la poscion. 
     */
    public void adicionarAlPrincipio(Item dato) {
        adicionarDato(0, dato);
    }

    /**
     * Agrega un elemento al final de la lista y la redimensiona.
     * @param dato Es el elemento que se asigna en la poscion.
     */
    public void aidcionarAlFinal(Item dato) {
        if (!estaLLeno()) {
            arreglo[contador] = dato;
            contador++;
        }
    }

     /**
     * Se utiliza para obtener el elemento en la poscion indicada 
     * @param pos posion que el usuario le alla indicado
     * @return arreglo[pos] = delvuelve el elemento en la posicon
     * @return null Si esta se encuentra vacia devolvera null
     */
    public Item obtenerDato(int pos) {
        if (!estaVacio()) {
            if (pos >= 0 && pos < contador) {
                return arreglo[pos];
            }
        }
        return null;
    }

    /**
     * Se utiliza para redimensionar la lista 
     * @param maxCap Sera la nueva capacidad maxima que obtendre la lista
     */
    private void resize(int maxCap) {
        Item temp[] = (Item[]) new Object[maxCap];
        for (int i = 0; i < contador; i++) {
            temp[i] = arreglo[i];
        }
        arreglo = temp;
    }

    /**
     * Devuelve la clase implementada en su interfaz y a partir de: 
     * 
     * metodo hasNext comprueba el sigueinte elemento de la lista. 
     * metodo next Recupera el siguiente elemento. 
     * @return ArrayIterator itera sobre los elementos de la lista desde el primer hasta el ultimo elemento. 
     */
    @Override
    public Iterator<Item> iterator() {
   
        return new ArrayIterator();  
    
    }

    
    private class ArrayIterator implements Iterator<Item> {
        
        int i= 0;
        int c= contador;
        public boolean hasNext (){
          return i<c;
        }
        
        public Item next(){
            Item temp = arreglo [i];
            i++;
            return temp;
        }
        
    }
    
}

/*



*/
