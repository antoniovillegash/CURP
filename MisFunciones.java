package curp;

public class MisFunciones {
	boolean esValido=false;
	
	public boolean validarSiSonLetras(String temporal) {
		esValido=false;
		for(int i=0; i<temporal.length(); i++) {
			if((temporal.charAt(i)>='A' && temporal.charAt(i)<='Z') || temporal.charAt(i)==32 || temporal.charAt(i)=='Ñ') {
			esValido=true;
		}else {
			esValido=false;
			break;
		}
		}return esValido;
	}
	
	public boolean validarSiElDiaEsCorrecto(String temporal) {
		if(temporal.length()!=2) {
			return false;
		}
		for(int i=0; i<2; i++) {
			if((temporal.charAt(i)>='0' && temporal.charAt(i)<='9')) {
				
			}else {
				esValido=false;
				return esValido;
				
			}
		}
		int dia=Integer.parseInt(temporal);
		if(dia>00 && dia<=31) {
			esValido=true;;
		}else {
			return false;
		}
		return esValido;
	}

	public boolean validarSiElMesEsCorrecto(String temporal) {
		if(temporal.length()!=2) {
			return false;
		}
		for(int i=0; i<2; i++) {
			if((temporal.charAt(i)>='0' && temporal.charAt(i)<='9')) {
				
			}else {
				esValido=false;
				return esValido;
				
			}
		}
		int mes=Integer.parseInt(temporal);
		if(mes>00 && mes<=12) {
			esValido=true;;
		}else {
			return false;
		}
		return esValido;
	}
	
	public boolean validarSiElAnioEsCorrecto(String temporal) {
		if(temporal.length()!=4) {
			return false;
		}
		for(int i=0; i<4; i++) {
			if((temporal.charAt(i)>='0' && temporal.charAt(i)<='9')) {
				
			}else {
				esValido=false;
				return esValido;
				
			}
		}
		int ano=Integer.parseInt(temporal);
		if(ano>1900) {
			esValido=true;;
		}else {
			return false;
		}
		return esValido;
	}
	
	public boolean validarSiElGeneroEsCorrecto(String temporal) {
		if(temporal.equals("HOMBRE") || temporal.equals("MUJER")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validarSiElEstadoEsCorrecto(String temporal) {
		String[] estados= {"AGUASCALIENTES","BAJA CALIFORNIA","BAJA CALIFORNIA SUR","CAMPECHE","CHIAPAS","CHIHUAHUA","CIUDAD DE MEXICO"
				,"COAHUILA","COLIMA","DURANGO","GUANAJUATO","GUERRERO","HIDALGO","JALISCO","ESTADO DE MEXICO","MICHOACAN","MORELOS"
				,"NAYARIT","NUEVO LEON","OAXACA","PUEBLA","QUERETARO","QUINTANA ROO","SAN LUIS POTOSI","SINALOA","SONORA","TABASCO"
				,"TAMAULIPAS","TLAXCALA","VERACRUZ","YUCATAN","ZACATECAS"};
		
		for(int i=0; i<32; i++) {
			if(estados[i].equals(temporal)) {
				esValido=true;
				break;
			}else {
				esValido=false;
			}
		}
		return esValido;
	}
	
	public boolean validarSiLaFechaEsValida(String anoCadena, String mesCadena, String diaCadena) {
		int ano=Integer.parseInt(anoCadena);
		int dia=Integer.parseInt(diaCadena);
		String[] mesLargo= {"01","03","05","07","08","10","12"};
		String[] mesCorto= {"04","06","09","11","06","09","11"};
		String[] mesFebrero= {"02","02","02","02","02","02","02"};
		for(int i=0; i<7; i++) {
			if(mesCadena.equals(mesLargo[i])) {
				if(dia>=01 && dia<=31) {
					esValido=true;
				}else {
					esValido=false;
					break;
				}
			}else if(mesCadena.equals(mesCorto[i])) {
				if(dia>=01 && dia<=30) {
					esValido=true;
				}else {
					esValido=false;
					break;
				}
			}else if(mesCadena.equals(mesFebrero[i])) {
				if(ano%4==0) {
					if(dia>=01 && dia<=29) {
						esValido=true;
					}else {
						esValido=false;
						break;
					}
				}else {
					if(dia>=01 && dia<=28) {
						esValido=true;
					}else {
						esValido=false;
						break;
					}
				}
			}
		}
		return esValido;
	}
	
	public String cualNombreUsar(String temporal) {
		if(temporal.contains(" ")) {
			String[]nombres=temporal.split(" ");
			String nombre1=nombres[0];
			String nombre2=nombres[1];
			String nombre=null;
			String[]nombresInvalidos={"MARIA","MA","JOSE","J"};
			for(int i=0; i<4; i++) {
				if(nombre1.equals(nombresInvalidos[i])) {
					nombre=nombre2;
					break;
				}else {
					nombre=nombre1;
				
				}
			}
			return nombre;
		}
		return temporal;
	}
	
	public boolean tieneGroserias(String temporal) {
		String[] groserias={"LOCO","LOKA","LOKO","MAME","MAMO","MEAR","MEAS","MEON","MIAR","MION","MOCO","MOKO","MULA","MULO","NACA","NACO","PEDA","PEDO"
				,"PENE","PIPI","PITO","POPO","PUTA","PUTO","QULO","RATA","ROBA","ROBE","ROBO","RUIN","SENO","TETA","VACA","VAGA","VAGO","VAKA","VUEI","VUEY"
				,"WUEI","WUEY","BACA","BAKA","BUEI","BUEY","CACA","CACO","CAGA","CAGO","CAKA","CAKO","COGE","COGI","COJA","COJE","COJI"
				,"COJO","COLA","CULO","FALO","FETO","GETA","GUEI","GUEY","JETA","JOTO","KACA","KACO","KAGA","KAGO","KAKA","KAKO","KOGE"
				,"KOGI","KOJA","KOJE","KOJI","KOJO","KOLA","KULO","LILO","LOCA"};
		for(int i=0; i<81; i++) {
			if(temporal.equals(groserias[i])) {
				esValido=true;
				break;
			}else {
				esValido=false;
			}
		}
		return esValido;
	}
	
	public boolean comienzaConVocal(String temporal) {
		for(int i=0; i<5; i++) {
			String[] vocales= {"A","E","I","O","U"};
			if(Character.toString(temporal.charAt(0)).equals(vocales[i])) {
				esValido=true;
				break;
			}
			esValido=false;
		}
		return esValido;
	}
	
	public boolean tieneVocales(String temporal) {
		for(int i=0; i<temporal.length(); i++) {
			String[] vocales= {"A","E","I","O","U"};
			for(int j=0; j<5; j++) {
				if(Character.toString(temporal.charAt(i)).equals(vocales[j])) {
					esValido=true;
					break;
				}else {
				esValido=false;
				}
			}
			if(esValido==true) {
				break;
			}
		}
		return esValido;
	}
	
	public boolean tieneSegundoApellido(String temporal) {
		if(temporal.equals("s")) {
			esValido=true;
		}else if(temporal.equals("n")) {
			esValido=false;
		}
		return esValido;
	}
	
	public String regresarLetraPorNumero(int temporal) {
		String[] alfabeto= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		return alfabeto[temporal];
	}
}
