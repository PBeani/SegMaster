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

    public Pedido(int codigo, int codCliente, java.sql.Date dtExpedicao, int codContador, double valorBruto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pedido(int cod, String textoCliente, String textoContador, LocalDate textoData, double textoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Pedido(int codCliente, int codContador,LocalDate textoData, double textoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
