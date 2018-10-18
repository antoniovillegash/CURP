package curp;
import java.util.*;

public class Persona {
	Random numeroAzar=new Random();
	private String nombre;
	private String apellidoPat;
	private String apellidoMat;
	private String dia,mes,year,estado,genero;
	private String tieneSegundoApellido;
	String curp=null;
	MisFunciones funcion=new MisFunciones();
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public void setTieneSegundoApellido(String tieneSegundoApellido) {
		this.tieneSegundoApellido=tieneSegundoApellido;
	}
	public String getTieneSegundoApellido() {
		return tieneSegundoApellido;
	}
	public String generarCurp() {
		nombre=funcion.cualNombreUsar(getNombre());
		curp=Character.toString(getApellidoPat().charAt(0));
		if(funcion.comienzaConVocal(getApellidoPat())) {
				curp+=Character.toString(getApellidoPat().replaceAll("[QWRTYPSDFGHJKLÑZXCVBNM]","").charAt(1));
		}else {
			if(funcion.tieneVocales(getApellidoPat())) {
				curp+=Character.toString(getApellidoPat().replaceAll("[QWRTYPSDFGHJKLÑZXCVBNM]","").charAt(0));
			}else {
				curp+="X";
			}
		}
		
		if(funcion.tieneSegundoApellido(getTieneSegundoApellido())) {
			curp+=Character.toString(getApellidoMat().charAt(0));
		}else if(getTieneSegundoApellido().equals("n")){
			curp+="X";
		}
		curp+=Character.toString(nombre.charAt(0));
		curp+=getYear().substring(2, 4);
		curp+=getMes();
		curp+=getDia();
		curp+=Character.toString(getGenero().charAt(0));
		curp+=Character.toString(getEstado().charAt(0));
		String estadoSinVocales=getEstado().replaceAll("[AEIOU]", "");
		curp+=Character.toString(estadoSinVocales.charAt(estadoSinVocales.length()-1));
		if(getApellidoPat().replaceAll("[AEIOU]","").length()<2) {
			curp+='X';
		}else {
			curp+=Character.toString(getApellidoPat().substring(2,getApellidoPat().length()).replaceAll("[AEIOU]","").charAt(0));
		}
		if(getTieneSegundoApellido().equals("s")) {
			if(getApellidoMat().replaceAll("[AEIOU]","").length()<2) {
				curp+='X';
			}else {
			curp+=Character.toString(getApellidoMat().substring(2,getApellidoMat().length()).replaceAll("[AEIOU]","").charAt(0));
			}
		}else if(getTieneSegundoApellido().equals("n")){
			curp+="X";
		}
		curp+=Character.toString(nombre.substring(2,nombre.length()).replaceAll("[AEIOU]","").charAt(0));
		if(Integer.parseInt(getYear())<2000) {
			curp+=Integer.toString(numeroAzar.nextInt(9));
		}else {
			curp+=funcion.regresarLetraPorNumero(numeroAzar.nextInt(26));
		}
		numeroAzar=new Random();
		curp+=Integer.toString(numeroAzar.nextInt(9));
		
		curp=curp.replaceAll("Ñ", "X");
		
		if(funcion.tieneGroserias(curp.substring(0, 4))) {
			curp=curp.substring(0, 2).replaceAll("[AEIOU]", "X")+curp.substring(2, curp.length());
		}
		return curp;
	}
}
