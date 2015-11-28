package pakiet;

public class FormularzDetal {
	private int id;
	private String imie;
	private String nazwisko;
	private String produkty;
	private Double cena;
	private String data_dodania;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


	public String getProdukty() {
		return produkty;
	}


	public void setProdukty(String produkty) {
		this.produkty = produkty;
	}


	public Double getCena() {
		return cena;
	}


	public void setCena(Double cena) {
		this.cena = cena;
	}


	public String getData_dodania() {
		return data_dodania;
	}


	public void setData_dodania(String data_dodania) {
		this.data_dodania = data_dodania;
	}
	
	
	public FormularzDetal(int id, String imie, String nazwisko, String produkty, Double cena, String data_dodania) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.produkty = produkty;
		this.cena = cena;
		this.data_dodania = data_dodania;
	}


	public FormularzDetal(String imie, String nazwisko, String produkty, Double cena, String data_dodania) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.produkty = produkty;
		this.cena = cena;
		this.data_dodania = data_dodania;
	}


	@Override
	public String toString() {
		return "FormularzDetal [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", produkty=" + produkty
				+ ", cena=" + cena + ", data_dodania=" + data_dodania + "]";
	}
	
	

}
