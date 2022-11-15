package edu.fiuba.algo3.modelo.UnidadesProtoss;

import edu.fiuba.algo3.modelo.danioYAtaque.*;
import edu.fiuba.algo3.modelo.vida.Vida;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;
import edu.fiuba.algo3.modelo.vida.VidaSimple;

public class Zealot implements UnidadProtoss {

    private int danioTerrestre = 8;

    private DanioUnidad danio = new DanioZealot(danioTerrestre);

    private Vida vida = new VidaConEscudo(100, 60);

    public Ataque atacar(){
        Ataque unAtaque = new Ataque(danio);
        return unAtaque;
    }

    public void recibirAtaque(Ataque unAtaque){
        this.vida.aplicarAtaque(unAtaque);
    }
}
