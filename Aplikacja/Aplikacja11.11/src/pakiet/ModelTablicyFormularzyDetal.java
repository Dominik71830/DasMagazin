package pakiet;

import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.table.AbstractTableModel;

public class ModelTablicyFormularzyDetal extends AbstractTableModel{
	
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int IMIE_COL  = 0;
	public static final  int NAZWISKO_COL   = 1;
	//public static final  int PRODUKTY_COL   = 2;
	public static final  int CENA_COL   = 2;
	public static final  int DATA_DODANIA_COL = 3;
	
	private String[] nazwykolumn = {"Imie",
			"Nazwisko","Cena","Data dodania"};
	
	private List<FormularzDetal> formularze;
	
	
	public ModelTablicyFormularzyDetal(List<FormularzDetal> formularze) {
		super();
		this.formularze = formularze;
	}

	@Override
	public int getColumnCount() {
		return nazwykolumn.length;
	}

	@Override
	public int getRowCount() {
		return formularze.size();
	}

	public String getColumnName(int _nr) {
		return nazwykolumn[_nr];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		
		FormularzDetal tempformularz = formularze.get(row);
		
		switch (col) {
		case IMIE_COL:
			return tempformularz.getImie();
		case NAZWISKO_COL:
			return tempformularz.getNazwisko();
		case CENA_COL:
			return tempformularz.getCena();
		case DATA_DODANIA_COL:
			return tempformularz.getData_dodania();
		case OBJECT_COL:
			return tempformularz;
		default:
			return tempformularz.getNazwisko();
		}
	}
	
	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
