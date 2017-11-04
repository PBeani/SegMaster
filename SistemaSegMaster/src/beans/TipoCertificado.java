package beans;

public class TipoCertificado {
	private int id_tipo_certificado;
	private String desc_tipo_certificado;
	public TipoCertificado(int id_tipo_certificado, String desc_tipo_certificado) {
		super();
		this.id_tipo_certificado = id_tipo_certificado;
		this.desc_tipo_certificado = desc_tipo_certificado;
	}
	public int getId_tipo_certificado() {
		return id_tipo_certificado;
	}
	public void setId_tipo_certificado(int id_tipo_certificado) {
		this.id_tipo_certificado = id_tipo_certificado;
	}
	public String getDesc_tipo_certificado() {
		return desc_tipo_certificado;
	}
	public void setDesc_tipo_certificado(String desc_tipo_certificado) {
		this.desc_tipo_certificado = desc_tipo_certificado;
	}
	
}
