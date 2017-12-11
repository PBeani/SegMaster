package bancoDeDados;

import beans.Municipio;
import java.util.LinkedList;

public interface MunicipioDao {
    
    public int selecionaCodMunicipio(String desc) throws BancoException;

    public void insereMunicipio(Municipio m) throws BancoException;

    public void alteraMunicipio(Municipio c) throws BancoException;

    public Municipio selecionaMunicipio(int cod) throws BancoException;

    public LinkedList<Municipio> listaMunicipio() throws BancoException;
    
    public LinkedList<Municipio> listaMunicipioEstado(int cod) throws BancoException;

    public void removeMunicipio(int cod) throws BancoException;
    
    public boolean existeMunicipio(String descricao) throws BancoException;
}
