package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitys.Compra;
import entitys.ItemMovimento;
import entitys.PessoaJuridica;
import entitys.Produto;
import entitys.Usuario;
import services.CompraService;
import services.ItemMovimentoService;
import services.PessoaJuridicaService;
import services.ProdutoService;

@RequestMapping(value = "compras")
@Controller
public class CompraController {

	@Autowired
	private CompraService cService;

	@Autowired
	private PessoaJuridicaService pjService;	
	
	@Autowired
	private ItemMovimentoService iService;
	
	@Autowired
	private ProdutoService pService;

	@RequestMapping(value = "listCompras", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Compra> compras = cService.listAll();
		map.addAttribute("compras", compras);
		map.addAttribute("filtro", new Compra());		
		return "compra/listCompras";
	}

	@RequestMapping(value = "cadCompras", method = RequestMethod.GET)
	public String listCad(ModelMap map, HttpSession session, HttpServletRequest req) {
		session = req.getSession();		
		Compra movimento = (Compra) session.getAttribute("movimento");
		if (movimento == null) {
			movimento = new Compra();
		}		
		ItemMovimento itemMovimento = new ItemMovimento();		
		List<ItemMovimento> itensMovimento = (List<ItemMovimento>) session.getAttribute("listItens");
		map.addAttribute("itensList", itensMovimento);
		map.addAttribute("selectFornecedores", fornecedorSelect());
		map.addAttribute("selectProdutos", produtoSelect());
		map.addAttribute("itemMovimento", itemMovimento);
		map.addAttribute("movimento", movimento);		
		return "compra/cadCompra";
	}

	@RequestMapping(value = "addItem", method = RequestMethod.POST)
	public String add(@ModelAttribute("itemMovimento") ItemMovimento itemMovimento, ModelMap map, HttpSession session,
			HttpServletRequest req) {
		session = req.getSession();
		Compra movimento = (Compra) session.getAttribute("movimento");
		if (movimento == null) {
			movimento = new Compra();
		}
		Produto produto = pService.findId(itemMovimento.getProduto().getId());
		itemMovimento.setProduto(produto);
		itemMovimento.setValor(itemMovimento.getValor() * itemMovimento.getQtde());
		List<ItemMovimento> itensMovimento = (List<ItemMovimento>) session.getAttribute("listItens");
		if (itensMovimento != null) {
			itemMovimento.setMovimento(movimento);
			itensMovimento.add(itemMovimento);
		} else {
			itensMovimento = new ArrayList<ItemMovimento>();			
			itensMovimento.add(itemMovimento);
		}		
		movimento.setTotalMovimento(movimento.getTotalMovimento() + itemMovimento.getValor());
		session.setAttribute("movimento", movimento);
		session.setAttribute("listItens", itensMovimento);		
		return "redirect:/compras/cadCompras";
	}

	@RequestMapping(value = "{id}/removeItem", method = RequestMethod.GET)
	public String removeItem(@PathVariable int id, ModelMap map, HttpSession session, HttpServletRequest req) {
		session = req.getSession();
		List<ItemMovimento> itensMovimento = (List<ItemMovimento>) session.getAttribute("listItens");
		Compra movimento = (Compra) session.getAttribute("movimento");
		ItemMovimento item = itensMovimento.get(id - 1);
		movimento.setTotalMovimento(movimento.getTotalMovimento() - item.getValor());
		itensMovimento.remove(id - 1);
		session.setAttribute("listItens", itensMovimento);
		session.setAttribute("movimento", movimento);		
		return "redirect:/compras/cadCompras";
	}

	@RequestMapping(value = "cadastro", method = RequestMethod.POST)
	public String saveCompra(@ModelAttribute("movimento") Compra compra, ModelMap map, HttpSession session, HttpServletRequest req) {
		session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioL");
		List<ItemMovimento> itensMovimento = (List<ItemMovimento>) session.getAttribute("listItens");		
		Compra movimento = (Compra) session.getAttribute("movimento");
		compra.setItensMovimento(itensMovimento);
		compra.setUsuario(usuario);
		compra.setTotalMovimento(movimento.getTotalMovimento());		
		cService.insert(compra);
		for (ItemMovimento itemMovimento : itensMovimento) {
			itemMovimento.setMovimento(compra);
			iService.insert(itemMovimento);
		}		
		session.removeAttribute("movimento");
		session.removeAttribute("listItens");
		return "redirect:/compras/listCompras";
	}

	public Map<Long, String> fornecedorSelect() {
		List<PessoaJuridica> fornecedores = pjService.listAll();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (PessoaJuridica pessoaJuridica : fornecedores) {
			mapa.put(pessoaJuridica.getId(), pessoaJuridica.getRazaoSocial());
		}
		return mapa;
	}

	public Map<Long, String> produtoSelect() {
		List<Produto> produtos = pService.listAll();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (Produto produto : produtos) {
			mapa.put(produto.getId(), produto.getDescricao());
		}
		return mapa;
	}
}
