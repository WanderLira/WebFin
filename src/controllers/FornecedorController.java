package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitys.Endereco;
import entitys.PessoaJuridica;
import services.EnderecoService;
import services.PessoaJuridicaService;

@RequestMapping(value = "fornecedor")
@Controller
public class FornecedorController {
	
	@Autowired
	PessoaJuridicaService pjService;
	
	@Autowired
	EnderecoService eService;
	
	@RequestMapping(value = "listFornecedores", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<PessoaJuridica> fornecedores = pjService.listAll();
		map.addAttribute("fornecedores", fornecedores);
		map.addAttribute("filtro", new PessoaJuridica());
		return "fornecedores/fornecedoresLista";
	}
	
	@RequestMapping(value = "formCadastro", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		PessoaJuridica fornecedor = new PessoaJuridica();
		fornecedor.setEndereco(new Endereco());
		map.addAttribute("fornecedor", fornecedor);	
		return "fornecedores/fornecedorCadastro";
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String save(@ModelAttribute("fornecedor") PessoaJuridica fornecedor, ModelMap map) {

		if (fornecedor.hasValidId()) {			
			pjService.update(fornecedor);			
		} else {
			eService.insert(fornecedor.getEndereco());
			pjService.insert(fornecedor);
		}

		return "redirect:/fornecedor/listFornecedores";
	}
	
	@RequestMapping(value = "{id}/formCadastro", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, ModelMap map) {
		PessoaJuridica fornecedor = pjService.findId(id);		
		map.addAttribute("fornecedor", fornecedor);	
		return "fornecedor/cadFornecedor";
	}
	
	@RequestMapping(value = "{id}/altFormCadastro", method = RequestMethod.GET)
	public String updateFormCadastro(@PathVariable Long id, ModelMap map) {
		PessoaJuridica fornecedor = pjService.findId(id);		
		map.addAttribute("fornecedor", fornecedor);	
		return "fornecedor/altCadFornecedor";
	}
	
	@RequestMapping(value = "{id}/{idEnd}/formEndereco", method = RequestMethod.GET)
	public String updateEnd(@PathVariable Long id, @PathVariable Long idEnd, ModelMap map) {
		PessoaJuridica fornecedor = pjService.findId(id);				
		Endereco end = eService.findId(idEnd);		
		map.addAttribute("end", end);
		map.addAttribute("fornecedor", fornecedor);	
		return "fornecedor/altEndFornecedor";
	}
	
	@RequestMapping(value = "atlEndereco", method = RequestMethod.POST)
	public String enderecoAlt(@ModelAttribute("end") Endereco end, ModelMap map) {
					
		eService.update(end);		

		return "redirect:/fornecedor/listFornecedores";
	}
	@RequestMapping(value = "{id}/remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id, ModelMap map) {
		pjService.remove(new PessoaJuridica(id));
		return "redirect:/fornecedor/listFornecedores";
	}
}


