package Conversor.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	static JFrame marco = new JFrame();
	static JPanel panelConversor;
	static JMenuBar barraMenu;
	static JMenu menu, herramientas;
	static JMenuItem  menuSalir, panelTemperaturas, panelAlmacenamiento, panelDivisas, panelLongitud;

	static PanelDivisas panel1 = new PanelDivisas();
	static PanelTemperaturas panel2 = new PanelTemperaturas();
	static PanelAlmacenamiento panel3 = new PanelAlmacenamiento();
	static PanelLongitud panel4 = new PanelLongitud();

	public Ventana() {
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		marco = new JFrame();
		marco.setSize(400, 600);
		marco.setTitle("Convertidor");
		marco.setLocationRelativeTo(null);
		marco.setResizable(false);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setLayout(null);
		
		barraMenu();
		marco.add(barraMenu);

		panel1.setBounds(0, 0, 400, 600);
		marco.add(panel1);
		
		panel2.setBounds(0, 0, 400, 600);
		marco.add(panel2);
		
		panel3.setBounds(0, 0, 400, 600);
		marco.add(panel3);
		
		panel4.setBounds(0, 0, 400, 600);
		marco.add(panel4);

		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		
		marco.setVisible(true);

		menuSalir.addActionListener(this);
		panelDivisas.addActionListener(this);
		panelLongitud.addActionListener(this);
		panelTemperaturas.addActionListener(this);
		panelAlmacenamiento.addActionListener(this);
	}

	public void barraMenu() {
		barraMenu = new JMenuBar();

		menu = new JMenu("Menu", false);
		herramientas = new JMenu("Herramientas", false);

		menuSalir = new JMenuItem("Salir");
		
		panelDivisas = new JMenuItem("Divisas");
		panelLongitud = new JMenuItem("Longitud");
		panelTemperaturas = new JMenuItem("Temperatura");
		panelAlmacenamiento = new JMenuItem("Unidades informáticas");

		menu.add(menuSalir);
		
		
		herramientas.add(panelDivisas);
		herramientas.add(panelLongitud);
		herramientas.add(panelTemperaturas);
		herramientas.add(panelAlmacenamiento);

		barraMenu.add(menu);
		barraMenu.add(herramientas);

		barraMenu.setBounds(0, 0, 400, 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuSalir) {
			System.out.println("Salir");
			System.exit(0);
		} else if (e.getSource() == panelDivisas) {
			panel1.setVisible(true);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
		} else if (e.getSource() == panelTemperaturas) {
			panel1.setVisible(false);
			panel2.setVisible(true);
			panel3.setVisible(false);
			panel4.setVisible(false);
		} else if (e.getSource() == panelAlmacenamiento) {
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(true);
			panel4.setVisible(false);
		} else if (e.getSource() == panelLongitud) {
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(true);
		}

	}
}
