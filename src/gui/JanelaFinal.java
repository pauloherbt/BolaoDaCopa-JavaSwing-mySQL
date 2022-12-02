package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.BFinal;
import entities.CadastrarBolao;

public class JanelaFinal extends JFrame {
	private static final long serialVersionUID = 1L;
	private CadastrarBolao cb;

	public JanelaFinal(CadastrarBolao cb) {
		setTitle("Final");
		setLayout(new BorderLayout());
		setLocation(500, 100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		this.cb = cb;
		addPerifericos();
		addComponents();
	}

	private void addComponents() {
		JPanel panel = new JPanel();
		for (PainelConfrontos painel : cb.getFinale().getConfrontos()) {
			panel.add(painel);
		}
		add(BorderLayout.CENTER, panel);
	}

	private void addPerifericos() {
		JLabel label = new JLabel("FINAL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(BorderLayout.NORTH, label);
		BFinal botao = new BFinal(this, cb);
		add(BorderLayout.SOUTH, botao);
	}
}
