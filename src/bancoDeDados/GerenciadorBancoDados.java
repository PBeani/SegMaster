package bancoDeDados;

import beans.ClienteFisico;
import beans.ClienteJuridico;

public interface GerenciadorBancoDados {
	
	public void insereCliente();
	public void insereClienteFisico(ClienteFisico cliente);
	public void insereClienteJuridico(ClienteJuridico cliente);
	
	
	public void inserepedido();
	
	public void insereContador();
	
	public void insereCertificado();
	
	public void insereBairro();
	
	public void insereCidade();
	
	public void insereEstado();
	
	public void inserePais();	
	
	
	public retornaCertificado();
	
	public retornaBairros();
	
	public retornaCidades();
	
	public retornaEstados();
	
	public retornaPais();
	
	
	

}
