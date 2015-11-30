package pakiet;

public class Produkt {
	private int id;
	private String nazwa;
	private Double cena;
	private int ilosc;
	private String kategoria;
	private Double vat;
	private Double objetosc;
	
	public Produkt(String _nazwa,int _ilosc, Double _vat,Double _cena,  String _kategoria, Double _objetosc){//konstruktor
		nazwa=_nazwa;
		cena=_cena;
		ilosc=_ilosc;
		kategoria=_kategoria;
		vat = _vat;
		objetosc = _objetosc;
	}
	
	public Produkt(String _nazwa,int _ilosc,Double _cena ){//konstruktor dla kupionego
		nazwa=_nazwa;
		cena=_cena;
		ilosc=_ilosc;
	}
	
	public Produkt(int _id,String _nazwa, int _ilosc, Double _vat,Double _cena, String _kategoria, Double _objetosc){//konstruktor pelny
		id=_id;
		nazwa=_nazwa;
		cena=_cena;
		ilosc=_ilosc;
		kategoria=_kategoria;
		vat = _vat;
		objetosc = _objetosc;
	}

	public Double getObjetosc() {
		return objetosc;
	}

	public void setObjetosc(Double objetosc) {
		this.objetosc = objetosc;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	@Override
	public String toString() {
		return "Produkt [id=" + id + ", nazwa=" + nazwa + ", cena=" + cena + ", ilosc=" + ilosc + ", kategoria="
				+ kategoria + ", vat=" + vat + "]";
	}


	

}
