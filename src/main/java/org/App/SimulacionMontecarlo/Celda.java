package org.App.SimulacionMontecarlo;

import java.util.LinkedList;

public class Celda {


    public int Comida;
    public LinkedList<Bacteria> bacterias = new LinkedList<Bacteria>();
    public int futurasBacterias;

    public Celda() {
        this.Comida = 0;
        this.bacterias = new LinkedList<Bacteria>();
        this.futurasBacterias = 0;
    }
}
