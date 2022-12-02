package entities;

import java.util.ArrayList;

import gui.PainelConfrontos;

public class ProcessarQuartas {
	private ArrayList<PainelConfrontos> confrontos;
	public ProcessarQuartas() {
		this.confrontos= new ArrayList<>();
		addPaineis();
	}
	
	public void addPaineis() {
		PainelConfrontos painel;
		for(int i=0;i<4;i++) {
			painel = new PainelConfrontos();
			this.confrontos.add(painel);
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
