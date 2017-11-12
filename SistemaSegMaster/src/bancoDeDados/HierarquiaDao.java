package bancoDeDados;

import beans.Hierarquia;
import java.util.LinkedList;

public interface HierarquiaDao {

    public void insereHierarquia(Hierarquia c) throws BancoException;

    public void alteraHierarquia(Hierarquia c) throws BancoException;

    public Hierarquia selecionaHierarquia(int cod) throws BancoException;

    public LinkedList<Hierarquia> listaHierarquia() throws BancoException;

    public void removeHierarquia(int cod) throws BancoException;
    
    public boolean existeHierarquia (String desc_hierarquia) throws BancoException;
}
