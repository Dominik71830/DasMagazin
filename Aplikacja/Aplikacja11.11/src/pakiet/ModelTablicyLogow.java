package pakiet;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTablicyLogow extends AbstractTableModel{
	public static final  int OBJECT_COL =-1;
	public static final  int ID_COL     = -2;
	public static final  int DATA_POWSTANIA_COL  = 0;
	public static final  int AKCJA_COL   = 1;
	
	private String[] nazwykolumn = {"Data powstania", "Akcja"};
	
	private List<Log> logi;

	public ModelTablicyLogow(List<Log> logi) {
		super();
		this.logi = logi;
	}

	@Override
	public int getColumnCount() {
		return nazwykolumn.length;
	}

	@Override
	public int getRowCount() {
		return logi.size();
	}
	
	public String getColumnName(int _nr) {
		return nazwykolumn[_nr];
	}
	

	@Override
	public Object getValueAt(int row, int col) {
		Log	 templog = logi.get(row);
		
		switch (col) {
		case DATA_POWSTANIA_COL:
			return templog.getData_powstania();
		case AKCJA_COL:
			return templog.getAkcja();
		case OBJECT_COL:
			return templog;
		default:
			return templog.getData_powstania();
		}
	}
	
	
}
