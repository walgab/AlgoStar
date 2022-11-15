package edu.fiuba.algo3.modelo.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Mapa.Casilla.SuperficieTerrestre;
import edu.fiuba.algo3.modelo.danioYAtaque.*;
import edu.fiuba.algo3.modelo.Imperio.Recurso;
import edu.fiuba.algo3.modelo.vida.Vida;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

import java.util.ArrayList;

public class Dragon extends UnidadProtoss {

    private int danioTerrestre = 20;
    private int danioAereo = 20;

    private DanioUnidad danio = new DanioDragon(danioTerrestre, danioAereo);

    private Vida vida = new VidaConEscudo(100, 80);

    public Dragon() {
        this.turnosDeConstruccion = 6;
        superficieDondeSeMueve.add(new SuperficieTerrestre());
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
