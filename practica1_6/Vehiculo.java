package practica1_6;



class Vehiculo {
	
	
	
	private Vehiculo_Tipo tipo;
	private int matricula;
	
	
	

	/**
	 * @param tipo
	 * @param matricula
	 */
	public Vehiculo(Vehiculo_Tipo tipo, int matricula) {
		
		this.tipo = tipo;
		this.matricula = matricula;
	}


	


	/**
	 * @return the tipo
	 */
	public Vehiculo_Tipo getTipo() {
		return tipo;
	}





	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Vehiculo_Tipo tipo) {
		this.tipo = tipo;
	}





	/**
	 * @return the matricula
	 */
	public int getMatricula() {
		return matricula;
	}





	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

    
}