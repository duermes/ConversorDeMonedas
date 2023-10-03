package com.conversordemonedas;

import com.conversordemonedas.gui.MainFrame;

public class Main {

    public static void main(String[] args) {
        Conversiones c = new Conversiones();
        new MainFrame();
        System.out.println(c.ConvertirAPen(10, Currency.DOLAR));
        System.out.println(Currency.DOLAR);

    }

}
