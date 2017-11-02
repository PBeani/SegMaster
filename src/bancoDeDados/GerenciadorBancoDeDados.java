package bancoDeDados;

import java.sql.SQLException;
import beans.*;

public class GerenciadorBancoDeDados extends ConectorJDBC implements GerenciadorBancoDados {

	private static final String PASSWORD = "";
	private static final String USER = "";
	private static final String HOST = "localhost";
	private static final String DB_NAME = "";

	public GerenciadorBancoDeDados(DB db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getUser() {
		return USER;
	}

	@Override
	protected String getPassword() {
		return PASSWORD;
	}

	@Override
	protected String getDbHost() {
		return HOST;
	}

	@Override
	protected String getDbName() {
		return DB_NAME;
	}

	public void insereClienteFisico(Cliente_Fisico cliente) {
		abreConexao();
		preparaComandoSQL(
				"insert into Cliente (id_cliente, nome_cliente,cod_tipo_cliente,cod_endereco) values (?, ?, ?, ?) ; insert into Cliente_Fisico (id_cliente_fisico,cod_cliente, cpf) values (?,?,?,?)	");
		try {
			pstmt.setInt(1, cliente.getId_cliente());
			pstmt.setString(2, cliente.getNome());
			pstmt.setInt(3, );
			pstmt.setString(4, cliente.getEndereco());
			pstmt.execute();
		} catch (SQLException e) {
			Log.gravaLog(e);
			throw new BancoException("Problema ao cadastrar cliente");
		}

		fechaConexao();
	}

}
