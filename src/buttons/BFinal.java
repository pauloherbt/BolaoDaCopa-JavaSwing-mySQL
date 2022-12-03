package buttons;

import java.awt.event.ActionEvent;

import entities.CadastrarBolao;
import gui.JanelaFinal;

public class BFinal extends Botao {
	private static final long serialVersionUID = 1L;
	private CadastrarBolao cb;
	private JanelaFinal janela;
	public BFinal(JanelaFinal janela,CadastrarBolao cb) {
		setText("ENVIAR");
		addActionListener(this);
		this.janela=janela;
		this.cb=cb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		janela.setVisible(false);
		cb.janelaGanhador();
	}

}
