package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Problematica;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class c_nodo_LP {
    public Problematica dato;
    public c_nodo_LP ant;
    public c_nodo_LP sig;

    //-----------------

    public c_nodo_LP(Problematica dato) {
        this.dato = dato;
        this.ant = this.sig = null;
    }

    public c_nodo_LP() {
        this.ant = this.sig = null;
    }

    //-----------------

    @Override
    public String toString() {
        return "c_nodo_LP (dato=" + dato + ")";
    }
}
