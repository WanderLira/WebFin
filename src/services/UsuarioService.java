package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.UsuarioDao;
import entitys.Usuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDao uDao;

	public void insert(Usuario usuario) {
		uDao.inserir(usuario);
	}

	public void update(Usuario usuario) {
		uDao.atualizar(usuario);
	}

	public Usuario findId(long id) {
		return uDao.buscarPorId(id);
	}

	public Usuario login(String login, String senha) {
		return uDao.login(login, senha);
	}

	public List<Usuario> listAll() {
		return uDao.listar();
	}

	public List<Usuario> buscar(Usuario filtro) {
		return uDao.filtrar(filtro);
	}
	public void remove(Usuario cardapio) {
		uDao.remover(cardapio);
	}
}
