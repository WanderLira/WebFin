package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.CompraDao;
import entitys.Compra;

@Service
@Transactional
public class CompraService {

	@Autowired
	private CompraDao uDao;

	public void insert(Compra compra) {
		uDao.inserir(compra);
	}

	public void update(Compra compra) {
		uDao.atualizar(compra);
	}

	public Compra findId(long id) {
		return uDao.buscarPorId(id);
	}	

	public List<Compra> listAll() {
		return uDao.listar();
	}	

	public void remove(Compra cardapio) {
		uDao.remover(cardapio);
	}
}
