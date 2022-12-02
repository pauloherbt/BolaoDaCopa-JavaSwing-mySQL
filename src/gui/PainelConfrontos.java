package gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelConfrontos extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField s1;
	private JTextField s2;
	private JTextField p1;
	private JTextField p2;

	public PainelConfrontos() {
		setLayout(new FlowLayout());
		adicionarComponentes();
	}

	private void adicionarComponentes() {
		JLabel label = new JLabel("Selecao:");
		add(label);
		s1 = new JTextField(4);
		add(s1);
		label = new JLabel("Placar:");
		add(label);
		p1 = new JTextField(4);
		add(p1);
		label = new JLabel("   X   ");
		add(label);
		label = new JLabel("Selecao:");
		add(label);
		s2 = new JTextField(4);
		add(s2);
		label = new JLabel("Placar:");
		add(label);
		p2 = new JTextField(4);
		add(p2);
	}

	public JTextField getS1() {
		return s1;
	}

	public JTextField getS2() {
		return s2;
	}

	public JTextField getP1() {
		return p1;
	}

	public JTextField getP2() {
		return p2;
	}

}
