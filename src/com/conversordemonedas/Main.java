package com.conversordemonedas;

import java.util.HashMap;

public class Main {
    private static HashMap<Currency, Double> moneda = new HashMap<>(6);

    public static void main(String[] args) {
        moneda.put(Currency.DOLAR, 3.79);
        moneda.put(Currency.EURO,4.01);
        moneda.put(Currency.WON_SUR_COREANO, 0.0028);
        moneda.put(Currency.LIBRA_ESTERLINA, 4.61);
        moneda.put(Currency.YEN_JAPONES, 0.025);


        new Gui();

    }

    public static double Convertir(double amount, Currency currency) {
        return amount/moneda.get(currency);
    }
}
