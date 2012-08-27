package br.com.controller;

import java.util.List;

import br.com.bean.Item;
import br.com.dao.ItemDAO;

public class ItemController {

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
		ItemDAO itemDao = new ItemDAO();
		itemDao.salvar(item);
		return "salvar";
	}

	public/* DataModel */List getTodos() {
		ItemDAO itemDao = new ItemDAO();
		model = /* new ListDataModel */(itemDao.exibir());
		return model;
	}

	public String salvarItem() {
		ItemDAO dao = new ItemDAO();
		dao.salvar(getItem());
		return "";
	}
}
