package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Confronto;
import entities.Participante;
import entities.ParticipanteDados;
import gui.PainelConfrontos;

public class ParticipanteDAO {

	public ArrayList<Participante> listar() {
		ArrayList<Participante> part = new ArrayList<>();
		try (Connection conexao = new Conexao().getConexao()) {
			ResultSet result = conexao.prepareStatement("select * from tab_bolao").executeQuery();
			Participante parti;
			while (result.next()) {
				parti = new Participante();
				parti.setNome(result.getString("nome"));
				parti.setQuartas(organizarQuartas(result));
				parti.setSemi(organizarSemi(result));
				parti.setFinale(organizarFinal(result));
				parti.setVencedor(result.getString("VENCEDOR"));
				part.add(parti);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return part;
	}
	public void inserirNome(Participante p) {
		try (Connection conexao = new Conexao().getConexao()) {
			PreparedStatement statement = conexao.prepareStatement("insert into tab_bolao (nome) values (?)");
			statement.setString(1, p.getNome());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(Participante participante, String query, ArrayList<Confronto> etapa) {
		try (Connection conexao = new Conexao().getConexao()) {
			PreparedStatement statement = conexao.prepareStatement(query);
			preencherStatement(statement, participante, etapa);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void preencherStatement(PreparedStatement statement, Participante participante, ArrayList<Confronto> fase) {
		int i = 1;
		try {
			for (Confronto conf : fase) {
				statement.setString(i, conf.getSelecao1());
				i++;
				statement.setString(i, conf.getSelecao2());
				i++;
			}
			for (Confronto conf : fase) {
				statement.setInt(i, conf.getPlacar1());
				i++;
				statement.setInt(i, conf.getPlacar2());
				i++;
			}
			statement.setString(i, participante.getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateQuartas(Participante participante) {
		String query = "update tab_bolao set QS1 =?,QS2=?,QS3=?,QS4=?,QS5=?,QS6=?,QS7=?,QS8=?,"
				+ "QP1=?,QP2=?,QP3=?,QP4=?,QP5=?,QP6=?,QP7=?,QP8=? where nome=?";
		update(participante, query, participante.getQuartas());
	}

	public void updateSemi(Participante participante) {
		String query = "update tab_bolao set SS1 =?,SS2=?,SS3=?,SS4=?," + "SP1=?,SP2=?,SP3=?,SP4=? where nome=?";
		update(participante, query, participante.getSemi());
	}

	public void updateFinal(Participante participante) {
		String query = "update tab_bolao set FS1 =?,FS2=?," + "FP1=?,FP2=? where nome=?";
		update(participante, query, participante.getFinale());
	}

	public void updateVencedor(Participante participante) {
		try (Connection conexao = new Conexao().getConexao()) {
			String query = "update tab_bolao set VENCEDOR =? where nome=?";
			PreparedStatement statement = conexao.prepareStatement(query);
			statement.setString(1, participante.getVencedor());
			statement.setString(2, participante.getNome());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Confronto> organizarFinal(ResultSet result) {
		ArrayList<Confronto> confrontos = new ArrayList<>();
		try {
			confrontos.add(new Confronto(result.getString("FS1"), result.getString("FS2"), result.getInt("FP1"),
					result.getInt("FP2")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return confrontos;
	}

	private ArrayList<Confronto> organizarSemi(ResultSet result) {
		ArrayList<Confronto> confrontos = new ArrayList<>();
		try {
			confrontos.add(new Confronto(result.getString("SS1"), result.getString("SS2"), result.getInt("SP1"),
					result.getInt("SP2")));
			confrontos.add(new Confronto(result.getString("SS3"), result.getString("SS4"), result.getInt("SP3"),
					result.getInt("SP4")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confrontos;
	}

	private ArrayList<Confronto> organizarQuartas(ResultSet result) {
		ArrayList<Confronto> confrontos = new ArrayList<>();
		try {
			confrontos.add(new Confronto(result.getString("QS1"), result.getString("QS2"), result.getInt("QP1"),
					result.getInt("QP2")));
			confrontos.add(new Confronto(result.getString("QS3"), result.getString("QS4"), result.getInt("QP3"),
					result.getInt("QP4")));
			confrontos.add(new Confronto(result.getString("QS5"), result.getString("QS6"), result.getInt("QP5"),
					result.getInt("QP6")));
			confrontos.add(new Confronto(result.getString("QS7"), result.getString("QS8"), result.getInt("QP7"),
					result.getInt("QP8")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confrontos;
	}
}
