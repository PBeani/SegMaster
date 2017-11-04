package beans;

import java.time.LocalDate;
import java.util.Date;

public class Pedido {
	private int idPedido;
	private int codCliente;
	private LocalDate dtExpedicao;
	private int codContador;
	private double valorBruto;
	
	public Pedido(int idPedido , int codCliente, LocalDate dtExpedicao, int codContador,
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
	public LocalDate getDtExpedicao() {
		return dtExpedicao;
	}
	public void setDtExpedicao(LocalDate dtExpedicao) {
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
