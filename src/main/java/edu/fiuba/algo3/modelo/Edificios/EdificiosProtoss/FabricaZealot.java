package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Fabrica;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

public class FabricaZealot extends Fabrica {

    public Zealot crearUnidad(){
        return new Zealot();
    }
}
