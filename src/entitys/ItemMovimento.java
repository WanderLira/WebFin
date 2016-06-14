package entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_itemMovimento", sequenceName = "itemMovimento_seq", allocationSize = 1)
public class ItemMovimento extends AbstractEntity{
	
	@Id
	@Column(name = "id_itemMovimento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_itemMovimento")
	private Long id;
	
	private int qtde;
	
	private double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_movimento")
	private Movimento movimento;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}
}
