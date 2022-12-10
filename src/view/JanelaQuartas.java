package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.BQuartasFinal;
import entities.CadastrarBolao;


public class JanelaQuartas extends JFrame {
	private static final long serialVersionUID = 1L;
	private CadastrarBolao cb;
	public JanelaQuartas(CadastrarBolao cb) {
		setTitle("Quartas de Final");
		setLayout(new BorderLayout());
		setLocation(500, 100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		this.cb= cb;
		addLabels();
		addConfrontos();
	}

	private void addLabels() {
		JLabel label = new JLabel("Quartas de Final");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(BorderLayout.NORTH,label);
		BQuartasFinal botao = new BQuartasFinal(this,cb);
		add(BorderLayout.SOUTH,botao);
	}
	private void addConfrontos(){
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(4,1));
		
		for (PainelConfrontos painel : cb.getQuartas().getConfrontos()) {
			panel.add(painel);
		}
		add(BorderLayout.CENTER,panel);
	}
}
