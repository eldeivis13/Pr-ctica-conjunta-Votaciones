package persistencias;

public class Cantante {
	private String dni;
	private String nombre;
	private int votos;
	
	public Cantante(String nombre) {
		super();
		this.nombre = nombre;
		this.votos = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	@Override
	public String toString() {
		return "Cantante [nombre=" + nombre + ", votos=" + votos + "]";
	}
	
	public int incrementar() {
		return votos++;
	}
	
}
