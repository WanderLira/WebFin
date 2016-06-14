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
import entitys.Unidade;
import services.UnidadeService;

@RequestMapping(value = "unidade")
@Controller
public class UnidadeController {

	@Autowired
	UnidadeService uService;

	@RequestMapping(value = "listUnidades", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Unidade> unidades = uService.listAll();
		map.addAttribute("unidades", unidades);
		map.addAttribute("filtro", new Unidade());
		return "unidade/unidadesLista";
	}

	@RequestMapping(value = "formCadastro", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		Unidade unidade = new Unidade();
		map.addAttribute("unidade", unidade);
		return "unidade/unidadeCadastro";
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String save(@ModelAttribute("unidade") Unidade unidade, ModelMap map) {

		if (unidade.hasValidId()) {
			uService.update(unidade);
		} else {
			uService.insert(unidade);
		}

		return "redirect:/unidade/listUnidades";
	}

	@RequestMapping(value = "{id}/formCadastro", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, ModelMap map) {
		Unidade unidade = uService.findId(id);
		map.addAttribute("unidade", unidade);
		return "unidade/unidadeCadastro";
	}

	@RequestMapping(value = "{id}/altFormCadastro", method = RequestMethod.GET)
	public String updateFormCadastro(@PathVariable Long id, ModelMap map) {
		Unidade unidade = uService.findId(id);
		map.addAttribute("unidade", unidade);
		return "unidade/altCadUnidade";
	}

	@RequestMapping(value = "{id}/remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id, ModelMap map) {
		uService.remove(new Unidade(id));
		return "redirect:/unidade/listUnidades";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Unidade filtro, ModelMap map) {

		List<Unidade> unidades = uService.buscar(filtro);
		map.addAttribute("unidades", unidades);
		map.addAttribute("filtro", filtro);
		return "unidade/unidadesLista";
	}
}
