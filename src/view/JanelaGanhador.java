package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import buttons.BVoltar;
import entities.CadastrarBolao;

public class JanelaGanhador extends JFrame {
	private static final long serialVersionUID = 1L;
	private CadastrarBolao cb;
	private JanelaPrincipal jprincipal;

	public JanelaGanhador(JanelaPrincipal jprincipal,CadastrarBolao cb) {
		setTitle("Ganhador");
		setLayout(new BorderLayout());
		setLocation(500, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		this.cb = cb;
		this.jprincipal=jprincipal;
		labelSuperior();
		labelCentral();
		addBotao();
	}

	private void labelSuperior() {
		JLabel label = new JLabel("Ganhador do Bolao segundo o usuario");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(BorderLayout.NORTH, label);
	}

	private void labelCentral() {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img =verificarGanhador();
		if(img!=null)
		img.setImage(img.getImage().getScaledInstance(250, 150, 100));
		label.setIcon(img);
		add(BorderLayout.CENTER,label);
	}
	private void addBotao() {
		BVoltar botao = new BVoltar(jprincipal, this);
		botao.setText("VOLTAR");
		add(BorderLayout.SOUTH,botao);
	}
	private ImageIcon verificarGanhador() {
		String winner = cb.getParticipante().getVencedor();
		
		if (winner.equals("BRA"))
			return new ImageIcon("src/selecoes/brasil.png");
		if (winner.equals("ALE"))
			return new ImageIcon("src/selecoes/alemanha.png");
		if (winner.equals("ARG"))
			return new ImageIcon("src/selecoes/argentina.png");
		if (winner.equals("BEL"))
			return new ImageIcon("src/selecoes/belgica.png");
		if (winner.equals("CAM"))
			return new ImageIcon("src/selecoes/camaroes.png");
		if (winner.equals("ESP"))
			return new ImageIcon("src/selecoes/espanha.png");
		if (winner.equals("FRA"))
			return new ImageIcon("src/selecoes/franca.png");
		if (winner.equals("CRO"))
			return new ImageIcon("src/selecoes/croacia.png");
		return null;
	}
}
