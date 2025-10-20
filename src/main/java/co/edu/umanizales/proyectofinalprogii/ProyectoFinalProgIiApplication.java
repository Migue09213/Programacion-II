package co.edu.umanizales.proyectofinalprogii;

import co.edu.umanizales.proyectofinalprogii.controlador.lstDepartamento;
import co.edu.umanizales.proyectofinalprogii.controlador.lstIndicador;
import co.edu.umanizales.proyectofinalprogii.controlador.lstProblematica;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ProyectoFinalProgIiApplication {

    public static lstIndicador indicadores;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProyectoFinalProgIiApplication.class, args);

        //------------------------------------------------

        indicadores = new lstIndicador();
        indicadores.cargarIndicadores();
        System.out.println(indicadores.mostrarTodo());

        lstDepartamento obj_lst_dep = new lstDepartamento();
        System.out.println(obj_lst_dep.mostrarTodo());

        lstProblematica obj_lst_pro = new lstProblematica();
        System.out.println(obj_lst_pro.mostrarTodo());



        //-------------------------------------------------



    }

}
