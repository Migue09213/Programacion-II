package co.edu.umanizales.proyectofinalprogii.model;

import co.edu.umanizales.proyectofinalprogii.controlador.lstIndicador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problematica {
    public String id_problema;
    public String tipo_problema;
    public String nombreProb;
    public String palabrasClave;
    public lstIndicador indicador;

    //--------------------------


    public Problematica() {
    }

    public Problematica(String id_problema, String nombreProb, String tipo_problema, String palabrasClave) {
        this.id_problema = id_problema;
        this.nombreProb = nombreProb;
        this.tipo_problema = tipo_problema;
        this.palabrasClave = palabrasClave;
    }

    public Problematica(String id_problema, String nombreProb, String tipo_problema, String palabrasClave, lstIndicador indicador) {
        this.id_problema = id_problema;
        this.tipo_problema = tipo_problema;
        this.nombreProb = nombreProb;
        this.palabrasClave = palabrasClave;
        this.indicador = indicador;
    }

    //--------------------------

    @Override
    public String toString() {
        return "Problematica{" +
                "ID='" + id_problema + '\'' +
                ", Tipo='" + tipo_problema + '\'' +
                ", nombreProb='" + nombreProb + '\'' +
                ", palabrasClave='" + palabrasClave + '\'' +
                ", indicador=" + indicador.mostrarTodo() +
                '}';
    }
}
