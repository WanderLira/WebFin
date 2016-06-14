package entitys;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "id_movimento", sequenceName = "movimento_seq", allocationSize = 1)
public class Movimento extends AbstractEntity{
	
	@Id
	@Column(name = "id_movimento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_movimento")
	private Long id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date data;	
	
	private double totalMovimento;
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "movimento")
	private List<ItemMovimento> itensMovimento;
	
	
	public List<ItemMovimento> getItensMovimento() {
		return itensMovimento;
	}
	public void setItensMovimento(List<ItemMovimento> itensMovimento) {
		this.itensMovimento = itensMovimento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getTotalMovimento() {
		return totalMovimento;
	}
	public void setTotalMovimento(double totalMovimento) {
		this.totalMovimento = totalMovimento;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
}
