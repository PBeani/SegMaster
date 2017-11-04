package bancoDeDados;

import beans.Municipio;

public interface MunicipioDao {
    
    public void insereMunicipio(Municipio m) throws BancoException;
//    public Municipio selecionaMunicipio() throws BancoException;
}
