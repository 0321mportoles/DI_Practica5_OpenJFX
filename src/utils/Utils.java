package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static boolean isNifNie(String nif){
		// If it is NIE, remove initial x,y,z to manage as NIF
		if (
			nif.toUpperCase().startsWith("X")
			|| nif.toUpperCase().startsWith("Y")
			|| nif.toUpperCase().startsWith("Z")
		) {
			nif = nif.substring(1);
		}

		Pattern nifPattern = 
			Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		
		Matcher m = nifPattern.matcher(nif);
		
		if (m.matches()) {
			String letra = m.group(2);
			
			//Extract NIF letter
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			
			int dni = Integer.parseInt(m.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni,dni+1);
		 
			if (reference.equalsIgnoreCase(letra)){
				return true;
			} else { return false; }
		} else {
			return false;
		}
	}
}
