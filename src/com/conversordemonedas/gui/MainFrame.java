package com.conversordemonedas.gui;

import com.conversordemonedas.Conversiones;
import com.conversordemonedas.Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel titulo;
    private JTextField cantidadtf;
    private JButton convertirButton;
    private JLabel mensaje;
    private JLabel from;
    private JLabel to;
    private JLabel resultado;
    private JLabel advertencia;
    private JComboBox<Currency> seleccionDe;
    private JComboBox<Currency> seleccionA;
    private Conversiones conversiones = new Conversiones();
    public MainFrame() {

        super.setTitle("Conversor de monedas");
        super.setSize(400,400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(null);

        titulo = new JLabel();
        mensaje = new JLabel();
        convertirButton = new JButton("Convertir");
        cantidadtf = new JTextField();
        from = new JLabel();
        to = new JLabel();
        resultado = new JLabel();
        seleccionDe = new JComboBox<>();
        seleccionA = new JComboBox<>();
        advertencia = new JLabel();

        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);
        titulo.setBounds(100,10,200,40);
        titulo.setText("Conversor de monedas");
        titulo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));

        convertirButton.setFont(font);
        convertirButton.setBounds(140,250,120,30);

        mensaje.setText("Importe:");
        mensaje.setBounds(80,100,70,40);
        mensaje.setFont(font);

        from.setText("De:");
        from.setBounds(80,140,70,40);
        from.setFont(font);

        to.setText("A:");
        to.setBounds(80,180,70,40);
        to.setFont(font);

        resultado.setText("");
        resultado.setBounds(140,290,120,30);
        resultado.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        cantidadtf.setBounds(165,105,100,30);

        advertencia.setText("");
        advertencia.setBounds(80,280,300,30);
        advertencia.setFont(font);

        seleccionDe.addItem(Currency.DOLAR);
        seleccionDe.addItem(Currency.EURO);
        seleccionDe.addItem(Currency.YEN_JAPONES);
        seleccionDe.addItem(Currency.LIBRA_ESTERLINA);
        seleccionDe.addItem(Currency.PEN);
        seleccionDe.setBounds(160, 145, 100, 30);
        seleccionA.setBounds(160, 185, 100, 30);


        accionesForm();
        super.add(titulo);
        super.add(convertirButton);
        super.add(mensaje);
        super.add(from);
        super.add(to);
        super.add(cantidadtf);
        super.add(seleccionA);
        super.add(seleccionDe);
        super.add(resultado);
        super.add(advertencia);

        super.setVisible(true);

    }

    private void accionesForm() {
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                advertencia.setText("");
                try {
                    int cantidad = Integer.parseInt(cantidadtf.getText());
                    if (seleccionDe.getSelectedItem() != Currency.PEN) {
                        System.out.println(seleccionDe.getSelectedItem());
                        double asd = conversiones.ConvertirAPen(cantidad, (Currency) seleccionDe.getSelectedItem());
                        System.out.println("OBJETO: "+asd);
                        resultado.setText(String.valueOf(asd));

                    } else {
                        double asd = conversiones.ConvertirDePen(cantidad, (Currency) seleccionA.getSelectedItem());
                        System.out.println(seleccionA.getSelectedItem());
                        System.out.println("OBJETO: "+asd);
                        resultado.setText(String.valueOf(asd));
                    }
                } catch (NumberFormatException nfe) {
                    advertencia.setText("Debes de ingresar un número");
                }


            }
        });
        seleccionDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionA.removeAllItems();
                if (seleccionDe.getSelectedItem() != Currency.PEN) {
                    seleccionA.addItem(Currency.PEN);
                } else {
                    seleccionA.addItem(Currency.DOLAR);
                    seleccionA.addItem(Currency.EURO);
                    seleccionA.addItem(Currency.YEN_JAPONES);
                    seleccionA.addItem(Currency.LIBRA_ESTERLINA);
                    seleccionA.removeItem(Currency.PEN);
                }
            }
        });

    }

}
