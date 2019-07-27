package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class KelvinCelsiusConverter implements Converter {
    public static void main(String[] args) {
        System.out.println();
    }

    @Override
    public String convertFromMid(float value) {
        float result = value + 273.15f;
        return String.format("%.2f", result);
    }

    @Override
    public String convertToMid(float value) {
        float result = value - 273.15f;
        return String.format("%.2f", result);
    }

}
