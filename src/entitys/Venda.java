package entitys;

import javax.persistence.Entity;

@Entity
public class Venda extends Movimento{
	
	private double desconto;

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
