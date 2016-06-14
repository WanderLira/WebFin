package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitys.Usuario;
import services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService uService;

	@RequestMapping(value = {"/", "loginForm"}, method = RequestMethod.GET)
	public String createFrom(ModelMap map, HttpSession session) {
		map.addAttribute("usuario", new Usuario());
		session.invalidate();
		return "index/login";
	}

	@RequestMapping(value = "logar", method = RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario usuario, HttpSession session, ModelMap map, HttpServletRequest req) {
		if (usuario.getLogin() == null || usuario.getSenha() == null) {
			map.addAttribute("usuario", usuario);			
			return "index/login";
		}	
		
		Usuario retorno = uService.login(usuario.getLogin(), usuario.getSenha());
		
		if (retorno == null) {
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);			
			return "index/login";
		}		
		int act = 1;
		map.addAttribute("act", act);
		session.setAttribute("logado", retorno);		
		return "index/principal";
	}
}
