package pakiet;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTablicyProduktow extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int NAZWA_COL  = 0;
	public static final  int ILOSC_COL  = 1;
	public static final  int VAT_COL   = 2;
	public static final  int CENA_COL   = 3;
	public static final  int KATEGORIA_COL   = 4;
	

	private String[] nazwykolumn = {"Nazwa", "Iloœæ",
	"Vat","Cena","Kategoria" };
	private List<Produkt> produkty;


	public ModelTablicyProduktow(List<Produkt> _produkty) {
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
		case VAT_COL:
			return tempprodukt.getVat();
		case CENA_COL:
			return tempprodukt.getCena();
		case KATEGORIA_COL:
			return tempprodukt.getKategoria();
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
