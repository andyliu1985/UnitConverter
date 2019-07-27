package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class MillilitreLitreConverter implements Converter {

    @Override
    public float convertToMid(float value) {
        float result = value / 1000f;
        return result;
    }

    @Override
    public float convertFromMid(float value) {
        float result = value * 1000f;
        return result;
    }
}
