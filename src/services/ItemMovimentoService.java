package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.ItemMovimentoDao;
import entitys.ItemMovimento;

@Service
@Transactional
public class ItemMovimentoService {
	
	@Autowired
	private ItemMovimentoDao pDao;
	
	public void insert(ItemMovimento itemMovimento) {
		pDao.inserir(itemMovimento);
	}

	public void update(ItemMovimento itemMovimento) {
		pDao.atualizar(itemMovimento);
	}

	public ItemMovimento findId(long id) {
		return pDao.buscarPorId(id);
	}	

	public List<ItemMovimento> listAll() {
		return pDao.listar();
	}

	public void remove(ItemMovimento cardapio) {
		pDao.remover(cardapio);
	}
}
