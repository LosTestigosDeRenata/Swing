package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JFrame frame;
	private static VentanaPrincipal myVentana;
	private static VentanaAgregar ventanaAgregar;
	
	DefaultListModel<Auto> modelAuto = new DefaultListModel<Auto>();
	DefaultListModel<Estadisticas> modelEstadistica = new DefaultListModel<Estadisticas>();
	private LinkedList<Auto> listaAutoPosta = new LinkedList<Auto>();
	private LinkedList<Estadisticas> listaEstadisticasPosta = new LinkedList<Estadisticas>();
	
	private JList<Auto> listaAuto;
	private JList<Estadisticas> listaEstadisticas;
	
//	JList<Auto> listaAuto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myVentana = new VentanaPrincipal();
					myVentana.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 888, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ventanaAgregar == null)
				{
					ventanaAgregar = new VentanaAgregar(myVentana);
				}else
					ventanaAgregar.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(645, 407, 89, 23);
		frame.getContentPane().add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(527, 10, 271, 208);
		frame.getContentPane().add(scrollPane);
		
		listaEstadisticas = new JList<Estadisticas>(modelEstadistica);
		scrollPane.setViewportView(listaEstadisticas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(9, 16, 499, 433);
		frame.getContentPane().add(scrollPane_1);
		
		listaAuto = new JList<Auto>(modelAuto);
		scrollPane_1.setViewportView(listaAuto);
		listaAuto.setValueIsAdjusting(true);
		
		JList<Estadisticas> listaEstadisticas = new JList<Estadisticas>();
		listaEstadisticas.setBounds(232, 11, 192, 187);
		frame.getContentPane().add(listaEstadisticas);
	}
	
	public void addAuto(Auto autoPaquetito){
		int index;
		Estadisticas e = new Estadisticas(autoPaquetito);
		listaAutoPosta.add(autoPaquetito);
		modelAuto.addElement(autoPaquetito);
		
		index = listaEstadisticasPosta.indexOf(e);
		
		if(index != -1){
			listaEstadisticasPosta.get(index).actualizar(autoPaquetito.getPrecio());
		}
		else{
			listaEstadisticasPosta.add(e);
			modelEstadistica.addElement(e);
		}
	}

}