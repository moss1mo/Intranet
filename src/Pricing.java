import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.MessagePolicy.ProtectionPolicy;

import com.shq.utils.Constantes;
import com.shq.utils.TipoTransportes;
import com.shq.utils.Utileria;

public class Pricing {
	
	
	
	
	

	public static void main(String[] args) {
		
		
		//Datos inciales de entrada que debe ingresar el usuario
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		
		//Integer paquetes = 100; se calcula dependiendo del tama


		/* prueba final happy path*/
	    
	    Factura factura = new Factura();
	    
	    Double gananciaPorSaldos = 250000.00;
		
		Producto producto1 = new Producto();
		producto1.setHarmonizedCode("");
		producto1.setProducto("Glucosamina 2KCl");
		producto1.setIGI(10.00);
		producto1.setIVA(16.00);
		producto1.setUnidad("KG");
		producto1.setPresentacion(25.00);
		producto1.setCantidad(100000.00);
		producto1.setCostoUSD(0.05);
		producto1.setCostoMXN(Utileria.covertirUSDToMXN(producto1.getCostoUSD()));
		producto1.setCostoTransporte(TipoTransportes.SEA.costo());
		producto1.setPrecioMercado(10.5);
		
		Producto producto2 = new Producto();
		producto2.setHarmonizedCode("");
		producto2.setProducto("Glucosamina 2KCl 2");
		producto2.setIGI(10.00);
		producto2.setIVA(16.00);
		producto2.setUnidad("KG");
		producto2.setPresentacion(25.00);
		producto2.setCantidad(100000.00);
		producto2.setCostoUSD(0.05);
		producto2.setCostoMXN(Utileria.covertirUSDToMXN(producto2.getCostoUSD()));
		producto2.setCostoTransporte(TipoTransportes.SEA.costo());
		producto2.setPrecioMercado(10.5);

		
		Producto producto3 = new Producto();
		producto3.setHarmonizedCode("");
		producto3.setProducto("Glucosamina 2KCl 3");
		producto3.setIGI(10.00);
		producto3.setIVA(16.00);
		producto3.setUnidad("KG");
		producto3.setPresentacion(25.00);
		producto3.setCantidad(100000.00);
		producto3.setCostoUSD(0.05);
		producto3.setCostoMXN(Utileria.covertirUSDToMXN(producto3.getCostoUSD()));
		producto3.setCostoTransporte(TipoTransportes.SEA.costo());
		producto3.setPrecioMercado(10.5);

		

		
		/*
		Pricing producto1 = new Pricing();
		producto1.setHarmonizedCode("");
		producto1.setProducto("Glucosamina 2KCl");
		producto1.setIGI(10.00);
		producto1.setIVA(16.00);
		producto1.setUnidad("KG");
		producto1.setPresentacion("250GR");
		producto1.setCantidad(200000.00);
		producto1.setCostoUSD(0.715);
		producto1.setCostoMXN(covertirUSDToMXN(producto1.getCostoUSD()));*/
		
		
		/*Pricing producto2 = new Pricing();
		producto2.setHarmonizedCode("");
		producto2.setProducto("L-LYSINE MONOHYDROCHLORIDE");
		producto2.setIGI(0.00);
		producto2.setIVA(16.00);
		producto2.setUnidad("KG");
		producto2.setPresentacion("250GR");
		producto2.setCantidad(200000.00);
		producto2.setAlto(0.4);
		producto2.setAncho(0.4);
		producto2.setLargo(0.4);
		producto2.setCostoUSD(0.715);
		producto2.setCostoMXN(covertirUSDToMXN(producto2.getCostoUSD()));
		listaProductos.add(producto2);

		 */
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		factura.setProductos(listaProductos);
		factura.setCostoTransporte(TipoTransportes.SEA.costo());
		
		
		
		Double montoTotalFacturaMXN = calcularMontoTotalFactura(factura);
		Double cantidadTotalFactura = calcularCantidadTotalFactura(factura);
		Double totalVolumenFactura = calcularVolumenTotal(factura);

		for(Producto producto:factura.getProductos()){
			
			//Costeo gastos de aduana
			
			System.out.println("------------------- Aduana -------------------------");
			Double costoFijoAduana = Constantes.SUM_COSTOS_FIJOS_ADUANA;
			Double costoVariableAduana = calcularCostosVariablesAduana(producto,montoTotalFacturaMXN,cantidadTotalFactura);
			Double costoSeguro = montoTotalFacturaMXN*Constantes.PORC_SEGURO;
			Double costoAduanal = costoVariableAduana+costoFijoAduana+costoSeguro;
			Double costoUnitario = calcularCostoUnitario(producto,costoAduanal,montoTotalFacturaMXN);
			Double costoUnitarioIVA = costoUnitario+(costoUnitario*Constantes.IVA);
			System.out.println("Costo total de aduana: "+costoUnitarioIVA);
						
			//Calculo gastos de logistica
			
			System.out.println("------------------- Logistica -------------------------");

			Double costoFijoLogistica = Constantes.SUM_COSTOS_FIJOS_LOGISTICA;
			Double dimensionTotalProducto = producto.getDimensionTotalProducto();			
			Double costoDescTransfer = 0.0;
			
			if(dimensionTotalProducto >= Constantes.MINIMO_METROS_CUBICOS_LOGISTICA){
			    costoDescTransfer = calcularCostosLogistica(dimensionTotalProducto,Constantes.DESCONSOLIDACION+Constantes.TRANSFER);
			}else{
			    costoDescTransfer = calcularCostosLogistica(producto,listaProductos,Constantes.DESCONSOLIDACION+Constantes.TRANSFER);
			}
			
			Double cuotaTransporte = calcularCuotaTransporte(dimensionTotalProducto,factura.getCostoTransporte(),Constantes.TRANSPORT_FEE_MINIMO);
			if(cuotaTransporte < Constantes.TRANSPORT_FEE_MINIMO){
				cuotaTransporte = calcularCuotaTransporte(producto,listaProductos,factura.getCostoTransporte(),Constantes.TRANSPORT_FEE_MINIMO);
			}

			Double costoPorEntradaPuerto = calcularCostoPorEntradaPuerto(calculaSumatoriaPeso(listaProductos));			
			Double sumLogisticaVariables = costoDescTransfer+cuotaTransporte+costoPorEntradaPuerto;
			
			Double costoUnitarioMVL = calcularCostoUnitario(producto,sumLogisticaVariables,montoTotalFacturaMXN);	
			Double costoUnitarioMFL =  calcularCostoUnitario(producto,costoFijoLogistica,montoTotalFacturaMXN);	
			producto.setCostoVariableLogistica(sumLogisticaVariables/calculaSumatoriaPeso(listaProductos));
			Double costoSeguroFlete = producto.getCostoMXN()*0.0085;			
			Double costoFinalLogisticaSinIVA = costoSeguroFlete +costoUnitarioMVL+costoUnitarioMFL;
			Double IVAcostoFinalLogistica = costoFinalLogisticaSinIVA * Constantes.IVA;
			Double costoFinalLogisticaConIVA = costoFinalLogisticaSinIVA + IVAcostoFinalLogistica;
			
			System.out.println("Costo fijo logistica: "+costoFinalLogisticaConIVA);			
			
			
			
			System.out.println("--------------------FINAL------------------------");
			
			Double costoFinalAlmacen = costoUnitarioIVA+costoFinalLogisticaConIVA+producto.getCostoMXN();
			System.out.println("Costo TOTAL ADUANA:  "+costoUnitarioIVA);
			
			System.out.println("Costo FINAL  LOGISTICA "+costoFinalLogisticaConIVA);
			
			
			System.out.println("Costo FINAL "+ costoFinalAlmacen);
			
			
			Double precioBase = calcularPrecioBase(costoFinalAlmacen);
			
			if(precioBase.equals(producto.getPrecioMercado())){
				//Precio igual de competitivo al del mercado se vende al mismo precio
				System.out.println("Precio de venta: "+precioBase);
			}else if(precioBase > producto.getPrecioMercado()){
				//Precio menos competitivo que el del mercado, se procede a calcular precio por saldos
				precioBase = calcularPrecioPorSaldos(producto,costoFinalAlmacen,gananciaPorSaldos);
				if(precioBase>producto.getPrecioMercado()){
					//No se pudo ser mas competitivo ahora se sugiere cotizar con otros proveedores o buscar transporte mas economico.
					System.out.println("Recotizar el producto con otros proveedores y/o buscar mejores opciones de envios");
				}else if(precioBase.equals(producto.getPrecioMercado())){
					//Precio igual de competitivo al del mercado se vende al mismo precio
					System.out.println("Precio de venta: "+precioBase);
				}else{
					//Precio mas competitivo que del mercado, se procede a calcular rando de precios
					List<Double> listaPrecios = calcularListaPrecios(precioBase,producto.getPrecioMercado(),10);
					List<Double> listaGanancias = calcularListaGanancias(producto,listaPrecios,costoFinalAlmacen);
					//Tomamos de la lista el que se encuentra a la mitad de mejor precio mercado y mejor ganancia.
					System.out.println("Precio de venta: "+listaPrecios.get(5));	
					System.out.println("Ganancia de venta: "+listaGanancias.get(5));	
				}
			}else{
				//Precio mas competitivo que del mercado, se procede a calcular rando de precios
				List<Double> listaPrecios = calcularListaPrecios(precioBase,producto.getPrecioMercado(),10);
				List<Double> listaGanancias = calcularListaGanancias(producto,listaPrecios,costoFinalAlmacen);
				//Tomamos de la lista el que se encuentra a la mitad de mejor precio mercado y mejor ganancia.
				System.out.println("Precio de venta: "+listaPrecios.get(5));
				System.out.println("Ganancia de venta: "+listaGanancias.get(5));
			}

		} 
		
	}
	
	 

	
	
