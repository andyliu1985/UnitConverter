package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class FahrenheitToCelsiusConverter implements Converter {
    @Override
    public String convert(float value) {
        float result = ((value - 32) * 5 / 9);
        return String.format("%.2f", result);
    }
}
