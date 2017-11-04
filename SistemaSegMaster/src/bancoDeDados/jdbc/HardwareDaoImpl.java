package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Hardware;

public class HardwareDaoImpl extends ConectorJDBC implements HardwareDao {

    public HardwareDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereHardware(Hardware hardware) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into hardware (desc_hardware) values (?)");
        try {
            pstmt.setString(1, hardware.getDesc_hardware());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar Hardware");
        }
        fechaConexao();
    }

    @Override
    public void alteraHardware(Hardware hardware) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update hardware set desc_hardware = ? where id_hardware = ?");
        try {
            pstmt.setString(1, hardware.getDesc_hardware());
            pstmt.setInt(2, hardware.getId_hardware());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização do hardware.");
        }

        fechaConexao();
    }

    @Override
    public Hardware selecionaHardware(int cod) throws BancoException {
        abreConexao();

        Hardware hardware = null;
        preparaComandoSQL("select * from hardware where id_hardware = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                hardware = new Hardware(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de hardware.");
        }
        
        fechaConexao();
        return hardware;
    }

    @Override
    public LinkedList<Hardware> listaHardware() throws BancoException {
        LinkedList<Hardware> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from hardware");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                Hardware item = new Hardware(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Hardware.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeHardware(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from hardware where id_hardware = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção do Hardware.");
        }

        fechaConexao();
    }

}
