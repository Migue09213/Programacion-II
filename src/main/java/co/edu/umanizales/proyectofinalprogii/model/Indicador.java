package co.edu.umanizales.proyectofinalprogii.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Indicador {
    public String id_indicador;
    public String nombre;
    public int valor;

    //---------------------

    public Indicador (String id_indicador,String nombre, int valor) {
        this.id_indicador = id_indicador;
        this.nombre = nombre;
        this.valor = valor;
    }


    //---------------------

    @Override
    public String toString() {
        return "Indicador{" +
                "ID='" + id_indicador + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}//fin de la clase Indicador
