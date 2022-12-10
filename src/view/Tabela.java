package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entities.Confronto;
import entities.Participante;
import persistencia.ParticipanteDAO;

public class Tabela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Tabela() {
		setTitle("RESULTADOS");
		setSize(new Dimension(700, 500));
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addTabela();
	}

	private void addTabela() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		criarTabela(panel);
		add(panel);
	}

	private void criarTabela(JPanel panel) {
		ArrayList<Object[]> dados = listarDados();
		String[] colunas = { "NOME", "QUARTAS DE FINAL", "SEMIFINAIS", "FINAL", "GANHADOR" };
		JTable tabela = new JTable(new ModeloTabela(dados, colunas));
		tabela.setRowHeight(80);
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabela.setFillsViewportHeight(true);
		JScrollPane scroll= new JScrollPane(tabela);
		scroll.setViewportView(tabela);
		panel.add(scroll);
	}
	
	private ArrayList<Object[]> listarDados() {
		ArrayList<Object[]> dados = new ArrayList<>();
		ParticipanteDAO part = new ParticipanteDAO();
		for (Participante parti : part.listar()) {
			dados.add(new Object[] { parti.getNome(), transformarString(parti.getQuartas()),
					transformarString(parti.getSemi()),transformarString(parti.getFinale()),parti.getVencedor()});
		}
		return dados;
	}
	private String transformarString(ArrayList<Confronto> confronto) {
		String pattern = " %s %d X %s %d<br>";
		String result="<html>";
		for (Confronto conf : confronto) {
			result+=String.format(pattern, conf.getSelecao1(),conf.getPlacar1(),conf.getSelecao2(),conf.getPlacar2());
		}
		return result+"</html>";	
	}
}
