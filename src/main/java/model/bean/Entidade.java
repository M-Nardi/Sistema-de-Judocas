package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entidade")
@NamedQueries(value = {
		@NamedQuery(name = "listDojo", query = "SELECT e FROM Entidade e"),
		@NamedQuery(name = "listNameDojo", query = "SELECT e FROM Entidade e WHERE e.nome LIKE :names"),
		@NamedQuery(name = "dojoName", query = "SELECT e FROM Entidade e WHERE e.nome = :name")
		})
public class Entidade {
	
	@Id
	@GeneratedValue
	private Long entidade_id;
	
	@Column
	String nome;
	
	@Column
	String cnpj;

	@Column
	String telefone1;

	@Column
	String telefone2;

	@OneToOne(cascade=CascadeType.ALL)
	Endereco endereco;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Entidade){
			Entidade other = (Entidade) obj;
			return nome == other.nome;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		return 29 * hash +(this.nome != null ? this.nome.hashCode() : 0);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString(){
		return "Dojo=[ID: " + this.entidade_id + "; Nome: " + this.nome + "; CNPJ: " + this.cnpj + "; Endereço: " + this.getEndereco().toString() + "]";
	}

	public void copyProperties(Entidade entidade) {
		nome = entidade.nome;
		cnpj = entidade.cnpj;
		telefone1 = entidade.telefone1;
		telefone2 = entidade.telefone2;
		endereco = entidade.endereco;
	}
}