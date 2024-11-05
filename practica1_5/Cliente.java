package practica1_5;

public class Cliente {
	
	private String id;
	private int productos;
	
	
	/**
	 * @param id
	 * @param productos
	 */
	public Cliente(String id, int productos) {
		super();
		this.id = id;
		this.productos = productos;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the productos
	 */
	public int getProductos() {
		return productos;
	}


	/**
	 * @param productos the productos to set
	 */
	public void setProductos(int productos) {
		this.productos = productos;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", productos=" + productos + "]";
	}
	
	
	
	
	

}
