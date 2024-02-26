package tipMaster;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import java.awt.Color;


import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;


public class TipMaster extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField importe;
	private JTextField porcentaje;
	private JTextField total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipMaster frame = new TipMaster();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TipMaster() {
		setTitle("TipMaster - Calculadora de propinas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TipMaster.class.getResource("/tipMaster/img/ww.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(148, 177, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		importe = new JTextField();
		importe.setHorizontalAlignment(SwingConstants.CENTER);
		importe.setBounds(36, 94, 278, 63);
		
		contentPane.add(importe);
		importe.setColumns(10);
		
		
		porcentaje = new JTextField();
		porcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		porcentaje.setColumns(10);
		porcentaje.setBounds(342, 94, 278, 63);
		contentPane.add(porcentaje);
		
		JButton calcular = new JButton("Calcular");
		calcular.setFont(new Font("Tahoma", Font.BOLD, 15));
		calcular.setForeground(new Color(255, 255, 255));
		calcular.setBackground(new Color(60, 179, 113));
		calcular.setBounds(668, 94, 98, 63);
		contentPane.add(calcular);
		
		JTextField propina = new JTextField();
		propina.setHorizontalAlignment(SwingConstants.CENTER);
		propina.setEditable(false);
		propina.setBounds(204, 218, 270, 32);
		
		contentPane.add(propina);
		
		JLabel importe_label = new JLabel("Importe");
		importe_label.setFont(new Font("Tahoma", Font.BOLD, 25));
		importe_label.setHorizontalAlignment(SwingConstants.CENTER);
		importe_label.setBounds(89, 34, 177, 49);
		contentPane.add(importe_label);
		
		JLabel porcentaje_label = new JLabel("%");
		porcentaje_label.setHorizontalAlignment(SwingConstants.CENTER);
		porcentaje_label.setFont(new Font("Tahoma", Font.BOLD, 25));
		porcentaje_label.setBounds(396, 34, 177, 49);
		contentPane.add(porcentaje_label);
		
		JLabel propina_label = new JLabel("Propina");
		propina_label.setHorizontalAlignment(SwingConstants.CENTER);
		propina_label.setFont(new Font("Tahoma", Font.BOLD, 25));
		propina_label.setBounds(242, 168, 177, 49);
		contentPane.add(propina_label);
		
		JButton reset_button = new JButton("Limpiar");
		reset_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		reset_button.setForeground(new Color(255, 255, 255));
		reset_button.setBackground(new Color(255, 0, 0));
		reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importe.setText("");
				porcentaje.setText("");
				propina.setText("");
				total.setText("");
			}
		});
		reset_button.setBounds(668, 247, 98, 32);
		contentPane.add(reset_button);
		
		JLabel total_label = new JLabel("Importe total");
		total_label.setHorizontalAlignment(SwingConstants.CENTER);
		total_label.setFont(new Font("Tahoma", Font.BOLD, 25));
		total_label.setBounds(242, 256, 177, 49);
		contentPane.add(total_label);
		
		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setEditable(false);
		total.setBounds(204, 308, 270, 32);
		contentPane.add(total);
		
		
		
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // obtener los valores de los TextField
                String importeStr= importe.getText();
                String porcentajeStr = porcentaje.getText();

                // convertir a double
                double importeValue = Double.parseDouble(importeStr);
                double porcentajeValue = Double.parseDouble(porcentajeStr);

                // operacion
                double resultado = importeValue * porcentajeValue / 100;

                // Mostrar
                propina.setText(Double.toString(resultado) + "€");
                total.setText(Double.toString(resultado + importeValue) + "€");
            }
		});
			
	}
}
