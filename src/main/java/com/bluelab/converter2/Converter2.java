package com.bluelab.converter2;

/**
 * Created by Hunter on 27/07/2019.
 */
public class Converter2 {
    public static void main(String[] args) {
        System.out.println();
    }

    float fToK() {
        FahrenheitCelsiusConverter fcc = new FahrenheitCelsiusConverter();
        KelvinCelsiusConverter kcc = new KelvinCelsiusConverter();
        float temp = fcc.fToC(1);
        float result = kcc.cToK(temp);

        return result;
    }
}
