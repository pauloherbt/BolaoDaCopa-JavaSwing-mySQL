package buttons;

import java.awt.event.ActionEvent;

import entities.CadastrarBolao;
import entities.ProcessarQuartas;
import gui.JanelaQuartas;
import gui.PainelConfrontos;

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
		// TODO Auto-generated method stub
		for (PainelConfrontos confronto : quartas.getConfrontos()) {
			String string = confronto.getS1().getText()+" "+confronto.getP1().getText()+" "+confronto.getS2().getText()+" "+confronto.getP2().getText();
			System.out.println(string);
		}
		for (String string : quartas.getVencedores()) {
			System.out.println(string);
		}
		janela.setVisible(false);
		cb.janelaSemi();
	}
	

}
