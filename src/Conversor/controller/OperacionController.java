package Conversor.controller;

import Conversor.modelo.MatrizDivisa;

public class OperacionController {

	MatrizDivisa divisas = new MatrizDivisa();
	double base;
	double destino;
	String unidadB, unidadD, conversion, resultado;

	public String convertirDivisas(double dato, int unidad1, int unidad2) {
		double tasa = divisas.tasa(unidad1, unidad2);
		return String.valueOf((double) Math.round(dato * tasa * 100d) / 100);
	}

	public String convertirTemperatura(double dato, String unidad1, String unidad2) {
		String conversion = unidad1.concat(unidad2);
		switch (conversion) {
		case "01":
			resultado = String.valueOf((double) Math.round((dato * 1.8 + 32) * 100d) / 100);
			break;
		case "02":
			resultado = String.valueOf((double) Math.round((dato + 273.15) * 100d) / 100);
			break;

		case "10":
			resultado = String.valueOf((double) Math.round((dato - 32) / 1.8 * 100d) / 100);
			break;
		case "12":
			resultado = String.valueOf((double) Math.round(((5 / 9) * (dato - 32) + 273.15) * 100d) / 100);
			break;

		case "20":
			resultado = String.valueOf((double) Math.round((dato - 273.15) * 100d) / 100);
			break;
		case "21":
			resultado = String.valueOf((double) Math.round((1.8 * (dato - 273.15) + 32) * 100d) / 100);
			break;
		default:
			resultado = String.valueOf((double) Math.round((dato) * 100d) / 100);
		}
		return resultado;
	}

	public String convertirAlmacenamiento(double dato, int unidadBase, int unidadDestino) {
		if (unidadBase < unidadDestino) {
			resultado = String
					.valueOf((double) Math.round((dato / Math.pow(1024, (unidadDestino - unidadBase))) * 100d) / 100);
		} else if (unidadBase > unidadDestino) {
			resultado = String
					.valueOf((double) Math.round((dato * Math.pow(1024, (unidadBase - unidadDestino))) * 100d) / 100);
		} else {
			resultado = String.valueOf((double) Math.round(dato * 100d) / 100);
		}
		return resultado;
	}

	public String convertirLongitud(double dato, int unidadBase, int unidadDestino) {
		unidadB = String.valueOf(unidadBase);
		unidadD = String.valueOf(unidadDestino);
		conversion = unidadB.concat(unidadD);
		
		if(unidadBase < 3 && unidadDestino < 3) {
			resultado = String.valueOf((double) Math.round(convertirSistMetrico(dato, conversion) * 100d) / 100);
		} else if (unidadBase > 2 && unidadDestino > 2) {
			resultado = String.valueOf((double) Math.round(convertirSistIngles(dato, conversion) * 100d) / 100);
		} else if (unidadBase < 3 && unidadDestino > 2) {
			base = convertirSistMetrico(dato, unidadB.concat("1"))*3.28084;
			unidadB = "4";
			resultado = String.valueOf((double) Math.round(convertirSistIngles(base, unidadB.concat(unidadD)) * 100d) / 100);
		} else if (unidadBase > 2 && unidadDestino < 3) {
			base = convertirSistIngles(dato, unidadB.concat("4"))*0.3048;
			unidadB = "1";
			resultado = String.valueOf((double) Math.round(convertirSistMetrico(base, unidadB.concat(unidadD)) * 100d) / 100);
		}
		return resultado;
	}
	
	public double convertirSistMetrico(double dato, String conversion) {
		switch(conversion) {
		case "01":
			destino = dato / 100;
			break;
		case "02":
			destino = dato / 100000;
			break;
		case "10":
			destino = dato * 100;
			break;
		case "12":
			destino = dato / 1000;
			break;
		case "21":
			destino = dato * 1000;
			break;
		case "20":
			destino = dato * 100000;
			break;
		default:
			destino = dato;
		}
		System.out.println(conversion);
		return destino;
	}
	
	public double convertirSistIngles(double dato, String conversion) {
		switch(conversion) {
		case "34":
			destino = dato / 12;
			break;
		case "35":
			destino = dato / 63360;
			break;
		case "43":
			destino = dato * 12;
			break;
		case "45":
			destino = dato / 5280;
			break;
		case "54":
			destino = dato * 5280;
			break;
		case "53":
			destino = dato * 63360;
			break;
		default:
			destino = dato;
		}
		return destino;
	}

	public void actualizarDivisa(int moneda1, int moneda2, double tasa) {
		System.out.println("operacionController: "+String.valueOf((double) Math.round(tasa * 100d) / 100));
		divisas.actualizarTasa(moneda1, moneda2, tasa);
	}

}
