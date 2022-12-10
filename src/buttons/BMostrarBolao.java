package buttons;

import java.awt.event.ActionEvent;

import view.Tabela;

public class BMostrarBolao extends Botao {
	private static final long serialVersionUID = 1L;
	public BMostrarBolao() {
		setText("Mostrar Boloes Cadastrados");
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Tabela tab= new Tabela();
	}
	
}
