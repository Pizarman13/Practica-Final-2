package org.App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.App.CultivoBacterias.*;
import org.App.SimulacionMontecarlo.*;
import java.util.LinkedList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // menu
        while(true) {
            System.out.println("1. Abrir un archivo que contenga un experimento");
            System.out.println("2. Crear un nuevo experimento");
            System.out.println("0. Salir");


            System.out.print("Ingrese una opcion: ");

                String opcion = sc.nextLine();

                switch(opcion) {
                    case "1":
                        System.out.println("Introduzca el nombre del archivo que desea abrir: ");
                        String nombreArchivo = sc.nextLine();
                        Experimento experimento = Experimento.cargarExperimento(nombreArchivo);
                        abrirExperimento(experimento);
                        break;
                    case "2":
                        System.out.println("Introduzca el nombre del experimento que desea crear: ");
                        String nombreArchivoEx = sc.nextLine();
                        Experimento nuevoExperimento = new Experimento(147, new PoblacionBacterias[0], 30);
                        abrirExperimento(nuevoExperimento);
                        break;
                    case "0":
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

        }
    }

    public static void abrirExperimento(Experimento experimento) {

        boolean s = true;
        while(s) {
            System.out.println("1. Crecimiento y decrecimiento lineal de la comida");
            System.out.println("2. Comida constante para todos los días");
            System.out.println("3. Comida creciente para todos los días");
            System.out.println("4. Comida constante para los dias impares");
            System.out.println("Escoja el metodo de implementacion de la comida: ");

            String opcion = sc.nextLine();
            switch(opcion) {
                case "1":
                    System.out.println("Escoja el dia a partir del cual dejara de incrementarse la comida y empezara a disminuir: ");
                    int dia = sc.nextInt();
                    experimento.crecimientoDecrecimientoComida(dia, experimento.getDuracionExperimento());
                    s = false;
                    break;
                case "2":
                    experimento.comidaConstante(4000);
                    s = false;
                    break;
                case "3":
                    experimento.comidaCreciente();
                    s = false;
                    break;
                case "4":
                    experimento.comidaImpar(7000);
                    s = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }

       while(true) {
            System.out.println("1. Crear una nueva población de bacterias y  añadirla a este experimento");
            System.out.println("2. Borrar una población de bacterias de este experimento");
            System.out.println("3. Visalizar los nombres de las poblaciones de bacterias de este experimento");
            System.out.println("4. Ver informacion detallada de una población de bacterias de este experimento");
            System.out.println("5. Guardar el experimento");
            System.out.println("6. Guardar el experimento como");
            System.out.println("7. Ver la cantidad de comida para cada día del experimento");
            System.out.println("8. Simulacion de Montecarlo");
            System.out.println("9. Salir");

            System.out.print("Ingrese una opcion: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Introduzca el nombre de la población de bacterias: ");
                    String nombrePoblacion = sc.nextLine();
                    System.out.println("Introduzca la fecha de inicio de la población de bacterias (formato fecha aaaa-mm-dd): ");
                    String fechaInicial = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate fechaInicio = LocalDate.parse(fechaInicial, formatter);
                    System.out.println("Introduzca el número inicial de bacterias: ");
                    int numInicialBacterias = sc.nextInt();
                    System.out.println("Introduzca la temperatura: ");
                    double temperatura = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduzca la luminosidad: ");
                    System.out.println("1. Alta");
                    System.out.println("2. Media");
                    System.out.println("3. Baja");
                    String num = sc.nextLine();
                    PoblacionBacterias.Luminosidad luminosidad;
                    switch (num) {
                        case "1":
                            luminosidad = PoblacionBacterias.Luminosidad.Alta;
                            break;
                        case "2":
                            luminosidad = PoblacionBacterias.Luminosidad.Media;
                            break;
                        case "3":
                            luminosidad = PoblacionBacterias.Luminosidad.Baja;
                            break;
                        default:
                            System.out.println("Luminosidad no válida, por defecto se le dara el valor de Media");
                            luminosidad = PoblacionBacterias.Luminosidad.Media;
                            break;
                    }
                    experimento.anadirPoblacionBacterias(new PoblacionBacterias(nombrePoblacion, fechaInicio, numInicialBacterias, temperatura, luminosidad));
                    break;
                case "2":
                    System.out.println("Introduzca el nombre de la población de bacterias que desea borrar: ");
                    String nombrePoblacionBorrar = sc.nextLine();
                    experimento.borrarPoblacionBacterias(nombrePoblacionBorrar);
                    break;
                case "3":
                    boolean exit = true;
                    while (exit) {
                        System.out.println("1. Ordenados por fecha de inicio");
                        System.out.println("2. Ordenados por nombre");
                        System.out.println("3. Ordenados por número inicial de bacterias");
                        System.out.println("Escoja el criterio de ordenamiento: ");
                        String criterio = sc.nextLine();

                        switch (criterio) {
                            case "1":
                                experimento.ordenarPoblacionesPorFechaInicio();
                                exit = false;
                                break;
                            case "2":
                                experimento.ordenarPoblacionesPorNombre();
                                exit = false;
                                break;
                            case "3":
                                experimento.ordenarPoblacionesPorNumInicialBacterias();
                                exit = false;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }

                    System.out.println("Nombres de las poblaciones de bacterias de este experimento: ");
                    experimento.visualizarNombresPoblaciones();
                    break;
                case "4":
                    System.out.println("Introduzca el nombre de la población de bacterias de la que desea ver información detallada: ");
                    String nombrePoblacionDetalles = sc.nextLine();
                    experimento.verDetallesPoblacion(nombrePoblacionDetalles);
                    break;
                case "5":
                    experimento.guardarExperimento();
                    break;
                case "6":
                    System.out.println("Introduzca el nombre del archivo en el que desea guardar el experimento \n(recomiendo que nombre su archivo con experimetos/... para que su archivo se guarde en la carpeta experimentos): ");
                    String nombreArchivoGuardar = sc.nextLine();
                    experimento.guardarExperimentoComo(nombreArchivoGuardar);
                    break;
                case "7":
                    experimento.visualizarComida();
                    break;
                case "8":

                    System.out.println("Introduzca el número de bacterias que desea en el plato de cultivo: ");
                    int numBacterias = sc.nextInt();
                    System.out.println("Introduzca el número de días que desea simular: ");
                    int numDias = sc.nextInt();
                    System.out.println("Introduzca la cantidad de comida inicial: ");
                    int comidaInicial = sc.nextInt();

                    PlatoCultivo plato = new PlatoCultivo(numBacterias);
                    for (int i = 0; i < numDias; i++) {
                        plato.simularDia(comidaInicial);
                    }

                    // Visualizar la cantidad de bacterias y comida en cada celda
                    for (int i = 0; i < plato.celdas.length; i++) {
                        for (int j = 0; j < plato.celdas[i].length; j++) {
                            System.out.print(" Celda [" + i + "][" + j + "]: ");
                            System.out.print(" Comida: " + plato.celdas[i][j].Comida);
                            System.out.print(" Bacterias: " + plato.celdas[i][j].bacterias.size());
                        }
                        System.out.println();
                    }

                    System.out.println("Simulación terminada");

                    break;
                case "9":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

    }

}