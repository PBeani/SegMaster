package beans;

public class Cliente {
	
	int id_cliente;
	String nome_cliente;
	int cod_tipo_cliente;
	String cod_endereco;
	
	public Cliente(int id_cliente, String nome_cliente, int cod_tipo_cliente, String cod_endereco) {
		super();
		this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.cod_tipo_cliente = cod_tipo_cliente;
		this.cod_endereco = cod_endereco;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public int getCod_tipo_cliente() {
		return cod_tipo_cliente;
	}
	public void setCod_tipo_cliente(int cod_tipo_cliente) {
		this.cod_tipo_cliente = cod_tipo_cliente;
	}
	public String getCod_endereco() {
		return cod_endereco;
	}
	public void setCod_endereco(String cod_endereco) {
		this.cod_endereco = cod_endereco;
	}
	
	

}
