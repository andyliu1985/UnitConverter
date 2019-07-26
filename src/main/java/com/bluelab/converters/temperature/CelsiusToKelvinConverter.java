package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class CelsiusToKelvinConverter implements Converter {

    float result;

    public CelsiusToKelvinConverter() {
        this.convert(this.result);
    }

    public CelsiusToKelvinConverter(String result) {}

    public CelsiusToKelvinConverter(FahrenheitToCelsiusConverter fcc, float value) {
        String result = fcc.convert(value);
        this.result = Float.valueOf(result);
    }

    @Override
    public String convert(float value) {
        float result = value + 273.15f;
        return String.format("%.2f", result);
    }




}
