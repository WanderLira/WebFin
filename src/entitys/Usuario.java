package entitys;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_usuario", sequenceName = "usuario_seq", allocationSize = 1)
public class Usuario extends AbstractEntity{
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_usuario")
	private Long id;
	
	private String login;
	
	private String senha;	
	
	private String nome;
	
	private String matricula;	
	
	public Usuario(Long id){
		this.id = id;
	}
	
	public Usuario(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
