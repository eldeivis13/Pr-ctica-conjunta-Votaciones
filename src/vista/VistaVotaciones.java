package vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVotaciones;
import persistencias.RoundedBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VistaVotaciones extends JFrame {

	private JPanel contentPane;
	public JButton btnIniciar;
	public JPanel panelPortada, panelVotaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVotaciones frame = new VistaVotaciones();
					ControladorVotaciones controlador = new ControladorVotaciones(frame);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaVotaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelVotaciones = new JPanel();
		panelVotaciones.setBounds(0, 0, 1221, 711);
		contentPane.add(panelVotaciones);
		
		panelPortada = new JPanel();
		panelPortada.setBounds(0, 0, 1221, 711);
		contentPane.add(panelPortada);
		panelPortada.setLayout(null);
		
		JLabel lblFotoPortada = new JLabel("");
		lblFotoPortada.setBounds(0, 0, 1221, 711);
		ImageIcon img = new ImageIcon(getClass().getResource("/resources/F3.jpg"));
		ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(lblFotoPortada.getWidth(), lblFotoPortada.getHeight(), Image.SCALE_SMOOTH));
		
		btnIniciar = new JButton("Ir a las votaciones");
		btnIniciar.setBackground(new Color(204, 204, 255));
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIniciar.setBounds(509, 619, 196, 43);
		btnIniciar.setBorder(new RoundedBorder(10));
		panelPortada.add(btnIniciar);
		lblFotoPortada.setIcon(ico);
		panelPortada.add(lblFotoPortada);
	}
}
