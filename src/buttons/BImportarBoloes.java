package buttons;

import java.awt.event.ActionEvent;

import entities.ImportarBolao;

public class BImportarBoloes extends Botao {
	private static final long serialVersionUID = 1L;
	
	public BImportarBoloes() {
		setText("Importar Boloes");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImportarBolao importar= new ImportarBolao();
	}

}
