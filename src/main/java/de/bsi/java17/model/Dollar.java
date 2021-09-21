package de.bsi.java17.model;

public non-sealed class Dollar extends Currency {

    @Override
    public String printValue(double value) {
        return value + "$";
    }

}
