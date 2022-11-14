package edu.fiuba.algo3.modelo.Mapa.Casilla;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.ErrorNoSePuedeConstruirEdificioSobreOtroEdificio;
import edu.fiuba.algo3.modelo.Excepciones.ErrorNoSePuedeDesconstruirUnEdificioNoCreado;
import edu.fiuba.algo3.modelo.Mapa.Coordenada;
import edu.fiuba.algo3.modelo.UnidadesZerg.UnidadZerg;

public class CasillaVacia extends Casilla{

    public CasillaVacia(Coordenada coordenada){
        estadoRecolectable = new NoRecolectable();
        estadoMoho = new SinMoho();
        estadoCarga = new SinCarga();
        this.coordenada = coordenada;
    }

    public Casilla construirEdificio(Edificio unEdificio){

        unEdificio.verificarConstruccion(this);

        return new CasillaOcupada(coordenada, this.estadoCarga, this.estadoMoho, this.estadoRecolectable);
    }

    public CasillaVacia(Coordenada coordenada, Cargable estadoCarga, EstadoMoho estadoMoho, Recolectable estadoRecolectable){
        this.estadoRecolectable = estadoRecolectable;
        this.estadoMoho = estadoMoho;
        this.estadoCarga = estadoCarga;
        this.coordenada = coordenada;
    }

    public Coordenada obtenerCoordenada(){
        return this.coordenada;
    }

    @Override
    public void llenarDeMoho() {
        estadoMoho = new ConMoho();
    }

    public Casilla colocarUnidadZerg(UnidadZerg unaUnidadZerg){
        unaUnidadZerg.interaccionar(this);
        return new CasillaOcupada(coordenada);
    }
    
    public Casilla desconstruirEdificio(Coordenada coordenada){
        throw new ErrorNoSePuedeDesconstruirUnEdificioNoCreado();
    }
}
