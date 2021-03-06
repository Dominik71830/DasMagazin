package pakiet;

import java.util.Date;

public class Log {
	private int id;
	private int produktId;
	private Date data_powstania;
	private String akcja;
	
	

	public Log(int produktId, Date datapowstania, String akcja) {
		super();
		this.produktId = produktId;
		this.data_powstania = datapowstania;
		this.akcja = akcja;
	}

	public Log(int id, int produktId, Date data_powstania, String akcja) {
		super();
		this.id = id;
		this.produktId = produktId;
		this.data_powstania = data_powstania;
		this.akcja = akcja;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", produktId=" + produktId + ", data_powstania=" + data_powstania + ", akcja=" + akcja
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_powstania() {
		return data_powstania;
	}

	public void setData_powstania(Date data_powstania) {
		this.data_powstania = data_powstania;
	}

	public String getAkcja() {
		return akcja;
	}

	public void setAkcja(String akcja) {
		this.akcja = akcja;
	}

	
	public int getProduktId() {
		return produktId;
	}

	public void setProduktId(int produktId) {
		this.produktId = produktId;
	}

	
}
