package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class GallonLitreConverter implements Converter {
    @Override
    public float convertFromMid(float value) {
        float result = value / 3.78541f;
        return result;
    }

    @Override
    public float convertToMid(float value) {
        float result = value * 3.78541f;
        return result;
    }
}
