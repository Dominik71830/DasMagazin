package pakiet;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;



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
					+ " set nazwa=?, ilosc=?, vat=?, cena=?, kategoria=?"
					+ " where id=?");
			
			myStmt.setString(1, _produkt.getNazwa());
			myStmt.setInt(2, _produkt.getIlosc());
			myStmt.setDouble(3, _produkt.getVat());
			myStmt.setDouble(4, _produkt.getCena());
			myStmt.setString(5, _produkt.getKategoria());
			myStmt.setInt(6, _produkt.getId());
			
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
				+ " (nazwa,ilosc,vat,cena,kategoria)"
				+ " values (?, ?, ?, ?, ?)");//, Statement.RETURN_GENERATED_KEYS);
		
		myStmt.setString(1, _produkt.getNazwa());
		myStmt.setInt(2, _produkt.getIlosc());
		myStmt.setDouble(3, _produkt.getVat());
		myStmt.setDouble(4, _produkt.getCena());
		myStmt.setString(5, _produkt.getKategoria());
		
		myStmt.executeUpdate();
		
		/*ResultSet generatedKeys = myStmt.getGeneratedKeys();
		if (generatedKeys.next()) {
			_produkt.setId(generatedKeys.getInt(1));
		} else {
			throw new SQLException("Error generating key for produkt");
		}*/
		}
		catch(SQLException exc)
		{
			JOptionPane.showMessageDialog(null,"B��d przy dodawaniu produktu do bazy ", exc); 
		}
		
	}

	private Produkt convertRowToProdukt(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String nazwa = myRs.getString("nazwa");
		int ilosc = myRs.getInt("ilosc");
		Double cena = myRs.getDouble("cena");
		String kategoria = myRs.getString("kategoria");
		Double vat = myRs.getDouble("vat");
		
		Produkt tempProdukt = new Produkt(id, nazwa, ilosc,vat,cena,kategoria);
		
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
	
	public void ustawiloscnazero(Produkt _produkt){
		_produkt.setIlosc(0);
	}

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

}