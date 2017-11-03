package beans;

public class Cliente {
	
	private int id_cliente;
	private String nome_cliente;
	private int cod_tipo_cliente;
	private String endereco;
	
	public Cliente(int id_cliente, String nome_cliente, int cod_tipo_cliente, String endereco) {
		super();
		this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.cod_tipo_cliente = cod_tipo_cliente;
		this.endereco = endereco;
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
		return endereco;
	}
	public void setCod_endereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
