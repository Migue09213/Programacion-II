package co.edu.umanizales.proyectofinalprogii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    public String nombre;
    public String id_dep;
    public int poblacion;
    public enum region{
        ORINOCO, PACIFICA, CARIBE, ANDINA, AMAZONICA
    };
} //fin clase Departamento
