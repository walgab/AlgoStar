package edu.fiuba.algo3.modelo.UnidadesZerg;

import edu.fiuba.algo3.modelo.Imperio.Recurso;
import edu.fiuba.algo3.modelo.Mapa.Casilla.Casilla;
import edu.fiuba.algo3.modelo.Mapa.Casilla.MineralRecolectable;
import edu.fiuba.algo3.modelo.Mapa.Casilla.Recolectable;
import edu.fiuba.algo3.modelo.Mapa.Casilla.SuperficieTerrestre;
import edu.fiuba.algo3.modelo.danioYAtaque.Ataque;
import edu.fiuba.algo3.modelo.danioYAtaque.Danio;
import edu.fiuba.algo3.modelo.vida.Vida;
import edu.fiuba.algo3.modelo.vida.VidaSimple;

import java.util.ArrayList;

public class Zangano extends UnidadZerg {

    private Recolectable recolecta = new MineralRecolectable();

    private Danio danio = new Danio(4);

    private Vida vida = new VidaSimple(35);

    public Zangano(){
        //FALTA CREAR UNA VIDA
        this.turnosDeConstruccion = 0;
        superficieDondeSeMueve.add(new SuperficieTerrestre());
        this.mineralDelImperio = null;
    }

    @Override
    public void interaccionar(Casilla unaCasilla){
        unaCasilla.tieneEsteRecoletable(recolecta);
        this.recursoARecolectar = unaCasilla.obtenerMaterial();
    }

    @Override
    public void setDepositoRecurso( Recurso recursoImperio ) {
        this.mineralDelImperio = recursoImperio;
    }

    public void extraer(){
        mineralDelImperio.depositar(recursoARecolectar.extraer(10));
    }

    public Ataque atacar(){
        Ataque unAtaque = new Ataque(danio);
        return unAtaque;
    }

    public void recibirAtaque(Ataque unAtaque){
        this.vida.aplicarAtaque(unAtaque);
    }


    public ArrayList<Recurso> requisitosMateriales() {
        ArrayList<Recurso> requisitosMateriales = new ArrayList<>();
        return requisitosMateriales;
    }
}