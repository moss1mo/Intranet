package com.shq.utils;

public class Constantes {
	
	//COSTOS ADUANA FIJOS
	public final static Double HONORARIOS = 4000.00;
	public final static Double ASESORIA_MANEJO = 6000.00;
	public final static Double PORC_ASESORIA_MANEJO = 0.0045;
	public final static Double MANEJO = 6000.00;
	public final static Double PORC_MANEJO = 0.0045;
	public final static Double PREVALIDACION = 267.00;
	public final static Double VALIDACION = 580.00;
	public final static Double PEDIMENTO = 150.00;
	public final static Double DIGITALIZACION = 300.00;
	public final static Double PAPELERIA = 500.00;
	public final static Double IVA = 0.16;
	public final static Double PORC_SEGURO = 0.01;
	
	//COSTO POR UNIDAD (KILO) ADUANA VARIABLE CALCULADO EN PROMEDIO A DISTINTAS FACTURAS
	public final static Double OTROS_CARGOS = 2.70;
	
	//COSTOS LOGISTICA FIJOS EN DOLARES
	
	public final static Double LIBERACION_USD = 50.00;
	public final static Double VALIDATION_FEE_USD = 20.00;
	public final static Double DOCUMENTACION_USD = 25.00;
	public final static Double ADMON_FEE_USD = 10.00;
	
	public final static Double DESCONSOLIDACION = 20.00;
	public final static Double TRANSFER = 10.00;
	
	public final static Double MINIMO_METROS_CUBICOS_LOGISTICA = 1.00;
	
	//COSTOS LOGISTICA FIJOS EN PESOS
	
	//SEGUN PDF EL COSTO MARITIMO ES 45 USD POR TRANSPORTE MARITIMO SE PUSO EN UN ENUM.
	//public final static Double TRANSPORT_FEE = 850.00; 
	public final static Double TRANSPORT_FEE_MINIMO = 2900.00;
	
	
	
	public final static Double SUM_COSTOS_FIJOS_ADUANA  = Constantes.PREVALIDACION+Constantes.VALIDACION
			+Constantes.PEDIMENTO+Constantes.DIGITALIZACION+Constantes.PAPELERIA;

public final static Double SUM_COSTOS_FIJOS_LOGISTICA = Utileria.covertirUSDToMXN(Constantes.LIBERACION_USD+Constantes.VALIDATION_FEE_USD+
Constantes.DOCUMENTACION_USD+Constantes.ADMON_FEE_USD);
}
