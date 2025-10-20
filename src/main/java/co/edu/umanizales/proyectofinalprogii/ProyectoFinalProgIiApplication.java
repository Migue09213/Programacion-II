package co.edu.umanizales.proyectofinalprogii;

import co.edu.umanizales.proyectofinalprogii.controlador.lstDepartamento;
import co.edu.umanizales.proyectofinalprogii.controlador.lstEvaluador;
import co.edu.umanizales.proyectofinalprogii.controlador.lstIndicador;
import co.edu.umanizales.proyectofinalprogii.controlador.lstProblematica;
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
        System.out.println(indicadores.mostrarTodo());

        problematica = new lstProblematica();
        problematica.cargarProblematicas();
        System.out.println(problematica.mostrarTodo());

        departamento = new lstDepartamento();
        departamento.cargarDepartamentos();
        System.out.println(departamento.mostrarTodo());

        Evaluador = new lstEvaluador();
        Evaluador.crearEvaluacion();
        System.out.println(Evaluador.mostrarTodo());


        //-------------------------------------------------



    }

}
