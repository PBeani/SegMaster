package beans;

import java.util.Date;

public class Certificado {
	private int id_certificado;
	private int cod_tipo_certificado;
	private int cod_categoria_certificado;
	private int cod_hardware;
	private int cod_hierarquia;
	private int cod_pedido;
	private String num_certificado;
	private Date data_validade;
	
	public Certificado(int id_certificado, int cod_tipo_certificado, int cod_categoria_certificado, int cod_hardware,
			int cod_hierarquia, int cod_pedido, String num_certificado, Date data_validade) {
		super();
		this.id_certificado = id_certificado;
		this.cod_tipo_certificado = cod_tipo_certificado;
		this.cod_categoria_certificado = cod_categoria_certificado;
		this.cod_hardware = cod_hardware;
		this.cod_hierarquia = cod_hierarquia;
		this.cod_pedido = cod_pedido;
		this.num_certificado = num_certificado;
		this.data_validade = data_validade;
	}

	public int getId_certificado() {
		return id_certificado;
	}

	public void setId_certificado(int id_certificado) {
		this.id_certificado = id_certificado;
	}

	public int getCod_tipo_certificado() {
		return cod_tipo_certificado;
	}

	public void setCod_tipo_certificado(int cod_tipo_certificado) {
		this.cod_tipo_certificado = cod_tipo_certificado;
	}

	public int getCod_categoria_certificado() {
		return cod_categoria_certificado;
	}

	public void setCod_categoria_certificado(int cod_categoria_certificado) {
		this.cod_categoria_certificado = cod_categoria_certificado;
	}

	public int getCod_hardware() {
		return cod_hardware;
	}

	public void setCod_hardware(int cod_hardware) {
		this.cod_hardware = cod_hardware;
	}

	public int getCod_hierarquia() {
		return cod_hierarquia;
	}

	public void setCod_hierarquia(int cod_hierarquia) {
		this.cod_hierarquia = cod_hierarquia;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public String getNum_certificado() {
		return num_certificado;
	}

	public void setNum_certificado(String num_certificado) {
		this.num_certificado = num_certificado;
	}

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	
	
	
	

}
