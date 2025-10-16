package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Indicador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class c_nodo_LI {
    public Indicador dato;
    public c_nodo_LI sig;

    //-----------------

    public c_nodo_LI(Indicador dato) {
        this.dato = dato;
        this.sig = null;
    }

    public c_nodo_LI() {
        this.sig = null;
    }

    //-----------------

    @Override
    public String toString() {
        return "c_nodo_LI (dato=" + dato + ")";
    }
}
