package persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Hilo41_65 extends Thread { 
	private String voto;
	private Connection conexion;
	
	public Hilo41_65(Connection conexion) {
		this.conexion = conexion;
		this.voto = "";
		
	}
	public Connection getConexion() {
		return conexion;
	}
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	public void run() {
		
		try {
			votosRango_41_65(conexion);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		/*try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private void getVoto(int numVoto) throws ClassNotFoundException, SQLException {
		if(numVoto>=0&&numVoto<=5) {
			this.setVoto("Joel");
			
		}else if(numVoto>=6&&numVoto<15) {
			this.setVoto("Victoria");
			
		}else if(numVoto>=16&&numVoto<=27) {
			this.setVoto("Thiago");
			
		}else if(numVoto>=28&&numVoto<=33) {
			this.setVoto("Sarah");
			
		}else if(numVoto>=34&&numVoto<=40) {
			this.setVoto("Elton");
			
		}else if(numVoto>=41&&numVoto<=54) {
			this.setVoto("Amie");
			
		}else if(numVoto>=55&&numVoto<=61) {
			this.setVoto("Nahid");
			
		}else if(numVoto>=62&&numVoto<=71) {
			this.setVoto("Marc");
			
		}else if(numVoto>=72&&numVoto<=88) {
			this.setVoto("Alba");
			
		}else if(numVoto>=89&&numVoto<=100) {
			this.setVoto("Julio");
		}
	}
	
	public List<HilosRango> getHilosRango_41_65(Connection conecction) throws Exception {
		List<HilosRango> listaHilos = new ArrayList<HilosRango>();
		
		String consultaSQL = "SELECT PR.NOMBRE_COMUNIDAD, ROUND((PR.TOTAL_HABITANTES * (PR.RANGO_41_65 / 100)) * (PVR.PORCENTAJE / 100)) AS HILO \r\n"
				+ "FROM PORCENTAJES_RANGOEDAD AS PR, PORCENTAJE_VOTACION_RANGO AS PVR \r\n"
				+ "WHERE PVR.RANGO = 'RANGO_41_65' ";
		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			
			preparedStatement = conecction.prepareStatement(consultaSQL);
			resultset = preparedStatement.executeQuery();
			
			HilosRango hilos;
			while(resultset.next()) {
				hilos = new HilosRango();
				hilos.setComunidad(resultset.getString("NOMBRE_COMUNIDAD"));
				hilos.setHilos(resultset.getInt("HILO"));
				listaHilos.add(hilos);
			}
			
			
		}catch (SQLException e) {
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

	private void votosRango_41_65(Connection conexion) throws InterruptedException, Exception {
		List<HilosRango> comunidades = getHilosRango_41_65(conexion);
		int cont = 0;
		
		for(int i = 0; i < comunidades.size(); i++) {
			for( int j = 0; j < comunidades.get(i).getHilos(); j++) {
				int numVoto = (int)(0+Math.random()*100);
				if(comunidades.get(i).getHilos() < 3) {
					while(cont <= 3) {
						getVoto(numVoto);
						updateVotosCantante(conexion, comunidades.get(i).getComunidad(), this.getVoto());
						System.out.println(comunidades.get(i).getComunidad() + " " + this.getVoto());
						cont++;
					}
				}else {
					getVoto(numVoto);
					updateVotosCantante(conexion, comunidades.get(i).getComunidad(), this.getVoto());
					System.out.println(comunidades.get(i).getComunidad() + " " + this.getVoto());
				}
			}
		}
	}
	
	public void updateVotosCantante(Connection connection, String comunidad, String cantante) throws ClassNotFoundException, SQLException{
		
		String consultaSQL = "UPDATE VOTOS_COMUNIDAD_RANGO \r\n"
								+ "SET RANGO_41_65 = RANGO_41_65 + 1 \r\n"
								+ "WHERE NOMBRE_COMUNIDAD = ? AND NOMBRE_CANTANTE = ? ";
		PreparedStatement preparedStatement = null;

		try {
			
			preparedStatement = connection.prepareStatement(consultaSQL);
			preparedStatement.setString(1, comunidad);
			preparedStatement.setString(2, cantante);
			preparedStatement.executeUpdate();
			
			
			connection.commit();

		} catch (SQLException e) {
			connection.rollback();
			
			e.printStackTrace();
			throw e;
		} finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Ciudadano [ voto=" + voto + " ]";
	}
}
