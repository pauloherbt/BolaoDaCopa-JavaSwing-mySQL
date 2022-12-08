package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import persistencia.ParticipanteDAO;

public class ExportarBolao {
	ParticipanteDAO partDAO;
	public ExportarBolao() {
		this.partDAO= new ParticipanteDAO();
		exportarArquivo();
	}

	private void exportarArquivo() {
		File path = new File("C:\\Users\\paulo\\eclipse-workspace\\Bolao");
		File arq= new File(path,".txt");
		try {
			escreverArquivo(arq);
			arq.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void escreverArquivo(File arq) {
		ArrayList<Participante> part = partDAO.listar();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(arq));
			for (Participante parti : part) {
				bw.write(parti.getNome()+";");
				for (Confronto conf : parti.totalConfrontos()) {
					bw.write(conf.getSelecao1()+";");
					bw.write(conf.getPlacar1()+";");
					bw.write(conf.getSelecao2()+";");
					bw.write(conf.getPlacar2()+";");
				}
				bw.write(parti.getVencedor());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
