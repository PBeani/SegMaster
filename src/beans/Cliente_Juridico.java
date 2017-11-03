package beans;

public class Cliente_Juridico extends Cliente {

	private int id_cliente_juridico;
	private int cod_cliente;
	private String cnpj;
	private String nomeEmpresa;
	private String endereco;

	public Cliente_Juridico(int id_cliente, int id_cliente_juridico, String cnpj,
			String nomeEmpresa, String nome, String endereco) {
		super(id_cliente, nome, id_cliente_juridico, endereco);
		this.id_cliente_juridico = id_cliente_juridico;
		this.cod_cliente = id_cliente;
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public int getId_cliente_juridico() {
		return id_cliente_juridico;
	}

	public void setId_cliente_juridico(int id_cliente_juridico) {
		this.id_cliente_juridico = id_cliente_juridico;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

}
