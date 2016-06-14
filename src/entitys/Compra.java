package entitys;

import javax.persistence.Entity;

@Entity
public class Compra extends Movimento{
	
	private int numeroNf;

	public int getNumeroNf() {
		return numeroNf;
	}

	public void setNumeroNf(int numeroNf) {
		this.numeroNf = numeroNf;
	}
}
