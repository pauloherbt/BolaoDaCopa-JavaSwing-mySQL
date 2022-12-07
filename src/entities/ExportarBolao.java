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
			arq.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		ArrayList<Participante> part = partDAO.listarTudo();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(arq));
			for (Participante parti : part) {
				bw.write(parti.getNome()+";");
				for(int i=0;i<14;i++) {
					bw.write(parti.getSelecoes().get(i)+";");
					bw.write(parti.getPlacares().get(i)+";");
				}
				bw.write(parti.getVencedor());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
