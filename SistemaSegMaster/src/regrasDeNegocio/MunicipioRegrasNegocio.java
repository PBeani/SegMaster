package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.MunicipioDao;
import bancoDeDados.jdbc.MunicipioDaoImpl;
import beans.Municipio;

public class MunicipioRegrasNegocio {

    private MunicipioDaoImpl municipioDaoImpl;

    public MunicipioRegrasNegocio() throws BancoException {
        this.municipioDaoImpl = new MunicipioDaoImpl();
    }

    public boolean cadastroMunicipio(Municipio municipio) throws Exception {
        try {
            //fazer funcao para listar Municipio
            boolean existeMunicipio = municipioDaoImpl.existeMunicipio(municipio.getDescricao());
            if (existeMunicipio) {
                JOptionPane.showMessageDialog(null, "Municipio ja cadastrado");
                return false;
            }

            //alterar a funcao para ser INSEREMUNICIPIO
            municipioDaoImpl.insereMunicipio(municipio);
            return true;
        } catch (BancoException e) {
            throw new Exception("Erro ao cadastrar municipio");
        }
    }

    public Municipio seleciona(int cod) throws Exception {
        try {
            return municipioDaoImpl.selecionaMunicipio(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public boolean altera(Municipio municipio) throws Exception {
        try {
            municipioDaoImpl.alteraMunicipio(municipio);
            return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<Municipio> listaMunicipio() throws Exception {
        try {

            return municipioDaoImpl.listaMunicipio();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<Municipio> listaMunicipioEstado(int idEstado) throws Exception {
        return municipioDaoImpl.listaMunicipioEstado(idEstado);
    }

    public void remove(int cod) throws Exception {
        try {
            municipioDaoImpl.removeMunicipio(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
