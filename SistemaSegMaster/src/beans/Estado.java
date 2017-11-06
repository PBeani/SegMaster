package beans;

public class Estado{
	
	private int id_estado;
	private String desc_estado;
	private String sigla;
        
        public Estado(String desc_estado,String sigla){
            super();
            this.desc_estado = desc_estado;
		this.sigla = sigla;
        }
	
	public Estado(int id_estado, String desc_estado, String sigla) {
		super();
		this.id_estado = id_estado;
		this.desc_estado = desc_estado;
		this.sigla = sigla;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	public String getDesc_estado() {
		return desc_estado;
	}

	public void setDesc_estado(String desc_estado) {
		this.desc_estado = desc_estado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
