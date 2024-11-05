package practica1_8;

import java.util.ArrayList;

public class LineaDeCarga {
	private String idLinea; // Identificador de la línea de carga
	private ArrayList<Paquete> paquetes;

	public LineaDeCarga(String idLinea) {
		this.idLinea = idLinea;
		this.paquetes = new ArrayList<>();
	}

	public String getIdLinea() {
		return idLinea;
	}

	public ArrayList<Paquete> getPaquetes() {
		return paquetes;
	}

	public void addPaquete(Paquete paquete) {
		paquetes.add(paquete);
	}
}
