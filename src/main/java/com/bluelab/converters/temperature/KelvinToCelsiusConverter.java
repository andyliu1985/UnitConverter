package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class KelvinToCelsiusConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value -273.15f;
        return String.format("%.2f", result);
    }
}
