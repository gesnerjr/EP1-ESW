package br.com.caelum.vraptor.blank;

import java.util.List;

import br.com.bean.Item;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.controller.PedidoController;
import br.com.dao.ItemDAO;

@Resource
public class IndexController {

	ItemDAO itemDAO;
	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	public IndexController(ItemDAO dao, Result result) {
		this.itemDAO = dao;
		this.result = result;
	}

	public IndexController() {
		this.result = null;
		getItem();
	}

	private Item item;
	private/* DataModel */List model;

	@Path("/")
	public void index() {
		(new PedidoController()).salvarPedido1();
		// result.include("variable", "Gesner Junior");
		// Item i = new Item();
		// i.setDescricao("Novo item");
		// i.setQtde(4);
		// i.setValorUnitario(4.32);
		//
		// (new ItemDAO()).getEntityManager().persist(i);

	}

	public Item cadastrar() {
		Item i = new Item();
		i.setDescricao("Novo item 2");
		i.setQtde(4);
		i.setValorUnitario(4.32);

		(new ItemDAO()).getEntityManager().persist(i);
		return i;
	}

	public Item getItem() {
		if (item == null) {
			item = new Item();
			item.setDescricao("");
			item.setQtde(0);
			item.setValorUnitario(0);
		}

		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	// public String salvar() {
	// getItemDAO().salvar(item);
	// return "salvar";
	// }

	public/* DataModel */List listar() {
		return (getItemDAO().exibir());
	}

	public String salvarItem() {
		getItemDAO().salvar(getItem());
		return "";
	}

	public ItemDAO getItemDAO() {
		if (itemDAO == null)
			itemDAO = new ItemDAO();
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public Result getResult() {
		return result;
	}

	public List getModel() {
		return model;
	}

	public void setModel(List model) {
		this.model = model;
	}

}
