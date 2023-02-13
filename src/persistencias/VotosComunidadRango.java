package persistencias;

public class VotosComunidadRango {
	private String nombreComunidad;
	private String rango_18_25;
	private String rango_26_40;
	private String rango_41_65;
	private String rango_MAS_66;
	private String nombreCantante;
	private int totalVotos;
	
	public VotosComunidadRango() {
		
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public String getRango_18_25() {
		return rango_18_25;
	}

	public void setRango_18_25(String rango_18_25) {
		this.rango_18_25 = rango_18_25;
	}

	public String getRango_26_40() {
		return rango_26_40;
	}

	public void setRango_26_40(String rango_26_40) {
		this.rango_26_40 = rango_26_40;
	}

	public String getRango_41_65() {
		return rango_41_65;
	}

	public void setRango_41_65(String rango_41_65) {
		this.rango_41_65 = rango_41_65;
	}

	public String getRango_MAS_66() {
		return rango_MAS_66;
	}

	public void setRango_MAS_66(String rango_MAS_66) {
		this.rango_MAS_66 = rango_MAS_66;
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
		return "VotosComunidadRango [nombreComunidad=" + nombreComunidad + ", rango_18_25=" + rango_18_25
				+ ", rango_26_40=" + rango_26_40 + ", rango_41_65=" + rango_41_65 + ", rango_MAS_66=" + rango_MAS_66
				+ ", nombreCantante=" + nombreCantante + ", totalVotos=" + totalVotos + "]";
	}
}
