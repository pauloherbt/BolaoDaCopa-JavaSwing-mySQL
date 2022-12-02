package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.BSemifinal;
import entities.CadastrarBolao;

public class JanelaSemi extends JFrame {
	private static final long serialVersionUID = 1L;
	private CadastrarBolao cb;

	public JanelaSemi(CadastrarBolao cb) {
		setTitle("Semifinais");
		setLayout(new BorderLayout());
		setLocation(500, 100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		this.cb = cb;
		addPerifericos();
		addComponents();
	}

	private void addPerifericos() {
		JLabel label = new JLabel("Semifinais");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(BorderLayout.NORTH, label);
		BSemifinal botao = new BSemifinal(this, cb);
		add(BorderLayout.SOUTH, botao);
	}

	private void addComponents() {
		JPanel panel = new JPanel();
		for (PainelConfrontos confronto : cb.getSemi().getConfrontos()) {
			panel.add(confronto);
		}
		add(panel);
	}
}
