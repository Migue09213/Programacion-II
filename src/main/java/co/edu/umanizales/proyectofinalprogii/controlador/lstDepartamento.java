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

    public lstDepartamento() {
        cab = null;
        ult = null;
        tam = 0;
    }

    //------------------------

    @Value("${departamentos_filename}")
    private String departamentosFileName;

    public void cargarDepartamentos() throws IOException, URISyntaxException {

        Path filepath = Paths.get(ClassLoader.getSystemResource(departamentosFileName).toURI());

        try (BufferedReader br = new BufferedReader(new FileReader(filepath.toFile()))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                String codigo, nombre;
                int poblacion;

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

            System.out.println("> Buscando Archivo: " + "|" + departamentosFileName + "|");
            System.out.println("> Archivo Cargado con éxito, " + this.getTam() + " Elementos encontrados");

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



}
