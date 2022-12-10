package buttons;

import java.awt.event.ActionEvent;

import view.JanelaGanhador;
import view.JanelaPrincipal;

public class BVoltar extends Botao {
	private JanelaPrincipal jprincipal;
	private JanelaGanhador jfinal;
	
	public BVoltar(JanelaPrincipal jprincipal, JanelaGanhador jfinal) {
		this.jprincipal = jprincipal;
		this.jfinal = jfinal;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jfinal.setVisible(false);
		jprincipal.setVisible(true);
	}

}
