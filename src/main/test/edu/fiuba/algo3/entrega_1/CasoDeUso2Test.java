package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Imperio.*;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Mapa.Casilla.*;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @BeforeEach
    public void setup(){
        Mapa.obtener().reiniciarMapa();
    }

    @Test
    public void test01UnCriaderoNoEstaConstruidoEn3Turnos() {
        Criadero unCriadero = new Criadero();

        for (int i = 0; i < 3; i++)
            unCriadero.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unCriadero.crearUnidad(new FabricaZangano()));
    }

    @Test
    public void test02UnCriaderoEstaConstruidoEn4Turnos() {
        Criadero unCriadero = new Criadero();

        for (int i = 0; i < 4; i++)
            unCriadero.pasarTurno();

        assertDoesNotThrow(() -> unCriadero.crearUnidad(new FabricaZangano()));
    }

    @Test
    public void test03UnExtractorNoEstaConstruidoEn5Turnos() {
        Recurso gasDelImperio = new Recurso(0);
        Extractor unExtractor = new Extractor(gasDelImperio);

        for (int i = 0; i < 5; i++)
            unExtractor.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unExtractor.contratarZangano(new Zangano()));
    }

    @Test
    public void test04UnExtractorEstaConstruidoEn6Turnos() {
        Mapa mapa = Mapa.obtener();
        Zerg zerg = new Zerg();
        Coordenada coordenadasGas = new Coordenada(0,0);

        mapa.colocarMaterial(new GasRecolectable(), coordenadasGas);
        zerg.abastecerDeRecursos(new Recurso(150), new Recurso(0));
        zerg.construirCriadero(new Coordenada(1,1));

        for (int i = 0; i < 5; i++)
            zerg.terminarTurno();

        zerg.construirExtractor(coordenadasGas);

        //Construimos el extractor
        for (int i = 0; i < 6; i++)
            zerg.terminarTurno();

        Edificio extractor = zerg.conseguirEdificio(coordenadasGas);
        assertDoesNotThrow( () -> extractor.contratarUnidad(new Zangano()));
    }

    @Test
    public void test05UnaReservaDeReproduccionNoEstaConstruidaEn11Turnos(){
        ReservaDeReproduccion unaReserva = new ReservaDeReproduccion();

        for(int i = 0; i < 11; i++)
            unaReserva.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unaReserva.crearFabricaZerling());
    }

     @Test
     public void test06UnaReservaDeReproduccionEstaConstruidaEn12Turnos() {
        ReservaDeReproduccion unaReserva = new ReservaDeReproduccion();

        for (int i = 0; i < 12; i++)
            unaReserva.pasarTurno();

        assertDoesNotThrow(() -> unaReserva.crearFabricaZerling());
     }

    @Test
    public void test07UnaGuaridaNoEstaConstruidaEn11Turnos(){
        Guarida unaGuarida = new Guarida();

        for(int i = 0; i < 11; i++)
            unaGuarida.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unaGuarida.crearFabricaHidralisco());
    }

    @Test
    public void test08UnaGuaridaEstaConstruidaEn12Turnos() {
        Guarida unaGuarida = new Guarida();

        for (int i = 0; i < 12; i++)
            unaGuarida.pasarTurno();

        assertDoesNotThrow(() -> unaGuarida.crearFabricaHidralisco());
    }

    @Test
    public void test09UnEspiralNoEstaConstruidoEn9Turnos() {
        Espiral unEspiral = new Espiral();

        for (int i = 0; i < 9; i++)
            unEspiral.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unEspiral.crearFabricaMutalisco());
    }

    @Test
    public void test10UnEspiralEstaConstruidoEn10Turnos() {
        Espiral unEspiral = new Espiral();

        for (int i = 0; i < 10; i++)
            unEspiral.pasarTurno();

        assertDoesNotThrow(() -> unEspiral.crearFabricaMutalisco());
    }

    @Test
    public void test11UnNexoMineralNoEstaConstruidoEn3Turnos() {
        Mapa mapa = Mapa.obtener();
        Protoss protoss = new Protoss();
        Coordenada coordenadasMIneral = new Coordenada(0,0);

        mapa.colocarMaterial(new MineralRecolectable(), coordenadasMIneral);
        protoss.abastecerDeRecursos(new Recurso(50), new Recurso(0));
        protoss.construirNexoMineral(coordenadasMIneral);

        for (int i = 0; i < 3; i++)
            protoss.terminarTurno();

        assertTrue(protoss.tienesEstaCantidadDeMineral(0));
    }

    @Test
    public void test12UnNexoMineralEstaConstruidoEn4Turnos() {
        Mapa mapa = Mapa.obtener();
        Protoss protoss = new Protoss();
        Coordenada coordenadaMineral = new Coordenada(0,0);

        mapa.colocarMaterial(new MineralRecolectable(), coordenadaMineral);
        protoss.abastecerDeRecursos(new Recurso(50), new Recurso(0));
        protoss.construirNexoMineral(coordenadaMineral);

        for (int i = 0; i < 4; i++)
            protoss.terminarTurno();

        assertTrue(protoss.tienesEstaCantidadDeMineral(10));
    }

    @Test
    public void test13UnPilonNoEstaConstruidoEn4TUrnos() {
        Mapa elmapa = Mapa.obtener();
        Pilon unpilon = new Pilon();
        Acceso unAcceso = new Acceso();
        Coordenada coordenadasPilon = new Coordenada(2,2);
        Coordenada coordenadaAcceso = new Coordenada(2,3);

        elmapa.construirEdificio(unpilon, coordenadasPilon);

        for (int i = 0; i < 4; i++)
            unpilon.pasarTurno();

        assertThrows(ErrorEdificioNoSePuedeConstruirEnEstaCasilla.class,
                () -> elmapa.construirEdificio(unAcceso, coordenadaAcceso));
    }

    @Test
    public void test14UnPilonEstaConstruidoEn5TUrnos() {
        Mapa elmapa = Mapa.obtener();
        Pilon unpilon = new Pilon();
        Acceso unAcceso = new Acceso();
        Coordenada coordenadasPilon = new Coordenada(2,2);
        Coordenada coordenadaAcceso = new Coordenada(2,3);

        elmapa.construirEdificio(unpilon, coordenadasPilon);

        for (int i = 0; i < 5; i++)
            unpilon.pasarTurno();

        assertDoesNotThrow(() -> elmapa.construirEdificio(unAcceso, coordenadaAcceso));
    }

    @Test
    public void test15UnAsimiladorNoEstaConstruidoEn5Turnos() {
        Mapa mapa = Mapa.obtener();
        Protoss protoss = new Protoss();
        Coordenada coordenadasGas = new Coordenada(0,0);

        mapa.colocarMaterial(new GasRecolectable(), coordenadasGas);
        protoss.abastecerDeRecursos(new Recurso(100), new Recurso(0));
        protoss.construirAsimilador(coordenadasGas);

        for (int i = 0; i < 5; i++)
            protoss.terminarTurno();

        assertTrue(protoss.tienesEstaCantidadDeMineral(0));
    }

    @Test
    public void test16UnAsimiladorEstaConstruidoEn6Turnos() {
        Mapa mapa = Mapa.obtener();
        Protoss protoss = new Protoss();
        Coordenada coordenadasGas = new Coordenada(0,0);

        mapa.colocarMaterial(new GasRecolectable(), coordenadasGas);
        protoss.abastecerDeRecursos(new Recurso(100), new Recurso(0));
        protoss.construirAsimilador(coordenadasGas);

        for (int i = 0; i < 6; i++)
            protoss.terminarTurno();

        assertTrue(protoss.tienesEstaCantidadDeGas(20));
    }

    @Test
    public void test17UnAccesoNoEstaConstruidoEn7Turnos() {
        Acceso unAcceso = new Acceso();

        for (int i = 0; i < 7; i++)
            unAcceso.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unAcceso.crearFabricaDragon());
    }

    @Test
    public void test18UnAccesoEstaConstruidoEn8Turnos() {
        Acceso unAcceso = new Acceso();

        for (int i = 0; i < 8; i++)
            unAcceso.pasarTurno();

        assertDoesNotThrow(() -> unAcceso.crearFabricaDragon());
    }

    @Test
    public void test19UnPuertoEstelarNoEstaConstruidoEn9Turnos() {
        PuertoEstelar unPuertoEstelar = new PuertoEstelar();

        for (int i = 0; i < 9; i++)
            unPuertoEstelar.pasarTurno();

        assertThrows(ErrorEdificioNoEstaConstruido.class, () -> unPuertoEstelar.crearFabricaScout());
    }

    @Test
    public void test20UnPuertoEstelarEstaConstruidoEn10Turnos() {
        PuertoEstelar unPuertoEstelar = new PuertoEstelar();

        for (int i = 0; i < 10; i++)
            unPuertoEstelar.pasarTurno();

        assertDoesNotThrow(() -> unPuertoEstelar.crearFabricaScout());
    }
}
