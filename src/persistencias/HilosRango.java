package persistencias;

public class HilosRango {
	
	private String comunidad;
	private int hilos;
	
	public HilosRango(String comunidad, int hilos) {
		this.comunidad = comunidad;
		this.hilos = hilos;
	}

	public HilosRango() {
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public int getHilos() {
		return hilos;
	}

	public void setHilos(int hilos) {
		this.hilos = hilos;
	}

	@Override
	public String toString() {
		return "HilosRango [comunidad=" + comunidad + ", hilos=" + hilos + "]";
	}

}
