
package practica1_8;

public class Paquete {

	private long tiempoCargaEnMilisegundos;

	public Paquete() {
		this.tiempoCargaEnMilisegundos = 1000 + (long) (Math.random() * 2000); // Valor entre 1000 y 3000 milisegundos
	}

	public long getTiempoCargaEnMilisegundos() {
		return tiempoCargaEnMilisegundos;
	}

	public void setTiempoCargaEnMilisegundos(long tiempoCargaEnMilisegundos) {
		this.tiempoCargaEnMilisegundos = tiempoCargaEnMilisegundos;
	}

}
