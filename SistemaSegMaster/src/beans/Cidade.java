package beans;

public class Cidade {
	
	int id_cidade;
	String desc_cidade;
	public Cidade(int id_cidade, String desc_cidade) {
		super();
		this.id_cidade = id_cidade;
		this.desc_cidade = desc_cidade;
	}
	public int getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}
	public String getDesc_cidade() {
		return desc_cidade;
	}
	public void setDesc_cidade(String desc_cidade) {
		this.desc_cidade = desc_cidade;
	}
	

}
