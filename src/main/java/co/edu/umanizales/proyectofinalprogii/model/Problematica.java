package co.edu.umanizales.proyectofinalprogii.model;

import co.edu.umanizales.proyectofinalprogii.controlador.lstIndicador;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Problematica {
    public String tipo_problema;
    public String id_problema;
    public String nombreProb;
    public String palabrasClave;
    public lstIndicador indicador;

    //--------------------------

    public Problematica(String id_problema, String nombreProb, String tipo_problema, String palabrasClave) {
        this.id_problema = id_problema;
        this.nombreProb = nombreProb;
        this.tipo_problema = tipo_problema;
        this.palabrasClave = palabrasClave;
    }

    //--------------------------

    @Override
    public String toString() {
        return "Problematica{" +
                "tipo_problema='" + tipo_problema + '\'' +
                ", id_problema='" + id_problema + '\'' +
                ", nombreProb='" + nombreProb + '\'' +
                ", palabrasClave='" + palabrasClave + '\'' +
                ", indicador=" + indicador +
                '}';
    }
}
