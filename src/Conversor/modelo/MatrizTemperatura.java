package Conversor.modelo;

public class MatrizTemperatura {
	
double [][] matrizTemperatura = new double [3][3];
	
	public void cargarMatriz() {
		
		for (int f = 0; f < 3; f++) {
			for (int c = 0; c < 3; c++) {
				if (f == c) {
					matrizTemperatura[f][c] = 1;
				} else {
					matrizTemperatura[f][c] = 0;
				}
			}
		}
		
		matrizTemperatura[0][1] = 0.00021;
		matrizTemperatura[0][2] = 0.00019;
		
		matrizTemperatura[1][0] = 1/matrizTemperatura[0][1];
		matrizTemperatura[1][2] = 0.93555;

		matrizTemperatura[2][0] = 1/matrizTemperatura[0][2];
		matrizTemperatura[2][1] = 1/matrizTemperatura[1][2];
		
	}
	
	public MatrizTemperatura() {
		cargarMatriz();
	}


	public double tasa(int moneda1,int moneda2) {
		return matrizTemperatura[moneda1][moneda2];
	}

}
