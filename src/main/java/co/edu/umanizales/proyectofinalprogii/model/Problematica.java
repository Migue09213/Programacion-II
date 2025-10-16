package co.edu.umanizales.proyectofinalprogii.model;

import co.edu.umanizales.proyectofinalprogii.controlador.lstIndicador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problematica {
    public String tipo_problema;
    public String id_problema;
    public String nombreProb;
    public String palabrasClave;
    public lstIndicador indicador;
}
