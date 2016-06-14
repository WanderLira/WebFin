package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.PessoaJuridicaDao;
import entitys.PessoaJuridica;

@Service
@Transactional
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaDao uDao;

	public void insert(PessoaJuridica pessoaJuridica) {
		uDao.inserir(pessoaJuridica);
	}

	public void update(PessoaJuridica pessoaJuridica) {
		uDao.atualizar(pessoaJuridica);
	}

	public PessoaJuridica findId(long id) {
		return uDao.buscarPorId(id);
	}	

	public List<PessoaJuridica> listAll() {
		return uDao.listar();
	}	

	public void remove(PessoaJuridica cardapio) {
		uDao.remover(cardapio);
	}
}
