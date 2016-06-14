package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.CategoriaDao;
import entitys.Categoria;
import entitys.Usuario;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaDao uDao;

	public void insert(Categoria categoria) {
		uDao.inserir(categoria);
	}

	public void update(Categoria categoria) {
		uDao.atualizar(categoria);
	}

	public Categoria findId(long id) {
		return uDao.buscarPorId(id);
	}	

	public List<Categoria> listAll() {
		return uDao.listar();
	}	

	public void remove(Categoria cardapio) {
		uDao.remover(cardapio);
	}
	public List<Categoria> buscar(Categoria filtro) {
		return uDao.filtrar(filtro);
	}
}
