package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.BCadastrarBolao;
import buttons.BExportarBoloes;
import buttons.BImportarBoloes;
import buttons.BMostrarBolao;

public class PainelPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;
	private JanelaPrincipal janela;

	public PainelPrincipal(JanelaPrincipal janela) {
		setLayout(new BorderLayout());
		setVisible(true);
		this.janela = janela;
		addSuperior();
		addBotoes();

	}

	private void addSuperior() {
		JLabel label = new JLabel("Funcionalidades do Bolao");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		add(BorderLayout.NORTH, label);
	}

	private void addBotoes() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 10));
		panel.add(new BCadastrarBolao(janela));
		panel.add(new BMostrarBolao());
		panel.add(new BImportarBoloes());
		panel.add(new BExportarBoloes());
		add(BorderLayout.CENTER, panel);
	}

}
