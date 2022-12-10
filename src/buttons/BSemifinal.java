package buttons;

import java.awt.event.ActionEvent;

import entities.CadastrarBolao;
import view.JanelaSemi;

public class BSemifinal extends Botao {
	private CadastrarBolao cb;
	private JanelaSemi janela;
	public BSemifinal(JanelaSemi janela,CadastrarBolao cb) {
		setText("ENVIAR");
		addActionListener(this);
		this.cb=cb;
		this.janela=janela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		janela.setVisible(false);
		cb.janelaFinal();
	}

}
