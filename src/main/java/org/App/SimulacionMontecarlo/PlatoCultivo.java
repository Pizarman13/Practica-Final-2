package org.App.SimulacionMontecarlo;

import java.util.Random;

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

    public void simularDia() {
        for (int z = 1; z <= 10; z++) {
            for (int i = 0; i < this.celdas.length; i++) {
                for (int j = 0; j < this.celdas[i].length; j++) {
                    Celda celda = this.celdas[i][j];
                    for (Bacteria bacteria: celda.bacterias) {
                        bacteria.comerYmoverse(celda);
                        if (bacteria.viva && bacteria.moverse) {
                            moverBacteria(i, j, bacteria);
                        }
                    }
                }
            }
        }

    }

    public void moverBacteria(int i, int j, Bacteria bc) {
        int[][] movimientos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] movimiento = movimientos[new Random().nextInt(movimientos.length)]; // selecciona un movimiento aleatorio

        int nuevoI = i + movimiento[0];
        int nuevoJ = j + movimiento[1];

        // Verifica si la nueva posicion enta dentro del plato de cultivo
        if (nuevoI >= 0 && nuevoI < this.celdas.length && nuevoJ >= 0 && nuevoJ < this.celdas[nuevoI].length) {
            return;
        }

        // Mueve la bacteria a la nueva posicion
        this.celdas[nuevoI][nuevoJ].bacterias.add(bc);
        this.celdas[i][j].bacterias.remove(bc);
    }
}
