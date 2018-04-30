package mx.org.banxico.dgie.ws;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	    private final static String REGEX = 
	          "<bm:Series\\s++TITULO\\s*+=\\s*+\"(?<titulo>[^\"]*+)\""
	        + "\\s++IDSERIE\\s*+=\\s*+\"SF43718\"[^>]*+>"
	        + "\\s*+<bm:Obs\\s++TIME_PERIOD\\s*+=\\s*+\"(?<fecha>[^\"]*+)\""
	        + "\\s++OBS_VALUE\\s*+=\\s*+\"(?<cotizacion>[^\"]*)";
	    

	public static Double obtnerCotizacionDelDia(final String uxml) {
        // Sacar las entities 
        //  (se rompe el XML pero es mas facil procesarlo directamente)
        String xml = unescapeCommonEntities(uxml);

        // Obtener los campos buscados con una expresion regular sobre todo el xml
        Pattern idPatt = Pattern.compile(REGEX);
        Matcher m = idPatt.matcher(xml);
        if (m.find()) {
        	return new Double( m.group("cotizacion"));
           /* System.out.println("Cotizacion: " + m.group("cotizacion"));
            System.out.println("Fecha: " + m.group("fecha"));
            System.out.println("Descripcion: " + m.group("titulo"));*/
        } else {
        	return new Double(0.0);
        }
    }
	
	// Funcion para decodificar los entities del xml
    private static String unescapeCommonEntities( final String xmle )
    {
        return xmle.replaceAll( "&lt;", "<" )
                    .replaceAll( "&gt;", ">" )
                    .replaceAll( "&amp;", "&" )
                    .replaceAll( "&apos;", "'" )
                    .replaceAll( "&quot;", "\"" );
    }

	
}
