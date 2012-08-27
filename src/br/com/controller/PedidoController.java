package br.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bean.Item;
import br.com.bean.Pedido;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.dao.PedidoDAO;

@Resource
public class PedidoController {

	PedidoDAO pedidoDAO;
	Result result;

	public PedidoController(PedidoDAO dao, Result result) {
		this.pedidoDAO = dao;
		this.result = result;
	}

	private Pedido pedido;
	private/* DataModel */List model;

	public PedidoController() {
		setPedido(null);
		getPedido();
	}

	public Pedido getPedido() {
		if (pedido == null) {
			pedido = new Pedido();
			pedido.setCliente("");
			pedido.setData(new Date());
			pedido.setItens(new ArrayList<Item>());
		}
		return pedido;
	}

	public List lista() {
		return getPedidoDAO().exibir();
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String salvar() {
		getPedidoDAO().salvar(pedido);
		return "salvar";
	}

	public/* DataModel */List getTodos() {
		model = /* new ListDataModel */(getPedidoDAO().exibir());
		return model;
	}

	public String salvarPedido() {
		getPedidoDAO().salvar(getPedido());
		return "";
	}

	public String salvarPedido(Pedido pedido) {
		getPedidoDAO().salvar(pedido);
		return "";
	}

	public void salvarPedido1() {
		getPedido().setCliente("Gesner Junior");
		getPedido().setData(new Date());
		getPedido().setItens(new ArrayList<Item>());
		getPedido().getItens().add(new Item("TESTE", 3, 2.99));
		getPedidoDAO().salvar(getPedido());
	}

	public PedidoDAO getPedidoDAO() {
		if (pedidoDAO == null)
			pedidoDAO = new PedidoDAO();
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
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
