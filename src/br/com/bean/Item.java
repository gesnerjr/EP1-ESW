package br.com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
// caso o nome da tabela seja diferente informe aqui
public class Item {
	@Column(name = "desc_item")
	private String descricao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// anotação acima indica que o campo será gerado automaticamente pelo BD
	@Column(name = "id")
	private int id;
	@Column(name = "qtde")
	private int qtde;
	@Column(name = "valorUnitario")
	// bag, pegar do item
	private double valorUnitario;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String desc, int qtde, double valor) {
		this.descricao = desc;
		this.qtde = qtde;
		this.valorUnitario = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
