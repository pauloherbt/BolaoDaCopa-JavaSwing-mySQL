package entities;

public class Confronto {
	private String selecao1;
	private String selecao2;
	private int placar1;
	private int placar2;
	
	public Confronto(String selecao1, String selecao2, int placar1, int placar2) {
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.placar1 = placar1;
		this.placar2 = placar2;
	}

	public Confronto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSelecao1() {
		return selecao1;
	}

	public String getSelecao2() {
		return selecao2;
	}

	public int getPlacar1() {
		return placar1;
	}

	public int getPlacar2() {
		return placar2;
	}

	public void setSelecao1(String selecao1) {
		this.selecao1 = selecao1;
	}

	public void setSelecao2(String selecao2) {
		this.selecao2 = selecao2;
	}

	public void setPlacar1(int placar1) {
		this.placar1 = placar1;
	}

	public void setPlacar2(int placar2) {
		this.placar2 = placar2;
	}
	
}
