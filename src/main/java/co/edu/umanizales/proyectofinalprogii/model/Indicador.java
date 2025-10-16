package co.edu.umanizales.proyectofinalprogii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Indicador {
    public String nombre;
    public String id_indicador;
    public int valor;
}
