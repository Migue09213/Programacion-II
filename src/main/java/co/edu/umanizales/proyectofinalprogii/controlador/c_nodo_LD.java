package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Departamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class c_nodo_LD {
    public Departamento dato;
    public c_nodo_LD sig;

    //-----------------

    public c_nodo_LD(Departamento dato) {
        this.dato = dato;
        this.sig = null;
    }

    public c_nodo_LD() {
        this.sig = null;
    }

    //-----------------

    @Override
    public String toString() {
        return "c_nodo_LD (dato=" + dato + ")";
    }
}
