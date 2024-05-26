package org.App.SimulacionMontecarlo;

public class PlatoCultivo {
    public Celda[][] celdas = new Celda[20][20];

    public PlatoCultivo(int comidaInicial, int numBacterias){

        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = new Celda();
            }
        }

        int comidaXCelda = comidaInicial / 400;
        for (Celda[] fila : this.celdas) {
            for (Celda celda : fila) {
                celda.Comida += comidaXCelda;
            }
        }

        int inicio = this.celdas.length / 2 - 2;
        int bacteriaXCeldaInicial = numBacterias / 16;
        for (int i = inicio; i < inicio + 4; i++) {
            for (int j = inicio; j < inicio + 4; j++) {
                for (int k = 0; k < bacteriaXCeldaInicial; k++) {
                    celdas[i][j].bacterias.add(new Bacteria());
                }
            }
        }
    }
}
