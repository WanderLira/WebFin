package daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entitys.Produto;

@Repository
public class ProdutoDao extends AbstractDAO<Produto>{

	@Override
	public Class<Produto> entityClass() {
		// TODO Auto-generated method stub
		return Produto.class;
	}
	
	public List<Produto> filtrar(Produto filtro){
		String str = "select p from Produto p where upper(descricao) like upper(:descricao)";
				
		if(filtro.getDescricao() == null){
			filtro.setDescricao("");
		}
		
		if(filtro.getCategoria().getId() != null){
			str+=" and p.categoria.id = :idCat";
		}
		
		Query query=manager.createQuery(str);   
		
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		if(filtro.getCategoria().getId() != null){
			query.setParameter("idCat", filtro.getCategoria().getId());
		}
		
		return query.getResultList();
	}

}
