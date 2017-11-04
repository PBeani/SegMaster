package beans;

public class Pais {
	
	private int id_pais;
	private String desc_pais;
	private String sigla;
	
	public Pais(int id_pais, String desc_pais, String sigla) {
		super();
		this.id_pais = id_pais;
		this.desc_pais = desc_pais;
		this.sigla = sigla;
	}
	
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getDesc_pais() {
		return desc_pais;
	}
	public void setDesc_pais(String desc_pais) {
		this.desc_pais = desc_pais;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
}
