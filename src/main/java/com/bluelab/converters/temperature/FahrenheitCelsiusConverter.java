package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class FahrenheitCelsiusConverter implements Converter {
    public static void main(String[] args) {
        System.out.println();
    }

    @Override
    public String convertToMid(float value) {
        float result = ((value - 32) * 5 / 9);
        return String.format("%.2f", result);
    }

    @Override
    public String convertFromMid(float value) {
        float result = (value * 9 / 5) + 32;
        return String.format("%.2f", result);
    }
}
