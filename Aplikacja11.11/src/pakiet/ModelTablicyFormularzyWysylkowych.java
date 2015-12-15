package pakiet;

import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.table.AbstractTableModel;

public class ModelTablicyFormularzyWysylkowych extends AbstractTableModel{
	
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int MIEJSCE_DOCELOWE_COL  = 0;
	public static final  int SAMOCHOD_COL   = 1;
	//public static final  int PRODUKTY_COL   = 2;
	public static final  int CENA_COL   = 2;
	public static final  int DATA_DODANIA_COL = 3;
	
	private String[] nazwykolumn = {"Miejsce docelowe",
			"Model samochodu","Cena","Data dodania"};
	
	private List<FormularzWysylka> formularze;
	
	
	public ModelTablicyFormularzyWysylkowych(List<FormularzWysylka> formularze) {
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
		
		FormularzWysylka tempformularz = formularze.get(row);
		
		switch (col) {
		case MIEJSCE_DOCELOWE_COL:
			return tempformularz.getMiejsce_docelowe();
		case SAMOCHOD_COL:
			return tempformularz.getSamochod();
		case CENA_COL:
			return tempformularz.getCena();
		case DATA_DODANIA_COL:
			return tempformularz.getData_dodania();
		case OBJECT_COL:
			return tempformularz;
		default:
			return tempformularz.getMiejsce_docelowe();
		}
	}
	
	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
