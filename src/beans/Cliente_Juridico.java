package beans;

public class Cliente_Juridico {
	
	private String nome;
	private String endereco;
	private String cnpj;
	private String nomeEmpresa;
	
	public Cliente_Juridico(String nome, String endereco, String cnpj,
			String nomeEmpresa) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
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
	
	

}
