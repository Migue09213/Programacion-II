package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Departamento;
import co.edu.umanizales.proyectofinalprogii.model.Indicador;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Getter
@Setter
public class lstDepartamento {
    public c_nodo_LD cab;
    public c_nodo_LD ult;
    public int tam;

    //------------------------

    public lstDepartamento() throws IOException {
        cab = null;
        ult = null;
        tam = 0;
        cargarDepartamentos();
    }

    //------------------------

    private String departamentosFileName = "C:\\Users\\danie\\IdeaProjects\\Proyecto final Prog II\\src\\main\\resources\\codigos_departamentos.csv";

    public void cargarDepartamentos() throws IOException {
        String codigo, nombre;
        int poblacion=0;
        String[] parts;

        try (BufferedReader br = new BufferedReader(new FileReader(departamentosFileName))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                parts = line.split(",");

                if (parts.length >= 3) {
                    codigo = parts[0];
                    nombre = parts[1];
                    if (parts[2] == null) {
                        System.out.println("no existe población en el departamento");
                    }
                    poblacion = Integer.parseInt(parts[2]);

                    this.agregarFinal(new c_nodo_LD(new Departamento(codigo, nombre, poblacion)));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    //------------------------

    //Operaciones de la lista
    public boolean estaVacio() {
        return cab == null;
    }

    //-------------------------

    public void agregarFinal(c_nodo_LD n_nodo) {
        if (this.estaVacio()) {
            this.setCab(n_nodo);
            this.setUlt(n_nodo);
        }else{
            c_nodo_LD temp = this.getUlt();
            temp.setSig(n_nodo);
            this.setUlt(n_nodo);
        }
        this.setTam(this.getTam() + 1);
    }//Fin metodo agregarFinal

    //----------------------------

    public String mostrarTodo(){

        String resultado_cadena = "";
        if (this.estaVacio()) {
            return resultado_cadena; //retorna la lista vacía
        }else{
            c_nodo_LD temp;
            temp = this.getCab();

            while (temp != null) { //iniciar el ciclo de recorrido
                resultado_cadena = resultado_cadena + temp.dato + "\n";
                temp = temp.getSig();
            }
            return resultado_cadena;
        }//fin else
    }//fin metodo mostrar

    public String mostrarPosicion(int pos) {
        int cont = 0;
        String r_cad = "";
        if ((pos <= 0) || (pos > this.getTam())) {
            return "Error en la posicion";
        }// fin del si para las posiciones
        else {
            if (!this.estaVacio()) {  // lista diferente vacio
                cont = 1;
                c_nodo_LD temp = this.getCab();
                while (cont != pos) {
                    cont++;
                    temp = temp.getSig();
                }// fin del mientras para el contador
                r_cad = temp.dato.toString();
            }// fin si de la lista tiene elementos
            return r_cad;
        }// fin del sino para validar la lista
    }// fin de mostrar con posicion

    //---------------------------------

    public Departamento mostrarPosicionObj(int pos) {
        int cont = 0;
        c_nodo_LD temp = null;
        if ((pos <= 0) || (pos > this.getTam())) {
            return null;
        }// fin del si para las posiciones
        else {
            if (!this.estaVacio()) {  // lista diferente vacio
                cont = 1;
                temp = this.getCab();
                while (cont != pos) {
                    cont++;
                    temp = temp.getSig();
                }// fin del mientras para el contador
            }// fin si de la lista tiene elementos
            return temp.dato;
        }// fin del sino para validar la lista
    }// fin de mostrar con posicion

    //-------------------------------

    public Departamento sacarUltimoDato () {
        c_nodo_LD temp = this.getCab();
        Departamento depa = this.ult.dato;
        while (temp.sig != this.ult) {
            temp = temp.sig;
        }
        tam--;
        this.ult = temp;
        temp.sig = null;
        return depa;
    }

    //--------------------------------

    public Departamento sacarPrimero() {
        c_nodo_LD temp = this.getCab();
        Departamento depa = temp.dato;
        this.cab = temp.sig;
        temp = null;
        tam--;
        return depa;
    }
}
