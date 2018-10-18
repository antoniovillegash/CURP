package curp;

import java.util.*;

public class TestCurp {
	public static void main(String[] args) {
	
		Scanner scan=new Scanner(System.in);
		Persona persona=new Persona();
		MisFunciones funciones=new MisFunciones();
		String curp=null;
		boolean validacion=false;
		boolean validacion2=false;
	do {
		System.out.println("ingrese primer apellido");
		persona.setApellidoPat(scan.nextLine().toUpperCase());
		validacion=funciones.validarSiSonLetras(persona.getApellidoPat());
		if(validacion==false) {
			System.out.println("ingrese solo letras y sin acentos");
		}
	}while(validacion==false);
	do {
		System.out.println("¿tiene segundo apellido? s/n");
		persona.setTieneSegundoApellido(scan.nextLine());
		if(persona.getTieneSegundoApellido().equals("s")) {
			validacion2=true;
			do {
				System.out.println("ingrese segundo apellido");
				persona.setApellidoMat(scan.nextLine().toUpperCase());
				validacion=funciones.validarSiSonLetras(persona.getApellidoMat());
				if(validacion==false) {
					System.out.println("ingrese solo letras y sin acentos");
				}
			}while(validacion==false);	
		}else if(persona.getTieneSegundoApellido().equals("n")){
			validacion2=true;
		}else {
			System.out.println("ingrese una opcion valida");
		}
	}while(validacion2==false);
	
	do {
		System.out.println("ingrese nombre ");
		persona.setNombre(scan.nextLine().toUpperCase());
		validacion=funciones.validarSiSonLetras(persona.getNombre());
		if(validacion==false) {
			System.out.println("ingrese solo letras y sin acentos");
		}
	}while(validacion==false);
	
		//funciones.validarSiSonLetras(persona.getNombre());
	do{
		do{
			System.out.println("ingrese dia de nacimineto DD");
			persona.setDia(scan.nextLine());
			validacion=funciones.validarSiElDiaEsCorrecto(persona.getDia());
			if(validacion==false) {
				System.out.println("ingrese un valor valido");
			}
		}while(validacion==false);
	
		do{
			System.out.println("ingrese mes de nacimineto MM");
			persona.setMes(scan.nextLine());
			validacion=funciones.validarSiElMesEsCorrecto(persona.getMes());
			if(validacion==false) {
				System.out.println("Ingrese un valor valido");
			}
		}while(validacion==false);
	
		do{
			System.out.println("ingrese año de nacimineto AAAA");
			persona.setYear(scan.nextLine());
			validacion=funciones.validarSiElAnioEsCorrecto(persona.getYear());
			if(validacion==false) {
				System.out.println("ingrese un valor valido");
			}
		}while(validacion==false);
		validacion=funciones.validarSiLaFechaEsValida(persona.getYear(),persona.getMes(),persona.getDia());
		if(validacion==false) {
			System.out.println("la fecha no es correcta");
		}
	}while(validacion==false);
	do {
		System.out.println("ingrese genero");
		persona.setGenero(scan.nextLine().toUpperCase());
		validacion=funciones.validarSiElGeneroEsCorrecto(persona.getGenero());
		if(validacion==false) {
			System.out.println("ingrese un genero valido");
		}
	}while(validacion==false);
		
	do {
		System.out.println("ingrese estado");
		persona.setEstado(scan.nextLine().toUpperCase());
		validacion=funciones.validarSiSonLetras(persona.getEstado()) && funciones.validarSiElEstadoEsCorrecto(persona.getEstado());
		if(validacion==false) {
			System.out.println("ingrese un estado valido");
		}
	}while(validacion==false);
		
	scan.close();
		
	curp=persona.generarCurp();
	System.out.print(curp);
	}
}
