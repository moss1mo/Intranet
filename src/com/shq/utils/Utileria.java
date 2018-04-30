package com.shq.utils;

import java.rmi.RemoteException;

import org.apache.axis.AxisFault;
import mx.org.banxico.dgie.ws.DgieWSPortProxy;
import mx.org.banxico.dgie.ws.Utils;

public class Utileria {

	//método para convertir de dolares a pesos
		public static Double covertirUSDToMXN(Double cantidadUSD){
		  Double tipoCambio = null;
		  
			  try {
					DgieWSPortProxy wsTipoCambioBANXICO = new DgieWSPortProxy();			
					tipoCambio = Utils.obtnerCotizacionDelDia(wsTipoCambioBANXICO.tiposDeCambioBanxico());
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			  if(tipoCambio == null){
				  return null;
			  }
			  
			  System.out.println("Tipo cambio: "+tipoCambio);
			 return cantidadUSD*tipoCambio;
		 }
		
		public static Double getTC(){
			Double tipoCambio = null;
				  try {
						DgieWSPortProxy wsTipoCambioBANXICO = new DgieWSPortProxy();			
						tipoCambio = Utils.obtnerCotizacionDelDia(wsTipoCambioBANXICO.tiposDeCambioBanxico());
					} catch (AxisFault e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				  if(tipoCambio == null){
					  return null;
				  }
				  
				  System.out.println("Tipo cambio: "+tipoCambio);
				 return tipoCambio;
			 }
}
