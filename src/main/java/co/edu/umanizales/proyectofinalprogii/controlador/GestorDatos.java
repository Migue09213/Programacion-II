package co.edu.umanizales.proyectofinalprogii.controlador;


import co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication;

import static co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication.*;

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
            departamentoMostrarProb = departamentoMostrarProb + '\n' + "Departamento: " + tempD.dato.getNombre() + "" +
                    '\n';
            while(tempE != null) {
                if (tempE.dato.getDpto().getNombre().equalsIgnoreCase(tempD.dato.getNombre())) {
                    departamentoMostrarProb = departamentoMostrarProb + '\n' +
                            "Problematica: " + tempE.dato.getProblema() + '\n' ;
                }
                tempE = tempE.sig;
            }
            tempD = tempD.sig;
        }
        return departamentoMostrarProb;
    }

    public String MostrarValoracionPorProb() {
        c_nodo_LP tempP;
        tempP = problematica.cab;
        String valoracionPorProb="";
        int valorTotal = 0;
        while(tempP != null) {
            c_nodo_Eval tempE;
            tempE = Evaluador.cab;
            valoracionPorProb = valoracionPorProb + '\n' + "Problemática: " + tempP.dato.getNombreProb() + "" + '\n';
            try {
                valorTotal = 0;
                while(tempE != null) {
                    if(tempE.dato.getProblema().getNombreProb().equalsIgnoreCase(tempP.dato.getNombreProb())) {
                        valoracionPorProb = valoracionPorProb +
                                "Valor: " + tempE.dato.getValor_impacto() + "   " +
                                "Departamento: " + tempE.dato.getDpto().getNombre() + '\n';
                        valorTotal = valorTotal + tempE.dato.getValor_impacto();
                    }
                    tempE = tempE.sig;
                }//fin while
            } catch (NullPointerException e) {
            }
            valoracionPorProb = valoracionPorProb + '\n' +  "Valor Total: " + valorTotal + '\n' + '\n';
            tempP = tempP.sig;
        }
        return valoracionPorProb;
    }

}
