package practica1_6;

class Vehiculo_2 {
	
	
	
	private Vehiculo_Tipo_2 tipo;
	private int matricula;
	
	
	

	/**
	 * @param tipo
	 * @param matricula
	 */
	public Vehiculo_2(Vehiculo_Tipo_2 tipo, int matricula) {
		
		this.tipo = tipo;
		this.matricula = matricula;
	}


	


	/**
	 * @return the tipo
	 */
	public Vehiculo_Tipo_2 getTipo() {
		return tipo;
	}





	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Vehiculo_Tipo_2 tipo) {
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
