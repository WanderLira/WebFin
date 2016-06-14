package controllers;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitys.Categoria;
import entitys.Produto;
import entitys.Unidade;
import services.CategoriaService;
import services.ProdutoService;
import services.UnidadeService;

@RequestMapping(value = "produtos")
@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService pService;
	
	@Autowired
	private UnidadeService uniService;
	
	@Autowired
	private CategoriaService cService;	

	@RequestMapping(value = "listarProdutos", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Produto> produtos = pService.listAll();
		map.addAttribute("produtos", produtos);
		map.addAttribute("filtro", new Produto());		
		map.addAttribute("listaCategoria", categoriasLista());
		return "produtos/produtosLista";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Produto filtro, ModelMap map) {

		List<Produto> produtos = pService.buscar(filtro);
		map.addAttribute("produtos", produtos);
		map.addAttribute("filtro", filtro);		
		map.addAttribute("selectCategoria", categoriasLista());
		return "produtos/produtosLista";
	}

	@RequestMapping(value = "{id}/remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id, ModelMap map) {
		pService.remove(new Produto(id));		
		return "redirect:/produtos/listarProdutos";
	}

	@RequestMapping(value = "formCadastro", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		Produto produto = new Produto();		
		map.addAttribute("produto", produto);
		map.addAttribute("listaUnidade", unidadesLista());
		map.addAttribute("listaCategoria", categoriasLista());		
		return "produtos/produtoCadastro";
	}

	@RequestMapping(value = "{id}/formCadastro", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, ModelMap map) {
		Produto produto = pService.findId(id);
		map.addAttribute("produto", produto);
		map.addAttribute("selectUnidade", unidadesLista());
		map.addAttribute("selectCategoria", categoriasLista());		
		return "produto/cadProduto";
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String save(@ModelAttribute("produto") Produto produto, ModelMap map) {

		if (produto.hasValidId()) {			
			pService.update(produto);
		} else {			
			pService.insert(produto);
		}	
		return "redirect:/produtos/listarProdutos";
	}
	
	public Map<Long, String> unidadesLista(){
		List<Unidade> unidades  = uniService.listAll();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (Unidade unidade : unidades) {
			mapa.put(unidade.getId(), unidade.getDescricao());
		}
		return mapa;
	}
	
	public Map<Long, String> categoriasLista(){
		List<Categoria> categorias  = cService.listAll();
		Map<Long, String> mapa = new TreeMap<Long, String>();		
		for (Categoria categoria : categorias) {
			mapa.put(categoria.getId(), categoria.getDescricao());
		}
		return mapa;
	}
	
	@RequestMapping(value = "formCadastroUni", method = RequestMethod.GET)
	public String createFormUni(ModelMap map) {
		Unidade unidade = new Unidade();
		List<Unidade> unidades = uniService.listAll();
		map.addAttribute("unidade", unidade);
		map.addAttribute("unidades", unidades);		
		return "produto/cadUnidade";
	}
	
	@RequestMapping(value = "cadastrarUni", method = RequestMethod.POST)
	public String saveuni(@ModelAttribute("unidade") Unidade unidade, ModelMap map) {

		if (unidade.hasValidId()) {		
			uniService.update(unidade);
		} else {		
			uniService.insert(unidade);
		}		
		return "redirect:/produtos/formCadastroUni";
	}
	
	@RequestMapping(value = "{id}/formCadastroUni", method = RequestMethod.GET)
	public String updateFormUni(@PathVariable Long id, ModelMap map) {
		Unidade unidade = uniService.findId(id);
		List<Unidade> unidades = uniService.listAll();
		map.addAttribute("unidade", unidade);
		map.addAttribute("unidades", unidades);		
		return "produto/cadUnidade";
	}
	
	@RequestMapping(value = "{id}/removeUni", method = RequestMethod.GET)
	public String removeUni(@PathVariable Long id, ModelMap map) {
		uniService.remove(new Unidade(id));	
		return "redirect:/produtos/formCadastroUni";
	}
	
	@RequestMapping(value = "formCadastroCat", method = RequestMethod.GET)
	public String createFormCat(ModelMap map) {
		Categoria categoria = new Categoria();
		List<Categoria> categorias = cService.listAll();
		map.addAttribute("categoria", categoria);
		map.addAttribute("categorias", categorias);	
		return "produto/cadCategoria";
	}
	
	@RequestMapping(value = "cadastrarCat", method = RequestMethod.POST)
	public String saveCat(@ModelAttribute("categoria") Categoria categoria, ModelMap map) {

		if (categoria.hasValidId()) {		
			cService.update(categoria);
		} else {		
			cService.insert(categoria);
		}	
		return "redirect:/produtos/formCadastroCat";
	}
	
	@RequestMapping(value = "{id}/formCadastroCat", method = RequestMethod.GET)
	public String updateFormCat(@PathVariable Long id, ModelMap map) {
		Categoria categoria = cService.findId(id);
		List<Categoria> categorias = cService.listAll();
		map.addAttribute("categoria", categoria);
		map.addAttribute("categorias", categorias);	
		return "produto/cadCategoria";
	}
	
	@RequestMapping(value = "{id}/removeCat", method = RequestMethod.GET)
	public String removeCat(@PathVariable Long id, ModelMap map) {
		cService.remove(new Categoria(id));	
		return "redirect:/produtos/formCadastroCat";
	}
}
