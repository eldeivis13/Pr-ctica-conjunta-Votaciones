package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import persistencias.Hilo26_40;
import persistencias.Hilo41_65;
import persistencias.Hilo_18_25;
import persistencias.Hilo_MAS_66;
import persistencias.HilosRango;
import persistencias.VotosComunidadRango;
import vista.VistaVotaciones;

public class ControladorVotaciones implements ActionListener{
	
	VistaVotaciones vista = new VistaVotaciones();
	HashMap<String, String> fotosCantantes = new HashMap<>();
	HashMap<String, String> cancionesCantantes = new HashMap<String, String>();
	DefaultListModel<String> modelo = new DefaultListModel<>();
	Boolean btnC = false, btnR = false;
	
	public ControladorVotaciones(VistaVotaciones vista) {
		
		this.vista = vista;
		this.vista.btnIniciar.addActionListener(this);
		this.vista.btnCerrar.addActionListener(this);
		this.vista.btnComunidad.addActionListener(this);
		this.vista.btnNacional.addActionListener(this);
		this.vista.btnRangos.addActionListener(this);
		this.vista.cbFiltros.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				Connection connection = null;
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            
		            if(vista.cbFiltros.getSelectedItem().equals("Rango_18_25")) {
						try {
							List<VotosComunidadRango> lista18_25 = get3MejoresRango_18_25(connection);
							getCantanteRangoComunidad(lista18_25);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Rango_26_40")) {
						try {
							List<VotosComunidadRango> lista26_40 = get3MejoresRango_26_40(connection);
							getCantanteRangoComunidad(lista26_40);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Rango_41_65")) {
						try {
							List<VotosComunidadRango> lista41_65 = get3MejoresRango_41_65(connection);
							getCantanteRangoComunidad(lista41_65);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Rango_MAS_66")) {
						try {
							List<VotosComunidadRango> listaMAS_66 = get3MejoresRango_MAS_66(connection);
							getCantanteRangoComunidad(listaMAS_66);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Andalucia")) {
						try {
							List<VotosComunidadRango> listaAndalucia = get3MejoresComunidad(connection, "Andalucia");
							getCantanteRangoComunidad(listaAndalucia);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Aragon")) {
						try {
							List<VotosComunidadRango> Aragon = get3MejoresComunidad(connection, "Aragon");
							getCantanteRangoComunidad(Aragon);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Asturias")) {
						try {
							List<VotosComunidadRango> listaAsturias = get3MejoresComunidad(connection, "Asturias");
							getCantanteRangoComunidad(listaAsturias);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Baleares")) {
						try {
							List<VotosComunidadRango> listaBaleares = get3MejoresComunidad(connection, "Baleares");
							getCantanteRangoComunidad(listaBaleares);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Canarias")) {
						try {
							List<VotosComunidadRango> Canarias = get3MejoresComunidad(connection, "Canarias");
							getCantanteRangoComunidad(Canarias);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Cantabria")) {
						try {
							List<VotosComunidadRango> Cantabria = get3MejoresComunidad(connection, "Cantabria");
							getCantanteRangoComunidad(Cantabria);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Castilla La Mancha")) {
						try {
							List<VotosComunidadRango> CastillaLaMancha = get3MejoresComunidad(connection, "Castilla La Mancha");
							getCantanteRangoComunidad(CastillaLaMancha);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Castilla y León")) {
						try {
							List<VotosComunidadRango> CastillayLeón = get3MejoresComunidad(connection, "Castilla y León");
							getCantanteRangoComunidad(CastillayLeón);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Cataluña")) {
						try {
							List<VotosComunidadRango> Cataluña = get3MejoresComunidad(connection, "Catalunia");
							getCantanteRangoComunidad(Cataluña);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Comunidad Valenciana")) {
						try {
							List<VotosComunidadRango> ComunidadValenciana = get3MejoresComunidad(connection, "Comunidad Valenciana");
							getCantanteRangoComunidad(ComunidadValenciana);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Extremadura")) {
						try {
							List<VotosComunidadRango> Extremadura = get3MejoresComunidad(connection, "Extremadura");
							getCantanteRangoComunidad(Extremadura);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Galicia")) {
						try {
							List<VotosComunidadRango> Galicia = get3MejoresComunidad(connection, "Galicia");
							getCantanteRangoComunidad(Galicia);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Madrid")) {
						try {
							List<VotosComunidadRango> Madrid = get3MejoresComunidad(connection, "Madrid");
							getCantanteRangoComunidad(Madrid);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Murcia")) {
						try {
							List<VotosComunidadRango> Murcia = get3MejoresComunidad(connection, "Murcia");
							getCantanteRangoComunidad(Murcia);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Navarra")) {
						try {
							List<VotosComunidadRango> Navarra = get3MejoresComunidad(connection, "Navarra");
							getCantanteRangoComunidad(Navarra);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Pais Vasco")) {
						try {
							List<VotosComunidadRango> PaisVasco = get3MejoresComunidad(connection, "Pais Vasco");
							getCantanteRangoComunidad(PaisVasco);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("La Rioja")) {
						try {
							List<VotosComunidadRango> LaRioja = get3MejoresComunidad(connection, "La Rioja");
							getCantanteRangoComunidad(LaRioja);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Ceuta")) {
						try {
							List<VotosComunidadRango> Ceuta = get3MejoresComunidad(connection, "Ceuta");
							getCantanteRangoComunidad(Ceuta);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(vista.cbFiltros.getSelectedItem().equals("Melilla")) {
						try {
							List<VotosComunidadRango> Melilla = get3MejoresComunidad(connection, "Melilla");
							getCantanteRangoComunidad(Melilla);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
		        }
				
			}
		});
	}
	
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
		
		public void inicializarFotos() {
			
			fotosCantantes.put("Joel", "/resources/joel.jpg");
			fotosCantantes.put("Victoria", "/resources/victoria.jpg");
			fotosCantantes.put("Thiago", "/resources/thiago.jpg");
			fotosCantantes.put("Sarah", "/resources/sara.jpg");
			fotosCantantes.put("Elton", "/resources/elton.jpg");
			fotosCantantes.put("Amie", "/resources/amie.jpg");
			fotosCantantes.put("Nahid", "/resources/nahid.jpg");
			fotosCantantes.put("Marc", "/resources/marc.jpg");
			fotosCantantes.put("Alba", "/resources/alba.jpg");
			fotosCantantes.put("Julio", "/resources/julio.jpg");
			
			cancionesCantantes.put("Joel", "/resources/joel.mp3");
			cancionesCantantes.put("Victoria", "/resources/victoria.mp3");
			cancionesCantantes.put("Thiago", "/resources/thiago.mp3");
			cancionesCantantes.put("Sarah", "/resources/sara.mp3");
			cancionesCantantes.put("Elton", "/resources/elton.mp3");
			cancionesCantantes.put("Amie", "/resources/amie.mp3");
			cancionesCantantes.put("Nahid", "/resources/nahid.mp3");
			cancionesCantantes.put("Marc", "/resources/marc.mp3");
			cancionesCantantes.put("Alba", "/resources/alba.mp3");
			cancionesCantantes.put("Julio", "/resources/julio.mp3");
			
		}
		
		
		private void updateCantanteComunidad(Connection connection, ControladorVotaciones helper)
				throws Exception, InterruptedException, ClassNotFoundException, SQLException {
			
			List<VotosComunidadRango> cantantes = getCantante(connection);
			
			for(int i = 0; i < cantantes.size(); i++) {
				System.out.println(cantantes.get(i).getNombreCantante());
				int votos = getTotalVotos(connection, cantantes.get(i).getNombreCantante());
				System.out.println(votos);
				updateCantantes(connection, votos, cantantes.get(i).getNombreCantante());
			}
				
			List<VotosComunidadRango> comunidad = helper.getComunidad(connection);
				
			for(int i = 0; i < comunidad.size(); i++) {
				List<VotosComunidadRango> Top3 = helper.get3MejoresComunidad(connection, comunidad.get(i).getNombreComunidad());
				
				helper.updateMejoresCantantes(connection, 15, comunidad.get(i).getNombreComunidad(), Top3.get(0).getNombreCantante());
				helper.updateMejoresCantantes(connection, 10, comunidad.get(i).getNombreComunidad(), Top3.get(1).getNombreCantante());
				helper.updateMejoresCantantes(connection, 8, comunidad.get(i).getNombreComunidad(), Top3.get(2).getNombreCantante());
			}
			
			List<VotosComunidadRango> top3 = get3MejoresNacional(connection);
			
			listaCantantesNacional(top3);
			mostrarCantantesGanadores(top3);
		}
		
		public int getTotalVotos(Connection connection, String nombre) throws Exception, InterruptedException {
			int votos = 0;
			
			String consultaSQL = "SELECT SUM(RANGO_18_25 + RANGO_26_40 + RANGO_41_65 + RANGO_MAS_66) AS VOTOS \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO\r\n"
					+ "WHERE NOMBRE_CANTANTE = ? ";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				preparedStatement.setString(1, nombre);
				resultset = preparedStatement.executeQuery();
				
				while(resultset.next()) {
					votos = resultset.getInt("VOTOS");
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
			
			return votos;
		}
		
		
		public void updateCantantes(Connection connection, int num, String cantante) throws ClassNotFoundException, SQLException{
			
			String consultaSQL = "UPDATE VOTOS_COMUNIDAD_RANGO SET TOTAL_VOTOS = TOTAL_VOTOS + ? WHERE NOMBRE_CANTANTE = ?";
			PreparedStatement preparedStatement = null;

			try {
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				preparedStatement.setInt(1, num);
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
		
		public void updateMejoresCantantes(Connection connection, int num, String comunidad, String cantante) throws ClassNotFoundException, SQLException{
			
			String consultaSQL = "UPDATE VOTOS_COMUNIDAD_RANGO \r\n"
									+ "SET TOTAL_VOTOS = TOTAL_VOTOS + ? \r\n"
									+ "WHERE NOMBRE_COMUNIDAD = ? AND NOMBRE_CANTANTE = ?";
			PreparedStatement preparedStatement = null;

			try {
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				preparedStatement.setInt(1, num);
				preparedStatement.setString(2, comunidad);
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
		
		public List<VotosComunidadRango> getCantante(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> cantante = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT DISTINCT NOMBRE_CANTANTE FROM VOTOS_COMUNIDAD_RANGO";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vComunidad;
				while(resultset.next()) {
					vComunidad = new VotosComunidadRango();
					vComunidad.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					cantante.add(vComunidad);
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
			
			return cantante;
		}
		
		public List<VotosComunidadRango> getComunidad(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> comunidad = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT DISTINCT NOMBRE_COMUNIDAD \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO ";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vComunidad;
				while(resultset.next()) {
					vComunidad = new VotosComunidadRango();
					vComunidad.setNombreComunidad(resultset.getString("NOMBRE_COMUNIDAD"));
					comunidad.add(vComunidad);
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
			
			return comunidad;
		}
		
		public List<VotosComunidadRango> get3MejoresComunidad(Connection connection, String comunidad) throws Exception, InterruptedException {
			List<VotosComunidadRango> top3CantantesComunidad = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT NOMBRE_CANTANTE, SUM(RANGO_18_25 + RANGO_26_40 + RANGO_41_65 + RANGO_MAS_66) AS VOTOS \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO \r\n"
					+ "WHERE NOMBRE_COMUNIDAD = ? \r\n"
					+ "GROUP BY NOMBRE_CANTANTE \r\n"
					+ "ORDER BY VOTOS DESC LIMIT 3";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				preparedStatement.setString(1, comunidad);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vCantante;
				while(resultset.next()) {
					vCantante = new VotosComunidadRango();
					vCantante.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					vCantante.setTotalVotos(resultset.getInt("VOTOS"));
					top3CantantesComunidad.add(vCantante);
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
			
			return top3CantantesComunidad;
		}
		
		public List<VotosComunidadRango> get3MejoresRango_MAS_66(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> top3_MAS_66 = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT NOMBRE_CANTANTE, RANGO_MAS_66 \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO \r\n"
					+ "GROUP BY NOMBRE_CANTANTE \r\n"
					+ "ORDER BY RANGO_MAS_66 DESC LIMIT 3";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vCantante;
				while(resultset.next()) {
					vCantante = new VotosComunidadRango();
					vCantante.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					vCantante.setTotalVotos(resultset.getInt("RANGO_MAS_66"));
					top3_MAS_66.add(vCantante);
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
			
			return top3_MAS_66;
		}
		
		public List<VotosComunidadRango> get3MejoresRango_41_65(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> top3_41_65 = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT NOMBRE_CANTANTE, RANGO_41_65 \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO \r\n"
					+ "GROUP BY NOMBRE_CANTANTE \r\n"
					+ "ORDER BY RANGO_41_65 DESC LIMIT 3";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vCantante;
				while(resultset.next()) {
					vCantante = new VotosComunidadRango();
					vCantante.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					vCantante.setTotalVotos(resultset.getInt("RANGO_41_65"));
					top3_41_65.add(vCantante);
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
			
			return top3_41_65;
		}
		
		public List<VotosComunidadRango> get3MejoresRango_26_40(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> top3_26_40 = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT NOMBRE_CANTANTE, RANGO_26_40 \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO \r\n"
					+ "GROUP BY NOMBRE_CANTANTE \r\n"
					+ "ORDER BY RANGO_26_40 DESC LIMIT 3";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vCantante;
				while(resultset.next()) {
					vCantante = new VotosComunidadRango();
					vCantante.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					vCantante.setTotalVotos(resultset.getInt("RANGO_26_40"));
					top3_26_40.add(vCantante);
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
			
			return top3_26_40;
		}
		
		public List<VotosComunidadRango> get3MejoresRango_18_25(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> top3_18_25 = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT NOMBRE_CANTANTE, RANGO_18_25 \r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO \r\n"
					+ "GROUP BY NOMBRE_CANTANTE \r\n"
					+ "ORDER BY RANGO_18_25 DESC LIMIT 3";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vCantante;
				while(resultset.next()) {
					vCantante = new VotosComunidadRango();
					vCantante.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					vCantante.setTotalVotos(resultset.getInt("RANGO_18_25"));
					top3_18_25.add(vCantante);
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
			
			return top3_18_25;
		}
		
		
		public List<VotosComunidadRango> get3MejoresNacional(Connection connection) throws Exception, InterruptedException {
			List<VotosComunidadRango> top3CantantesNacional = new ArrayList<VotosComunidadRango>();
			
			String consultaSQL = "SELECT NOMBRE_CANTANTE, TOTAL_VOTOS\r\n"
					+ "FROM VOTOS_COMUNIDAD_RANGO \r\n"
					+ "GROUP BY NOMBRE_CANTANTE \r\n"
					+ "ORDER BY TOTAL_VOTOS DESC";
			
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = createConnection();
				
				preparedStatement = connection.prepareStatement(consultaSQL);
				resultset = preparedStatement.executeQuery();
				
				VotosComunidadRango vCantante;
				while(resultset.next()) {
					vCantante = new VotosComunidadRango();
					vCantante.setNombreCantante(resultset.getString("NOMBRE_CANTANTE"));
					vCantante.setTotalVotos(resultset.getInt("TOTAL_VOTOS"));
					top3CantantesNacional.add(vCantante);
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
			
			return top3CantantesNacional;
		}
		
		public void listaCantantesNacional(List<VotosComunidadRango> top3) {
	        modelo.removeAllElements();
	        for (int i = 0; i < top3.size(); i++) {
	            modelo.addElement((i + 1) + "º 	Nombre: " + top3.get(i).getNombreCantante() + " Votos: " + top3.get(i).getTotalVotos());
	        }
	        vista.ltCantantes.setModel(modelo);

	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.vista.btnIniciar) {
			
			this.vista.btnIniciar.setVisible(false);
			this.vista.lblCargando.setVisible(true);
			inicializarFotos();
			
			new Cargar().mostrar();
		}
		
		if(e.getSource() == this.vista.btnRangos) {
			this.vista.cbFiltros.removeAllItems();
			
			this.vista.cbFiltros.addItem("");
			this.vista.cbFiltros.addItem("Rango_18_25");
			this.vista.cbFiltros.addItem("Rango_26_40");
			this.vista.cbFiltros.addItem("Rango_41_65");
			this.vista.cbFiltros.addItem("Rango_MAS_66");
		}

		if(e.getSource() == this.vista.btnNacional) {
			this.vista.panelLista.setVisible(true);
		}

		if(e.getSource() == this.vista.btnComunidad) {
			this.vista.cbFiltros.removeAllItems();
			
			this.vista.cbFiltros.addItem("");
			this.vista.cbFiltros.addItem("Andalucia");
			this.vista.cbFiltros.addItem("Aragon");
			this.vista.cbFiltros.addItem("Asturias");
			this.vista.cbFiltros.addItem("Baleares");
			this.vista.cbFiltros.addItem("Canarias");
			this.vista.cbFiltros.addItem("Cantabria");
			this.vista.cbFiltros.addItem("Castilla La Mancha");
			this.vista.cbFiltros.addItem("Castilla y León");
			this.vista.cbFiltros.addItem("Cataluña");
			this.vista.cbFiltros.addItem("Comunidad Valenciana");
			this.vista.cbFiltros.addItem("Extremadura");
			this.vista.cbFiltros.addItem("Galicia");
			this.vista.cbFiltros.addItem("Madrid");
			this.vista.cbFiltros.addItem("Murcia");
			this.vista.cbFiltros.addItem("Navarra");
			this.vista.cbFiltros.addItem("Pais Vasco");
			this.vista.cbFiltros.addItem("La Rioja");
			this.vista.cbFiltros.addItem("Ceuta");
			this.vista.cbFiltros.addItem("Melilla");
			
		}
		
		if(e.getSource() == this.vista.btnCerrar) {
			this.vista.panelLista.setVisible(false);
		}
		
	}

	private void getCantanteRangoComunidad(List<VotosComunidadRango> lista) {
		for (Map.Entry<String, String> fotos : fotosCantantes.entrySet()) {
			if(lista.get(0).getNombreCantante().equals(fotos.getKey())) {
				ImageIcon img = new ImageIcon(getClass().getResource(fotos.getValue()));
				ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(this.vista.lblCantante1.getWidth(), this.vista.lblCantante1.getHeight(), Image.SCALE_SMOOTH));
				this.vista.lblCantante1.setIcon(ico);
				
			}
			if(lista.get(1).getNombreCantante().equals(fotos.getKey())) {
				ImageIcon img = new ImageIcon(getClass().getResource(fotos.getValue()));
				ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(this.vista.lblCantante2.getWidth(), this.vista.lblCantante2.getHeight(), Image.SCALE_SMOOTH));
				this.vista.lblCantante2.setIcon(ico);
			}
			if(lista.get(2).getNombreCantante().equals(fotos.getKey())) {
				ImageIcon img = new ImageIcon(getClass().getResource(fotos.getValue()));
				ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(this.vista.lblCantante3.getWidth(), this.vista.lblCantante3.getHeight(), Image.SCALE_SMOOTH));
				this.vista.lblCantante3.setIcon(ico);
			}
			
			vista.lblNombreC1.setText(lista.get(0).getNombreCantante());
			vista.lblNombreC2.setText(lista.get(1).getNombreCantante());
			vista.lblNombre3.setText(lista.get(2).getNombreCantante());
			
			vista.lblVotosC1.setText(String.valueOf(lista.get(0).getTotalVotos()));
			vista.lblVotosC2.setText(String.valueOf(lista.get(1).getTotalVotos()));
			vista.lblVotosC3.setText(String.valueOf(lista.get(2).getTotalVotos()));
		}
	}
	
	public class Cargar implements Runnable {
		Connection connection = null;
		ControladorVotaciones helper = new ControladorVotaciones(vista);
		
		public void mostrar() {
			new Thread(this).start();
		}
		
		public void run() {
			int cont = 0;
			
			try {
				connection = helper.createConnection();
				
				realizarVotaciones(connection, helper, cont);
				
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
	}
	
	

	private void realizarVotaciones(Connection connection, ControladorVotaciones helper, int cont) 
			throws Exception, InterruptedException, ClassNotFoundException, SQLException {
		

		Hilo_18_25 hilos18_25 = new Hilo_18_25(connection);
		hilos18_25.start();
		hilos18_25.join();
		
		Hilo26_40 hilos26_40 = new Hilo26_40(connection);
		hilos26_40.start();
		hilos26_40.join();
		
		Hilo41_65 hilos41_65 = new Hilo41_65(connection);
		hilos41_65.start();
		hilos41_65.join();
		
		Hilo_MAS_66 hilos_MAS_66 = new Hilo_MAS_66(connection);
		hilos_MAS_66.start();
		hilos_MAS_66.join();
		
		this.vista.panelPortada.setVisible(false);
		this.vista.panelVotaciones.setVisible(true);
		
		updateCantanteComunidad(connection, helper);
			
	}

	private void mostrarCantantesGanadores(List<VotosComunidadRango> top3) {
		for (Map.Entry<String, String> fotos : fotosCantantes.entrySet()) {
			if(top3.get(0).getNombreCantante().equals(fotos.getKey())) {
				ImageIcon img = new ImageIcon(getClass().getResource(fotos.getValue()));
				ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(this.vista.lblCantante1.getWidth(), this.vista.lblCantante1.getHeight(), Image.SCALE_SMOOTH));
				this.vista.lblCantante1.setIcon(ico);
				
			}
			if(top3.get(1).getNombreCantante().equals(fotos.getKey())) {
				ImageIcon img = new ImageIcon(getClass().getResource(fotos.getValue()));
				ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(this.vista.lblCantante2.getWidth(), this.vista.lblCantante2.getHeight(), Image.SCALE_SMOOTH));
				this.vista.lblCantante2.setIcon(ico);
			}
			if(top3.get(2).getNombreCantante().equals(fotos.getKey())) {
				ImageIcon img = new ImageIcon(getClass().getResource(fotos.getValue()));
				ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(this.vista.lblCantante3.getWidth(), this.vista.lblCantante3.getHeight(), Image.SCALE_SMOOTH));
				this.vista.lblCantante3.setIcon(ico);
			}
		}
		
		this.vista.lblNombreC1.setText(top3.get(0).getNombreCantante());
		this.vista.lblNombreC2.setText(top3.get(1).getNombreCantante());
		this.vista.lblNombre3.setText(top3.get(2).getNombreCantante());
		
		this.vista.lblVotosC1.setText(String.valueOf(top3.get(0).getTotalVotos()));
		this.vista.lblVotosC2.setText(String.valueOf(top3.get(1).getTotalVotos()));
		this.vista.lblVotosC3.setText(String.valueOf(top3.get(2).getTotalVotos()));
	}
	
}
