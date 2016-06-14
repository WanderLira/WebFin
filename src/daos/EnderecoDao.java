package daos;

import org.springframework.stereotype.Repository;

import entitys.Endereco;

@Repository
public class EnderecoDao extends AbstractDAO<Endereco>{

	@Override
	public Class<Endereco> entityClass() {
		// TODO Auto-generated method stub
		return Endereco.class;
	}

}
