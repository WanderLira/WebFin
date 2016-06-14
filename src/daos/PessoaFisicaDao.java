package daos;

import org.springframework.stereotype.Repository;

import entitys.PessoaFisica;

@Repository
public class PessoaFisicaDao extends AbstractDAO<PessoaFisica>{

	@Override
	public Class<PessoaFisica> entityClass() {
		// TODO Auto-generated method stub
		return PessoaFisica.class;
	}

}
