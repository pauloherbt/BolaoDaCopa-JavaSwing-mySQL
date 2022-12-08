package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import persistencia.ParticipanteDAO;

public class ImportarBolao {
	public ImportarBolao() {
		JFileChooser filech= new JFileChooser();
		filech.setFileSystemView(FileSystemView.getFileSystemView());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
		filech.setFileFilter(filter);
		filech.showOpenDialog(null);
		if(filech.getSelectedFile()!=null) {
			importarArquivo(filech.getSelectedFile());
		}
	}

	private void importarArquivo(File file) {
		ParticipanteDAO partDAO = new ParticipanteDAO();
		for (Participante part : lerArquivo(file)) {
			partDAO.inserirNome(part);
			partDAO.updateQuartas(part);
			partDAO.updateSemi(part);
			partDAO.updateFinal(part);
			partDAO.updateVencedor(part);
		}
	}
	private ArrayList<Participante> lerArquivo(File file){
		ArrayList<Participante> parts= new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (br.ready()) {
				String linha = br.readLine();
				parts.add(criarParticipante(linha));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parts;
	}
	private Participante criarParticipante(String linha) {
		String nomes[] = linha.split(";");
		Participante p = new Participante();
		p.setNome(nomes[0]);
		p.setQuartas(mapearQuartas(nomes));
		p.setSemi(mapearSemi(nomes));
		p.setFinale(mapearFinal(nomes));
		p.setVencedor(nomes[nomes.length-1]);
		return p;
	}
	private ArrayList<Confronto> mapearFinal(String[] nomes) {
		int startIndex=25;
		int qtdConfronto=1;
		return mapear(startIndex,qtdConfronto, nomes);
	}
	private ArrayList<Confronto> mapearSemi(String[] nomes) {
		int startIndex=17;
		int qtdConfronto=2;
		return mapear(startIndex,qtdConfronto, nomes);
	}

	private ArrayList<Confronto> mapearQuartas(String nomes[]) {
		int startIndex = 1;
		int qtdConfronto=4;
		return mapear(startIndex,qtdConfronto,nomes);
	}
	private ArrayList<Confronto> mapear(int j,int qtdConf,String nomes[]){
		ArrayList<Confronto> fase = new ArrayList<>();
		int count=j+2;
		for (int i = 0; i < qtdConf; i++) {
			Confronto conf = new Confronto();
			setInfo1(j, count, nomes, conf);
			j = count;
			count += 2;
			setInfo2(j, count, nomes, conf);
			j = count;
			count += 2;
			fase.add(conf);
		}
		return fase;
	}
	private void setInfo1(int j, int count, String[] nomes, Confronto conf) {
		for (; j < count; j++) {
			if (j % 2 == 0) {
				conf.setPlacar1(Integer.parseInt(nomes[j]));
			} else
				conf.setSelecao1(nomes[j]);
		}
	}

	private void setInfo2(int j, int count, String[] nomes, Confronto conf) {
		for (; j < count; j++) {
			if (j % 2 == 0) {
				conf.setPlacar2(Integer.parseInt(nomes[j]));
			} else
				conf.setSelecao2(nomes[j]);
		}
	}
}
