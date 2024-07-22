/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea_1_progra_ii;

import tarea_1_progra_ii.Multa;

/**
 *
 * @author ar466
 */
public class Transito {
    private Multa[] multas;
    private int contador;

    public Transito() {
        multas = new Multa[100];
        contador = 0;
    }

    public Multa buscarMulta(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (multas[i].getCodigo() == codigo) {
                return multas[i];
            }
        }
        return null;
    }

    public String agregarMulta(int codigo, String nombreInfractor, String tipo) {
        if (contador >= 100) {
            return "No hay espacio en el sistema para más multas.";
        }

        if (buscarMulta(codigo) != null) {
            return "El código de la multa ya existe.";
        }

        multas[contador++] = new Multa(codigo, nombreInfractor, tipo);
        return "Multa agregada: Código " + codigo + ", Nombre " + nombreInfractor + ", Tipo " + tipo;
    }

    public String pagarMulta(int codigo) {
        Multa multa = buscarMulta(codigo);
        if (multa != null) {
            return multa.pay();
        } else {
            return "No se encontró la multa con código " + codigo;
        }
    }

    public String imprimirMultas() {
        String resultado = "";
        for (int i = 0; i < contador; i++) {
            resultado += multas[i].print() + "\n";
        }
        return resultado;
    }

    public String imprimirResumen() {
        int pagadas = 0;
        int pendientes = 0;
        double montoPagadas = 0;
        double montoPendientes = 0;

        for (int i = 0; i < contador; i++) {
            if (multas[i].isPagada()) {
                pagadas++;
                montoPagadas += multas[i].getMontoAPagar();
            } else {
                pendientes++;
                montoPendientes += multas[i].getMontoAPagar();
            }
        }

        return "Cantidad de Multas generadas: " + contador +
               "\nCantidad de Multas Pagadas: " + pagadas + " por un monto de Lps. " + montoPagadas +
               "\nCantidad de Multas Pendientes: " + pendientes + " por un monto de Lps. " + montoPendientes;
    }
}

