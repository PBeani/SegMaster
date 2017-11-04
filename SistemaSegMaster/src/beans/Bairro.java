package beans;

public class Bairro {
	
	private int id_bairro;
	private String desc_bairro;
	
	public Bairro(int id_bairro, String desc_bairro) {
		super();
		this.id_bairro = id_bairro;
		this.desc_bairro = desc_bairro;
	}
	
	public int getId_bairro() {
		return id_bairro;
	}
	public void setId_bairro(int id_bairro) {
		this.id_bairro = id_bairro;
	}
	public String getDesc_bairro() {
		return desc_bairro;
	}
	public void setDesc_bairro(String desc_bairro) {
		this.desc_bairro = desc_bairro;
	}
	

}
