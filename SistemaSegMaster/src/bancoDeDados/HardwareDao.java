package bancoDeDados;

import beans.Hardware;
import java.util.LinkedList;

public interface HardwareDao {

    public void insereHardware(Hardware c) throws BancoException;

    public void alteraHardware(Hardware c) throws BancoException;

    public Hardware selecionaHardware(int cod) throws BancoException;

    public LinkedList<Hardware> listaHardware() throws BancoException;

    public void removeHardware(int cod) throws BancoException;
}
