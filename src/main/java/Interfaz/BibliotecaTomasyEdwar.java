package Interfaz;

import patrones.observador.*;
import patrones.decorador.*;
import adts.ColaReTopcopianew;
import patrones.DAO.*;
import patrones.singleton.*;

import Socio.Socio;
import Vip.Vip;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class BibliotecaTomasyEdwar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Patron Observador
        BibliotecaObservador biblioteca = new BibliotecaObservador();

        //Patron decorador
        IdecoradorSocio deSocio = new NotificarSocioCorreo();
        IdecoradorVip deVip = new NotificarVipCelular();

        IdecoradorSocio InformacionSocio = new InformacionSocioDecorador(deSocio);
        IdecoradorVip InformacionVip = new InformacionVipDecorador(deVip);

        //Patron Singleton 
        Libreria libreria = Libreria.getInstancia();

        ColaReTopcopianew<Socio> datosSocios = new ColaReTopcopianew<>();
        ColaReTopcopianew<Vip> datosVip = new ColaReTopcopianew<>();

        List<Libro> libros = new ArrayList<>();
        LibrosDAO libroDAO = new LibroDAOImpl();

        String nombre = "";
        String libro = "";
        String revista = "";
        int prestamo;
        int id = 0;

        while (true) {
            System.out.println("__________BIENVENIDO A LA BIBLIOTECA__________");
            System.out.println("1. Registrar un nuevo socio");
            System.out.println("2. Registar un nuevo vip");
            System.out.println("3. Eliminar a un socio");
            System.out.println("4. Eliminar a un Vip");
            System.out.println("5. Ver socios");
            System.out.println("6. Ver VIP");
            System.out.println("7. Solicitar un libro");
            System.out.println("8. Solicitar una revista");
            System.out.println("");
            System.out.println("");
            System.out.println("9. Ingresar un libro");
            System.out.println("10. Modificar un libro");
            System.out.println("11. Eliminar un libro");
            System.out.println("12. Listar todos los libros");
            System.out.println("");
            System.out.println("13. Verificar disponibilidad del libro");
            System.out.println("14. Salir");
            int Opcion = in.nextInt();
            in.nextLine();

            switch (Opcion) {
                case 1:
                    System.out.println("Ingrese el nombre para el nuevo socio");
                    nombre = in.nextLine();
                    System.out.println("Ingrese su numero de identificacion: ");
                    id = in.nextInt();
                    Socio sañadir = new Socio(nombre, libro, id);
                    datosSocios.enqueue(sañadir);
                    biblioteca.agregarReceptor(sañadir);
                    sañadir.añadirUsuario(nombre, id);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre para el nuevo Vip");
                    nombre = in.nextLine();
                    System.out.println("Ingrese su numero de identificacion: ");
                    id = in.nextInt();
                    Vip vañadir = new Vip(nombre, revista, id);
                    datosVip.enqueue(vañadir);
                    biblioteca.agregarReceptor(vañadir);
                    vañadir.añadirUsuario(nombre, id);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre para el socio que desea eliminar:");
                    nombre = in.nextLine();
                    Socio socioAEliminar = null;
                    for (Socio socio : datosSocios) {
                        if (socio.getNombre().equals(nombre)) {
                            socioAEliminar = socio;
                            break;
                        }
                    }
                    if (socioAEliminar != null) {
                        datosSocios.dequeue();
                        biblioteca.eliminarReceptor(socioAEliminar);
                        socioAEliminar.eliminarUsuario(nombre);
                    } else {
                        System.out.println("El socio no se encuentra registrado.");
                    }

                    break;
                case 4:

                    System.out.print("Ingrese el nombre para el vip que desea eliminar:");
                    nombre = in.nextLine();
                    Vip vipAEliminar = null;
                    for (Vip socio : datosVip) {
                        if (socio.getNombre().equals(nombre)) {
                            vipAEliminar = socio;
                            break;
                        }
                    }

                    if (vipAEliminar != null) {
                        datosVip.dequeue();
                        biblioteca.eliminarReceptor(vipAEliminar);
                        vipAEliminar.eliminarUsuario(nombre);
                    } else {
                        System.out.println("El Vip no se encuentra registrado.");
                    }
                    break;
                case 5:
                    if (!datosSocios.isEmpty()) {
                        System.out.println("Los socios registrados son: ");
                        for (Socio x : datosSocios) {
                            System.out.println(x.toString());
                        }
                    } else {
                        System.out.println("No hay Socios registrados");
                    }

                    break;
                case 6:
                    if (!datosVip.isEmpty()) {
                        System.out.println("los vip registrados son: ");
                        for (Vip z : datosVip) {
                            System.out.println(z.toString());
                        }
                    } else {
                        System.out.println("No hay vip registrados");
                    }

                    break;
                case 7:
                    System.out.println("Cual es el nombre del socio: ");
                    nombre = in.nextLine();

                    if (biblioteca.comprobarSocio(nombre)) {
                        System.out.println("Cual es el libro que lleva el socio " + nombre + ":");
                        libro = in.nextLine();

                        Socio sverlibro = new Socio(nombre, libro, id);
                        biblioteca.agregarReceptor(sverlibro);

                        System.out.println("Cuantos libros lleva prestados: ");
                        prestamo = in.nextInt();
                        in.nextLine();

                        if (prestamo < 6) {
                            if (biblioteca.comprobarLibro(libro)) {
                                sverlibro.recibirLibro(libro, nombre);
                                biblioteca.verRecibirLibro(libro);

                                InformacionSocio.notificarLibro(sverlibro);
                            } else {
                                System.out.println("La revista no se encuentra por el momento");
                            }
                        } else {
                            System.out.println("No se le pueden prestar mas libros ya que alcanzo su capacidad");
                        }
                    } else {
                        System.out.println(nombre + " no es socio");
                        System.exit(0);
                    }
                    biblioteca.listarLibrosRegistrados();
                    break;
                case 8:
                    System.out.println("Cual es el nombre del vip: ");
                    nombre = in.nextLine();

                    if (biblioteca.comprobarVip(nombre)) {

                        System.out.println("Cual es la revista que lleva el vip " + nombre + ":");
                        revista = in.nextLine();

                        Vip vVerRevista = new Vip(nombre, revista, id);
                        biblioteca.agregarReceptor(vVerRevista);

                        System.out.println("Cuantas revistas lleva prestados: ");
                        prestamo = in.nextInt();
                        in.nextLine();

                        if (prestamo < 12) {
                            if (biblioteca.comprobarEstadoRevista(revista)) {
                                vVerRevista.recibirLibro(revista, nombre);
                                biblioteca.verRecibirRevista(revista);

                                InformacionVip.notificarRevista(vVerRevista);
                            } else {
                                System.out.println("La revista no se encuentra por el momento");
                            }
                        } else {
                            System.out.println("No se le pueden prestar mas revistas ya que alcanzo su capacidad");
                        }
                    } else {
                        System.out.println(nombre + " no es vip");
                        System.exit(0);
                    }

                    break;
                case 9:
                    System.out.println("id del libro: ");
                    int idlib = in.nextInt();
                    in.nextLine(); // Consumir el salto de línea después de leer el ID

                    System.out.println("Ingrese el título del libro: ");
                    String titulo = in.nextLine();

                    Libro libroNuevo = new Libro(idlib, titulo);
                    libroDAO.agregarLibro(libroNuevo);
                    System.out.println("El libro se ha ingresado correctamente.");
                    break;
                case 10:
                    System.out.println("Ingrese el ID del libro a modificar: ");
                    idlib = in.nextInt();
                    in.nextLine();

                    Libro libroModificar = null;
                    in.nextLine();
                    List<Libro> listaLibros = libroDAO.obtenerTodosLosLibros();

                    for (int i = 0; i < listaLibros.size(); i++) {
                        if (listaLibros.get(i).getId() == idlib) {
                            libroModificar = listaLibros.get(i);
                            break;
                        }
                    }
                    if (libroModificar != null) {
                        System.out.println("Ingrese el nuevo título del libro: ");
                        String nuevoTitulo = in.nextLine();
                        libroModificar.setTitulo(nuevoTitulo);
                        libroDAO.modificarLibro(libroModificar);
                        System.out.println("El libro se ha modificado correctamente.");
                    } else {
                        System.out.println("No se encontró un libro con el ID especificado.");
                    }
                    break;
                case 11:
                    System.out.println("Ingrese el ID del libro a eliminar: ");
                    idlib = in.nextInt();
                    in.nextLine(); // Consumir el salto de línea

                    Libro libroEliminar = null;
                    List<Libro> listaLibrosEliminar = libroDAO.obtenerTodosLosLibros();
                    for (int i = 0; i < listaLibrosEliminar.size(); i++) {
                        if (listaLibrosEliminar.get(i).getId() == idlib) {
                            libroEliminar = listaLibrosEliminar.get(i);
                            break;
                        }
                    }

                    if (libroEliminar != null) {
                        libroDAO.eliminarLibro(libroEliminar);
                        System.out.println("El libro se ha eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un libro con el ID especificado.");
                    }
                    break;
                case 12:
                    List<Libro> TotalLibros = libroDAO.obtenerTodosLosLibros();
                    int cantidadLibros = TotalLibros.size();
                    if (cantidadLibros == 0) {
                        System.out.println("No hay libros registrados.");
                    } else {
                        System.out.println("cantidad de libros: " + cantidadLibros);
                        System.out.println("Lista de todos los libros");
                        for (int i = 0; i < TotalLibros.size(); i++) {
                            Libro libr = TotalLibros.get(i);
                            System.out.println(libr);
                        }
                    }
                    break;
                case 13:
                    System.out.println("Ingrese el nombre del libro que desea ver si esta disponible: ");
                    String disBus = in.nextLine();

                    List<Libro> todosLosLibros = libroDAO.obtenerTodosLosLibros();

                    for (Libro la : todosLosLibros) {
                        if (la.getTitulo().equals(disBus)) {
                            boolean disponible = Libreria.getInstancia().comprobarDisponibilidadLibro(la.getTitulo());

                            if (disponible) {
                                System.out.println("El libro '" + la.getTitulo() + "' está disponible.");
                            } else {
                                System.out.println("El libro '" + la.getTitulo() + "' no está disponible.");
                            }
                        }
                    }
                    break;
                case 14:
                    System.out.println("Usted a salido de la biblioteca");
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opcion que ingreso no es valida");
                    break;
            }
        }
    }
}
/*
 System.out.println("Usted a salido de la biblioteca");
                    System.exit(0);
 */
