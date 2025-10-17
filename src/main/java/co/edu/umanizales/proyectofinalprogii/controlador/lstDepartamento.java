package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.model.Departamento;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter
public class lstDepartamento {
    public c_nodo_LD cab;
    public c_nodo_LD ult;
    public int tam;
    //------------------------

    public lstDepartamento() throws IOException, URISyntaxException {
        cab = null;
        ult = null;
        tam = 0;
        cargarDepartamentos();
    }

    //------------------------

    private String departamentosFileName = "C:\\Users\\danie\\IdeaProjects\\Proyecto final Prog II\\src\\main\\resources\\codigos_departamentos.csv";

    private void cargarDepartamentos() throws IOException, URISyntaxException {
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

                    this.agregarFinal(new c_nodo_LD(new Departamento(nombre, codigo, poblacion)));

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


}
