package com.shq.utils;

public enum TipoTransportes{

	    SEA (45.00);

	    private final Double costo;   // en dolares
	    TipoTransportes(Double costo) {
	        this.costo = costo;
	    }
	    public Double costo() { return costo; }
	
}
