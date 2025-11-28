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
        Problematica prob = null; // Inicializar para seguridad
        int valorImpacto;
        c_nodo_LD temp;
        temp = ProyectoFinalProgIiApplication.departamento.cab;

        // Obtener el tamaño de la lista de problemáticas una sola vez
        int tamProblematica = ProyectoFinalProgIiApplication.problematica.tam;

        // Verificación: Asegurarse de que el departamento no sea null
        if (tamProblematica == 0 || ProyectoFinalProgIiApplication.departamento == null) {
            return;
        }

        // El bucle while (temp != null) garantiza que el departamento no se repita
        while (temp != null) {

            int cantProb = (int) (Math.random() * 5) + 5;
            for (int i = 1; i <= cantProb; i++) {

                int intentos = 0;
                boolean existeDuplicado = true; // Asumir que existe hasta que se pruebe lo contrario
                boolean exitoEncontrado = false; // Bandera para indicar si encontramos un valor único

                do{
                    pos = (int) (Math.random() * tamProblematica) + 1;
                    prob = ProyectoFinalProgIiApplication.problematica.mostrarPosicionObj(pos);

                    // Validación principal: Asegurar que la problemática exista y no sea un duplicado
                    if (prob != null && !buscar(temp.dato.id_dep)) {
                        existeDuplicado = false; // La combinación es ÚNICA
                        exitoEncontrado = true; // Encontramos lo que buscábamos
                    } else {
                        existeDuplicado = true; // El valor sigue siendo un duplicado o es nulo
                    }

                    intentos++;

                    if (intentos > 30){
                        existeDuplicado = false; // Forzar la salida si se agotan los intentos
                        break;
                    }

                    // **++ CORRECCIÓN DE LA CONDICIÓN: Usar '!=' o '!' para la comparación ++**
                } while(existeDuplicado); // Repetir mientras AÚN exista un duplicado

                // **++ Crear Evaluación SOLO si se encontró una Problemática ÚNICA ++**
                if (exitoEncontrado) {
                    valorImpacto = (int) (Math.random() * 100);

                    Evaluador ObjEvaluador = new Evaluador(temp.dato, prob, valorImpacto);

                    this.agregarFinal(new c_nodo_Eval(ObjEvaluador));
                }
                // Si el bucle terminó por `break;` (intentos agotados), simplemente no se crea la evaluación.
            }

            // Esta línea es la que AVANZA el departamento, asegurando que no se repita el mismo
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

    public boolean buscar(String idDepartamento) {
        c_nodo_Eval temp = this.cab;

        while (temp != null) {
            if (idDepartamento.equalsIgnoreCase(temp.dato.getDpto().id_dep)) {
                return true;
            }
            temp = temp.sig;
        }
        return false;
    }// fin del metodo de buscar un elemento

}
