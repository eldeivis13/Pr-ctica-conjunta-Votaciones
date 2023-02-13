package vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVotaciones;
import persistencias.HilosRango;
import persistencias.RoundedBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;

public class VistaVotaciones extends JFrame {

	private JPanel contentPane;
	public JButton btnIniciar, btnNacional, btnRangos, btnComunidad, btnCerrar;
	public JPanel panelPortada, panelVotaciones, panelLista;
	public JLabel lblCargando, lblFondoPodio;
	public JLabel lblCantante1, lblCantante2, lblCantante3, lblNombreC2, lblVotosC2, lblVotosC1, lblNombreC1, lblVotosC3, lblNombre3;
	public JComboBox cbFiltros;
	public JList ltCantantes;

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
		panelVotaciones.setVisible(false);
		panelVotaciones.setLayout(null);
		
		lblFondoPodio = new JLabel("");
		lblFondoPodio.setBounds(0, -16, 1322, 727);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/resources/F1.jpg"));
		ImageIcon ico3 = new ImageIcon(img3.getImage().getScaledInstance(lblFondoPodio.getWidth(), lblFondoPodio.getHeight(), Image.SCALE_SMOOTH));
		
		panelLista = new JPanel();
		panelLista.setBackground(new Color(200, 13, 163));
		panelLista.setBounds(10, 136, 270, 304);
		panelVotaciones.add(panelLista);
		panelLista.setVisible(false);
		panelLista.setLayout(null);
		
		ltCantantes = new JList();
		ltCantantes.setBackground(new Color(204, 204, 204));
		ltCantantes.setFont(new Font("MV Boli", Font.BOLD, 13));
		ltCantantes.setBounds(10, 24, 250, 270);
		panelLista.add(ltCantantes);
		
		btnCerrar = new JButton("X");
		btnCerrar.setBackground(new Color(255, 0, 0));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCerrar.setBounds(221, 0, 49, 21);
		panelLista.add(btnCerrar);
		
		JLabel lblNewLabel = new JLabel("Clasificacion Final");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 0, 201, 21);
		panelLista.add(lblNewLabel);
		
		cbFiltros = new JComboBox();
		cbFiltros.setBackground(new Color(255, 255, 255));
		cbFiltros.setFont(new Font("MV Boli", Font.BOLD, 13));
		cbFiltros.setBounds(10, 450, 237, 21);
		panelVotaciones.add(cbFiltros);
		
		btnRangos = new JButton("Mostrar Por Rango");
		btnRangos.setBackground(new Color(204, 153, 204));
		btnRangos.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnRangos.setBounds(307, 663, 192, 38);
		panelVotaciones.add(btnRangos);
		
		btnComunidad = new JButton("Mostrar Por Comunidad");
		btnComunidad.setBackground(new Color(204, 153, 204));
		btnComunidad.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnComunidad.setBounds(861, 663, 212, 38);
		panelVotaciones.add(btnComunidad);
		
		btnNacional = new JButton("Mostrar General");
		btnNacional.setBackground(new Color(204, 153, 204));
		btnNacional.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnNacional.setBounds(589, 663, 192, 38);
		panelVotaciones.add(btnNacional);
		
		lblVotosC3 = new JLabel("");
		lblVotosC3.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblVotosC3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotosC3.setBounds(989, 518, 107, 27);
		lblVotosC3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panelVotaciones.add(lblVotosC3);
		
		lblVotosC1 = new JLabel("");
		lblVotosC1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotosC1.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblVotosC1.setBounds(704, 489, 107, 27);
		lblVotosC1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panelVotaciones.add(lblVotosC1);
		
		lblNombreC1 = new JLabel("");
		lblNombreC1.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblNombreC1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreC1.setBounds(574, 489, 120, 27);
		lblNombreC1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panelVotaciones.add(lblNombreC1);
		
		lblNombre3 = new JLabel("");
		lblNombre3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblNombre3.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblNombre3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre3.setBounds(859, 518, 120, 27);
		panelVotaciones.add(lblNombre3);
		
		lblNombreC2 = new JLabel("");
		lblNombreC2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblNombreC2.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblNombreC2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreC2.setBounds(301, 507, 120, 27);
		panelVotaciones.add(lblNombreC2);
		
		lblVotosC2 = new JLabel("");
		lblVotosC2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblVotosC2.setFont(new Font("MV Boli", Font.BOLD, 15));
		lblVotosC2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotosC2.setBounds(431, 507, 107, 27);
		panelVotaciones.add(lblVotosC2);
		
		lblCantante2 = new JLabel("");
		lblCantante2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblCantante2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantante2.setBounds(301, 174, 237, 253);
		panelVotaciones.add(lblCantante2);
		
		lblCantante3 = new JLabel("");
		lblCantante3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblCantante3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantante3.setBounds(859, 229, 237, 253);
		panelVotaciones.add(lblCantante3);
		
		lblCantante1 = new JLabel("");
		lblCantante1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblCantante1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantante1.setBounds(574, 124, 237, 253);
		panelVotaciones.add(lblCantante1);
		lblFondoPodio.setIcon(ico3);
		panelVotaciones.add(lblFondoPodio);
		
		panelPortada = new JPanel();
		panelPortada.setBounds(0, 0, 1221, 711);
		contentPane.add(panelPortada);
		panelPortada.setLayout(null);
		ImageIcon img = new ImageIcon(getClass().getResource("/resources/F3.jpg"));
		
		lblCargando = new JLabel("");
		lblCargando.setIcon(new ImageIcon(VistaVotaciones.class.getResource("/resources/carga3.gif")));
		lblCargando.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargando.setBounds(356, 442, 493, 259);
		ImageIcon img2 = new ImageIcon(getClass().getResource("/resources/carga3.gif"));
		ImageIcon ico2 = new ImageIcon(img2.getImage().getScaledInstance(lblCargando.getWidth(), lblCargando.getHeight(), Image.SCALE_SMOOTH));
		lblCargando.setVisible(false);
		panelPortada.add(lblCargando);
		
		btnIniciar = new JButton("Ir a las votaciones");
		btnIniciar.setBackground(new Color(204, 204, 255));
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIniciar.setBounds(508, 643, 196, 43);
		btnIniciar.setBorder(new RoundedBorder(10));
		panelPortada.add(btnIniciar);
		
		JLabel lblFotoPortada = new JLabel("");
		lblFotoPortada.setBounds(0, 0, 1221, 711);
		ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(lblFotoPortada.getWidth(), lblFotoPortada.getHeight(), Image.SCALE_SMOOTH));
		lblFotoPortada.setIcon(ico);
		panelPortada.add(lblFotoPortada);
	}
}
