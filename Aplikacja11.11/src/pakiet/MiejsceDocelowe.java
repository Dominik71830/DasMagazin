package pakiet;

public class MiejsceDocelowe {
	private int id;
	private String adres;
	private int odleglosc;
	
	public MiejsceDocelowe(int id, String adres, int odleglosc) {
		super();
		this.id = id;
		this.adres = adres;
		this.odleglosc = odleglosc;
	}

	public MiejsceDocelowe(String adres, int odleglosc) {
		super();
		this.adres = adres;
		this.odleglosc = odleglosc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getOdleglosc() {
		return odleglosc;
	}

	public void setOdleglosc(int odleglosc) {
		this.odleglosc = odleglosc;
	}

	@Override
	public String toString() {
		return adres + " - " + odleglosc + "km";
	}

	
}
