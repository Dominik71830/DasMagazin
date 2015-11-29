package pakiet;

import java.io.FileInputStream;
import java.sql.*;
import java.sql.Date;
import java.text.Normalizer.Form;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.omg.CORBA.DATA_CONVERSION;




public class Funkcje {

	private Connection myConn;
	
	public Funkcje()throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("dane.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("Po��czono z " + dburl + "\n" + "U�ytkownik: " + user);
	}
	
	public void updateProdukt(Produkt _produkt) throws SQLException{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("update produkty"
					+ " set nazwa=?, ilosc=?, vat=?, cena=?, kategoria=?, objetosc=?"
					+ " where id=?");
			
			myStmt.setString(1, _produkt.getNazwa());
			myStmt.setInt(2, _produkt.getIlosc());
			myStmt.setDouble(3, _produkt.getVat());
			myStmt.setDouble(4, _produkt.getCena());
			myStmt.setString(5, _produkt.getKategoria());
			myStmt.setDouble(6, _produkt.getObjetosc());
			myStmt.setInt(7, _produkt.getId());
			
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	
	}

	public void addProdukt(Produkt _produkt) throws Exception {
		PreparedStatement myStmt = null;
		
		try{
		myStmt = myConn.prepareStatement("insert into produkty"
				+ " (nazwa,ilosc,vat,cena,kategoria,objetosc)"
				+ " values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);//, Statement.RETURN_GENERATED_KEYS);
		
		myStmt.setString(1, _produkt.getNazwa());
		myStmt.setInt(2, _produkt.getIlosc());
		myStmt.setDouble(3, _produkt.getVat());
		myStmt.setDouble(4, _produkt.getCena());
		myStmt.setString(5, _produkt.getKategoria());
		myStmt.setDouble(6, _produkt.getObjetosc());
		
		myStmt.executeUpdate();
		
		ResultSet kluczeId = myStmt.getGeneratedKeys();
		if (kluczeId.next()) {
			_produkt.setId(kluczeId.getInt(1));
		} else {
			throw new SQLException("B��d przy generowaniu klucza Id dla produktu");
		}
		
		// LOGI
		
				myStmt = myConn.prepareStatement("insert into logi"
						+ " (data_powstania,akcja,produkt_id)"
						+ " values (?, ?,?)");
				
				
				myStmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
				myStmt.setString(2, "Dodano produkt do bazy.");
				myStmt.setInt(3, _produkt.getId());
				
				
				myStmt.executeUpdate();
				
		}
		catch(SQLException exc)
		{
			JOptionPane.showMessageDialog(null,"B��d przy dodawaniu produktu do bazy " + exc); 
		}
		
			
	}

	private Produkt convertRowToProdukt(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String nazwa = myRs.getString("nazwa");
		int ilosc = myRs.getInt("ilosc");
		Double cena = myRs.getDouble("cena");
		String kategoria = myRs.getString("kategoria");
		Double vat = myRs.getDouble("vat");
		Double objetosc = myRs.getDouble("objetosc");
		
		Produkt tempProdukt = new Produkt(id, nazwa, ilosc,vat,cena,kategoria,objetosc);
		
		return tempProdukt;
	}

	public List<Produkt> getAllProdukty() throws SQLException {
		List<Produkt> lista = new ArrayList<Produkt>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from produkty order by nazwa");
			
			while(myRs.next()){
				Produkt tempProdukt = convertRowToProdukt(myRs);
				lista.add(tempProdukt);
			}
		return lista;
		}
		finally{
			close(myStmt);
		}
	}
	
	public List<FormularzDetal> getAllFormularzeDetal() throws SQLException {
		List<FormularzDetal> lista = new ArrayList<FormularzDetal>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from formularzeDetal");
			
			while(myRs.next()){
				FormularzDetal temp = convertRowToFormularzDetal(myRs);
				lista.add(temp);
			}
		return lista;
		}
		finally{
			close(myStmt);
		}
	}
	
	private FormularzDetal convertRowToFormularzDetal(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String imie = myRs.getString("imie");
		String nazwisko = myRs.getString("nazwisko");
		String produkty = myRs.getString("produkty");
		Double cena = myRs.getDouble("cena");
		Date data_dodania = myRs.getDate("data_dodania");
		
		FormularzDetal temp = new FormularzDetal(imie, nazwisko, produkty, cena, data_dodania);
		
		return temp;
	}

	public List<Produkt> searchProdukt(String _nazwa) throws SQLException {
		List<Produkt> lista = new ArrayList<Produkt>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			_nazwa = '%' + _nazwa + '%';
			myStmt = myConn.prepareStatement("select * from produkty where nazwa like ?  order by nazwa");
			
			myStmt.setString(1, _nazwa);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Produkt tempProdukt = convertRowToProdukt(myRs);
				lista.add(tempProdukt);
			}
			
			return lista;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Log> getLogi(int _produktId) throws Exception {
		List<Log> listalogow = new ArrayList<Log>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = "SELECT data_powstania,akcja "
					+ "FROM logi "
					+ "WHERE produkt_id=" + _produktId;
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				
				String akcja = myRs.getString("logi.akcja");
				
				Timestamp timestamp = myRs.getTimestamp("logi.data_powstania");
				java.util.Date dataakcji = new java.util.Date(timestamp.getTime());
				
				Log temp = new Log(_produktId,dataakcji,akcja);
				
				listalogow.add(temp);
			}

			return listalogow;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	
	/*public void ustawiloscnazero(Produkt _produkt){
		_produkt.setIlosc(0);
	}*/

/*public static void main(String[] args) throws Exception {
	
	//Funkcje f = new Funkcje();
	//System.out.println(f.searchProdukt("m"));

	//System.out.println(f.getAllProdukty());
	
}
*/
public void deleteProdukt(int _id) throws SQLException {
	PreparedStatement myStmt = null;
	
	try{
		myStmt = myConn.prepareStatement("delete from produkty where id = ?");
		
		myStmt.setInt(1, _id);
		
		myStmt.executeUpdate();
	}
	finally{
		close(myStmt);
	}
	
}

public void wyzeruj(Produkt _produkt) throws SQLException {
	int _id = _produkt.getId();
	PreparedStatement myStmt = null;
	
	try{
		
		myStmt = myConn.prepareStatement("update produkty"
				+ " set ilosc=0"
				+ " where id=?");
		
		myStmt.setInt(1,_id);
		
		myStmt.executeUpdate();
	}
	finally{
		close(myStmt);
	}
	
}

public void odswiezProdukty(JTable table) {
	
	try{
		List<Produkt> produkty = getAllProdukty();
		
		ModelTablicyProduktow model = new ModelTablicyProduktow(produkty);
		
		table.setModel(model);
	}
	catch(Exception exc){
		JOptionPane.showMessageDialog(null,"Blad przy odswiezaniu " + exc);
	}
	
}




}