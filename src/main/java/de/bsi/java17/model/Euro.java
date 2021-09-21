package de.bsi.java17.model;

public final class Euro extends Currency {

    @Override
    public String printValue(double value) {
        return value + "€";
    }

}
