package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication;
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
        } else {
            c_nodo_Eval temp = this.getUlt();
            n_nodo.ant = temp;
            temp.setSig(n_nodo);
            this.setUlt(n_nodo);
        }
        this.setTam(this.getTam() + 1);
    }//Fin metodo agregarFinal

    //-----------------------

    public void crearEvaluacion() {

        int pos;
        Problematica prob = null;
        int valorImpacto;
        c_nodo_LD temp;
        temp = ProyectoFinalProgIiApplication.departamento.cab;

        // Obtener el tamaño de la lista de problemáticas una sola vez
        int tamProblematica = ProyectoFinalProgIiApplication.problematica.tam;

        if (tamProblematica == 0) {
            return; // No hay problemáticas para evaluar
        }

        while (temp != null) {

            // **++ El departamento actual (temp.dato) es único en cada iteración ++**

            int cantProb = (int) (Math.random() * 5) + 5;

            for (int i = 1; i <= cantProb; i++) {

                // **++ Control de Bucle Infinito y Unicidad ++**
                int intentos = 0;
                boolean encontradaUnica = false;

                do {
                    // Genera la posición en el rango [1, tam] (corrige el NPE)
                    pos = (int)(Math.random() * tamProblematica) + 1;
                    prob = ProyectoFinalProgIiApplication.problematica.mostrarPosicionObj(pos);

                    // 1. Verificación: Asegurarse de que el objeto no es nulo (seguridad).
                    // 2. Unicidad: Asegurarse de que NO exista una evaluación previa.
                    if (prob != null && !buscar(temp.dato.id_dep, prob.id_problema)) {
                        encontradaUnica = true; // Se encontró una problemática única para este departamento.
                    }

                    intentos++;

                    // Salir del do-while si se agotan los intentos (Protección contra bucle infinito)
                    if (intentos > 100) {
                        break;
                    }

                } while (!encontradaUnica); // Repetir mientras no se encuentre una problemática única.

                // **++ Creación de la Evaluación SOLO si se encontró una Problemática Única ++**
                if (encontradaUnica) {
                    valorImpacto = (int) (Math.random() * 100);

                    Evaluador ObjEvaluador = new Evaluador(temp.dato, prob, valorImpacto);

                    this.agregarFinal(new c_nodo_Eval(ObjEvaluador));
                }
            }

            temp = temp.sig;
        }
    }

    //----------------------

    public String mostrarTodo() {

        String resultado_cadena = "";
        if (this.estaVacio()) {
            return resultado_cadena; //retorna la lista vacía
        } else {
            c_nodo_Eval temp;
            temp = this.getCab();

            while (temp != null) { //iniciar el ciclo de recorrido
                resultado_cadena = resultado_cadena + temp.dato + "\n";
                temp = temp.getSig();
            }
            return resultado_cadena;
        }//fin else
    }//fin metodo mostrar

    //-------------------------

    public Evaluador sacarUltimoDato() {
        c_nodo_Eval temp = this.ult;
        Evaluador prob = temp.dato;
        this.ult = temp.ant;
        this.ult.sig = null;
        temp = null;
        tam = tam--;
        return prob;
    }

    //---------------------------

    public Evaluador sacarPrimero() {
        c_nodo_Eval temp = this.getCab();
        Evaluador eval = temp.dato;
        this.cab = temp.sig;
        temp = null;
        tam--;
        return eval;
    }

    //-----------------------------

    public boolean buscar(String idDepartamento, String idProblematica) {
        c_nodo_Eval temp;
        int pos;
        pos = 0;
        temp = this.cab;
        boolean res = false;
        if (this.estaVacio()) {
            return res;
        }
        while ((temp != null) &&
                (!idDepartamento.equalsIgnoreCase(temp.dato.getDpto().id_dep)) &&
                !idProblematica.equalsIgnoreCase(temp.dato.getProblema().id_problema)) {
            temp = temp.sig;
            pos++;
        }
        if (pos <= this.getTam()) {
            res = true;
        }
        return res;
    }// fin del metodo de buscar un elemento
}
