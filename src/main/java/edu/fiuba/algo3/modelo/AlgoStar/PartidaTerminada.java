package edu.fiuba.algo3.modelo.AlgoStar;

public class PartidaTerminada implements Turno {

    private Jugador ganador;

    public PartidaTerminada(Jugador ganador) {
        this.ganador = ganador;
    }

    @Override
    public Turno terminarTurno() {
        return this;
    }

    @Override
    public boolean partidaTerminada() {
        return true;
    }

    @Override
    public Jugador jugadorActual() {
        return ganador;
    }
}
