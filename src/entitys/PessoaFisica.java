package entitys;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{
	
	@Column(length = 16)
	private String cpf;
	
	public PessoaFisica(Long id){
		this.setId(id);
	}
	
	public PessoaFisica(){
		
	}
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
}
