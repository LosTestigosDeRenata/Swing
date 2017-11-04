package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ItemSelectable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregar extends JFrame {

	private JPanel contentPane;
	private JTextField campoModelo;
	private JTextField campoPrecio;
	private static VentanaAgregar ventanaAgregar;

	/**
	 * Create the frame.
	 */
	public VentanaAgregar(VentanaPrincipal ventanaPrincipal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ventanaPrincipal.setVisible(false);
		ventanaPrincipal.setEnabled(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventanaAgregar = this;
		
		// Año
		JComboBox<Integer> comboBoxAño = new JComboBox<Integer>();
		comboBoxAño.setBounds(111, 36, 84, 20);
		
		for(int i = 2008; i <= 2017; i++)
			comboBoxAño.addItem(i);
		contentPane.add(comboBoxAño);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(74, 39, 27, 14);
		contentPane.add(lblAo);
		
		// Mes
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(221, 39, 27, 14);
		contentPane.add(lblMes);
		
		JComboBox<Integer> comboBoxMes = new JComboBox<Integer>();
		comboBoxMes.setBounds(258, 36, 81, 20);
		contentPane.add(comboBoxMes);
		for(int i = 1; i <= 12; i++)
			comboBoxMes.addItem(i);
		
		// Marca
		JComboBox<String> comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.setBounds(111, 82, 228, 20);
		comboBoxMarca.addItem("Fiat");
		comboBoxMarca.addItem("Ford");
		comboBoxMarca.addItem("Chevrolet");
		contentPane.add(comboBoxMarca);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(41, 85, 60, 14);
		contentPane.add(lblMarca);
		
		// Modelo
		campoModelo = new JTextField();
		campoModelo.setBounds(109, 113, 230, 20);
		contentPane.add(campoModelo);
		campoModelo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(41, 116, 60, 14);
		contentPane.add(lblModelo);
		
		// Precio
		campoPrecio = new JTextField();
		campoPrecio.setBounds(109, 144, 230, 20);
		campoPrecio.setInputVerifier(new VerificadorPrecio());
		contentPane.add(campoPrecio);
		campoPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(41, 147, 60, 14);
		contentPane.add(lblPrecio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(true);
		this.setVisible(true);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auto auto = new Auto((String) comboBoxMarca.getSelectedItem(), campoModelo.getText(),
						(Integer) comboBoxAño.getSelectedItem(), (Integer) comboBoxMes.getSelectedItem(), new Double(campoPrecio.getText()));
				
				ventanaPrincipal.addAuto(auto);
			}
		});
		
		btnAceptar.setBounds(111, 202, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ventanaAgregar.setEnabled(false);
				campoModelo.setText("");
				campoPrecio.setText("");
				ventanaAgregar.setVisible(false);
			}
		});
		btnCancelar.setBounds(250, 202, 89, 23);
		contentPane.add(btnCancelar);
	}
}
