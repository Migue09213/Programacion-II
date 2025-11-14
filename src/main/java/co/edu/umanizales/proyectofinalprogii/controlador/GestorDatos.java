package co.edu.umanizales.proyectofinalprogii.controlador;


import co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication;

import static co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication.Evaluador;
import static co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication.departamento;

public class GestorDatos {

    //---------------------

    public GestorDatos() {
    }

    //------------------------
        //Reportes Departamentales

    public String MostrarDepConProb() {
        c_nodo_LD tempD;
        tempD = ProyectoFinalProgIiApplication.departamento.cab;
        String departamentoMostrarProb="";
        while(tempD != null){
            c_nodo_Eval tempE;
            tempE = Evaluador.cab;
            departamentoMostrarProb = departamentoMostrarProb + '\n' + "Departamento: " + tempD.dato.getNombre() + "" + '\n';
            while(tempE != null) {
                if (tempE.dato.getDpto().getNombre().equalsIgnoreCase(tempD.dato.getNombre())) {
                    departamentoMostrarProb = departamentoMostrarProb +
                            "Problematica: " + tempE.dato.getProblema() + '\n' ;
                }
                tempE = tempE.sig;
            }
            tempD = tempD.sig;
        }
        return departamentoMostrarProb;
    }

}
