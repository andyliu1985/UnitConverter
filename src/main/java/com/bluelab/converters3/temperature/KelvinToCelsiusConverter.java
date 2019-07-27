package com.bluelab.converters3.temperature;

import com.bluelab.converters3.Converter;

public class KelvinToCelsiusConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value -273.15f;
        return String.format("%.2f", result);
    }
}
