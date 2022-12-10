package buttons;

import java.awt.event.ActionEvent;

import entities.CadastrarBolao;
import entities.ProcessarQuartas;
import view.JanelaQuartas;
import view.PainelConfrontos;

public class BQuartasFinal extends Botao {
	private ProcessarQuartas quartas;
	private CadastrarBolao cb;
	private JanelaQuartas janela;
	public BQuartasFinal(JanelaQuartas janela,CadastrarBolao cb) {
		setText("ENVIAR");
		addActionListener(this);
		this.cb = cb;
		this.quartas=cb.getQuartas();
		this.janela=janela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		janela.setVisible(false);
		cb.janelaSemi();
	}
	

}
