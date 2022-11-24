package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.FabricaDragon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.FabricaZerling;
import edu.fiuba.algo3.modelo.Imperio.Gas;
import edu.fiuba.algo3.modelo.Imperio.Mineral;
import edu.fiuba.algo3.modelo.Imperio.Protoss;
import edu.fiuba.algo3.modelo.Imperio.Zerg;
import edu.fiuba.algo3.modelo.Mapa.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso31Test {

    @BeforeEach
    public void setup(){
        Mapa.obtener().reiniciarMapa();
    }

    @Test
    public void test01ConstruyoUnCriaderoYLuegoLoDestruyoYLaPoblacionVuelveASerCero() {
        Mapa elMapa = Mapa.obtener();
        Zerg imperioZerg = new Zerg();
        Coordenada coordenadaCriadero = new Coordenada(0,0);
        Coordenada coordenadaDragon = new Coordenada(1,0);

        imperioZerg.abastecerDeRecursos(new Mineral(375), new Gas(0));
        imperioZerg.construirCriadero(coordenadaCriadero);

        //Esperamos a que se construya el criadero
        for(int i = 0; i < 5; i++)
            imperioZerg.terminarTurno();

        //obtenemos el criadero
        Edificio criadero = imperioZerg.conseguirEdificio(coordenadaCriadero);

        //Ahora tengo el criadero construido, tengo 5 de poblacion y quiero atacarlo hasta destruirlo
        //Creo un Dragon para atacar al criadero
        Unidad unDragon = new Dragon();
        elMapa.colocarUnaUnidad(unDragon, coordenadaDragon);

        //Destruyo el criadero
        for (int i = 0; i < 25; i++)
            elMapa.atacar(coordenadaDragon, coordenadaCriadero);

        imperioZerg.terminarTurno();

        assertTrue(imperioZerg.tenesEsteSuministro(0));
    }

    @Test
    public void test02ConstruyoUnPilonYLuegoLoDestruyoYLaPoblacionVuelveASerCero() {
        /*Protoss imperioProtoss = new Protoss();
        Coordenada coordenadaPilon = new Coordenada(0,0);
        Coordenada coordenadaZerling = new Coordenada(1,0);

        imperioProtoss.abastecerDeRecursos(new Mineral(375), new Gas(50));
        imperioProtoss.construirPilon(coordenadaPilon);

        //Esperamos a que se construya el pilon
        for(int i = 0; i < 5; i++)
            imperioProtoss.terminarTurno();

        //obtenemos el edificio
        Edificio unPilon = imperioProtoss.conseguirEdificio(coordenadaPilon);

        //Ahora tengo el criadero construido, tengo 5 de poblacion y quiero atacarlo hasta destruirlo
        //Creo un Dragon para atacar al criadero
        Unidad unHidralisco = new Hidralisco();
        elMapa.colocarUnaUnidad(unDragon, coordenadaDragon);

        //Destruyo el criadero
        for (int i = 0; i < 25; i++)
            elMapa.atacar(coordenadaDragon, coordenadaCriadero);

        imperioZerg.terminarTurno();

        assertTrue(imperioZerg.tenesEsteSuministro(0));*/
    }
}
