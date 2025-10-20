package co.edu.umanizales.proyectofinalprogii.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evaluador {

    public Departamento Dpto;
    public Problematica problema;
    public int valor_impacto;

    public Evaluador() {}

    public Evaluador(Departamento dpto, Problematica problema, int valor_impacto) {
        Dpto = dpto;
        this.problema = problema;
        this.valor_impacto = valor_impacto;
    }

    @Override
    public String toString() {
        return "Evaluación: {" +
                "Departamento=" + Dpto + '\'' +
                ", Problema=" + problema + '\'' +
                "Valor=" + valor_impacto + '\'' +
                '}';
    }//Fin metodo ToString
}//Fin clase Evaluador
