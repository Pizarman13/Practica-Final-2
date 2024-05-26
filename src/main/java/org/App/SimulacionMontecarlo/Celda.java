package org.App.SimulacionMontecarlo;

import java.util.LinkedList;

public class Celda {


    public int Comida;
    public LinkedList<Bacteria> bacterias;
    public int futurasBacterias;

    public Celda() {
        this.Comida = 0;
        this.bacterias = new LinkedList<Bacteria>();
        this.futurasBacterias = 0;
    }
}
