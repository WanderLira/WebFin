package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitys.Categoria;
import entitys.Usuario;
import services.CategoriaService;

@RequestMapping(value = "categoria")
@Controller
public class CategoriaController {

	@Autowired
	CategoriaService cService;

	@RequestMapping(value = "listCategorias", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Categoria> categorias = cService.listAll();
		map.addAttribute("categorias", categorias);
		map.addAttribute("filtro", new Categoria());
		return "categoria/categoriasLista";
	}

	@RequestMapping(value = "formCadastro", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		//Categoria categoria = new Categoria();
		map.addAttribute("categoria", new Categoria());
		return "categoria/categoriaCadastro";
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String save(@ModelAttribute("categoria") Categoria categoria, ModelMap map) {

		if (categoria.hasValidId()) {
			cService.update(categoria);
		} else {
			cService.insert(categoria);
		}

		return "redirect:/categoria/listCategorias";
	}

	@RequestMapping(value = "{id}/formCadastro", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, ModelMap map) {
		Categoria categoria = cService.findId(id);
		map.addAttribute("categoria", categoria);
		return "categoria/categoriaCadastro";
	}

	@RequestMapping(value = "{id}/altFormCadastro", method = RequestMethod.GET)
	public String updateFormCadastro(@PathVariable Long id, ModelMap map) {
		Categoria categoria = cService.findId(id);
		map.addAttribute("categoria", categoria);
		return "categoria/altCadCategoria";
	}

	@RequestMapping(value = "{id}/remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id, ModelMap map) {
		cService.remove(new Categoria(id));
		return "redirect:/categoria/listCategorias";
	
	}@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Categoria filtro, ModelMap map) {

		List<Categoria> categorias = cService.buscar(filtro);
		map.addAttribute("categorias", categorias);
		map.addAttribute("filtro", filtro);
		return "categoria/categoriasLista";
	}
	
	
}
