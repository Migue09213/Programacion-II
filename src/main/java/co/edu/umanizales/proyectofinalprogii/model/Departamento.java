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
    }

    //------------------------


    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", id_dep='" + id_dep + '\'' +
                ", poblacion=" + poblacion +
                '}';
    }
} //fin clase Departamento
