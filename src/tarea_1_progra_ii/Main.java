/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea_1_progra_ii;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author ar466
 */
public class Main {
    private Transito transito;
    private JTextArea textArea;

    public Main() {
        transito = new Transito();
        crearInterfaz();
    }

    private void crearInterfaz() {
        JFrame frame = new JFrame("Sistema de Tránsito");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Código:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField codigoText = new JTextField(20);
        codigoText.setBounds(100, 20, 165, 25);
        panel.add(codigoText);

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(10, 50, 80, 25);
        panel.add(nameLabel);

        JTextField nombreText = new JTextField(20);
        nombreText.setBounds(100, 50, 165, 25);
        panel.add(nombreText);

        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setBounds(10, 80, 80, 25);
        panel.add(tipoLabel);

        JTextField tipoText = new JTextField(20);
        tipoText.setBounds(100, 80, 165, 25);
        panel.add(tipoText);

        JButton addButton = new JButton("Agregar Multa");
        addButton.setBounds(10, 110, 150, 25);
        panel.add(addButton);

        JButton payButton = new JButton("Pagar Multa");
        payButton.setBounds(10, 140, 150, 25);
        panel.add(payButton);

        JButton printButton = new JButton("Imprimir Multas");
        printButton.setBounds(10, 170, 150, 25);
        panel.add(printButton);

        JButton resumenButton = new JButton("Resumen");
        resumenButton.setBounds(10, 200, 150, 25);
        panel.add(resumenButton);

        textArea = new JTextArea();
        textArea.setBounds(10, 230, 560, 120);
        textArea.setEditable(false);
        panel.add(textArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codigoText.getText().isEmpty() || nombreText.getText().isEmpty() || tipoText.getText().isEmpty()) {
                    textArea.setText("No se ha ingresado ningun dato");
                } else {
                    try {
                        int codigo = Integer.parseInt(codigoText.getText());
                        String nombre = nombreText.getText();
                        String tipo = tipoText.getText();
                        String resultado = transito.agregarMulta(codigo, nombre, tipo);
                        textArea.setText(resultado);
                    } catch (NumberFormatException ex) {
                        textArea.setText("Error: Código debe ser un número entero.");
                    }
                }
            }
        });

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codigoText.getText().isEmpty()) {
                    textArea.setText("No se ha ingresado ningun dato");
                } else {
                    try {
                        int codigo = Integer.parseInt(codigoText.getText());
                        String resultado = transito.pagarMulta(codigo);
                        textArea.setText(resultado);
                    } catch (NumberFormatException ex) {
                        textArea.setText("Error: Código debe ser un número entero.");
                    }
                }
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = transito.imprimirMultas();
                textArea.setText(resultado);
            }
        });

        resumenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = transito.imprimirResumen();
                textArea.setText(resultado);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}

