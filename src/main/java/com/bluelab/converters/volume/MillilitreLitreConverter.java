package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class MillilitreLitreConverter implements Converter {

    @Override
    public String convertToMid(float value) {
        float result = value / 1000f;
        return String.format("%.2f", result);
    }

    @Override
    public String convertFromMid(float value) {
        float result = value * 1000f;
        return String.format("%.2f", result);
    }
}
