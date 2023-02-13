package persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vista.VistaVotaciones;

public class Hilo_18_25 extends Thread{
	private String voto;
	private Connection conexion;
	
	public Hilo_18_25(Connection conexion) {
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
			votosRango_18_25(conexion);
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
	
	public List<HilosRango> getHilosRango_18_25(Connection conecction) throws Exception {
		List<HilosRango> listaHilos = new ArrayList<HilosRango>();
		
		String consultaSQL = "SELECT PR.NOMBRE_COMUNIDAD, ROUND((PR.TOTAL_HABITANTES * (PR.RANGO_18_25 / 100)) * (PVR.PORCENTAJE / 100)) AS HILO \r\n"
				+ "FROM PORCENTAJES_RANGOEDAD AS PR, PORCENTAJE_VOTACION_RANGO AS PVR \r\n"
				+ "WHERE PVR.RANGO = 'RANGO_18_25' ";
		
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

	private void votosRango_18_25(Connection conexion) throws InterruptedException, Exception {
		List<HilosRango> comunidades = getHilosRango_18_25(conexion);
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

	private void getVoto(int numVoto) {
		if(numVoto>=0&&numVoto<=7) {
			this.setVoto("Joel");
			
		}else if(numVoto>=8&&numVoto<10) {
			this.setVoto("Victoria");
			
		}else if(numVoto>=11&&numVoto<=23) {
			this.setVoto("Thiago");
			
		}else if(numVoto>=24&&numVoto<=30) {
			this.setVoto("Sarah");
			
		}else if(numVoto>=31&&numVoto<=37) {
			this.setVoto("Elton");
			
		}else if(numVoto>=38&&numVoto<=51) {
			this.setVoto("Amie");
			
		}else if(numVoto>=52&&numVoto<=61) {
			this.setVoto("Nahid");
			
		}else if(numVoto>=62&&numVoto<=88) {
			this.setVoto("Marc");
			
		}else if(numVoto>=89&&numVoto<=95) {
			this.setVoto("Alba");
			
		}else if(numVoto>=96&&numVoto<=100) {
			this.setVoto("Julio");
			
		}
	}
	
	public void updateVotosCantante(Connection connection, String comunidad, String cantante) throws ClassNotFoundException, SQLException{
		
		String consultaSQL = "UPDATE VOTOS_COMUNIDAD_RANGO \r\n"
								+ "SET RANGO_18_25 = RANGO_18_25 + 1 \r\n"
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
