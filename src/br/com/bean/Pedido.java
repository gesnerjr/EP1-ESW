package br.com.bean;

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
	private Date data;
	@Column(name = "cidade")
	// bag, pegar do item
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pedidos_itens", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> itens = new ArrayList<Item>();

	public Pedido() {
		// TODO Auto-generated constructor stub
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
