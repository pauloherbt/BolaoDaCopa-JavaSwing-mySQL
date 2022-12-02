package buttons;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.CadastrarBolao;
import entities.Participante;

public class BPegarNome extends Botao {
	private JTextField text;
	private Participante p;
	private JFrame janela;
	private CadastrarBolao cb;

	public BPegarNome(CadastrarBolao cb,JFrame janela, JTextField text) {
		setText("ENVIAR");
		addActionListener(this);
		this.janela = janela;
		this.text = text;
		this.cb=cb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = text.getText();
		cb.getParticipante().setNome(nome);
		System.out.println(cb.getParticipante().getNome());
		janela.setVisible(false);
		cb.janelaQuartas();
		
	}
}
