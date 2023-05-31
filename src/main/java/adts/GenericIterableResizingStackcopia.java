package adts;

import java.util.Iterator;

/**
 * @version 01
 * @author Tomas Ballesteros, Mateo Ballesteros, Edwar Carvajal y Tomas Alvarez 
 * @since 17 de marzo de 2023 
 */
public class GenericIterableResizingStackcopia <Item> implements Iterable <Item>{
/**
 * La pila es una base de datos que se basa en las normas LIFO Last In First Out,
 * el ultimo que entra, es el primero que sale, de esta manera se aplicaron los metodos push y pop para el desarrollo
 * y funcionamiento de la misma
 */
    
 /**
 * Se crea un arreglo de tipo item
 * se crea un contador
*/
    private Item a [];
    private int count;
    
    /**
 * Se crea le contructor y en este se inicializan las variables
 * se castea el tipo de dato  del arreglo, ya que el arreglo fue creado de tipo object, se casteo a tipi item
 * se inicializo el contador en 0
 */
    public GenericIterableResizingStackcopia(){
        a = (Item[]) new Object [1];
        count = 0;
    }
   /**
    * El metodo push se encarga de poner los elementos en la pila.
    * @param item 
    */ 
    public void push(Item item){
        if(count == a.length)
            resize(1+a.length*2);
        a[count++] = item;
    }
    
    /**
     * El metodo pop se encarga de quitar los elementos de la pila.
     * @return temp
     */
    public Item pop (){
        Item temp = a[--count];
        a[count] = null;
        if(count <= a.length / 4 && count > 0)
            resize(a.length/2);
        return temp;
    }
  /**
 * el metodo peak retorna el ulitmo valor agregado a la pila, es decir el que esta en el tope
 * @return a[count-1]
 */  
    public Item peak(){ //retorna lo que hay en el tope de la pila :3
        return a[count-1];
    }
    /**
 * el metodo isEmpty verifica si el arreglo esta vacio, si es asi retorna count= 0
 * @return count
 */
    public boolean isEmpty(){
        return count==0;
    }
     public boolean isFull(){
        return count==a.length;
    }
    /**
 * el metodo size retorna la cantidad de datos dentro del arreglo
 * @return count
 */
    public int Size(){
        return count;
    }
    /**
    * El metodo resize se encarga de hacer crecer el arreglo cuando este lo requiera
    * en este metodo se utiliza un arreglo temporal del doble del arreglo orginal
    * en este arreglo se copian los datos del orginal y despues se iguala el arreglo original con el temporal
    * @param maxCap 
    */
    private void resize(int maxCap){
        Item temp[] = (Item[]) new Object[maxCap];
        for (int i = 0; i < count; i++) 
            temp[i] = a[i];
        a = temp;
    }
  
    /**
 * El iterador sera el encargado de procesar los datos.
 * @return 
 */
    @Override
    public Iterator<Item> iterator() {
      return new ReverseArrayIterator();  
    }
   
    
    /**
 * La clase ArrayIterador impementa la interfaz Iterador y contiene los metodos hasNext y Next
 */
    private class ReverseArrayIterator implements Iterator <Item>{
        int i = count;
 /**
 * El metodo hasNext se encarga de analizar si hay mas datos por procesar
 * @return i>0
 */ 
        @Override
        public boolean hasNext() {
            return i>0;
        }
 /**
    * El metodo Next procesa los datos.
    * @return item
    */
        @Override
        public Item next() {
          return a[--i];
        }
    }
    
}
