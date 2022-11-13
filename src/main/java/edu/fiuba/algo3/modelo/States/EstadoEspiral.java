package edu.fiuba.algo3.modelo.States;

import edu.fiuba.algo3.modelo.Edificio_Zerg.FabricaMutalisco;

public interface EstadoEspiral {

    public abstract EstadoEspiral actualizar();

    public abstract FabricaMutalisco crearFabricaMutalisco();
}