	private static List<Double> calcularListaGanancias(Producto producto, List<Double> listaPrecios,Double costoFinalAlmacen) {
		List<Double> ganancias = new ArrayList<>();
		for(Double precio:listaPrecios){
			ganancias.add((precio-costoFinalAlmacen)*producto.getCantidad());
		}
		return ganancias;
	}





	private static List<Double> calcularListaPrecios(Double precioBase, Double precioMercado,Integer numEscenarios) {
		Double dif = precioMercado - precioBase;
		List<Double> precios = new ArrayList<>();
		if(dif>0){
			for(int e=1;e<=numEscenarios;e++){
				Double gananciaEsc = dif/e;
				precios.add(precioBase+gananciaEsc);
			}
		}
		return precios;
	}





	private static Double calcularPrecioPorSaldos(Producto producto, Double costoFinalAlmacen, Double gananciaPorSaldos) {
		return (gananciaPorSaldos/producto.getCantidad())+costoFinalAlmacen;
		
	}





	private static Double calcularPrecioBase(Double costoFinalAlmacen) {
		return costoFinalAlmacen/(1-0.3);
	}





	private static Double calcularVolumenTotal(Factura factura) {
		Double volumen = 0.0;
		for(Producto producto:factura.getProductos()){
			volumen = volumen + producto.getDimensionTotalProducto();
		}
		return volumen;
	}





