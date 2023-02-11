package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Ciudadano extends Thread{
	private String comunidad;
	private String rango;
	private String voto;
	private Connection conexion;
	
	
	public Ciudadano(String comunidad, String rango, Connection conexion) {
		this.comunidad = comunidad;
		this.rango = rango;
		this.conexion = conexion;
		this.voto = "";
		
	}
	
	public String getComunidad() {
		return comunidad;
	}
	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
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
			int numVoto = (int)(0+Math.random()*100);
			//int numVoto = 5;
		
			if(rango.equals("18_25")) {
				votosRango_18_25(conexion, numVoto);
			
			} else if(rango.equals("26_40")) {
				votosRango_26_40(conexion, numVoto);
			
			} else if(rango.equals("41_65")) {
				votosRango_41_65(conexion, numVoto);
			
			} else if(rango.equals("MAS_66")) {
				votosRango_MAS_66(conexion, numVoto);
			
			}
			/*try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void votosRango_MAS_66(Connection conexion, int numVoto) throws ClassNotFoundException, SQLException {
		if(numVoto>=0&&numVoto<=3) {
			this.setVoto("Joel");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=4&&numVoto<20) {
			this.setVoto("Victoria");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=21&&numVoto<=25) {
			this.setVoto("Thiago");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=26&&numVoto<=37) {
			this.setVoto("Sarah");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=38&&numVoto<=49) {
			this.setVoto("Elton");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=50&&numVoto<=58) {
			this.setVoto("Amie");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=59&&numVoto<=65) {
			this.setVoto("Nahid");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=66&&numVoto<=76) {
			this.setVoto("Marc");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=77&&numVoto<=91) {
			this.setVoto("Alba");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
			
		}else if(numVoto>=92&&numVoto<=100) {
			this.setVoto("Julio");
			updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
		}
		//updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
		
	}

	private void votosRango_41_65(Connection conexion, int numVoto) throws ClassNotFoundException, SQLException {
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
		
		updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
	}

	private void votosRango_26_40(Connection conexion, int numVoto) throws ClassNotFoundException, SQLException {
		if(numVoto>=0&&numVoto<=14) {
			this.setVoto("Joel");
			
		}else if(numVoto>=15&&numVoto<20) {
			this.setVoto("Victoria");
			
		}else if(numVoto>=21&&numVoto<=33) {
			this.setVoto("Thiago");
			
		}else if(numVoto>=34&&numVoto<=40) {
			this.setVoto("Sarah");
			
		}else if(numVoto>=41&&numVoto<=46) {
			this.setVoto("Elton");
			
		}else if(numVoto>=47&&numVoto<=58) {
			this.setVoto("Amie");
			
		}else if(numVoto>=59&&numVoto<=65) {
			this.setVoto("Nahid");
			
		}else if(numVoto>=66&&numVoto<=81) {
			this.setVoto("Marc");
			
		}else if(numVoto>=82&&numVoto<=90) {
			this.setVoto("Alba");
			
		}else if(numVoto>=91&&numVoto<=100) {
			this.setVoto("Julio");
		}
		
		updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
	}

	private void votosRango_18_25(Connection conexion, int numVoto) throws ClassNotFoundException, SQLException {
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
		
		updateVotosCantante(conexion, this.comunidad, this.rango, this.voto);
	}
	
	public void updateVotosCantante(Connection connection, String comunidad, String rango, String cantante) throws ClassNotFoundException, SQLException{
		
		String consultaSQL = "UPDATE VOTOS_COMUNIDAD_RANGO \r\n"
								+ "SET TOTAL_VOTOS = TOTAL_VOTOS + 1 \r\n"
								+ "WHERE NOMBRE_COMUNIDAD = ? AND RANGO_EDAD = ? AND NOMBRE_CANTANTE = ? ";
		PreparedStatement preparedStatement = null;

		try {
			
			preparedStatement = connection.prepareStatement(consultaSQL);
			preparedStatement.setString(1, comunidad);
			preparedStatement.setString(2, rango);
			preparedStatement.setString(3, cantante);
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
		return "Ciudadano [comunidad=" + comunidad + ", rango=" + rango + ", voto=" + voto + "]";
	}
}
