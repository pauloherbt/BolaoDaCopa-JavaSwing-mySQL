package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "localhost";
		this.banco = "bolao";
		this.usuario = "peaga";
		this.senha = "";
	}

	public Connection getConexao() {
		String url = "jdbc:mysql://" + this.host + "/" + this.banco + "?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url,this.usuario,this.senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
