package br.com.bean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
// caso o nome da tabela seja diferente informe aqui
public class Pedido {
	@Column(name = "cliente")
	private String cliente;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// anotação acima indica que o campo será gerado automaticamente pelo BD
	@Column(name = "id")
	private int id;
	@Column(name = "data")
	private String data;
	@Column(name = "cidade")
	// bag, pegar do item
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pedidos_itens", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> itens;

	// Variavel responsavel pela conversao da data informada no cadastro ....

	public Pedido() {
		// TODO Auto-generated constructor stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		data = dateFormat.format(new Date());
		cliente = "";
		itens = new ArrayList<Item>();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		if (data == null)
			data = "";
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Item> getItens() {
		if (itens == null)
			itens = new ArrayList<Item>();
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getValorTotal() {
		// Pegar valor total do pedido direto com get do jsf....
		if (itens == null)
			return "0.00";
		double total = 0;
		for (Item ite : itens) {
			total += (ite.getQtde() * ite.getValorUnitario());
		}
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(total);
	}

	public int getQtdeItens() {
		if (itens == null)
			return 0;
		int qt = 0;
		for (Item ite : itens) {
			qt += ite.getQtde();
		}
		return qt;
	}

}
