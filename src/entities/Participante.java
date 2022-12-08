package entities;

import java.util.ArrayList;

import gui.PainelConfrontos;

public class Participante {
	private String nome;
	private ArrayList<Confronto> quartas;
	private ArrayList<Confronto> semi;
	private ArrayList<Confronto> finale;
	private ArrayList<String> selecoes;
	private ArrayList<Integer> placares;
	private String vencedor;

	public Participante() {
		selecoes = new ArrayList<>();
		placares = new ArrayList<>();
		quartas = new ArrayList<>();
		semi = new ArrayList<>();
		finale = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Confronto> getQuartas() {
		return quartas;
	}

	public void confrontosQuartas(ArrayList<PainelConfrontos> confrontos) {
		confrontos(quartas, confrontos);
	}

	public void confrontosSemi(ArrayList<PainelConfrontos> confrontos) {
		confrontos(semi, confrontos);
	}

	public void confrontosFinal(ArrayList<PainelConfrontos> confrontos) {
		confrontos(finale, confrontos);
	}

	private void confrontos(ArrayList<Confronto> fase, ArrayList<PainelConfrontos> confrontos) {
		for (PainelConfrontos painelConfrontos : confrontos) {
			fase.add(new Confronto(painelConfrontos.getS1().getText(), painelConfrontos.getS2().getText(),
					Integer.parseInt(painelConfrontos.getP1().getText()),
					Integer.parseInt(painelConfrontos.getP2().getText())));
		}
	}

	public ArrayList<Confronto> totalConfrontos() {
		ArrayList<Confronto> times = new ArrayList<>(quartas);
		times.addAll(semi);
		times.addAll(finale);
		return times;

	}

	public ArrayList<Confronto> getSemi() {
		return semi;
	}

	public ArrayList<Confronto> getFinale() {
		return finale;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public ArrayList<String> getSelecoes() {
		return selecoes;
	}

	public void addSelecoes(String selecoes) {
		this.selecoes.add(selecoes);
	}

	public ArrayList<Integer> getPlacares() {
		return placares;
	}

	public void addPlacares(int i) {
		placares.add(i);
	}

	public void setQuartas(ArrayList<Confronto> quartas) {
		this.quartas = quartas;
	}

	public void addQuartas(Confronto conf) {
		this.quartas.add(conf);
	}

	public void setSemi(ArrayList<Confronto> semi) {
		this.semi = semi;
	}

	public void setFinale(ArrayList<Confronto> finale) {
		this.finale = finale;
	}

}
