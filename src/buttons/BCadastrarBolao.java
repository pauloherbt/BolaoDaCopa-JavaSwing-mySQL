package buttons;

import java.awt.event.ActionEvent;

import entities.CadastrarBolao;
import gui.JanelaPrincipal;

public class BCadastrarBolao extends Botao{
	private static final long serialVersionUID = 1L;
	private JanelaPrincipal janela;
	public BCadastrarBolao(JanelaPrincipal janela) {
		setText("Cadastrar novo Bolao");
		addActionListener(this);
		this.janela=janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("cadastrar");
		janela.setVisible(false);
		CadastrarBolao cadastro = new CadastrarBolao();
	}

}
