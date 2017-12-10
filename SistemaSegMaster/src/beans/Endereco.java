package beans;

public class Endereco {
	
	private int id_endereco;
	private int cod_estado;
	private int cod_municipio;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	
        
	public Endereco(int id_endereco, int cod_estado, int cod_municipio, String bairro, String logradouro, String numero,
			String complemento, String cep) {
		super();
		this.id_endereco = id_endereco;
		this.cod_estado = cod_estado;
		this.cod_municipio = cod_municipio;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

    public Endereco(int cod_municipio,int codEstado,String bairro, String cep, String complemento, String logradouro,String numero) {
                this.cod_municipio=cod_municipio;
                this.cod_estado=codEstado;        
                this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;  
                
            }

    

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}

	public int getCod_municipio() {
		return cod_municipio;
	}

	public void setCod_municipio(int cod_municipio) {
		this.cod_municipio = cod_municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}   
	
	

}
