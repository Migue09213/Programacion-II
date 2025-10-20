package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Indicador;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Getter
@Setter
public class lstIndicador {
    public c_nodo_LI cab;
    public c_nodo_LI ult;
    public int tam;

    //------------------------

    public lstIndicador() throws IOException {
        cab = null;
        ult = null;
        tam = 0;
    }

    //------------------------

    private String indicadoresFileName = "C:\\Users\\danie\\IdeaProjects\\Proyecto final Prog II\\src\\main\\resources\\lista_indicadores.csv";

    public void cargarIndicadores() throws IOException {
        String codigo, nombre, valor;
        String[] parts;
        int valorInt;

        try (BufferedReader br = new BufferedReader(new FileReader(indicadoresFileName))) {

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
                        System.out.println("no existen valores para el indicador");
                    }
                    valor = parts[2].replaceAll("[^0-9]", "");
                    valorInt = Integer.parseInt(valor);

                    this.agregarFinal(new c_nodo_LI(new Indicador(codigo, nombre, valorInt)));

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

    public void agregarFinal(c_nodo_LI n_nodo) {
        if (this.estaVacio()) {
            this.setCab(n_nodo);
            this.setUlt(n_nodo);
        }else{
            c_nodo_LI temp = this.getUlt();
            temp.setSig(n_nodo);
            this.setUlt(n_nodo);
        }
        this.setTam(this.getTam() + 1);
    }//Fin metodo agregarFinal

    //----------------------------

    public String mostrarTodo() {

        String resultado_cadena = "";
        if (this.estaVacio()) {
            return resultado_cadena; //retorna la lista vacía
        } else {
            c_nodo_LI temp;
            temp = this.getCab();

            while (temp != null) { //iniciar el ciclo de recorrido
                resultado_cadena = resultado_cadena + temp.dato + "\n";
                temp = temp.getSig();
            }
            return resultado_cadena;
        }//fin else
    }//fin metodo mostrarTodo
}
