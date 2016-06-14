package daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entitys.Usuario;

@Repository
public class UsuarioDao extends AbstractDAO<Usuario>{

	@Override
	public Class<Usuario> entityClass() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}
	
	public Usuario login(String login, String senha){
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios = query.getResultList();
		if(usuarios != null && !usuarios.isEmpty()){
			return usuarios.get(0);
		}
		return null;
	}
	
	public List<Usuario> filtrar(Usuario filtro){
		String str = "select u from Usuario u where upper(login) like upper(:login) and upper(nome) like upper(:nome)";
		if(filtro.getLogin() == null){
			filtro.setLogin("");
		}
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		Query query=manager.createQuery(str);   
		
		query.setParameter("login", "%"+filtro.getLogin()+"%");
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		return query.getResultList();
	}

}
