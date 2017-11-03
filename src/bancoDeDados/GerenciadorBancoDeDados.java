package bancoDeDados;

import java.sql.SQLException;
import java.time.LocalDate;

import beans.*;
import classesBiblioteca.Usuario;
import utilidades.Log;

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

	public void insereCliente(Cliente cliente) throws BancoException {
		abreConexao();
		preparaComandoSQL(
				"insert into cliente (id_cliente, nome_cliente,cod_tipo_cliente,cod_endereco) values (?, ?, ?, ?) ");
		try {
			pstmt.setInt(1, cliente.getId_cliente());
			pstmt.setString(2, cliente.getNome_cliente());
			pstmt.setInt(3, cliente.getCod_tipo_cliente());
			pstmt.setString(4, cliente.getCod_endereco());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar cliente");
		}
		fechaConexao();
	}

	public void insereCliente_Fisico(Cliente_Fisico cliente) throws BancoException {
		insereCliente(cliente);
		abreConexao();
		preparaComandoSQL("insert into cliente_fisico (id_cliente_fisico,cod_cliente,cpf) values (?,?,?) ");
		try {
			pstmt.setInt(1, cliente.getCod_tipo_cliente());
			pstmt.setInt(2, cliente.getCod_cliente());
			pstmt.setString(3, cliente.getCpf());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar cliente fisico");
		}
		fechaConexao();

	}

	public void insereCliente_Juridico(Cliente_Juridico cliente) throws BancoException {
		insereCliente(cliente);
		abreConexao();
		preparaComandoSQL(
				"insert into cliente_fisico (id_cliente_juridico,cod_cliente,cnpj,nome_empresa) values (?,?,?,?) ");
		try {
			pstmt.setInt(1, cliente.getCod_tipo_cliente());
			pstmt.setInt(2, cliente.getCod_cliente());
			pstmt.setString(3, cliente.getCnpj());
			pstmt.setString(4, cliente.getNomeEmpresa());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar cliente juridico");
		}
		fechaConexao();
	}

	public void inserePedido(Pedido pedido) throws BancoException {
		abreConexao();
		preparaComandoSQL(
				"insert into pedido (id_pedido,cod_cliente,dt_expedicao,cod_contador,valor_bruto) values (?,?,?,?,?) ");
		try {
			pstmt.setInt(1, pedido.getIdPedido());
			pstmt.setInt(2, pedido.getCodCliente());
			pstmt.setDate(3, java.sql.Date.valueOf(pedido.getDtExpedicao()));
			pstmt.setInt(4, pedido.getCodContador());
			pstmt.setDouble(5, pedido.getValorBruto());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar pedido");
		}
		fechaConexao();

	}

	public void insereContador(Contador contador) throws BancoException {
		abreConexao();
		preparaComandoSQL("insert into contador (id_contador,nome_contador,cod_contabilidade) values (?,?,?) ");
		try {
			pstmt.setInt(1, contador.getId_contador());
			pstmt.setString(2, contador.getNomeContador());
			pstmt.setInt(3, contador.getCod_contabilidade());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar contador");
		}
		fechaConexao();

	}

	public void insereCertificado(Certificado certificado) throws BancoException {
		abreConexao();
		preparaComandoSQL(
				"insert into certificado (id_certificado,cod_tipo_certificado,cod_categoria_certificado,cod_hardware,cod_hierarquia,num_certificado,data_validade) values (?,?,?,?,?,?,?) ");
		try {
			pstmt.setInt(1, certificado.getId_certificado());
			pstmt.setInt(2, certificado.getCod_tipo_certificado());
			pstmt.setInt(3, certificado.getCod_categoria_certificado());
			pstmt.setInt(4, certificado.getCod_hardware());
			pstmt.setInt(5, certificado.getCod_hierarquia());
			pstmt.setString(6, certificado.getNum_certificado());
			pstmt.setDate(7, java.sql.Date.valueOf(certificado.getData_validade()));
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar certificado");
		}
		fechaConexao();

	}

	public void insereMunicipio(Municipio municipio) throws BancoException {
		abreConexao();
		preparaComandoSQL("insert into municipios (id_municipio,cod_estado,descricao) values (?,?,?) ");
		try {
			pstmt.setInt(1, municipio.getId_municipio());
			pstmt.setInt(2, municipio.getCod_estado());
			pstmt.setString(3, municipio.getDescricao());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar municipio");
		}
		fechaConexao();
	}

	public void insereEstado(Estado estado) throws BancoException {

		abreConexao();
		preparaComandoSQL("insert into estado (id_estado,desc_estado,sigla) values (?,?,?,?) ");
		try {
			pstmt.setInt(1, estado.getId_estado());
			pstmt.setString(2, estado.getDesc_estado());
			pstmt.setString(3, estado.getSigla());
			pstmt.execute();
		} catch (SQLException e) {
			throw new BancoException("Problema ao cadastrar estado");
		}
		fechaConexao();
	}

	// ------------------------------------------------------------

	public Cliente selecionaCliente(int id_cliente) throws BancoException {
		abreConexao();
		Cliente cliente = null;
		preparaComandoSQL("select * from cliente where id_cliente = ?");
		try {
			pstmt.setInt(1, id_cliente);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nome_cliente = rs.getString(2);
				int cod_tipo_cliente = rs.getInt(3);
				String cod_endereco = rs.getString(4);
				cliente = new Cliente(id_cliente, nome_cliente, cod_tipo_cliente, cod_endereco);
			}

		} catch (SQLException e) {
			fechaConexao();
			throw new BancoException("Problema na seleção do Usuário.");
		}

		fechaConexao();
		return cliente;

	}

	public Cliente_Fisico selecionaClienteFisico(int cod_cliente) throws BancoException {
		Cliente cliente = selecionaCliente(cod_cliente);
		abreConexao();
		Cliente_Fisico clientefisico = null;
		preparaComandoSQL("select * from cliente_fisico where id_cliente = ?");
		try {
			pstmt.setInt(1, cod_cliente);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id_cliente_fisico = rs.getInt(1);
				String cpf = rs.getString(3);

				String cod_endereco = rs.getString(4);
				clientefisico = new Cliente_Fisico(id_cliente_fisico, cod_cliente, cliente.getNome_cliente(),
						cliente.getCod_endereco(), cpf);
			}

		} catch (SQLException e) {
			fechaConexao();
			throw new BancoException("Problema na selecao de Cliente fisico");
		}

		fechaConexao();
		return clientefisico;
	}

	public Cliente_Juridico selecionaClienteJuridico(int cod_cliente) throws BancoException{
		Cliente cliente = selecionaCliente(cod_cliente);
		abreConexao();
		Cliente_Juridico clientejuridico = null;
		preparaComandoSQL("select * from cliente where id_cliente = ?");
		try {
			pstmt.setInt(1, cod_cliente);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id_cliente_juridico = rs.getInt(1);
				String cnpj = rs.getString(3);
				String nome_empresa = rs.getString(4);
				clientejuridico = new Cliente_Juridico(cod_cliente, id_cliente_juridico, cnpj, nome_empresa,
						cliente.getNome_cliente(), cliente.getCod_endereco());
			}

		} catch (SQLException e) {
			fechaConexao();
			throw new BancoException("Problema na selecao de Cliente juridico");
		}

		fechaConexao();
		return clientejuridico;

	}

}
