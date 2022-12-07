package entities;

import java.util.ArrayList;

import gui.PainelConfrontos;

public class Participante {
	private String nome;
	private ArrayList<PainelConfrontos> quartas;
	private ArrayList<PainelConfrontos> semi;
	private ArrayList<PainelConfrontos> finale;
	private ArrayList<String> selecoes;
	private ArrayList<Integer> placares;
	private String vencedor;
	public Participante() {
		selecoes= new ArrayList<>();
		placares= new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<PainelConfrontos> getQuartas() {
		return quartas;
	}
	
	public ArrayList<String> nomes(ArrayList<PainelConfrontos> confrontos){
		ArrayList<String> nomes = new ArrayList<>();
		for (PainelConfrontos painelConfrontos : confrontos) {
			nomes.add(painelConfrontos.getS1().getText());
			nomes.add(painelConfrontos.getS2().getText());
		}
		return nomes;
	}
	public ArrayList<Integer> placar(ArrayList<PainelConfrontos> confrontos){
		ArrayList<Integer> placar = new ArrayList<>();
		for (PainelConfrontos painelConfrontos : confrontos) {
			placar.add(Integer.parseInt(painelConfrontos.getP1().getText()));
			placar.add(Integer.parseInt(painelConfrontos.getP2().getText()));
		}
		return placar;
	}
	public ArrayList<PainelConfrontos> getSemi() {
		return semi;
	}

	public void setSemi(ArrayList<PainelConfrontos> semi) {
		this.semi = semi;
	}

	public ArrayList<PainelConfrontos> getFinale() {
		return finale;
	}

	public void setFinale(ArrayList<PainelConfrontos> finale) {
		this.finale = finale;
	}

	public void setQuartas(ArrayList<PainelConfrontos> quartas) {
		this.quartas = quartas;
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

}
