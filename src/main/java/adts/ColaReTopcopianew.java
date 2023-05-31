package adts;
import java.util.Iterator;
/**
 * @version 01
 * @author Tomas Ballesteros, Mateo Ballesteros, Edwar Carvajal y Tomas Alvarez 
 * @since 17 de marzo de 2023 
 */
public class ColaReTopcopianew<Item> implements Iterable<Item> {

    /**
     * La cola es una base de datos que se basa en las normas FIFO First In
     * First Out el primero que entra, es el primero que sale, de esta manera se
     * aplicaron los metodos enqueue y dequeue para el desarrollo y
     * funcionamiento de la misma
     */

    /**
     * Se crea un arreglo de tipo item se crea un contador se crean las
     * varibales inico y fin se crea una varaible tam para el tamaño del arreglo
     */
    private Item a[];
    private int count;
    private int inicio;
    private int fin;
    private int tam;

    /**
     * Se crea le contructor y en este se inicializan las variables se castea el
     * tipo de dato del arreglo, ya que el arreglo fue creado de tipo object, se
     * casteo a tipi item se inicializo el arreglo de tamaño 1 he inicio y fin
     * en 0
     */
    public ColaReTopcopianew() {
        tam = 1;
        a = (Item[]) new Object[tam];
        count = 0;
        inicio = 0;
        fin = 0;

    }

    /**
     * el metodo isEmpty verifica si el arreglo esta vacio, si es asi retorna
     * count= 0
     *
     * @return count
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * el metodo size retorna la cantidad de datos dentro del arreglo
     *
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * el metodo peak retorna el ulitmo valor agregado a la pila, es decir el
     * que esta en el tope
     *
     * @return a[count-1]
     */
    public Item peak() { //retorna lo que hay en el tope de la pila :3
        return a[count - 1];
    }

    /**
     * El metodo calcularNuevaPosicionFin calcula la nueva posicion en la que
     * sera ingresado el proximo dato esto lo hace por medio de una formula :
     * fin = (inicio + count) % tam;
     */
    private void CalcularNuevaPosicionFin() {
        fin = (inicio + count) % tam;
    }

    /**
     * El metodo calcularNuevaPosicionInicio calcula la nueva posicion en la que
     * sera ingresado el proximo dato esto lo hace por medio de una formula :
     * inicio = (inicio + 1) % tam;
     */
    private void CalcularNuevaPosicionInicio() {
        inicio = (inicio + 1) % tam;
    }

    /**
     * El metodo enqueue encola o agrega datos al final de la cola. Si la cola
     * esta llena, llama al metodo resize, si no, simplemente ubica el dato en
     * el arreglo y aumenta el contador
     *
     * @param item es el dato que se encola 
     */
    public void enqueue(Item item) {  //adicionar o encolar xd     

        if (count == a.length) {
            inicio = 0;
            fin = count - 1;
            resize(a.length * 2);
        }
        if (fin < inicio && count == a.length) {
            resize(a.length * 2);
        } else {
            CalcularNuevaPosicionFin();
        }
        a[fin] = item;
        count++;
    }

    /**
     * El metodo dequeue desencola o quita los datos del principio de la cola.
     * Si la cantidad de datos es menor o igual a la cuarta parte del arreglo,
     * se llamara al metodo resize para que divia el arreglo en 2 de no ser asi
     * solo se quitara el dato del arreglo, se llamara al metodo
     * CalcularNuevaPosicionInicio(); y se reducira le contador
     *
     * @return a[inicio] es el dato que quitara al inicio del arreglo
     */
    public Item dequeue() {
        if (!isEmpty()) {
            Item atemp = a[inicio];
            a[inicio] = null;
            if (count <= a.length / 4 && count > 0) {
                resize(a.length / 2);
            }
            CalcularNuevaPosicionInicio();
            count--;
            return atemp;
        }
        return a[inicio];
    }

    /**
     * El metodo resize se encarga de hacer crecer el arreglo cuando este lo
     * requiera en este metodo se utiliza un arreglo temporal del doble del
     * arreglo orginal en este arreglo se copian los datos del orginal y despues
     * se iguala el arreglo original con el temporal
     *
     * @param maxCap la capacidad maxima que obtendra el nuevo arreglo
     */
    public void resize(int maxCap) {
        Item temporal[] = (Item[]) new Object[maxCap];
        int i = 0;
        for (int k = inicio; k <= fin; k++) {
            temporal[i++] = a[k % tam];
        }
        tam = maxCap;
        inicio = 0;
        fin = count - 1;
        a = temporal;
    }

    /**
     * Recorre el arreglo a y todos sus datos los imprimi con un espacio de por medio en la salida.
     * Recorre el ciclo for que agrega el elemento actual al arrglo de la salida
     * con el operador += imprimira cada uno de estos datos
     * @return salida la impresion que se vera al final con sus valores 
     */
    public String imprimir() {
        String salida = " ";
        for (int i = 0; i < a.length; i++) {
            salida += a;

        }
        return salida;
    }

    /**
     * El iterador sera el encargado de procesar los datos.
     *
     * @return ArrayIterator itera sobre los elementos de la lista desde el
     * primer hasta el ultimo elemento.
     */
    @Override
    public Iterator<Item> iterator() {

        return new ArrayIterator();

    }

    private class ArrayIterator implements Iterator<Item> {

        int c = count;
        int i = 0;

        public boolean hasNext() {
            return i < c;
        }

        public Item next() {
            Item temp = a[(i + inicio) % a.length];
            i++;
            return temp;
        }

    }

}
