package br.com.controller;

import java.util.List;

import br.com.bean.Item;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.dao.ItemDAO;

@Resource
public class ItemController {

	ItemDAO itemDAO;
	Result result;

	public ItemController(ItemDAO dao, Result result) {
		this.itemDAO = dao;
		this.result = result;
	}

	private Item item;
	private/* DataModel */List model;

	public ItemController() {
		item = new Item();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String salvar() {
		getItemDAO().salvar(item);
		return "salvar";
	}

	public/* DataModel */List getTodos() {
		model = /* new ListDataModel */(getItemDAO().exibir());
		return model;
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

	public void setResult(Result result) {
		this.result = result;
	}

	public List getModel() {
		return model;
	}

	public void setModel(List model) {
		this.model = model;
	}

}
