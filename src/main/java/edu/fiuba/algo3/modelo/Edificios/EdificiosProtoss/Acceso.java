package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Fabrica;
import edu.fiuba.algo3.modelo.Edificios.Estados.EstadoCreador;
import edu.fiuba.algo3.modelo.Edificios.Estados.EstadoCreadorEnConstruccion;
import edu.fiuba.algo3.modelo.Edificios.Estados.EstadoHabilitador;
import edu.fiuba.algo3.modelo.Edificios.Estados.EstadoHabilitadorEnConstruccion;
import edu.fiuba.algo3.modelo.Edificios.FabricasDisponibles;
import edu.fiuba.algo3.modelo.Excepciones.ErrorElEdificioNoTieneCarga;
import edu.fiuba.algo3.modelo.Imperio.Suministro;
import edu.fiuba.algo3.modelo.Mapa.Casilla.*;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida.VidaConEscudo;

import java.util.ArrayList;

public class Acceso extends EdificioConCarga {

    private EstadoHabilitador estadoHabilitador;
    private EstadoCreador estadoCreador;
    private int turnoParaEstarConstruido = 8;
    private int valorVital = 500;

    // Fabricas que el edificio habilita
    private ArrayList<Fabrica> listaFabricasAHabilitar = new ArrayList<Fabrica>();
    private FabricasDisponibles fabricasDisponibles;
    private ArrayList<Unidad> unidades;

    public Acceso(){
        this.costoGas = 0;
        this.costoMineral = 150;
        this.estadoCarga = new ConCarga();
        this.estadoMoho = new SinMoho();
        this.estadoRecolectable = new NoRecolectable();
        this.vida = new VidaConEscudo(valorVital, valorVital);
        this.superficieRequerida = new SuperficieTerrestre();

        estadoHabilitador = new EstadoHabilitadorEnConstruccion(turnoParaEstarConstruido);
        estadoCreador = new EstadoCreadorEnConstruccion(turnoParaEstarConstruido);

        listaFabricasAHabilitar.add(new FabricaDragon());
        listaFabricasAHabilitar.add(new FabricaZealot());
    }

    public void crearUnidad(Fabrica unaFabrica) {
        if (verificarCarga()) {
            estadoHabilitador.estaAptoParaCrearse(unaFabrica);
            estadoCreador.crearUnidad(unaFabrica, unidades, mineralDelImperio, gasDelImperio);
        }
        else throw new ErrorElEdificioNoTieneCarga();
    }

    public void pasarTurno(){
        estadoHabilitador = estadoHabilitador.actualizar(listaFabricasAHabilitar, fabricasDisponibles);
        estadoCreador = estadoCreador.actualizar();
        vida.pasarTurno();
    }

    public void asignarListaDeUnidades(FabricasDisponibles fabricasDisponibles) {
        this.fabricasDisponibles = fabricasDisponibles;
        estadoCreador.asignarFabricasDisponibles(fabricasDisponibles);
    }

    public void asignarListaDeUnidadesImperio(ArrayList<Unidad> unidades){
        this.unidades = unidades;
    }

    public void construirInmediatamente(){
        for (int i = 0; i < turnoParaEstarConstruido; i++)
            pasarTurno();
    }

    @Override
    public void modificarPoblacion(Suministro suministro){
        estadoHabilitador.marcarSuministro(suministro, suministroAportado);
    }

    public void asignarSuministro(Suministro poblacionDelImperio){
        estadoHabilitador.marcarSuministro(poblacionDelImperio, 0);
    }
}
