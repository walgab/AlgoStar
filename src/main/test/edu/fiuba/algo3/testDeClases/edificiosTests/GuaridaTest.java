package edu.fiuba.algo3.testDeClases.edificiosTests;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Edificios.FabricasDisponibles;
import edu.fiuba.algo3.modelo.Excepciones.ErrorNoSeCumplenLosRequisitosDeEstaUnidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuaridaTest {

    @Test
    public void test01UnaGuaridaNoSeConstruyeEn11Turnos(){
        FabricasDisponibles fabricasDisponibles = new FabricasDisponibles();
        Guarida unaGuarida = new Guarida();
        unaGuarida.asignarListaDeUnidades(fabricasDisponibles);

        for(int i = 0; i < 11; i++)
            unaGuarida.pasarTurno();

        // Construyo criadero
        Criadero unCriadero = new Criadero();
        unCriadero.asignarListaDeUnidades(fabricasDisponibles);
        for (int i = 0; i < 4; i++)
            unCriadero.pasarTurno();

        assertThrows(ErrorNoSeCumplenLosRequisitosDeEstaUnidad.class,
                () -> unCriadero.crearUnidad(new FabricaHidralisco()));
    }

    @Test
    public void test02GuaridaSePuedeConstruirEn12Turnos(){
        FabricasDisponibles fabricasDisponibles = new FabricasDisponibles();
        Guarida unaGuarida = new Guarida();
        unaGuarida.asignarListaDeUnidades(fabricasDisponibles);

        for(int i = 0; i < 12; i++)
            unaGuarida.pasarTurno();

        // Construyo criadero
        Criadero unCriadero = new Criadero();
        unCriadero.asignarListaDeUnidades(fabricasDisponibles);
        for (int i = 0; i < 4; i++)
            unCriadero.pasarTurno();

        assertDoesNotThrow(() -> unCriadero.crearUnidad(new FabricaHidralisco()));
    }
}