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

        //--------- * REPORTES DEPARTAMENTALES * ------------//

        System.out.println("//*REPORTES DEPARTAMENTALES*//");

        System.out.println(obj_gestorDatos.MostrarDepConProb());
        System.out.println(obj_gestorDatos.MostrarValoracionPorProb());
        System.out.println(obj_gestorDatos.ImpactoTotalDepartamento());

        System.out.println('\n' + "-------------------------------------------");

        //--------- * REPORTES PROBLEMÁTICAS CRÍTICAS * ------------//

        System.out.println("//*REPORTES PROBLEMATICAS CRITICAS*//");

        System.out.println(obj_gestorDatos.MayorValorAcumuladoProblema());
        System.out.println(obj_gestorDatos.listarDepartamentosPorImpacto());
        System.out.println(obj_gestorDatos.MostrarValoracionPorProb());

        System.out.println('\n' + "-------------------------------------------");

        //--------- * REPORTES INDICADORES COMUNES * ----------//

        System.out.println("//-*-REPORTES INDICADORES COMUNES-*-//");

        System.out.println(obj_gestorDatos.identificarIndicadoresComunes());

        System.out.println('\n' + "-------------------------------------------");

        //--------- * REPORTES PALABRAS CLAVE * -------------//

        System.out.println("//-*-REPORTES PALABRAS CLAVE-*-//");

        System.out.println(obj_gestorDatos.analisisFrecuenciaPalabrasClave());
        System.out.println(obj_gestorDatos.IdentificarTerminosRecurrentes());

        System.out.println('\n' + "-------------------------------------------" + '\n');
    }

}
