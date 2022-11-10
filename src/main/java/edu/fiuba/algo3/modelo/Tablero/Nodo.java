package edu.fiuba.algo3.modelo.Tablero;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Zangano;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoCompatibleConEdificio;

public class Nodo {

    private Terreno terreno;
    private NodoRecurso nodoRecurso;
    private NodoEstado nodoEstado;

    public Nodo() {
        terreno = new Neutro();
        nodoRecurso = new SinRecurso();
        nodoEstado = new NodoVacio();
    }
    public Nodo(NodoRecurso recurso) {
        terreno = new Neutro();
        nodoRecurso = recurso;
        nodoEstado = new NodoVacio();
    }

    public Nodo(Terreno terreno, NodoRecurso recurso) {
        this.terreno = terreno;
        this.nodoRecurso = recurso;
        this.nodoEstado = new NodoVacio();
    }

    //Para pruebas, luego eliminar TODO
    public void establecerRecurso(NodoRecurso _nodoRecurso) {
        nodoRecurso = _nodoRecurso;
    }

    public void construir(Edificio construccion) {
        construccion.esCompatible(terreno, nodoRecurso);
        nodoEstado = nodoEstado.construir(construccion);
    }

    public void asignarUnidad(Zangano zangano) {
        zangano.esCompatible(nodoRecurso);
        nodoEstado = nodoEstado.asignarUnidad(zangano);
    }

    public void actualizarTerrenoCon(Terreno nuevoTerreno) {
        if (nuevoTerreno.getClass().equals(new Neutro().getClass())){
            terreno = nuevoTerreno;
        }
        else if (terreno.igualA(new Neutro())){
            terreno = nuevoTerreno;
        }
        this.terreno = nodoEstado.actualizar(terreno, nuevoTerreno);
    }

    public void cargarTerreno() {
        terreno = terreno.cargarTerreno();
    }

    public void descargarTerreno() {
        terreno = terreno.descargarTerreno();
    }

    public void desocuparNodo() {
        nodoEstado = nodoEstado.desocuparNodo();
    }

    public boolean estaEnergizado() {
        return terreno.igualA(new Energia());
    }
}
