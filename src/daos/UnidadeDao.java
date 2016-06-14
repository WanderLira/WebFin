package daos;

import org.springframework.stereotype.Repository;

import entitys.Unidade;

@Repository
public class UnidadeDao extends AbstractDAO<Unidade>{

	@Override
	public Class<Unidade> entityClass() {
		// TODO Auto-generated method stub
		return Unidade.class;
	}

}
