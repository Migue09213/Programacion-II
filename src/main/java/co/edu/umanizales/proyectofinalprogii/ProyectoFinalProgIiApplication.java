package co.edu.umanizales.proyectofinalprogii;

import co.edu.umanizales.proyectofinalprogii.controlador.lstDepartamento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class ProyectoFinalProgIiApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProyectoFinalProgIiApplication.class, args);
        lstDepartamento obj_lst_dep = new lstDepartamento();
        System.out.println(obj_lst_dep.mostrarTodo());


    }

}
