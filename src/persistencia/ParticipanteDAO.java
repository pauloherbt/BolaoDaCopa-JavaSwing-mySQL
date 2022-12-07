package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Participante;
import entities.ParticipanteDados;
import gui.PainelConfrontos;

public class ParticipanteDAO {

	
	public ArrayList<Participante> listarTudo() {
		ArrayList<Participante> parts= new ArrayList<>();
		try(Connection conexao = new Conexao().getConexao()){
			ResultSet res= conexao.prepareStatement("select * from tab_bolao").executeQuery();
			while(res.next()) {
				Participante part= new Participante();
				part.setNome(res.getString(2));
				int i=3;
				while(i<=30) {
					part.addSelecoes(res.getString(i));
					i++;
					part.addPlacares(res.getInt(i));
					i++;
				}
				part.setVencedor(res.getString(31));
				parts.add(part);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return parts;
	}
	
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
	public ArrayList<ParticipanteDados> listar() {
		ArrayList<ParticipanteDados> part = new ArrayList<>();
		try (Connection conexao = new Conexao().getConexao()) {
			ResultSet result = conexao.prepareStatement("select * from tab_bolao").executeQuery();
			ParticipanteDados parti;
			while (result.next()) {
				parti = new ParticipanteDados();
				String quartas = organizarQuartas(result);
				String semi = organizarSemi(result);
				String finale = organizarFinal(result);
				parti.setNome(result.getString("nome"));
				parti.setQuartas(quartas);
				parti.setSemi(semi);
				parti.setFinale(finale);
				parti.setWinner(result.getString("VENCEDOR"));
				part.add(parti);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return part;
	}

	private String organizarFinal(ResultSet result) {
		String confronto = "%s %d X %s %d\n";
		try {
			return String.format(confronto, result.getString("FS1"), result.getInt("FP1"), result.getString("FS2"),
					result.getInt("FP2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String organizarSemi(ResultSet result) {
		String confronto = "%s %d X %s %d\n";
		String semi = null;
		try {
			semi = String.format(confronto, result.getString("SS1"), result.getInt("SP1"), result.getString("SS2"),
					result.getInt("SP2"));
			semi += String.format(confronto, result.getString("SS3"), result.getInt("SP3"), result.getString("SS4"),
					result.getInt("SP4"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return semi;
	}

	private String organizarQuartas(ResultSet result) {
		String confronto = " %s %d X %s %d\n";
		String quartas = null;
		try {
			quartas = String.format(confronto, result.getString("QS1"), result.getInt("QP1"), result.getString("QS2"),
					result.getInt("QP2"));
			quartas += String.format(confronto, result.getString("QS3"), result.getInt("QP3"), result.getString("QS4"),
					result.getInt("QP4"));
			quartas += String.format(confronto, result.getString("QS5"), result.getInt("QP5"), result.getString("QS6"),
					result.getInt("QP6"));
			quartas += String.format(confronto, result.getString("QS7"), result.getInt("QP7"), result.getString("QS8"),
					result.getInt("QP8"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quartas;
	}
}
