package entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "id_pessoa", sequenceName = "pessoa_seq", allocationSize = 1)
public class Pessoa extends AbstractEntity{
	
	@Id
	@Column(name = "id_pessoa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pessoa")
	private Long id;
	
	private String nome;
	@Column(length = 150)
	private String email;
	@Column(length = 15)
	private String telefone;
	@Column(length = 16)
	private String celular;
	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Movimento> movimentos;	
	
	public List<Movimento> getMovimentos() {
		return movimentos;
	}
	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Pessoa(Long id){
		this.id  = id;
	}
	
	public Pessoa(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}	
}
