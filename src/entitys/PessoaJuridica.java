package entitys;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{
	
	private String razaoSocial;
	@Column(length = 20)
	private String cnpj;
	
	@Column(length = 150)
	private String nomeResponsavel;	

	@Column(length = 16)
	private String telefoneResponsavel;
	
	
	public PessoaJuridica(Long id){
		this.setId(id);
	}
	
	public PessoaJuridica(){
		
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}

	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
