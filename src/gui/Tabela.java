package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entities.ParticipanteDados;
import model.ModeloTabela;
import persistencia.ParticipanteDAO;

public class Tabela extends JFrame {

	public Tabela() {
		setTitle("RESULTADOS");
		setSize(new Dimension(700, 500));
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		String[] colunas = { "NOME", "QUARTAS", "SEMI", "FINAL", "GANHADOR" };
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
		for (ParticipanteDados parti : part.listar()) {
			dados.add(new Object[] { parti.getNome(), formatarStrings(parti.getQuartas()),
					formatarStrings(parti.getSemi()), formatarStrings(parti.getFinale()), parti.getWinner() });
		}
		return dados;
	}

	private String formatarStrings(String etapa) {
		String[] confrontos = etapa.split("\n", 0);
		StringBuilder str = new StringBuilder();
		str.append("<html>");
		for (String string : confrontos) {
			str.append(string);
			str.append("<br>");
		}
		str.append("</html>");
		return str.toString();
	}
}
