package daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entitys.Categoria;
import entitys.Unidade;

@Repository
public class UnidadeDao extends AbstractDAO<Unidade>{

	@Override
	public Class<Unidade> entityClass() {
		// TODO Auto-generated method stub
		return Unidade.class;
	}
	public List<Unidade> filtrar(Unidade filtro){
		String str = "select u from Unidade u where  upper(descricao) like upper(:descricao)";
		
		if(filtro.getDescricao() == null){
			filtro.setDescricao("");
		}
		
		Query query=manager.createQuery(str);   
		
		
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		
		return query.getResultList();
	}
}
