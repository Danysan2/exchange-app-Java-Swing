package com.conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignApp extends JFrame {
    private JPanel MainPanel;
    private JComboBox<String> divisaOrigen;
    private JComboBox<String> divisaDetino;
    private JTextField userInformation;
    private JPanel panel2;
    private JLabel Lbl_MensajeBienvenida;
    private JPanel panel_info;
    private JLabel Lbl_monedaActual;
    private JLabel monedaConvertida;
    private JLabel Lbl_second;
    private JButton btn_enviar;
    private String info_client;
    private Conversor conversor;

    public DesignApp() {
        conversor = new Conversor();
        btn_enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarConversion();
            }
        });
    }

    private void realizarConversion() {
        String seleccion1 = (String) divisaOrigen.getSelectedItem();
        String seleccion2 = (String) divisaDetino.getSelectedItem();

        double cantidad;

        try {
            cantidad = Double.parseDouble(userInformation.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa una cantidad válida.");
            return;
        }


        double resultado = conversor.convertir(seleccion1, seleccion2, cantidad);

        // Mostrar el resultado en una etiqueta o en un cuadro de diálogo
        monedaConvertida.setText("Resultado: " + resultado + " " + seleccion2);
    }

    class Conversor {
        public double convertir(String origen, String destino, double cantidad) {
        double tasa = 1; // Tasa de conversión inicial

        if (origen.equals("Dolares") && destino.equals("Pesos colombianos")) {
            tasa = 4.500;
        } else if (origen.equals("Pesos colombianos") && destino.equals("Dolares")) {
            tasa = 0.00023;
        } else if (origen.equals("Euros") && destino.equals("Dolares")) {
            tasa = 1.05;
        } else if (origen.equals("Dolares") && destino.equals("Euros")) {
            tasa = 0.95;
        } else if (origen.equals("Libras esterlinas") && destino.equals("Pesos colombianos")) {
            tasa = 5.496;
        } else if (origen.equals("Pesos colombianos") && destino.equals("Libras esterlinas")) {
            tasa = 0.00018;
        } else if (origen.equals("Euros") && destino.equals("Libras esterlinas")) {
            tasa = 0.83;
        } else if (origen.equals("Libras esterlinas") && destino.equals("Euros")) {
            tasa = 1.20;
        } else if (origen.equals("Libras esterlinas") && destino.equals("Dolares")) {
            tasa = 1.26;
        } else if (origen.equals("Dolares") && destino.equals("Libras esterlinas")) {
            tasa = 0.79;
        }

        // Agrega más conversiones según sea necesario

        return cantidad * tasa; // Retorna el resultado de la conversión
    }
    }

    public static void main(String[] args) {
        DesignApp start = new DesignApp();
        start.setContentPane(start.MainPanel);
        start.setTitle("CHANGE VALUE");
        start.setSize(700, 500);
        start.setVisible(true);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