	private static Double calcularCostoUnitario(Producto producto, Double costoAduanal, Double montoTotalFacturaMXN) {
		return costoAduanal*((producto.getCostoMXN())/montoTotalFacturaMXN);
	}





	private static Double calcularCantidadTotalFactura(Factura factura) {
		Double cantidadTotal = 0.0;
		for(Producto producto:factura.getProductos()){
			cantidadTotal = cantidadTotal + producto.getCantidad();
		}
		return cantidadTotal;
	}





	private static Double calcularMontoTotalFactura(Factura factura) {
		Double montoTotal = 0.0;
		for(Producto producto:factura.getProductos()){
			montoTotal = montoTotal + (producto.getCostoMXN()*producto.getCantidad());
		}
		return montoTotal;
	}





	static Double calcularCostosVariablesAduana(Producto producto, Double montoTotalFacturaMXN, Double cantidadTotalFactura){
			Double costoTotalIGI = montoTotalFacturaMXN *  convertPorcentToDecimal(producto.getIGI());
			Double costoTotalIVA = montoTotalFacturaMXN *  convertPorcentToDecimal(producto.getIVA());	
			Double costoTotalDTA = calcularDTA(montoTotalFacturaMXN);	
			Double costoTotalOtroCargos = cantidadTotalFactura*Constantes.OTROS_CARGOS;
			Double costoTotalAsesoria =(montoTotalFacturaMXN+Constantes.ASESORIA_MANEJO)*Constantes.PORC_ASESORIA_MANEJO;
			Double costoTotalManejo =(montoTotalFacturaMXN+Constantes.MANEJO)*Constantes.PORC_MANEJO;

			return costoTotalIGI+costoTotalIVA+costoTotalDTA+costoTotalOtroCargos+costoTotalAsesoria+costoTotalManejo+Constantes.HONORARIOS;	
	}
	
	
	static Double calculaSumatoriaPeso(List<Producto> productos){
		Double sumTotalPesoKg = 0.0;
		for(Producto producto:productos){
			sumTotalPesoKg = sumTotalPesoKg +convertToKg(producto.getCantidad(),producto.getUnidad());
		}
		return sumTotalPesoKg;
	}
	
	
	static Double calcularCostosLogistica(Double dimensionTotalProducto, Double costoTramite){
			return (dimensionTotalProducto)*Utileria.covertirUSDToMXN(costoTramite);
	}
	
