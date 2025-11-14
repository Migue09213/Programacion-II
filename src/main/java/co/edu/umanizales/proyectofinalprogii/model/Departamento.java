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
    public String id_dep;
    public String nombre;
    public int poblacion;
    public enum region{
        ORINOCO, PACIFICA, CARIBE, ANDINA, AMAZONICA
    }

    //------------------------

    @Override
    public String toString() {
        return "Departamento{" +
                "ID='" + id_dep + '\'' +
                ", nombre='" + nombre + '\'' +
                ", poblacion=" + poblacion +
                '}';
    }
} //fin clase Departamento
