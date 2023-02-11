package persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		
	    Connection connection = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CENSO_POR_COMUNIDADES?serverTimezone=UTC", "root", "root");
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
	
	public List<HilosRango> getHilosRango_18_25(Connection conecction, String rango) throws Exception {
		List<HilosRango> listaHilos = new ArrayList<HilosRango>();
		
		String consultaSQL = "SELECT PR.NOMBRE_COMUNIDAD, ROUND((PR.TOTAL_HABITANTES * (PR.RANGO_18_25 / 100)) * (PVR.PORCENTAJE / 100)) AS HILO \r\n"
				+ "FROM PORCENTAJES_RANGOEDAD AS PR, PORCENTAJE_VOTACION_RANGO AS PVR \r\n"
				+ "WHERE PVR.RANGO = ?";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			conecction = createConnection();
			
			preparedStatement = conecction.prepareStatement(consultaSQL);
			preparedStatement.setString(1, rango);
			resultset = preparedStatement.executeQuery();
			
			HilosRango hilos;
			while(resultset.next()) {
				hilos = new HilosRango();
				hilos.setComunidad(resultset.getString("NOMBRE_COMUNIDAD"));
				hilos.setHilos(resultset.getInt("HILO"));
				listaHilos.add(hilos);
			}
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			//cerramos todos los resources
			if (null != resultset) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaHilos;
		
	}
	
	public List<HilosRango> getHilosRango_26_40(Connection conecction, String rango) throws Exception {
		List<HilosRango> listaHilos = new ArrayList<HilosRango>();
		
		String consultaSQL = "SELECT PR.NOMBRE_COMUNIDAD, ROUND((PR.TOTAL_HABITANTES * (PR.RANGO_26_40 / 100)) * (PVR.PORCENTAJE / 100)) AS HILO \r\n"
				+ "FROM PORCENTAJES_RANGOEDAD AS PR, PORCENTAJE_VOTACION_RANGO AS PVR \r\n"
				+ "WHERE PVR.RANGO = ?";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			conecction = createConnection();
			
			preparedStatement = conecction.prepareStatement(consultaSQL);
			preparedStatement.setString(1, rango);
			resultset = preparedStatement.executeQuery();
			
			HilosRango hilos;
			while(resultset.next()) {
				hilos = new HilosRango();
				hilos.setComunidad(resultset.getString("NOMBRE_COMUNIDAD"));
				hilos.setHilos(resultset.getInt("HILO"));
				listaHilos.add(hilos);
			}
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			//cerramos todos los resources
			if (null != resultset) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaHilos;
		
	}
	
	public List<HilosRango> getHilosRango_41_65(Connection conecction, String rango) throws Exception {
		List<HilosRango> listaHilos = new ArrayList<HilosRango>();
		
		String consultaSQL = "SELECT PR.NOMBRE_COMUNIDAD, ROUND((PR.TOTAL_HABITANTES * (PR.RANGO_41_65 / 100)) * (PVR.PORCENTAJE / 100)) AS HILO \r\n"
				+ "FROM PORCENTAJES_RANGOEDAD AS PR, PORCENTAJE_VOTACION_RANGO AS PVR \r\n"
				+ "WHERE PVR.RANGO = ?";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			conecction = createConnection();
			
			preparedStatement = conecction.prepareStatement(consultaSQL);
			preparedStatement.setString(1, rango);
			resultset = preparedStatement.executeQuery();
			
			HilosRango hilos;
			while(resultset.next()) {
				hilos = new HilosRango();
				hilos.setComunidad(resultset.getString("NOMBRE_COMUNIDAD"));
				hilos.setHilos(resultset.getInt("HILO"));
				listaHilos.add(hilos);
			}
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			//cerramos todos los resources
			if (null != resultset) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaHilos;
		
	}
	
	public List<HilosRango> getHilosRango_MAS_66(Connection conecction, String rango) throws Exception {
		List<HilosRango> listaHilos = new ArrayList<HilosRango>();
		
		String consultaSQL = "SELECT PR.NOMBRE_COMUNIDAD, ROUND((PR.TOTAL_HABITANTES * (PR.RANGO_MAS_66 / 100)) * (PVR.PORCENTAJE / 100)) AS HILO \r\n"
				+ "FROM PORCENTAJES_RANGOEDAD AS PR, PORCENTAJE_VOTACION_RANGO AS PVR \r\n"
				+ "WHERE PVR.RANGO = ?";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			conecction = createConnection();
			
			preparedStatement = conecction.prepareStatement(consultaSQL);
			preparedStatement.setString(1, rango);
			resultset = preparedStatement.executeQuery();
			
			HilosRango hilos;
			while(resultset.next()) {
				hilos = new HilosRango();
				hilos.setComunidad(resultset.getString("NOMBRE_COMUNIDAD"));
				hilos.setHilos(resultset.getInt("HILO"));
				listaHilos.add(hilos);
			}
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			//cerramos todos los resources
			if (null != resultset) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return listaHilos;
		
	}

	public static void main(String[] args) {
		Connection connection = null;
		Main helper = new Main();
		
		try {
			connection = helper.createConnection();
			Ciudadano ciudadano = null;
			int cont = 0;
			
			getvotosRango_18_25(connection, helper, ciudadano, cont);
			
			getVotosRango_26_45(connection, helper, ciudadano, cont);
			
			getVotosRango_41_65(connection, helper, ciudadano, cont);
			
			getVotosRango_MAS_66(connection, helper, ciudadano, cont);
			
			connection.commit();
			
		}catch (Exception s ) {
			try {
				connection.rollback();
			} catch (SQLException s2) {
				s2.printStackTrace();
			}
			s.printStackTrace();
		}
		
		
	}

	private static void getVotosRango_MAS_66(Connection connection, Main helper, Ciudadano ciudadano, int cont) throws Exception, InterruptedException {
		List<HilosRango> listaHilosMAS_66 = helper.getHilosRango_MAS_66(connection, "Rango_MAS_66"); 
		//System.out.println(listaHilosMAS_66 + "\n");
		
		for(int i = 0; i < listaHilosMAS_66.size(); i++) {
			for( int j = 0; j<listaHilosMAS_66.get(i).getHilos(); j++) {
				/*if(listaHilosMAS_66.get(i).getHilos() < 3) {
					while(cont <= 3) {
						ciudadano = new Ciudadano(listaHilosMAS_66.get(i).getComunidad(), "MAS_66", connection);
						ciudadano.start();
						ciudadano.join();
						cont++;
						System.out.println(ciudadano.toString());
					}
				}else {*/
					ciudadano = new Ciudadano(listaHilosMAS_66.get(i).getComunidad(), "MAS_66", connection);
					ciudadano.start();
					ciudadano.join();
					System.out.println(ciudadano.toString());
				//}
			}
		}
	}

	private static void getVotosRango_41_65(Connection connection, Main helper, Ciudadano ciudadano, int cont) throws Exception, InterruptedException {
		List<HilosRango> listaHilos41_65 = helper.getHilosRango_41_65(connection, "Rango_41_65"); 
		//System.out.println(listaHilos41_65 + "\n");
		
		for(int i = 0; i < listaHilos41_65.size(); i++) {
			for( int j = 0; j<listaHilos41_65.get(i).getHilos(); j++) {
				if(listaHilos41_65.get(i).getHilos() < 3) {
					while(cont <= 3) {
						ciudadano = new Ciudadano(listaHilos41_65.get(i).getComunidad(), "41_65", connection);
						ciudadano.start();
						ciudadano.join();
						cont++;
						//System.out.println(ciudadano.toString());
					}
				}else {
					ciudadano = new Ciudadano(listaHilos41_65.get(i).getComunidad(), "41_65", connection);
					ciudadano.start();
					ciudadano.join();
					//System.out.println(ciudadano.toString());
				}
			}
		}
	}

	private static void getVotosRango_26_45(Connection connection, Main helper, Ciudadano ciudadano, int cont) throws Exception, InterruptedException {
		List<HilosRango> listaHilos26_40 = helper.getHilosRango_26_40(connection, "Rango_26_40"); 
		//System.out.println(listaHilos26_40 + "\n");
		
		for(int i = 0; i < listaHilos26_40.size(); i++) {
			for( int j = 0; j<listaHilos26_40.get(i).getHilos(); j++) {
				if(listaHilos26_40.get(i).getHilos() < 3) {
					while(cont <= 3) {
						ciudadano = new Ciudadano(listaHilos26_40.get(i).getComunidad(), "26_40", connection);
						ciudadano.start();
						ciudadano.join();
						cont++;
						//System.out.println(ciudadano.toString());
					}
				}else {
					ciudadano = new Ciudadano(listaHilos26_40.get(i).getComunidad(), "26_40", connection);
					ciudadano.start();
					ciudadano.join();
					//System.out.println(ciudadano.toString());
				}
			}
		}
	}

	private static void getvotosRango_18_25(Connection connection, Main helper, Ciudadano ciudadano, int cont) throws Exception, InterruptedException {
		List<HilosRango> listaHilos18_25 = helper.getHilosRango_18_25(connection, "Rango_18_25"); 
		
		for(int i = 0; i < listaHilos18_25.size(); i++) {
			for( int j = 0; j<listaHilos18_25.get(i).getHilos(); j++) {
				if(listaHilos18_25.get(i).getHilos() < 3) {
					while(cont <= 3) {
						ciudadano = new Ciudadano(listaHilos18_25.get(i).getComunidad(), "18_25", connection);
						ciudadano.start();
						ciudadano.join();
						cont++;
						//System.out.println(ciudadano.toString());
					}
				}else {
					ciudadano = new Ciudadano(listaHilos18_25.get(i).getComunidad(), "18_25", connection);
					ciudadano.start();
					ciudadano.join();
					//System.out.println(ciudadano.toString());
				}
			}
		}
	}

}
