package com.bluelab.converters3.volume;

import com.bluelab.converters3.Converter;

public class GallonToMillilitreConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value * 3785.412f;
        return String.format("%.2f", result);
    }
}
