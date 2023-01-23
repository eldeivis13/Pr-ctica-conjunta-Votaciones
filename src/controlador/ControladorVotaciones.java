package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vista.VistaVotaciones;

public class ControladorVotaciones implements ActionListener{
	
	VistaVotaciones vista = new VistaVotaciones();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public ControladorVotaciones(VistaVotaciones vista) {
		
		this.vista = vista;
		this.vista.btnIniciar.addActionListener(this);
		
	}
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
			
	        Connection connection = null;
	
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Habitantes?serverTimezone=UTC", "root", "root");
	            connection.setAutoCommit(false);
	        }catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	
	        return connection;
	    }
		
		public void disconnect(Connection connection) throws SQLException {
			
			if (null != connection) {
				try {
					connection.close();
					connection = null;
				}catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}

}
