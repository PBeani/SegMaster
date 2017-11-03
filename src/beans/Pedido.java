package beans;

import java.util.Date;

public class Pedido {
	private int idPedido;
	private int codCliente;
	private Date dtExpedicao;
	private int codContador;
	private double valorBruto;
	
	public Pedido(int idPedido , int codCliente, Date dtExpedicao, int codContador,
			double valorBruto) {
		super();
		this.idPedido = idPedido;
		this.codCliente = codCliente;
		this.dtExpedicao = dtExpedicao;
		this.codContador = codContador;
		this.valorBruto = valorBruto;
	}
	
	
	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public Date getDtExpedicao() {
		return dtExpedicao;
	}
	public void setDtExpedicao(Date dtExpedicao) {
		this.dtExpedicao = dtExpedicao;
	}
	public int getCodContador() {
		return codContador;
	}
	public void setCodContador(int codContador) {
		this.codContador = codContador;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}
	
	
	
}
