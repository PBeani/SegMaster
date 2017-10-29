package beans;

public class Hierarquia {
	
	private int id_hierarquia;
	private String desc_hierarquia;
	public Hierarquia(int id_hierarquia, String desc_hierarquia) {
		super();
		this.id_hierarquia = id_hierarquia;
		this.desc_hierarquia = desc_hierarquia;
	}
	public int getId_hierarquia() {
		return id_hierarquia;
	}
	public void setId_hierarquia(int id_hierarquia) {
		this.id_hierarquia = id_hierarquia;
	}
	public String getDesc_hierarquia() {
		return desc_hierarquia;
	}
	public void setDesc_hierarquia(String desc_hierarquia) {
		this.desc_hierarquia = desc_hierarquia;
	}
	
	

}
