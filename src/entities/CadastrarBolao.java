package entities;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttons.BPegarNome;
import gui.JanelaFinal;
import gui.JanelaGanhador;
import gui.JanelaQuartas;
import gui.JanelaSemi;
import persistencia.ParticipanteDAO;

public class CadastrarBolao {
	private Participante participante;
	private ParticipanteDAO partDAO;
	private ProcessarQuartas quartas;
	private ProcessarSemi semi;
	private ProcessarFinal finale;
	public CadastrarBolao() {
		participante = new Participante();
		quartas=new ProcessarQuartas();
		partDAO = new ParticipanteDAO();
		run();
	}
	
	private void run() {
		janelaNome();
	}
	private void janelaNome() {
		JFrame janelinha= new JFrame("Informacao do Participante");
		janelinha.setSize(new Dimension(300,100));
		janelinha.setLocation(600, 300);
		janelinha.setVisible(true);
		JPanel painel= new JPanel();
		painel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel nome= new JLabel("Nome:");
		painel.add(nome);
		JTextField texto = new JTextField(10);
		painel.add(texto);
		BPegarNome botao = new BPegarNome(this,janelinha,texto);
		painel.add(botao);
		janelinha.add(painel);
	}
	public void janelaQuartas() {
		partDAO.inserirNome(participante);
		JanelaQuartas jn=new JanelaQuartas(this);
	}
	public void janelaSemi() {
		participante.confrontosQuartas(quartas.getConfrontos());
		partDAO.updateQuartas(participante);
		semi =new ProcessarSemi(quartas);
		JanelaSemi js= new JanelaSemi(this);
	}
	public void janelaFinal() {
		participante.confrontosSemi(semi.getConfrontos());
		partDAO.updateSemi(participante);
		finale= new ProcessarFinal(semi);
		JanelaFinal jf = new JanelaFinal(this);
	}
	public void janelaGanhador() {
		participante.confrontosFinal(finale.getConfrontos());
		partDAO.updateFinal(participante);
		participante.setVencedor(finale.getVencedores().get(0));
		partDAO.updateVencedor(participante);
		JanelaGanhador jg= new JanelaGanhador(this);
	}
	public Participante getParticipante() {
		return participante;
	}

	public ProcessarQuartas getQuartas() {
		return quartas;
	}

	public ProcessarSemi getSemi() {
		return semi;
	}

	public ProcessarFinal getFinale() {
		return finale;
	}
	
}
