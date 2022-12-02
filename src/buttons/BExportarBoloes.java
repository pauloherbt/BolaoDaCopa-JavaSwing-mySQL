package buttons;

import java.awt.event.ActionEvent;

public class BExportarBoloes extends Botao {
	private static final long serialVersionUID = 1L;

	public BExportarBoloes() {
		setText("Exportar Boloes");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Exportar Boloes");
	}

}
