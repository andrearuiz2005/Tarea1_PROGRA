/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea_1_progra_ii;

/**
 *
 * @author ar466
 */
public class Multa {
    private int codigo;
    private String nombreInfractor;
    private String tipo;
    private double montoAPagar;
    private boolean pagada;

    // Atributos públicos para los tipos de multa
    public double tipoGrave;
    public double tipoMedio;
    public double tipoLeve;

    public Multa(int codigo, String nombreInfractor, String tipo) {
        this.codigo = codigo;
        this.nombreInfractor = nombreInfractor;
        this.tipo = tipo.toUpperCase();

        // Inicializar los montos según el tipo de multa
        this.tipoGrave = 5000.0;
        this.tipoMedio = 3000.0;
        this.tipoLeve = 1000.0;

        // Determinar el monto a pagar según el tipo
        if (this.tipo.equals("GRAVE")) {
            this.montoAPagar = tipoGrave;
        } else if (this.tipo.equals("MEDIO")) {
            this.montoAPagar = tipoMedio;
        } else {
            this.montoAPagar = tipoLeve;
            this.tipo = "LEVE";
        }

        this.pagada = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public boolean isPagada() {
        return pagada;
    }

    public String print() {
        String estado = pagada ? "Pagada por un monto de Lps " + montoAPagar : "Multa pendiente";
        return "Código: " + codigo + ", Nombre Infractor: " + nombreInfractor + ", Tipo: " + tipo + ", " + estado;
    }

    public String pay() {
        this.pagada = true;
        return "Multa con Código " + codigo + " fue pagada por un monto de Lps. " + montoAPagar;
    }
}
