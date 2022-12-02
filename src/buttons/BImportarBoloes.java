package buttons;

import java.awt.event.ActionEvent;

public class BImportarBoloes extends Botao {
	private static final long serialVersionUID = 1L;
	
	public BImportarBoloes() {
		setText("Importar Boloes");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Importar Boloes");
	}

}
