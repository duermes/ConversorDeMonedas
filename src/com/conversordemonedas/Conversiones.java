package com.conversordemonedas;

import java.util.HashMap;
public class Conversiones {
    private HashMap<Currency, Double> moneda;

    public Conversiones() {
        moneda = new HashMap<>(6);
        moneda.put(Currency.DOLAR, 3.79);
        moneda.put(Currency.EURO, 4.01);
        moneda.put(Currency.WON_SUR_COREANO, 0.0028);
        moneda.put(Currency.LIBRA_ESTERLINA, 4.61);
        moneda.put(Currency.YEN_JAPONES, 0.025);

    }

    /**
     *
     * Convertir de moneda peruana a otra moneda extranjera
     */
    public double ConvertirDePen(double amount, Currency currency) {

        return amount/moneda.get(currency);
    }

    public double ConvertirAPen(double amount, Currency currency) {

        return  amount*moneda.get(currency);
    }

    public double nombre(String nombre) {
        return moneda.get(nombre);
    }

    public HashMap<Currency, Double> getMoneda() {
        return moneda;
    }

    public void setMoneda(HashMap<Currency, Double> moneda) {
        this.moneda = moneda;
    }
}
