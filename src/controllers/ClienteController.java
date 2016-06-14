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
import entitys.PessoaFisica;
import services.EnderecoService;
import services.PessoaFisicaService;

@RequestMapping(value = "cliente")
@Controller
public class ClienteController {
	
	@Autowired
	PessoaFisicaService pfService;
	
	@Autowired
	EnderecoService eService;
	
	@RequestMapping(value = "listClientes", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<PessoaFisica> clientes = pfService.listAll();
		map.addAttribute("clientes", clientes);
		map.addAttribute("filtro", new PessoaFisica());
		return "cliente/listClientes";
	}
	
	 @RequestMapping(value = "formCadastro", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		PessoaFisica cliente = new PessoaFisica();
		cliente.setEndereco(new Endereco());
		map.addAttribute("cliente", cliente);	
		return "cliente/cadCliente";
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String save(@ModelAttribute("cliente") PessoaFisica cliente, ModelMap map) {

		if (cliente.hasValidId()) {			
			pfService.update(cliente);			
		} else {
			//eService.insert(cliente.getEndereco());
			pfService.insert(cliente);
		}

		return "redirect:/cliente/listClientes";
	}
	
	@RequestMapping(value = "{id}/formCadastro", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, ModelMap map) {
		PessoaFisica cliente = pfService.findId(id);		
		map.addAttribute("cliente", cliente);		
		return "cliente/cadCliente";
	}
	
	@RequestMapping(value = "{id}/altFormCadastro", method = RequestMethod.GET)
	public String updateFormCadastro(@PathVariable Long id, ModelMap map) {
		PessoaFisica cliente = pfService.findId(id);		
		map.addAttribute("cliente", cliente);		
		return "cliente/altCadCliente";
	}
	
	@RequestMapping(value = "{id}/{idEnd}/formEndereco", method = RequestMethod.GET)
	public String updateEnd(@PathVariable Long id, @PathVariable Long idEnd, ModelMap map) {
		PessoaFisica cliente = pfService.findId(id);				
		Endereco end = eService.findId(idEnd);		
		map.addAttribute("end", end);
		map.addAttribute("cliente", cliente);	
		return "cliente/altEndCliente";
	}
	
	@RequestMapping(value = "atlEndereco", method = RequestMethod.POST)
	public String enderecoAlt(@ModelAttribute("end") Endereco end, ModelMap map) {
					
		eService.update(end);		

		return "redirect:/cliente/listClientes";
	}
	@RequestMapping(value = "{id}/remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id, ModelMap map) {
		pfService.remove(new PessoaFisica(id));
		return "redirect:/cliente/listClientes";
	}
}
