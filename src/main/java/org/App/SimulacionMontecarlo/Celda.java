package org.App.SimulacionMontecarlo;

public class Celda {

    public int nBacterias;
    public int Comida;
    public Bacteria[] bacterias;

    public Celda() {
        this.Comida = 0;
        this.nBacterias = 0;
        this.bacterias = new Bacteria[0];
    }

    public int getnBacterias() {
        return bacterias.length;
    }
}
