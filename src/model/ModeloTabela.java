package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	private ArrayList linhas;
	private String[] colunas;

	public ModeloTabela(ArrayList linhas, String[] colunas) {
		setLinhas(linhas);
		setColunas(colunas);
	}

	public void setLinhas(ArrayList dados) {
		linhas = dados;
	}

	public ArrayList getLinhas() {
		return linhas;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] nomes) {
		colunas = nomes;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return linhas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	public String getColumnName(int num) {
		return colunas[num];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object[] objeto = (Object[]) getLinhas().get(rowIndex);
		return objeto[columnIndex];
	}

}
