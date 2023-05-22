package Conversor.modelo;

public class MatrizDivisa {

	double[][] matrizDivisas = new double[4][4];

	public void cargarMatriz() {

		for (int f = 0; f < 4; f++) {
			for (int c = 0; c < 4; c++) {
				if (f == c) {
					matrizDivisas[f][c] = 1;
				} else {
					matrizDivisas[f][c] = 0;
				}
			}
		}

		matrizDivisas[0][1] = 0.00021;
		matrizDivisas[0][2] = 0.00019;
		matrizDivisas[0][3] = 0.00017;

		matrizDivisas[1][0] = 1 / matrizDivisas[0][1];
		matrizDivisas[1][2] = 0.93555;
		matrizDivisas[1][3] = 0.83045;

		matrizDivisas[2][0] = 1 / matrizDivisas[0][2];
		matrizDivisas[2][1] = 1 / matrizDivisas[1][2];
		matrizDivisas[2][3] = 0.8878;

		matrizDivisas[3][0] = 1 / matrizDivisas[0][3];
		matrizDivisas[3][1] = 1 / matrizDivisas[1][3];
		matrizDivisas[3][2] = 1 / matrizDivisas[2][3];
	}

	public MatrizDivisa() {
		cargarMatriz();
	}

	public double tasa(int moneda1, int moneda2) {
		return matrizDivisas[moneda1][moneda2];
	}

	public void actualizarTasa(int moneda1, int moneda2, double tasa) {
		for (int f = 0; f < 4; f++) {
			if (f == moneda1) {
				for (int c = 0; c < 4; c++) {
					if (c == moneda2) {
						matrizDivisas[f][c] = tasa;
						matrizDivisas[c][f] = 1/tasa;
						System.out.println("Matriz: "+String.valueOf((double) Math.round(matrizDivisas[f][c] * 100d) / 100));
					} 
				}
			}
		}
	}

}
