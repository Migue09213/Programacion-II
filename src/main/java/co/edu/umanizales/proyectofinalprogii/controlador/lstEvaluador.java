package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication;
import co.edu.umanizales.proyectofinalprogii.model.Departamento;
import co.edu.umanizales.proyectofinalprogii.model.Evaluador;
import co.edu.umanizales.proyectofinalprogii.model.Problematica;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class lstEvaluador {
    public c_nodo_Eval cab;
    public c_nodo_Eval ult;
    public int tam;

    //---------------------

    public lstEvaluador() {
        cab = null;
        ult = null;
        tam = 0;
    }

    //---------------------

    //Operaciones de la lista
    public boolean estaVacio() {
        return cab == null;
    }

    //---------------------

    public void agregarFinal(c_nodo_Eval n_nodo) {
        if (this.estaVacio()) {
            this.setCab(n_nodo);
            this.setUlt(n_nodo);
        }else{
            c_nodo_Eval temp = this.getUlt();
            temp.setSig(n_nodo);
            this.setUlt(n_nodo);
        }
        this.setTam(this.getTam() + 1);
    }//Fin metodo agregarFinal

    //-----------------------

    public void crearEvaluacion() {

        c_nodo_LD temp = ProyectoFinalProgIiApplication.departamento.getCab();

        while(temp != null){
            int cantProb = (int)(Math.random()*5)+5;

            for(int i = 1; i <= cantProb; i++){
                int pos = (int)(Math.random()*ProyectoFinalProgIiApplication.problematica.tam);
                Problematica prob = ProyectoFinalProgIiApplication.problematica.mostrarPosicionObj(pos);
                int valorImpacto = (int)(Math.random()*100);

                Evaluador ObjEvaluador = new Evaluador(temp.dato, prob, valorImpacto);

                this.agregarFinal(new c_nodo_Eval(ObjEvaluador));
            }
            temp = temp.sig;
        }
    }

    public String mostrarTodo(){

        String resultado_cadena = "";
        if (this.estaVacio()) {
            return resultado_cadena; //retorna la lista vacía
        }else{
            c_nodo_Eval temp;
            temp = this.getCab();

            while (temp != null) { //iniciar el ciclo de recorrido
                resultado_cadena = resultado_cadena + temp.dato + "\n";
                temp = temp.getSig();
            }
            return resultado_cadena;
        }//fin else
    }//fin metodo mostrar

}
