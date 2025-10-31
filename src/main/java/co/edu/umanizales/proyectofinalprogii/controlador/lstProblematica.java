package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Departamento;
import co.edu.umanizales.proyectofinalprogii.model.Indicador;
import co.edu.umanizales.proyectofinalprogii.model.Problematica;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication.indicadores;

@Getter
@Setter
public class lstProblematica {
    public c_nodo_LP cab;
    public c_nodo_LP ult;
    public int tam;

    //---------------------

    public lstProblematica() throws IOException {
        cab = null;
        ult = null;
        tam = 0;
        cargarProblematicas();
    }

    //---------------------

    private String problematicasFileName = "C:\\Users\\danie\\IdeaProjects\\Proyecto final Prog II\\src\\main\\resources\\lista_problematicas.csv";


    private lstIndicador generarIndicador() throws IOException {
        c_nodo_LI temp = indicadores.cab;
        int CantDatos = 0;
        while (CantDatos == 0 ){
            CantDatos = (int) (Math.random()*5);
        }
        lstIndicador lstTemp = new lstIndicador();
        int cad = 1;
        while (cad < CantDatos){
            int datoObjetivo = (int) (Math.random()*30);
            int  pos = 1;
            temp = indicadores.cab;
            while (pos < datoObjetivo){
                temp = temp.sig;
                pos++;
            }
            cad++;
            lstTemp.agregarFinal(new c_nodo_LI(temp.dato));
        }
        return lstTemp;
    }


    public void cargarProblematicas() throws IOException {
        String codigo, nombre, tipo, palabras;
        String[] parts;

        try (BufferedReader br = new BufferedReader(new FileReader(problematicasFileName))) {

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
                    tipo = (parts[2]);
                    palabras = parts[3];

                    // llamar un metedo para caRGAR indicadores de problrnataica


                    this.agregarFinal(new c_nodo_LP(new Problematica(codigo, nombre, tipo, palabras,
                            generarIndicador())));

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

    public void agregarFinal(c_nodo_LP n_nodo) {
        if (this.estaVacio()) {
            this.setCab(n_nodo);
            this.setUlt(n_nodo);
        }else{
            c_nodo_LP temp = this.getUlt();
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
            c_nodo_LP temp;
            temp = this.getCab();

            while (temp != null) { //iniciar el ciclo de recorrido
                resultado_cadena = resultado_cadena + temp.dato + "\n";
                temp = temp.getSig();
            }
            return resultado_cadena;
        }//fin else
    }//fin metodo mostrar

    public Problematica mostrarPosicionObj(int pos) {
        int cont = 0;
        c_nodo_LP temp = null;
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

}