	static Double calcularCostosLogistica(Producto producto, List<Producto> productos, Double costoTramite){
		Double sumaDimensiones = 0.0;
		Double sumaCantidades = 0.0;
		for(Producto product: productos){
			if(product.getDimensionTotalProducto()<1.0){
				sumaDimensiones = sumaDimensiones+product.getDimensionTotalProducto();
				sumaCantidades = sumaCantidades+product.getCantidad();
			}
		}
		Double costoTotalMinimos = roundUP(sumaDimensiones)*Utileria.covertirUSDToMXN(costoTramite);
		return (producto.getCantidad()/sumaCantidades)*costoTotalMinimos;
	}
	
	
	static Double calcularCuotaTransporte(Double dimensionTotalProducto,Double costoTramite,Double minCostoTramite){
			return (dimensionTotalProducto*costoTramite);
	}
	
	static Double calcularCuotaTransporte(Producto producto, List<Producto> productos,Double costoTramite,Double minCostoTramite){
		Double sumaDimensiones = 0.0;
		Double sumaCantidades = 0.0;
		for(Producto product: productos){
			Double costoCoutaTransporte = product.getDimensionTotalProducto()*costoTramite;
			if(costoCoutaTransporte<Constantes.TRANSPORT_FEE_MINIMO){
				sumaDimensiones = sumaDimensiones+product.getDimensionTotalProducto();
				sumaCantidades = sumaCantidades+product.getCantidad();
			}
		}
		Double costoTotalMinimos = roundUP(sumaDimensiones)*Utileria.covertirUSDToMXN(costoTramite);
		return (producto.getCantidad()/sumaCantidades)*costoTotalMinimos;
	}
	
	

	static Double calcularCostoPorEntradaPuerto(Double cantidad){
		if(cantidad<=1500){
			return 1100.00;
		}else{
			return 1300.00;
		}
	}
	
	
	static int roundUP(double d){
	    double dAbs = Math.abs(d);
	    int i = (int) dAbs;
	    double result = dAbs - (double) i;
	    if(result==0.0){ 
	        return (int) d;
	    }else{
	        return (int) d<0 ? -(i+1) : i+1;          
	    }
	}
	
	
	
	
	

	
	//Método auxiliares para calculos y conversiones
	
	static Double calcularDTA(Double sumValorFactura){
		 return (sumValorFactura * 0.8) / 100;

	}
	
	
	static Double calcularValorFacturaPorProducto(Double costoUSD,Double cantidad){
		return costoUSD*cantidad;
		
	}
	
	
	
	static Double convertPorcentToDecimal(Double porcent){
		return porcent/100;
	}
	
	
	static Double convertToKg(Double cantidad,String unidad){
		if(unidad.equalsIgnoreCase("GR")){
			return cantidad/1000;
		}else if(unidad.equalsIgnoreCase("KG")){
			return cantidad;
		}else if(unidad.equalsIgnoreCase("TN")){
			return cantidad*1000;
		}else{
			return 0.0;
		}
	}
	
}
