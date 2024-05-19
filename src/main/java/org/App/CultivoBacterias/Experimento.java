package org.App.CultivoBacterias;

import java.io.*;

public class Experimento implements Serializable{

    int idExperimento;
    int maxComida = 300000;
    int[] cantidadComida;
    PoblacionBacterias[] poblacionBacteriana;
    String nombreArchivo;
    int duracionExperimento;

    public Experimento(int idExperimento, PoblacionBacterias[] poblacionBacteriana, int duracionExperimento) {
        this.idExperimento = idExperimento;
        this.poblacionBacteriana = poblacionBacteriana;
        this.duracionExperimento = duracionExperimento;
        this.cantidadComida = new int[duracionExperimento];
    }

    public int getDuracionExperimento() {
        return duracionExperimento;
    }

    public void crecimientoDecrecimientoComida(int dia, int duracionExperimento) {
        if (dia > 1 && dia < duracionExperimento) {

            for (int i = 0; i < dia; i++) {
                cantidadComida[i] = i*6 + 4000;

                if (cantidadComida[i] > maxComida) {
                    cantidadComida[i] = maxComida;
                }
            }

            for (int i = dia; i < cantidadComida.length; i++) {
                cantidadComida[i] = i*6 - 1000;

                if (cantidadComida[i] < 0) {
                    cantidadComida[i] = 0;
                }
            }

        }
    }

    public void comidaConstante(int cantidad) {
        for (int i = 0; i < cantidadComida.length; i++) {
            cantidadComida[i] = cantidad;

            if (cantidadComida[i] > maxComida) {
                cantidadComida[i] = maxComida;
            }
        }
    }

    public void comidaCreciente() {
        for (int i = 0; i < cantidadComida.length; i++) {
            cantidadComida[i] = i*4 + 3000;

            if (cantidadComida[i] > maxComida) {
                cantidadComida[i] = maxComida;
            }
        }
    }

    public void comidaImpar(int cantidad) {
        for (int i = 0; i < cantidadComida.length; i++) {
            if (i % 2 != 0) {
                cantidadComida[i] = cantidad;
            }
        }
    }

    public void visualizarComida() {
        for (int i = 0; i < cantidadComida.length; i++) {
            System.out.println("Dia " + (i+1) + ": " + cantidadComida[i]);
        }
    }

    public void anadirPoblacionBacterias(PoblacionBacterias poblacionBacterias) {
        PoblacionBacterias[] poblacionBacteriasAux = new PoblacionBacterias[poblacionBacteriana.length + 1];

        for (int i = 0; i < poblacionBacteriana.length; i++) {
            poblacionBacteriasAux[i] = poblacionBacteriana[i];
        }

        poblacionBacteriasAux[poblacionBacteriana.length] = poblacionBacterias;
        poblacionBacteriana = poblacionBacteriasAux;

    }

    public void borrarPoblacionBacterias(String nombrePoblacion) {

        for (int i = 0; i < poblacionBacteriana.length; i++) {
            if (poblacionBacteriana[i].nombre.equals(nombrePoblacion)) {
                PoblacionBacterias[] poblacionBacteriasAux = new PoblacionBacterias[poblacionBacteriana.length - 1];
                int j = 0;
                for (int k = 0; k < poblacionBacteriana.length; k++) {
                    if (k != i) {
                        poblacionBacteriasAux[j] = poblacionBacteriana[k];
                        j++;
                    }
                }
                poblacionBacteriana = poblacionBacteriasAux;
            } else {
                System.out.println("No se encontró la población de bacterias con el nombre " + nombrePoblacion);
            }
        }
    }

    public void ordenarPoblacionesPorFechaInicio() {
        for (int i = 0; i < poblacionBacteriana.length - 1; i++) {
            for (int j = 0; j < poblacionBacteriana.length - i - 1; j++) {
                if (poblacionBacteriana[j].fechaInicio.isAfter(poblacionBacteriana[j + 1].fechaInicio)) {
                    PoblacionBacterias aux = poblacionBacteriana[j];
                    poblacionBacteriana[j] = poblacionBacteriana[j + 1];
                    poblacionBacteriana[j + 1] = aux;
                }
            }
        }
    }

    public void ordenarPoblacionesPorNombre() {
        for (int i = 0; i < poblacionBacteriana.length - 1; i++) {
            for (int j = 0; j < poblacionBacteriana.length - i - 1; j++) {
                if (poblacionBacteriana[j].nombre.compareTo(poblacionBacteriana[j + 1].nombre) > 0) {
                    PoblacionBacterias aux = poblacionBacteriana[j];
                    poblacionBacteriana[j] = poblacionBacteriana[j + 1];
                    poblacionBacteriana[j + 1] = aux;
                }
            }
        }
    }

    public void ordenarPoblacionesPorNumInicialBacterias() {
        for (int i = 0; i < poblacionBacteriana.length - 1; i++) {
            for (int j = 0; j < poblacionBacteriana.length - i - 1; j++) {
                if (poblacionBacteriana[j].numInicialBacterias > poblacionBacteriana[j + 1].numInicialBacterias) {
                    PoblacionBacterias aux = poblacionBacteriana[j];
                    poblacionBacteriana[j] = poblacionBacteriana[j + 1];
                    poblacionBacteriana[j + 1] = aux;
                }
            }
        }
    }
    public void visualizarNombresPoblaciones() {
        for (int i = 0; i < poblacionBacteriana.length; i++) {
            System.out.println(poblacionBacteriana[i].nombre);
        }
    }


    public void verDetallesPoblacion(String nombrePoblacion) {
        for (int i = 0; i < poblacionBacteriana.length; i++) {
            if (poblacionBacteriana[i].nombre.equals(nombrePoblacion)) {
                System.out.println("Nombre: " + poblacionBacteriana[i].nombre);
                System.out.println("Fecha de inicio: " + poblacionBacteriana[i].fechaInicio);
                System.out.println("Número inicial de bacterias: " + poblacionBacteriana[i].numInicialBacterias);
                System.out.println("Temperatura: " + poblacionBacteriana[i].temperatura);
                System.out.println("Luminosidad: " + poblacionBacteriana[i].luminosidad);
                System.out.println("Fecha de fin: " + poblacionBacteriana[i].fechaFin);
            } else {
                System.out.println("No se encontró la población de bacterias con el nombre " + nombrePoblacion);
            }
        }
    }

    // Manejo archivos
    public void guardarExperimento() {
        if (nombreArchivo == null) {
            System.out.println("El nombre del archivo no puede ser nulo");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.nombreArchivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarExperimentoComo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        guardarExperimento();
    }

    public static Experimento cargarExperimento(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Experimento) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
