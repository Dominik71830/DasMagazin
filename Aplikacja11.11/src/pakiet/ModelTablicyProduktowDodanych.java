package pakiet;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTablicyProduktowDodanych extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int NAZWA_COL  = 0;
	public static final  int ILOSC_COL  = 1;
	public static final  int CENA_COL   = 2;
	
	private String[] nazwykolumn = {"Nazwa", "Ilo��","Cena"};
	
	private List<Produkt> produkty;
	
	public ModelTablicyProduktowDodanych(List<Produkt> _produkty) {
		produkty = _produkty;
	}

	@Override
	public int getColumnCount() {
		return nazwykolumn.length;
	}

	@Override
	public int getRowCount() {
		return produkty.size();
	}
	
	public String getColumnName(int _nr) {
		return nazwykolumn[_nr];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Produkt tempprodukt = produkty.get(row);

		switch (col) {
		case NAZWA_COL:
			return tempprodukt.getNazwa();
		case ILOSC_COL:
			return tempprodukt.getIlosc();
		case CENA_COL:
			return tempprodukt.getCena();
		case OBJECT_COL:
			return tempprodukt;
		default:
			return tempprodukt.getNazwa();
		}
	}
	
	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
