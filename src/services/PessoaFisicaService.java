package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.PessoaFisicaDao;
import entitys.PessoaFisica;

@Service
@Transactional
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaDao uDao;

	public void insert(PessoaFisica pessoaFisica) {
		uDao.inserir(pessoaFisica);
	}

	public void update(PessoaFisica pessoaFisica) {
		uDao.atualizar(pessoaFisica);
	}

	public PessoaFisica findId(long id) {
		return uDao.buscarPorId(id);
	}	

	public List<PessoaFisica> listAll() {
		return uDao.listar();
	}	

	public void remove(PessoaFisica cardapio) {
		uDao.remover(cardapio);
	}
}
