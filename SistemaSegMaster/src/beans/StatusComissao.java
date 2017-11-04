package beans;

public class StatusComissao {
	
	private int id_status_comissao;
	private String desc_status_comissao;
	
	public StatusComissao(int id_status_comissao, String desc_status_comissao) {
		super();
		this.id_status_comissao = id_status_comissao;
		this.desc_status_comissao = desc_status_comissao;
	}
	
	public int getId_status_comissao() {
		return id_status_comissao;
	}
	public void setId_status_comissao(int id_status_comissao) {
		this.id_status_comissao = id_status_comissao;
	}
	public String getDesc_status_comissao() {
		return desc_status_comissao;
	}
	public void setDesc_status_comissao(String desc_status_comissao) {
		this.desc_status_comissao = desc_status_comissao;
	}
	

}
