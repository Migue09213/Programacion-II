package co.edu.umanizales.proyectofinalprogii.controlador;

import co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication;

import java.io.IOException;

import static co.edu.umanizales.proyectofinalprogii.ProyectoFinalProgIiApplication.*;

public class GestorDatos {

    //---------------------

    public GestorDatos() {
    }

    //------------------------
    //Reportes Departamentales:

    public String MostrarDepConProb() {
        c_nodo_LD tempD;
        tempD = ProyectoFinalProgIiApplication.departamento.cab;
        String departamentoMostrarProb = "";
        while (tempD != null) {
            c_nodo_Eval tempE;
            tempE = Evaluador.cab;
            departamentoMostrarProb = departamentoMostrarProb + '\n' + "Departamento: " + tempD.dato.getNombre() + "" + '\n';
            while (tempE != null) {
                if (tempE.dato.getDpto().getNombre().equalsIgnoreCase(tempD.dato.getNombre())) {
                    departamentoMostrarProb = departamentoMostrarProb + '\n' + "Problematica: " + tempE.dato.getProblema() + '\n';
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
        String valoracionPorProb = "";
        int valorTotal = 0;
        while (tempP != null) {
            c_nodo_Eval tempE;
            tempE = Evaluador.cab;
            valoracionPorProb = valoracionPorProb + '\n' + "Problemática: " + tempP.dato.getNombreProb() + "" + '\n';
            try {
                valorTotal = 0;
                while (tempE != null) {
                    if (tempE.dato.getProblema().getNombreProb().equalsIgnoreCase(tempP.dato.getNombreProb())) {
                        valoracionPorProb = valoracionPorProb + "Valor: " + tempE.dato.getValor_impacto() + "   " + "Departamento: " + tempE.dato.getDpto().getNombre() + '\n';
                        valorTotal = valorTotal + tempE.dato.getValor_impacto();
                    }
                    tempE = tempE.sig;
                }//fin while
            } catch (NullPointerException e) {
            }
            valoracionPorProb = valoracionPorProb + '\n' + "Valor Total: " + valorTotal + '\n' + '\n';
            tempP = tempP.sig;
        }
        return valoracionPorProb;
    }

    public String ImpactoTotalDepartamento() {
        c_nodo_LD tempD;
        tempD = ProyectoFinalProgIiApplication.departamento.cab;
        String impactoTotalDepartamento = "";

        while (tempD != null) {
            c_nodo_Eval tempE;
            tempE = Evaluador.cab;
            impactoTotalDepartamento = impactoTotalDepartamento + '\n' + "Departamento: " + tempD.dato.getNombre() + '\n';
            try {

                int valorImpactoTotalDepartamento;
                valorImpactoTotalDepartamento = 0;

                while (tempE != null) {
                    if (tempE.dato.getDpto().getId_dep().equalsIgnoreCase(tempD.dato.id_dep)) {

                        valorImpactoTotalDepartamento = valorImpactoTotalDepartamento + tempE.dato.valor_impacto;

                        impactoTotalDepartamento = impactoTotalDepartamento + "Valor Impacto Total: " + valorImpactoTotalDepartamento + '\n';
                    }
                    tempE = tempE.sig;
                } // fin While
            } catch (NullPointerException e) {
            }
            tempD = tempD.sig;
        }
        return impactoTotalDepartamento;
    }

    //-------------------------
    //Reportes de problemáticas Críticas:

    public String MayorValorAcumuladoProblema() {
        if (ProyectoFinalProgIiApplication.Evaluador == null || ProyectoFinalProgIiApplication.Evaluador.cab == null) {
            return "No hay evaluaciones registradas\n";
        }

        c_nodo_Eval tempE;
        tempE = ProyectoFinalProgIiApplication.Evaluador.cab;
        String MayorValorAcumuladoProblema = "";
        c_nodo_Eval nodoMayorImpacto;
        nodoMayorImpacto = ProyectoFinalProgIiApplication.Evaluador.cab;

        // Buscar el nodo con mayor impacto
        while (tempE != null) {
            if (tempE.dato.valor_impacto > nodoMayorImpacto.dato.valor_impacto) {
                nodoMayorImpacto = tempE;
            }
            tempE = tempE.sig;
        }

        // Mostrar el departamento con mayor impacto
        MayorValorAcumuladoProblema = '\n' + "=== DEPARTAMENTO CON MAYOR IMPACTO ===" + '\n' + "Departamento: " + nodoMayorImpacto.dato.getDpto().getNombre() + '\n' + "Valor Impacto: " + nodoMayorImpacto.dato.valor_impacto + '\n' + "Problemática: " + nodoMayorImpacto.dato.getProblema().getNombreProb() + '\n';

        return MayorValorAcumuladoProblema;
    }

    public String listarDepartamentosPorImpacto() {
        if (ProyectoFinalProgIiApplication.Evaluador == null || ProyectoFinalProgIiApplication.Evaluador.cab == null) {
            return "No hay departamentos registradas\n";
        }

        // Contar elementos
        c_nodo_Eval tempE = ProyectoFinalProgIiApplication.Evaluador.cab;
        int contador = 0;
        while (tempE != null) {
            contador++;
            tempE = tempE.sig;
        }

        // Crear arreglos
        String[] departamentos = new String[contador];
        int[] impactos = new int[contador];
        String[] problemas = new String[contador];

        // Llenar arreglos
        tempE = ProyectoFinalProgIiApplication.Evaluador.cab;
        int index = 0;
        while (tempE != null) {
            departamentos[index] = tempE.dato.getDpto().getNombre();
            impactos[index] = tempE.dato.valor_impacto;
            problemas[index] = tempE.dato.getProblema().getNombreProb();
            index++;
            tempE = tempE.sig;
        }

        // Ordenar (burbuja de mayor a menor)
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (impactos[j] < impactos[j + 1]) {
                    int tempImpacto = impactos[j];
                    impactos[j] = impactos[j + 1];
                    impactos[j + 1] = tempImpacto;

                    String tempDepto = departamentos[j];
                    departamentos[j] = departamentos[j + 1];
                    departamentos[j + 1] = tempDepto;

                    String tempProb = problemas[j];
                    problemas[j] = problemas[j + 1];
                    problemas[j + 1] = tempProb;
                }
            }
        }

        // Mostrar TODOS ordenados
        String listarDepartamentosPorImpacto = '\n' + "=== DEPARTAMENTOS AFECTADOS (ordenados por impacto) ===" + '\n';
        for (int i = 0; i < contador; i++) {
            listarDepartamentosPorImpacto = listarDepartamentosPorImpacto + (i + 1) + ". " +
                    departamentos[i] + " | Impacto: " + impactos[i] +
                    '\n' + "Problemas: " + problemas[i] + '\n';
        }

        return listarDepartamentosPorImpacto;
    }

    public String MostrarEstadisticas() {
        if (ProyectoFinalProgIiApplication.Evaluador == null || ProyectoFinalProgIiApplication.Evaluador.cab == null) {
            return "No hay evaluaciones registradas\n";
        }

        c_nodo_Eval tempE;
        tempE = ProyectoFinalProgIiApplication.Evaluador.cab;

        int suma = 0;
        int contador = 0;
        int maximo = Integer.MAX_VALUE;
        int minimo = Integer.MIN_VALUE;

        while (tempE != null) {
            int valorImpacto = tempE.dato.valor_impacto;
            suma = suma + valorImpacto;
            contador++;

            if (valorImpacto > maximo) {
                maximo = valorImpacto;
            }
            if (valorImpacto < minimo) {
                minimo = valorImpacto;
            }

            tempE = tempE.sig;
        }

        double promedio = (double) suma / contador;

        String MostrarEstadisticas = '\n' + "=== Estadisticas ===" + '\n' +
                "Promedio: " + String.format("%.2f", promedio) + '\n' +
                "Maximo: " + maximo + '\n' +
                "Minimo: " + minimo + '\n' +
                "Total evaluaciones: " + contador + '\n';

        return MostrarEstadisticas;
    }

    //-------------------------
    //Reportes de Indicadores Comunes:

    public String identificarIndicadoresComunes() {

        StringBuilder resultado;
        resultado = new StringBuilder(); //se usa un StringBuilder para hacer más eficiente la creación de cadenas de texto

        c_nodo_LI tempI;
        tempI = indicadores.cab;

        c_nodo_LP tempP;


        while (tempI != null) {

            //inicializar el puntero para recorrer la lista de Problematicas
            tempP = problematica.cab; //aqui reinicia el puntero
            int aparicionesTotales = 0; //aqui reiniciar el contador de apariciones

            String problematicasEncontradas = ""; //aqui se crea la variable que guardará la problemáticas que encuentre

            while (tempP != null) {

                if (tempP.dato.toString()
                        .contains(tempI.dato.id_indicador)) {

                    aparicionesTotales++;
                    problematicasEncontradas = problematicasEncontradas + "   *" + tempP.dato.nombreProb + '\n';
                }
                tempP = tempP.sig;
            }

            //aqui genera el reporte
            resultado.append("\nEl Indicador {").append(tempI.dato.nombre).append("} ");

            if (aparicionesTotales == 0) {
                resultado.append(" no aparece").append('\n');

            } else if (aparicionesTotales == 1) {
                        resultado.append("\naparece 1 vez, por lo tanto NO es común: \n");

            } else if (aparicionesTotales > 1) {
                resultado.append("\naparece ").append(aparicionesTotales)
                        .append(" veces en la problemática: \n")
                        .append(problematicasEncontradas);
            } //fin del reporte

            tempI = tempI.sig; //aqui continúa al siguiente indicador
        }
        return resultado.toString();
    }

    //-------------------------
    //Reportes de Palabras Clave:

    public String analisisFrecuenciaPalabrasClave() {
        if (ProyectoFinalProgIiApplication.problematica == null || ProyectoFinalProgIiApplication.problematica.cab == null) {
            return "No hay palabras registradas\n";
        }

        c_nodo_LP tempP;
        tempP = ProyectoFinalProgIiApplication.problematica.cab;
        String analisisFrecuenciaPalabrasClave = '\n' + "=== ANALISIS DE FRECUENCIA DE PALABRAS CLAVE ===" + '\n';

        // Contar total de problemáticas para el análisis
        int totalProblematicas = 0;
        c_nodo_LP tempContador = tempP;
        while (tempContador != null) {
            totalProblematicas++;
            tempContador = tempContador.sig;
        }

        // Crear arreglo temporal para almacenar palabras y sus frecuencias
        String[] palabras = new String[totalProblematicas * 10]; // Estimación de palabras
        int[] frecuencias = new int[totalProblematicas * 10];
        int totalPalabras = 0;

        // Recorrer todas las problemáticas
        while (tempP != null) {
            String palabrasClave = tempP.dato.palabrasClave;

            if (palabrasClave != null && !palabrasClave.isEmpty()) {
                // Separar palabras por coma, punto y coma, o espacio
                String[] palabrasSeparadas = palabrasClave.split("[,;\\s]+");

                // Contar cada palabra
                for (int i = 0; i < palabrasSeparadas.length; i++) {
                    String palabra = palabrasSeparadas[i].trim().toLowerCase();

                    if (!palabra.isEmpty()) {
                        // Buscar si la palabra ya existe
                        boolean encontrada = false;
                        for (int j = 0; j < totalPalabras; j++) {
                            if (palabras[j].equals(palabra)) {
                                frecuencias[j]++;
                                encontrada = true;
                                break;
                            }
                        }

                        // Si no existe, agregarla
                        if (!encontrada) {
                            palabras[totalPalabras] = palabra;
                            frecuencias[totalPalabras] = 1;
                            totalPalabras++;
                        }
                    }
                }
            }

            tempP = tempP.sig;
        }

        // Ordenar por frecuencia (de mayor a menor)
        for (int i = 0; i < totalPalabras - 1; i++) {
            for (int j = 0; j < totalPalabras - i - 1; j++) {
                if (frecuencias[j] < frecuencias[j + 1]) {
                    // Intercambiar frecuencias
                    int tempFreq = frecuencias[j];
                    frecuencias[j] = frecuencias[j + 1];
                    frecuencias[j + 1] = tempFreq;

                    // Intercambiar palabras
                    String tempPalabra = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = tempPalabra;
                }
            }
        }

        // Generar reporte
        for (int i = 0; i < totalPalabras; i++) {
            analisisFrecuenciaPalabrasClave = analisisFrecuenciaPalabrasClave +
                    (i + 1) + ". " + palabras[i] +
                    " - Frecuencia: " + frecuencias[i] + " veces" + '\n';
        }

        return analisisFrecuenciaPalabrasClave;
    }

    public String IdentificarTerminosRecurrentes() {
        if (ProyectoFinalProgIiApplication.problematica == null || ProyectoFinalProgIiApplication.problematica.cab == null) {
            return "No hay terminos registrados\n";
        }

        c_nodo_LP tempP;
        tempP = ProyectoFinalProgIiApplication.problematica.cab;
        String IdentificarTerminosRecurrentes = '\n' + "=== Terminos Recurrentes ===" + '\n';

        int totalProblematicas = 0;
        c_nodo_LP tempContador = tempP;
        while (tempContador != null) {
            totalProblematicas++;
            tempContador = tempContador.sig;
        }

        String[] palabras = new String[totalProblematicas * 30];
        int[] frecuencias = new int[totalProblematicas * 30];
        int totalPalabras = 0;

        while (tempP != null) {
            String palabrasClave = tempP.dato.palabrasClave;
            if (palabrasClave != null && !palabrasClave.isEmpty()) {
                String[] palabrasSeparadas = palabrasClave.split("[,;\\s]+");

                for(int i = 0; i < palabrasSeparadas.length; i++) {
                    String palabra = palabrasSeparadas[i].trim().toLowerCase();

                    if (!palabra.isEmpty()) {
                        boolean encontrada = false;
                        for (int j = 0; j < totalPalabras; j++) {
                            if (palabras[j].equals(palabra)) {
                                frecuencias[j]++;
                                encontrada = true;
                                break;
                            }
                        }

                        if (!encontrada) {
                            palabras[totalPalabras] = palabra;
                            frecuencias[totalPalabras] = 1;
                            totalPalabras++;
                        }
                    }
                }
            }
            tempP = tempP.sig;
        }

        int limite = totalPalabras < 30 ? 30 : totalPalabras;
        for (int i = 0; i < limite; i++) {
            if (frecuencias[i] > 1) {
                IdentificarTerminosRecurrentes = IdentificarTerminosRecurrentes +
                        (i + 1) + ". " + palabras[i] +
                        "Aparece" + frecuencias[i] + "Veces" + '\n';
            }
        }

        return IdentificarTerminosRecurrentes;
    }

    //-------------------------

}
