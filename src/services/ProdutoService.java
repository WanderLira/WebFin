package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.ProdutoDao;
import entitys.Produto;

@Service
@Transactional
public class ProdutoService {
	
	@Autowired
	private ProdutoDao pDao;
	
	public void insert(Produto produto) {
		pDao.inserir(produto);
	}

	public void update(Produto produto) {
		pDao.atualizar(produto);
	}

	public Produto findId(long id) {
		return pDao.buscarPorId(id);
	}	

	public List<Produto> listAll() {
		return pDao.listar();
	}

	public List<Produto> buscar(Produto filtro) {
		return pDao.filtrar(filtro);
	}
	public void remove(Produto cardapio) {
		pDao.remover(cardapio);
	}
}
