package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class CelsiusToKelvinConverter extends Converter {

    private float result = 0;

    public CelsiusToKelvinConverter() {

    }

    public CelsiusToKelvinConverter(FahrenheitToCelsiusConverter fcc, float value) {
        String result = fcc.convert(value);
        this.result = Float.valueOf(result);
    }

    public String convert(float value) {
        float result = value + 273.15f;
        return String.format("%.2f", result);
    }

    public float getResult() {
        return this.result;
    }


}
