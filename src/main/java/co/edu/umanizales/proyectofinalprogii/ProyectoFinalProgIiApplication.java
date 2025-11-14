package co.edu.umanizales.proyectofinalprogii;

import co.edu.umanizales.proyectofinalprogii.controlador.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ProyectoFinalProgIiApplication {

    public static lstIndicador indicadores;
    public static lstProblematica problematica;
    public static lstDepartamento departamento;
    public static lstEvaluador Evaluador;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProyectoFinalProgIiApplication.class, args);

        //------------------------------------------------

        indicadores = new lstIndicador();
        indicadores.cargarIndicadores();

        problematica = new lstProblematica();
        problematica.cargarProblematicas();

        departamento = new lstDepartamento();
        departamento.cargarDepartamentos();

        Evaluador = new lstEvaluador();
        Evaluador.crearEvaluacion();


        //-------------------------------------------------

        GestorDatos obj_gestorDatos = new GestorDatos();
        System.out.println(obj_gestorDatos.MostrarDepConProb());


    }

}
