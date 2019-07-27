package com.bluelab.converters3.temperature;

import com.bluelab.converters3.Converter;

public class FahrenheitToCelsiusConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = ((value - 32) * 5 / 9);
        return String.format("%.2f", result);
    }
}
