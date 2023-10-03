package com.conversordemonedas;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private JLabel titulo;
    private JTextField cantidad;
    private JButton convertir;

    public Gui() {
        super.setTitle("Conversor de monedas");
        super.setSize(400,400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(null);

        titulo = new JLabel();
        convertir = new JButton("Convertir");
        cantidad = new JTextField();


        titulo.setBounds(100,10,200,40);
        titulo.setText("Conversor de monedas");
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 16);
        titulo.setFont(font);
        convertir.setFont(font);

        convertir.setBounds(100,300,50,40);

        super.add(titulo);





        super.setVisible(true);

    }

}
