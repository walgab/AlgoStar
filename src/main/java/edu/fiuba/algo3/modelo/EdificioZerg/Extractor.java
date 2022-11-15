package edu.fiuba.algo3.modelo.EdificioZerg;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.ErrorEstaUnidadNosePuedeContratar;
import edu.fiuba.algo3.modelo.Imperio.Recurso;
import edu.fiuba.algo3.modelo.Mapa.Casilla.*;
import edu.fiuba.algo3.modelo.Mapa.MaterialBruto;
import edu.fiuba.algo3.modelo.States.EstadoExtractor;
import edu.fiuba.algo3.modelo.States.EstadoExtractorEnConstruccion;
import edu.fiuba.algo3.modelo.UnidadesZerg.UnidadZerg;
import edu.fiuba.algo3.modelo.UnidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.vida.VidaRegenerativa;

import java.util.LinkedList;

public class Extractor extends Edificio {

    private EstadoExtractor estado;
    private int turnoParaEstarConstruido = 6;
    private Recurso gasDelImperio;
    private MaterialBruto volcanDeGas = null;
    private LinkedList<UnidadZerg> zanganosEmpleados = new LinkedList<>();
    private int valorVital = 750;


    public Extractor(Recurso gasDelImperio){
        this.costoGas = 0;
        this.costoMineral = 100;
        this.estadoRecolectable = new GasRecolectable();
        this.estadoMoho = new ConMoho();
        this.vida = new VidaRegenerativa(valorVital);
        this.gasDelImperio = gasDelImperio;
        this.estado = new EstadoExtractorEnConstruccion(turnoParaEstarConstruido);
    }

    public void pasarTurno(){
        estado = estado.actualizar();
        this.extraer();
        vida.pasarTurno();
    }

    private void extraer(){
        estado.extraer(gasDelImperio, volcanDeGas, zanganosEmpleados.size());
    }

    public void contratarZangano(UnidadZerg zanganoAContratar){
        if (!zanganoAContratar.esIgualA(new Zangano())){
            throw new ErrorEstaUnidadNosePuedeContratar();
        }
        estado.contratarZangano(zanganoAContratar, zanganosEmpleados);
    }

    public void verificarConstruccion(Casilla unaCasilla){
        super.verificarConstruccion(unaCasilla);
        establecerSobreGas(unaCasilla.obtenerMaterial());
    }

    public void establecerSobreGas(MaterialBruto volcanDeGas){
        this.volcanDeGas = volcanDeGas;
    }
    @Override
    public void contratarUnidad(UnidadZerg unidad){
        contratarZangano(unidad);
    }
}
