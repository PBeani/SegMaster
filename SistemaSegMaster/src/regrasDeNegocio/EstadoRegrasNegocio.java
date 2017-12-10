package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.EstadoDao;
import bancoDeDados.jdbc.EstadoDaoImpl;
import beans.Estado;

public class EstadoRegrasNegocio {

    private EstadoDaoImpl estadoDao;

    public EstadoRegrasNegocio() throws BancoException {

        estadoDao = new EstadoDaoImpl();
    }
    
    public boolean cadastroEstado(Estado estado) throws Exception {
        try {
            //fazer funcao para listar Estado

            boolean existeEstado = estadoDao.existeEstado(estado.getSigla());

            if (existeEstado) {
                JOptionPane.showMessageDialog(null, "Estado ja cadastrado");
                return false;
            }
            //falta fazer a funcao de inserir estado

            estadoDao.insereEstado(estado);
            return true;
        } catch (BancoException e) {
            throw new Exception("Falha ao cadastrar Estado");
        }
    }

    public Estado seleciona(int cod) throws Exception {
        try {
            return estadoDao.selecionaEstado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public boolean altera(Estado estado) throws Exception {
        try {
            estadoDao.alteraEstado(estado);
            return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<Estado> listaEstado() throws Exception {
        try {

            return estadoDao.listaEstado();

        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public void remove(int cod) throws Exception {
        try {
            estadoDao.removeEstado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    public int selecionaCodEstado(String sigla) throws Exception{
        try{
            return estadoDao.selecionaCodEstado(sigla);
        }catch(BancoException e){
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
