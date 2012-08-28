package br.com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bean.Item;
import br.com.bean.Pedido;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.dao.PedidoDAO;

@Resource
// @Path("/pedido")
public class PedidoController {

	PedidoDAO pedidoDAO;
	Result result;

	public PedidoController(PedidoDAO dao, Result result) {
		this.pedidoDAO = dao;
		this.result = result;
	}

	// public PedidoController(PedidoDAO dao, Result result, Pedido pedido) {
	// this.pedido = pedido;
	// this.pedidoDAO = dao;
	// this.result = result;
	// }

	private Pedido pedido;
	private String mensagem;
	private/* DataModel */List model;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public String getMensagem() {
		if (mensagem == null)
			mensagem = "";
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	// public PedidoController() {
	// setPedido(new Pedido());
	// }

	public Pedido getPedido() {

		return pedido;
	}

	// preencher a lista de pedidos(Metodo)
	public List lista() {
		return getPedidoDAO().exibir();
	}

	// public Pedido cadastrar() {
	// pedido.setCliente("Junior");
	// // adicionarItem();
	// return pedido;
	//
	// // return new Pedido();
	// // na teoria o pedido retornado aki devera estar na pagina
	// }

	public void cadastrar() {

	}

	@Path("/pedido/adicionarItem/{pedido.id}")
	@Post
	@Get
	public void adicionarItem(Pedido pedido, Item item) {
		Pedido p = getPedidoDAO().obterPedidoId(pedido.getId());
		if (item != null && p != null) {
			// return new Item();
			p.getItens().add(item);
			// setPedido((Pedido) (result.included().get("pedido")));
			getPedidoDAO().salvar(p);
		}
		result.include("pedido", p);
		// result.include(getPedido());
		// result.redirectTo(PedidoController.class).cadastrar();
		// result.redirectTo(PedidoController.class).cadastrar();
		// return new Item();
	}

	@Path({ "/pedido/removerItem/{pedido.id}/{item.id}", "/pedido/removerItem" })
	@Post
	@Get
	public void removerItem(Pedido pedido, Item item) {
		Pedido p = getPedidoDAO().obterPedidoId(pedido.getId());
		Item itemTmp = null;
		if (item != null) {
			// p.getItens().remove(item);
			for (Item i : p.getItens()) {
				if (i.getId() == item.getId())
					itemTmp = i;
			}
			p.getItens().remove(itemTmp);
			getPedidoDAO().salvar(p);
			result.include("pedido", p);
		}
		result.redirectTo(PedidoController.class).adicionarItem(pedido, null);
	}

	@Path("/pedido/salvar")
	@Post
	public void salvar(Pedido pedido) {
		// se der certo vai para a listagem, se der errado, tem que, de alguma
		// forma, avisar....
		getPedidoDAO().salvar(pedido);
		// result null
		result.include("pedido", pedido);
		result.redirectTo(PedidoController.class).adicionarItem(pedido, null);
	}

	@Path({ "/pedido/irParaEditar/{pedido.id}", "/pedido/irParaEditar" })
	// @Post
	public void irParaEditar(Pedido pedido) {
		Pedido p = getPedidoDAO().obterPedidoId(pedido.getId());
		result.include("pedido", p);
		result.redirectTo(PedidoController.class).adicionarItem(p, null);

	}

	public/* DataModel */List getTodos() {
		model = /* new ListDataModel */(getPedidoDAO().exibir());
		return model;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		// getPedido().setCliente("Gesner Junior");
		// getPedido().setData(new Date());
		// getPedido().setItens(new ArrayList<Item>());
		// getPedido().getItens().add(new Item("TESTE", 3, 2.9));
		// getPedido().getItens().add(new Item("TESTE2", 13, 21.99));
		// getPedido().getItens().add(new Item("TESTE3", 32, 42.99));
		// getPedidoDAO().salvar(getPedido());
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

	@Path({ "/pedido/remover/{pedido.id}", "/pedido/remover" })
	// @Path("/pedido/remover/{pedido.id}")
	// @Post
	// @Get
	public void remover(Pedido pedido) {
		if (pedido.getId() != 0)
			// result.include("pedido",
			// getPedidoDAO().obterPedidoId(pedido.getId()));
			getPedidoDAO().removerPedidoId(pedido.getId());
		result.redirectTo(PedidoController.class).lista();
	}

	@Path({ "/pedido/visualizar/{pedido.id}", "/pedido/visualizar" })
	// @Path("/pedido/visualizar/{pedido.id}")
	// @Post
	// @Get
	public void visualizar(Pedido pedido) {
		if (pedido.getId() != 0)
			result.include("pedido",
					getPedidoDAO().obterPedidoId(pedido.getId()));
	}

}
