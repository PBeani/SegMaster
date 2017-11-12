package beans;



public class Municipio {

	private int id_municipio;
	private int cod_estado;
	private String descricao;
        
        public Municipio(int cod_estado,String descricao){
        super();
        this.cod_estado = cod_estado;
        this.descricao = descricao;
        }

	public Municipio(int id_municipio, int cod_estado, String descricao) {
		super();
		this.id_municipio = id_municipio;
		this.cod_estado = cod_estado;
		this.descricao = descricao;
	}

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    @Override
    public String toString() {
        return getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
        

}
