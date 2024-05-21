package org.App.SimulacionMontecarlo;

public class PlatoCultivo {
    public Celda[][] celdas = new Celda[20][20];

    public PlatoCultivo() {
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }
}
