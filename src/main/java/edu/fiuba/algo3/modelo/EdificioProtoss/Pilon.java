package edu.fiuba.algo3.modelo.EdificioProtoss;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Mapa.Casilla.*;
import edu.fiuba.algo3.modelo.States.EstadoPilon;
import edu.fiuba.algo3.modelo.States.EstadoPilonEnConstruccion;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Pilon extends Edificio {

    private EstadoPilon estado;
    private int turnoParaEstarConstruido = 5;
    private int valorVital = 300;


    public Pilon(){
        this.costoGas = 0;
        this.costoMineral = 100;
        this.estadoRecolectable = new NoRecolectable();
        this.estadoMoho = new SinMoho();
        //Aplicacion de patron State
        estado = new EstadoPilonEnConstruccion(turnoParaEstarConstruido);
        this.vida = new VidaConEscudo(valorVital, valorVital);
    }

    public void pasarTurno(){
        estado = estado.actualizar(coordenada);
        vida.pasarTurno();
    }
}
