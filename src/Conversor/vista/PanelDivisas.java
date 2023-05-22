package Conversor.vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conversor.OperacionController;

public class PanelDivisas extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	static JTextField valor, resultado;
	static JButton btnCalcular, btnLimpiar;
	static JComboBox<String> monedaLocal, monedaDestino;
	static JLabel etiquetaValor, etiquetaResultado;
	
	static OperacionController operacionController = new OperacionController();
	

	public PanelDivisas() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 800));

		iniciarComponentes();
	}

	private void iniciarComponentes() {

		etiquetaValor = new JLabel("Ingrese el valor a convertir:");
		etiquetaResultado = new JLabel("Resultado de la conversión:");

		valor = new JTextField();
		resultado = new JTextField();
		resultado.setEditable(false);

		monedaLocal = new JComboBox<String>(new String []{"Peso","Dolar","Euro","Libra"});
		monedaDestino = new JComboBox<String>(new String []{"Peso","Dolar","Euro","Libra"});

		btnCalcular = new JButton("Calcular");
		btnLimpiar = new JButton("Limpiar");

		etiquetaValor.setBounds(25, 100, 160, 30);
		valor.setBounds(25, 140, 160, 30);
		monedaLocal.setBounds(200, 140, 160, 30);

		etiquetaResultado.setBounds(25, 190, 250, 30);
		resultado.setBounds(25, 230, 160, 30);
		monedaDestino.setBounds(200, 230, 160, 30);

		btnCalcular.setBounds(25, 380, 160, 30);
		btnLimpiar.setBounds(200, 380, 160, 30);

		add(etiquetaValor);
		add(etiquetaResultado);
		add(valor);
		add(monedaLocal);
		add(monedaDestino);
		add(resultado);
		add(btnCalcular);
		add(btnLimpiar);

		btnCalcular.addActionListener(this);
		btnLimpiar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalcular) {
			String input = valor.getText();
			int unidad1 =  monedaLocal.getSelectedIndex();
			int unidad2  =  monedaDestino.getSelectedIndex();
			
			if(verificarNumero(input)) {
				double dato = Double.parseDouble(input);
				String conversion = operacionController.convertirDivisas(dato,unidad1,unidad2);	
				resultado.setText(conversion);
			} else {
				JOptionPane.showMessageDialog(null, "Error: "+ e.getActionCommand());
			}
		}

		if (e.getSource() == btnLimpiar) {
			limpiar();
		}

	}

	public void limpiar() {
		valor.setText("");
		resultado.setText("");
	}
	
	public boolean verificarNumero(String input) {
		try {
			double x = Double.parseDouble(input);
			if (x >= 0 || x < 0)
				;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	

}
