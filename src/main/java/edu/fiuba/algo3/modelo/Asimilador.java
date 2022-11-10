package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Tablero.NodoRecurso;
import edu.fiuba.algo3.modelo.Tablero.Terreno;
import edu.fiuba.algo3.modelo.Tablero.VolcanGasVespeno;
import edu.fiuba.algo3.modelo.excepciones.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Asimilador extends Edificio {

    private Recurso gasVespeno;
    private NodoRecurso nodoGasVespeno;
    private int unidadesPorTurno = 20;
    private VidaConEscudo vida;

    public Asimilador(NodoCompatible requisitos, Recurso _gasVespeno) {
        this.turnosExistiendo = 0;
        this.turnosDeConstruccion = 6;
        this.nodoCompatible = requisitos;
        this.gasVespeno = _gasVespeno;
        this.vida = new VidaConEscudo(450, 0.25, 450);
    }

    @Override
    public void accionDeTurno() {
        try {
            this.estaActiva();
            gasVespeno.depositar(nodoGasVespeno.extraer(unidadesPorTurno));
        }
        catch(EdificioEnConstruccion e){
        }
        catch(NullPointerException e){
        }
        turnosExistiendo ++;
        this.vida.accionDeTurno();
        // TODO
    }

    @Override
    public void esCompatible(Terreno terreno, NodoRecurso nodoRecurso) {
        super.esCompatible(terreno, nodoRecurso);
        nodoGasVespeno = nodoRecurso;
    }

    public void recibirDanio(int danio){
        this.vida.aplicarDanio(danio);
    }

    public int getVida(){
        return vida.getVida();

    }
}
