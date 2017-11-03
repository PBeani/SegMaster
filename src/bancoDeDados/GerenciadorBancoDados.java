package bancoDeDados;

import beans.*;

public interface GerenciadorBancoDados {
	
	public void insereCliente();
	public void insereClienteFisico(Cliente_Fisico cliente);
	public void insereClienteJuridico(Cliente_Juridico cliente);
	
	
	public void inserepedido();
		
	public void insereContador();
	
	public void insereCertificado();
	
	public void insereBairro();
	
	public void insereCidade();
	
	public void insereEstado();
	
	public void inserePais();	
	
	
	public Certificado retornaCertificado();
	
	public Bairro retornaBairro();
	
	public Cidade retornaCidade();
	
	public Estado retornaEstado();
	
	public Pais retornaPai();
	
	
	

}
