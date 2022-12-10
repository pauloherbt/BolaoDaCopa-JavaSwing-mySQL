package entities;

import java.util.ArrayList;

import view.PainelConfrontos;

public class ProcessarSemi{
	private ArrayList<PainelConfrontos> confrontos;
	private ProcessarQuartas quartas;
	
	public ProcessarSemi(ProcessarQuartas quartas) {
		this.confrontos= new ArrayList<>();
		this.quartas=quartas;
		addPaineis();
	}
	
	public void addPaineis() {
		PainelConfrontos painel;
		int j=0;
		for(int i=0;i<2;i++) {
			painel=new PainelConfrontos();
			painel.getS1().setText(quartas.getVencedores().get(j));
			painel.getS1().setEditable(false);
			j++;
			painel.getS2().setText(quartas.getVencedores().get(j));
			painel.getS2().setEditable(false);
			j++;
			confrontos.add(painel);
		}
	}
	public ArrayList<String> getVencedores() {
		ArrayList<String> vencedores=new ArrayList<>();
		for (PainelConfrontos painel : confrontos) {
			int placar1=Integer.parseInt(painel.getP1().getText());
			int placar2=Integer.parseInt(painel.getP2().getText());
			if(placar1>placar2) {
				vencedores.add(painel.getS1().getText());
			}
			else
				vencedores.add(painel.getS2().getText());
		}
		return vencedores;
	}
	
	public ArrayList<PainelConfrontos> getConfrontos() {
		return confrontos;
	}	
	
	
}
