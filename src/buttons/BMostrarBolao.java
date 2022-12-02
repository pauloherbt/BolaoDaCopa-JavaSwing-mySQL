package buttons;

import java.awt.event.ActionEvent;

public class BMostrarBolao extends Botao {
	private static final long serialVersionUID = 1L;
	public BMostrarBolao() {
		setText("Mostrar Boloes Cadastrados");
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mostrando");
	}
	
}
