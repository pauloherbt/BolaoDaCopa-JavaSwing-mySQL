package view;
import java.awt.Dimension;

import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	public JanelaPrincipal() {
		setTitle("Inicio");
		setSize(new Dimension(500, 350));
		setLocation(500, 100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(new PainelPrincipal(this));
		setVisible(true);

	}
}
