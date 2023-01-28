package persistencias;

public class VotosComunidadRango {
	private String nombreComunidad;
	private String rangoEdad;
	private String nombreCantante;
	private int totalVotos;
	
	public VotosComunidadRango(String nombreComunidad, String rangoEdad, String nombreCantante, int totalVotos) {
		this.nombreComunidad = nombreComunidad;
		this.rangoEdad = rangoEdad;
		this.nombreCantante = nombreCantante;
		this.totalVotos = totalVotos;
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public String getRangoEdad() {
		return rangoEdad;
	}

	public void setRangoEdad(String rangoEdad) {
		this.rangoEdad = rangoEdad;
	}

	public String getNombreCantante() {
		return nombreCantante;
	}

	public void setNombreCantante(String nombreCantante) {
		this.nombreCantante = nombreCantante;
	}

	public int getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
	}

	@Override
	public String toString() {
		return "Cantante [nombreComunidad=" + nombreComunidad + ", rangoEdad=" + rangoEdad + ", nombreCantante="
				+ nombreCantante + ", totalVotos=" + totalVotos + "]";
	}
}
