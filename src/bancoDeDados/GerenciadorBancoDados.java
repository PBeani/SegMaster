package bancoDeDados;

import beans.*;

public interface GerenciadorBancoDados {
	
	public void insereCliente(Cliente cliente) throws BancoException;
	public void insereClienteFisico(Cliente_Fisico cliente) throws BancoException;
	public void insereClienteJuridico(Cliente_Juridico cliente) throws BancoException;
	
	
	public void inserepedido();
		
	public void insereContador();
	
	public void insereCertificado();
	
	public void insereBairro(); // lembrar de adicionar tabela
	
	public void insereCidade(); 
	
	public void insereEstado();
	
	public void inserePais();	//lembrar de adicionar tabela
	
	
	public Cliente_Fisico selecionaClienteFisico();
	
	public Cliente_Juridico selecionaClienteJuridico();
		
	
	public Certificado selecionaCertificado();
	
	public Bairro selecionaBairro();
	
	public Cidade selecionaCidade();
	
	public Estado selecionaEstado();
	
	public Pais selecionaPais();
	
	
	

}
