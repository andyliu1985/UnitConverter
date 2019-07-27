package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class GallonLitreConverter implements Converter {
    @Override
    public String convertFromMid(float value) {
        float result = value / 3.785f;
        return String.format("%.2f", result);
    }

    @Override
    public String convertToMid(float value) {
        float result = value * 3.785f;
        return String.format("%.2f", result);
    }
}
