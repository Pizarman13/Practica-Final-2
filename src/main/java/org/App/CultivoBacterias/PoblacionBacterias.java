package org.App.CultivoBacterias;

import java.util.*;
import java.time.LocalDate;

public class PoblacionBacterias {

    public enum Luminosidad {
        Alta, Media, Baja
    }

    String nombre;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    int numInicialBacterias;
    double temperatura;
    Luminosidad luminosidad;

    public PoblacionBacterias(String nombre, LocalDate fechaInicio, int numInicialBacterias, double temperatura, Luminosidad luminosidad) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.numInicialBacterias = numInicialBacterias;
        this.temperatura = temperatura;
        this.luminosidad = luminosidad;
        this.fechaFin = fechaInicio.plusDays(30);
    }

}
