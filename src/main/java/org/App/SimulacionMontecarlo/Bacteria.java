package org.App.SimulacionMontecarlo;

import java.util.Random;

public class Bacteria {

    public int comidaConsumida;
    public boolean viva;
    public boolean moverse;

    public Bacteria() {
        this.comidaConsumida = 0;
    }

    public void comerYmoverse(Celda celda) {
        Random rand = new Random();
        int destino = rand.nextInt(100);

        if (celda.Comida >= 100) {
            celda.Comida -= 20;
            this.comidaConsumida += 20;
            if (destino < 3) {
                this.viva = false;
            } else if (destino >= 60) {
                this.moverse = true;
            }
        } else if (celda.Comida >= 10) {
            celda.Comida -= 10;
            this.comidaConsumida += 10;

            if (destino < 6) {
                this.viva = false;
            } else if (destino > 20) {
                this.moverse = true;
            }
        } else {
            if (destino < 20) {
                this.viva = false;
            } else if (destino > 60) {
                this.moverse = true;
            }
        }
    }
}
