package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Tablero.*;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeRecursoInsuficiente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CasoDeUso7Test {

    @Test
    public void UnZanganoExtraeMineralPor5TurnosYAlcanzaParaConsturirOtroNexoMineral() {
        Tablero tablero = new Tablero(2,2);
        tablero.establecerRecurso(new NodoMineral(), new Coordenadas(0,0));

        Zergs zergs = new Zergs(tablero, new Recurso(0), new Recurso(0));
        Zangano zangano = zergs.reclutarZangano(new Coordenadas(0,0));
        Zangano zanganoParaCriadero = zergs.reclutarZangano(new Coordenadas(1,1));

        zangano.extraerMineral();

        zangano.accionDeTurno();
        zangano.accionDeTurno();
        zangano.accionDeTurno();
        zangano.accionDeTurno();
        zangano.accionDeTurno();

        assertDoesNotThrow(() -> zergs.construirCriadero(zanganoParaCriadero, new Coordenadas(0,0)));
    }

    @Test
    public void UnZanganoExtraeMineralPor4TurnosYNoAlcanzaParaConstruirOtroNexoMineral() {
        Tablero tablero = new Tablero(2,2);
        tablero.establecerRecurso(new NodoMineral(), new Coordenadas(0,0));

        Zergs zergs = new Zergs(tablero, new Recurso(0), new Recurso(0));
        Zangano zangano = zergs.reclutarZangano(new Coordenadas(0,0));
        Zangano zanganoParaCriadero = zergs.reclutarZangano(new Coordenadas(1,1));

        zangano.extraerMineral();

        zangano.accionDeTurno();
        zangano.accionDeTurno();
        zangano.accionDeTurno();
        zangano.accionDeTurno();

        assertThrows(CantidadDeRecursoInsuficiente.class ,() -> zergs.construirCriadero(zanganoParaCriadero, new Coordenadas(1,1)));
    }

    @Test
    public void UnNexoMineralExtraeMineralPor5TurnosYAlcanzaParaConstruirOtroNexoMineral() {
        Tablero tablero = new Tablero(2, 2);
        tablero.establecerRecurso(new NodoMineral(), new Coordenadas(0,0));
        tablero.establecerTerreno(new Neutro(), new Coordenadas(0,0));
        tablero.establecerRecurso(new NodoMineral(), new Coordenadas(1, 1));
        tablero.establecerTerreno(new Neutro(), new Coordenadas(1,1));

        Protoss protoss = new Protoss(tablero ,new Recurso(50), new Recurso(0));
        Edificio nexoMineral = protoss.construirNexoMineral(new Coordenadas(0, 0));

        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();

        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();

        assertDoesNotThrow(() -> protoss.construirNexoMineral(new Coordenadas(1, 1)));
    }

    @Test
    public void UnNexoMineralExtraeMineralPor4TurnosYNoAlcanzaParaConstruirOtroNexoMineral() {
        Tablero tablero = new Tablero(2, 2);
        tablero.establecerRecurso(new NodoMineral(), new Coordenadas(0,0));
        tablero.establecerTerreno(new Neutro(), new Coordenadas(0,0));
        tablero.establecerRecurso(new NodoMineral(), new Coordenadas(1, 1));
        tablero.establecerTerreno(new Neutro(), new Coordenadas(1,1));

        Protoss protoss = new Protoss(tablero ,new Recurso(50), new Recurso(0));
        Edificio nexoMineral = protoss.construirNexoMineral(new Coordenadas(0, 0));

        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();
        nexoMineral.accionDeTurno();

        assertThrows(CantidadDeRecursoInsuficiente.class ,() -> protoss.construirNexoMineral(new Coordenadas(1, 1)));
    }
}
