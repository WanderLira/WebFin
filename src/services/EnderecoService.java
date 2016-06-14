package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.EnderecoDao;
import entitys.Endereco;

@Service
@Transactional
public class EnderecoService {
	
	@Autowired
	private EnderecoDao pDao;
	
	public void insert(Endereco endereco) {
		pDao.inserir(endereco);
	}

	public void update(Endereco endereco) {
		pDao.atualizar(endereco);
	}

	public Endereco findId(long id) {
		return pDao.buscarPorId(id);
	}	

	public List<Endereco> listAll() {
		return pDao.listar();
	}

	public void remove(Endereco cardapio) {
		pDao.remover(cardapio);
	}
}
