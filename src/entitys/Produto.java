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
@SequenceGenerator(name = "id_produto", sequenceName = "produto_seq", allocationSize = 1)
public class Produto extends AbstractEntity{
	
	@Id
	@Column(name = "id_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_produto")
	private Long id;
	
	private String descricao;
	
	private float qtdeEstoque;	
	
	private double preco;	
	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	
	public Produto(Long id){
		this.id = id;
	}
	
	public Produto(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getQtdeEstoque() {
		return qtdeEstoque;
	}
	public void setQtdeEstoque(float qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
