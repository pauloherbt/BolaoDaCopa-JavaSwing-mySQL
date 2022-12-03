package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import entities.Participante;
import gui.PainelConfrontos;

public class ParticipanteDAO {

	public void inserir(Participante p) {
		try (Connection conexao = new Conexao().getConexao()) {
			PreparedStatement statement = conexao.prepareStatement("insert into tab_bolao (nome) values (?)");
			statement.setString(1, p.getNome());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(Participante participante, String query,ArrayList<PainelConfrontos> etapa) {
		try (Connection conexao = new Conexao().getConexao()) {
			PreparedStatement statement = conexao.prepareStatement(query);
			preencherStatement(statement, participante, etapa);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateQuartas(Participante participante) {
		String query = "update tab_bolao set QS1 =?,QS2=?,QS3=?,QS4=?,QS5=?,QS6=?,QS7=?,QS8=?,"
				+ "QP1=?,QP2=?,QP3=?,QP4=?,QP5=?,QP6=?,QP7=?,QP8=? where nome=?";
		update(participante, query,participante.getQuartas());
	}
	public void updateSemi(Participante participante) {
		String query = "update tab_bolao set SS1 =?,SS2=?,SS3=?,SS4=?,"
				+ "SP1=?,SP2=?,SP3=?,SP4=? where nome=?";
		update(participante,query,participante.getSemi());
	}
	public void updateFinal(Participante participante) {
		String query = "update tab_bolao set FS1 =?,FS2=?,"
				+ "FP1=?,FP2=? where nome=?";
		update(participante,query,participante.getFinale());
	}
	public void updateVencedor(Participante participante) {
		try (Connection conexao = new Conexao().getConexao()) {
			String query ="update tab_bolao set VENCEDOR =? where nome=?";
			PreparedStatement statement = conexao.prepareStatement(query);
			statement.setString(1, participante.getVencedor());
			statement.setString(2, participante.getNome());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void preencherStatement(PreparedStatement statement, Participante participante,
			ArrayList<PainelConfrontos> fase) {
		int i = 1;
		try {
			for (String selecao : participante.nomes(fase)) {
				statement.setString(i, selecao);
				i++;
			}
			for (Integer placar : participante.placar(fase)) {
				statement.setInt(i, placar);
				i++;
			}
			statement.setString(i, participante.getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
