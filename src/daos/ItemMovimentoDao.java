package daos;

import org.springframework.stereotype.Repository;

import entitys.ItemMovimento;

@Repository
public class ItemMovimentoDao extends AbstractDAO<ItemMovimento>{

	@Override
	public Class<ItemMovimento> entityClass() {
		// TODO Auto-generated method stub
		return ItemMovimento.class;
	}

}
