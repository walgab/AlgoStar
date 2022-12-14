package edu.fiuba.algo3.modelo.Edificios.FabricasUnidades;

import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;

public class FabricasUnidadesZangano extends FabricasUnidades {

    private static final int poblacionQueOcupa = 1;

    public FabricasUnidadesZangano(){
        this.poblacionNecesaria = poblacionQueOcupa;
    }

    public static int obtenerPoblacionNecesaria(){
        return poblacionQueOcupa;
    }

    public Zangano crearUnidad(){
        return new Zangano();
        // Ver para despues si hay que delegar en Criadero o no
    }
}
