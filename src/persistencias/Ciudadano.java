package persistencias;

import java.util.List;

public class Ciudadano {
	private String comunidad;
	private String rango;
	private String voto;
	private List<Cantante> cantantes;
	
	
	public Ciudadano(String comunidad, String rango, List<Cantante> cantantes) {
		super();
		this.comunidad = comunidad;
		this.rango = rango;
		this.cantantes = cantantes;
		
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
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	@Override
	public String toString() {
		return "Ciudadano [comunidad=" + comunidad + ", rango=" + rango + ", voto=" + voto + "]";
	}
	
	
	public void run() {
		int numVoto=(int)(0+Math.random()*100);
		/*for(int i=0;i<comunidades;i++) {
			if(comunidades.get(i)==comunidad) {
				comunidades.get(i).votar();
			}
		}*/
		if(rango.equals("18_25")) {
			if(numVoto>=0&&numVoto<=7) {
				cantantes.get(0).incrementar();
				voto="joel";
			}
			if(numVoto>=8&&numVoto<10) {
				cantantes.get(1).incrementar();
				voto="victoria";
			}
			if(numVoto>=11&&numVoto<=23) {
				cantantes.get(2).incrementar();
				voto="tiago";
			}
			if(numVoto>=24&&numVoto<=30) {
				cantantes.get(3).incrementar();
				voto="sara";
			}
			if(numVoto>=31&&numVoto<=37) {
				cantantes.get(4).incrementar();
				voto="elton";
			}
			if(numVoto>=38&&numVoto<=51) {
				cantantes.get(5).incrementar();
				voto="amie";
			}
			if(numVoto>=52&&numVoto<=61) {
				cantantes.get(6).incrementar();
				voto="nahid";
			}
			if(numVoto>=62&&numVoto<=88) {
				cantantes.get(7).incrementar();
				voto="mark";
			}
			if(numVoto>=89&&numVoto<=95) {
				cantantes.get(8).incrementar();
				voto="alba";
			}
			if(numVoto>=96&&numVoto<=100) {
				cantantes.get(9).incrementar();
				voto="julio";
			}
		}
	}
}
