package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Evaluador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class c_nodo_Eval {
    public Evaluador dato;
    public c_nodo_Eval ant;
    public c_nodo_Eval sig;

    //-----------------

    public c_nodo_Eval(Evaluador dato) {
        this.dato = dato;
        this.ant = this.sig = null;
    }

    public c_nodo_Eval() {
        this.ant = this.sig = null;
    }

    //-----------------

    @Override
    public String toString() {
        return "c_nodo_Eval (dato=" + dato + ")";
    }
}
