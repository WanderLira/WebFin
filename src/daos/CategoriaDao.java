package daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entitys.Categoria;

@Repository
public class CategoriaDao extends AbstractDAO<Categoria>{

	@Override
	public Class<Categoria> entityClass() {
		// TODO Auto-generated method stub
		return Categoria.class;
	}
	
	
	public List<Categoria> filtrar(Categoria filtro){
		String str = "select u from Categoria u where  upper(descricao) like upper(:descricao)";
		
		if(filtro.getDescricao() == null){
			filtro.setDescricao("");
		}
		
		Query query=manager.createQuery(str);   
		
		
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		
		return query.getResultList();
	}

}
