package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConectorJDBC {

    protected enum DB {
        MYSQL;
    }
    private static final String PASSWORD = "200298";
    private static final String USER = "root";
    private static final String HOST = "localhost";
    private static final String DB_NAME = "segmaster";

    // MySQL
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql";

    private DB db;
    protected Connection con;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    protected String getUser() {
        return USER;
    }

    protected String getPassword() {
        return PASSWORD;
    }

    protected String getDbHost() {
        return HOST;
    }

    protected String getDbName() {
        return DB_NAME;
    }

    protected ConectorJDBC(DB db) throws BancoException {
        this.db = db;
        String dbDriver = MYSQL_DRIVER;

        try {
            Class.forName(dbDriver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConectorJDBC() throws BancoException {
        this(DB.MYSQL);
    }

    protected void abreConexao() throws BancoException {
        String dbURL = MYSQL_URL;
        try {
            con = DriverManager.getConnection(dbURL + "://" + getDbHost() + "/"
                    + getDbName(), getUser(), getPassword());
        } catch (SQLException e) {
            throw new BancoException("Problemas ao acessar o banco de dados.");
        }
    }

    protected void fechaConexao() throws BancoException {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }

            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }

            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            throw new BancoException("Problemas ao finalizar o acesso ao banco de dados.");
        }
    }

    protected void preparaComandoSQL(String sql) throws BancoException {
        try {
            pstmt = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new BancoException("Problemas na formatação para o comando SQL.");
        }
    }

    protected void preparaComandoSQL(String sql, int volta) throws BancoException {
        try {
            pstmt = con.prepareStatement(sql, volta);
        } catch (SQLException e) {
            throw new BancoException("Problemas na formatação para o comando SQL.");
        }
    }
}
