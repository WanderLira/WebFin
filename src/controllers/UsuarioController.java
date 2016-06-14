package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitys.Usuario;
import services.UsuarioService;

@RequestMapping(value = "usuarios")
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuService;

	@RequestMapping(value = "listaUsuarios", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Usuario> usuarios = usuService.listAll();
		map.addAttribute("usuarios", usuarios);
		map.addAttribute("filtro", new Usuario());
		return "usuarios/usuariosLista";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Usuario filtro, ModelMap map) {

		List<Usuario> usuarios = usuService.buscar(filtro);
		map.addAttribute("usuarios", usuarios);
		map.addAttribute("filtro", filtro);
		return "usuarios/usuariosLista";
	}

	@RequestMapping(value = "{id}/remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id, ModelMap map) {
		usuService.remove(new Usuario(id));
		return "redirect:/usuarios/listaUsuarios";
	}

	@RequestMapping(value = "formCadastro", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		map.addAttribute("usuario", new Usuario());
		return "usuarios/usuarioCadastro";
	}

	@RequestMapping(value = "{id}/formCadastro", method = RequestMethod.GET)
	public String senhaForm(@PathVariable Long id, ModelMap map) {
		Usuario usuario = usuService.findId(id);
		map.addAttribute("usuario", usuario);
		return "usuarios/usuarioCadastro";
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String save(@ModelAttribute("usuario") Usuario usuario, ModelMap map) {

		if (usuario.hasValidId()) {
			usuService.update(usuario);
		} else {
			usuService.insert(usuario);
		}

		return "redirect:/usuarios/listaUsuarios";
	}
}
