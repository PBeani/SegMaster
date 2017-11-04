package beans;

public class Cliente_Fisico extends Cliente{

	private int id_cliente_fisico;
	private int cod_cliente;
	private String nome;
	private String endereco;
	private String cpf;
	
	public Cliente_Fisico(int id_cliente_fisico,int cod_cliente, String nome, String endereco, String cpf) {
		super(cod_cliente, nome,id_cliente_fisico, endereco );
		this.id_cliente_fisico= id_cliente_fisico;
		this.cod_cliente= cod_cliente;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}

	public int getId_cliente_fisico() {
		return id_cliente_fisico;
	}

	public void setId_cliente_fisico(int id_cliente_fisico) {
		this.id_cliente_fisico = id_cliente_fisico;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
