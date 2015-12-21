package FUNKCJE_I_KLASY;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;



public class Funkcje {
	
	private Connection myConn;
	
	public Funkcje()throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("dane.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("Po≥πczono z " + dburl + "\n" + "Uøytkownik: " + user);
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
	
	

	
	public void updateUchodzca (Uchodzca _uchodzca) throws SQLException{
		PreparedStatement myStmt = null;
		PreparedStatement myStmt2 = null;
		
		try{
			myStmt = myConn.prepareStatement("update uchodzcy"
					+ " set imie=?,nazwisko=?,data_urodzenia=?,plec=?,kraj_pochodzenia=?,zasilek=?,przydzielone_miasto=?,data_przydzialu=?"
					+ " where id=?", Statement.RETURN_GENERATED_KEYS);
			
			myStmt.setString(1, _uchodzca.getImie());
			myStmt.setString(2, _uchodzca.getNazwisko());
			myStmt.setString(3, _uchodzca.getData_urodzenia());
			myStmt.setString(4, _uchodzca.getPlec());
			myStmt.setString(5, _uchodzca.getKraj_pochodzenia());
			myStmt.setDouble(6, _uchodzca.getZasilek());
			myStmt.setInt(7, _uchodzca.getPrzydzielone_miasto());
			myStmt.setTimestamp(8, (Timestamp) _uchodzca.getData_przydzialu());
			myStmt.setInt(9, _uchodzca.getId());
			
			myStmt.executeUpdate();
			
			// LOGI
			
			/*ResultSet kluczeId = myStmt.getGeneratedKeys();
			if (kluczeId.next()) {
				_uchodzca.setId(kluczeId.getInt(1));
			} else {
				throw new SQLException("B≥πd przy generowaniu klucza Id dla uchodücy");
			}*/
			
			myStmt2 = myConn.prepareStatement("insert into logi"
					+ " (id_obiektu,data_powstania,akcja)"
					+ " values (?, ?,?)");
			
			myStmt2.setInt(1, _uchodzca.getId());
			myStmt2.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			myStmt2.setString(3, "Aktualizacja danych uchodücy.");
			
			
			
			myStmt2.executeUpdate();
			
		}
		finally{
			close(myStmt);
			close(myStmt2);
		}
	
	}
	
	

	
	public void addUchodzca(Uchodzca _uchodzca) throws Exception {
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into uchodzcy"
				+ " (imie,nazwisko,data_urodzenia,plec,kraj_pochodzenia,zasilek,przydzielone_miasto,data_przydzialu)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);//, Statement.RETURN_GENERATED_KEYS);
			
			myStmt.setString(1, _uchodzca.getImie());
			myStmt.setString(2, _uchodzca.getNazwisko());
			myStmt.setString(3,  _uchodzca.getData_urodzenia());
			myStmt.setString(4, _uchodzca.getPlec());
			myStmt.setString(5, _uchodzca.getKraj_pochodzenia());
			myStmt.setDouble(6, _uchodzca.getZasilek());
			myStmt.setInt(7,  _uchodzca.getPrzydzielone_miasto());
			myStmt.setTimestamp(8, (Timestamp) _uchodzca.getData_przydzialu());
			
			myStmt.executeUpdate();
			
			// LOGI
			
			ResultSet kluczeId = myStmt.getGeneratedKeys();
			if (kluczeId.next()) {
				_uchodzca.setId(kluczeId.getInt(1));
			} else {
				throw new SQLException("B≥πd przy generowaniu klucza Id dla uchodücy");
			}
			
			
			myStmt = myConn.prepareStatement("insert into logi"
					+ " (id_obiektu,data_powstania,akcja)"
					+ " values (?, ?,?)");
			
			myStmt.setInt(1, _uchodzca.getId());
			myStmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			myStmt.setString(3, "Zarejestrowano uchodücÍ.");
			
			
			
			myStmt.executeUpdate();
		}
		catch(SQLException exc)
		{
			JOptionPane.showMessageDialog(null,"B≥πd przy dodawaniu uchodücy do bazy " + exc); 
		}
		
			
	}


	
private Uchodzca convertRowToUchodzca(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String imie = myRs.getString("imie");
		String nazwisko = myRs.getString("nazwisko");
		String data_urodzenia = myRs.getString("data_urodzenia");
		String plec = myRs.getString("plec");
		String kraj_pochodzenia = myRs.getString("kraj_pochodzenia");
		Double zasilek = myRs.getDouble("zasilek");
		int przydzielone_miasto = myRs.getInt("przydzielone_miasto");
		Date data_przydzialu = myRs.getDate("data_przydzialu");
		
		Uchodzca temp = new Uchodzca(id, imie,nazwisko,data_urodzenia,plec,kraj_pochodzenia,zasilek,przydzielone_miasto,data_przydzialu);
		
		return temp;
	}



public List<Uchodzca> getAllUchodzcy() throws SQLException {
	List<Uchodzca> lista = new ArrayList<Uchodzca>();
	
	Statement myStmt = null;
	ResultSet myRs = null;
	
	try{
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from uchodzcy");
		
		while(myRs.next()){
			Uchodzca temp = convertRowToUchodzca(myRs);
			lista.add(temp);
		}
	return lista;
	}
	finally{
		close(myStmt);
	}
}



	
public Miasto convertRowToMiasto(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String nazwa = myRs.getString("nazwa");
		String kod_pocztowy = myRs.getString("kod_pocztowy");
		int liczba_uchodzcow = myRs.getInt("liczba_uchodzcow");
		boolean czy_przyjumje = myRs.getBoolean("czy_przyjmuje");
		
		Miasto temp = new Miasto(id, nazwa,kod_pocztowy,liczba_uchodzcow,czy_przyjumje);
		
		return temp;
	}




public List<Miasto> getAllMiasta() throws SQLException {
	List<Miasto> lista = new ArrayList<Miasto>();
	
	Statement myStmt = null;
	ResultSet myRs = null;
	
	try{
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from miasta");
		
		while(myRs.next()){
			Miasto temp = convertRowToMiasto(myRs);
			lista.add(temp);
		}
	return lista;
	}
	finally{
		close(myStmt);
	}
}



public List<Uchodzca> searchUchodzca(String _nazwa) throws SQLException {
	List<Uchodzca> lista = new ArrayList<Uchodzca>();

	PreparedStatement myStmt = null;
	ResultSet myRs = null;

	try {
		_nazwa = '%' + _nazwa + '%';
		myStmt = myConn.prepareStatement("select * from uchodzcy where nazwisko like ?");
		
		myStmt.setString(1, _nazwa);
		
		myRs = myStmt.executeQuery();
		
		while (myRs.next()) {
			Uchodzca temp = convertRowToUchodzca(myRs);
			lista.add(temp);
		}
		
		return lista;
	}
	finally {
		close(myStmt, myRs);
	}
}


public List<Log> getLogi(int _Id) throws Exception {
	List<Log> listalogow = new ArrayList<Log>();
	
	Statement myStmt = null;
	ResultSet myRs = null;
	
	try {
		myStmt = myConn.createStatement();
		
		String sql = "SELECT data_powstania,akcja "
				+ "FROM logi "
				+ "WHERE id_obiektu=" + _Id;
		
		myRs = myStmt.executeQuery(sql);
		
		while (myRs.next()) {
			
			String akcja = myRs.getString("logi.akcja");
			
			Timestamp timestamp = myRs.getTimestamp("logi.data_powstania");
			java.util.Date dataakcji = new java.util.Date(timestamp.getTime());
			
			Log temp = new Log(_Id,dataakcji,akcja);
			
			listalogow.add(temp);
		}

		return listalogow;		
	}
	finally {
		close(myStmt, myRs);
	}
}



public void wyzeruj(Miasto _miasto) throws SQLException {
	int _id = _miasto.getId();
	PreparedStatement myStmt = null;
	PreparedStatement myStmt2 = null;
	
	try{
		//wyzerowanie miasta
		myStmt = myConn.prepareStatement("update miasta"
				+ " set liczba_uchodzcow = 0"
				+ " where id=?");
		
		myStmt.setInt(1,_id);
		
		myStmt.executeUpdate();
		
		//wyzerowanie uchodücÛw
		myStmt2 = myConn.prepareStatement("update uchodzcy"
				+ " set przydzielone_miasto = 0"
				+ " where przydzielone_miasto = ?");
		
		myStmt2.setInt(1,_miasto.getId());
		
		myStmt2.executeUpdate();
		
	
		
	}
	finally{
		close(myStmt);
	}
	
}


public void odswiezMiasta(JTable table) {
	
	try{
		List<Miasto> miasta = getAllMiasta();
		
		ModelTablicyMiast model = new ModelTablicyMiast(miasta);
		
		table.setModel(model);
	}
	catch(Exception exc){
		JOptionPane.showMessageDialog(null,"B≥πd przy odswiezaniu miast " + exc);
	}
	
}

public void wypelnijComboboxaMiastami(JComboBox<Miasto> comboBoxMiasto) throws SQLException {
	
	List<Miasto> lista= new ArrayList<Miasto>();
	lista = getAllMiasta();
	
	for(Miasto m : lista)
	{
		comboBoxMiasto.addItem(m);
	}
}

public List<Uchodzca> getAllUchodzcyZMiasta(Miasto _miasto) throws SQLException {
	List<Uchodzca> lista = new ArrayList<Uchodzca>();
	
	Statement myStmt = null;
	ResultSet myRs = null;
	
	try{
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery("select * from uchodzcy");
		
		while(myRs.next()){
			Uchodzca temp = convertRowToUchodzca(myRs);
			
			if(_miasto.getId()==temp.getPrzydzielone_miasto())
			lista.add(temp);
		}
	return lista;
	}
	finally{
		close(myStmt);
	}
}

public String pobierzNazweMiastaDla(int przydzielone_miasto) throws SQLException {
	String nazwa = null;
	
	List<Miasto> lista = new ArrayList<Miasto>();
	lista = getAllMiasta();
	
	for(Miasto m : lista)
	{
		if(m.getId() == przydzielone_miasto) nazwa = m.getNazwa();
	}
	
	return nazwa;
}

public void odswiezUchodzcow(JTable table) {
	try{
		List<Uchodzca> lista = getAllUchodzcy();
		
		ModelTablicyUchodzcow model = new ModelTablicyUchodzcow(lista);
		
		table.setModel(model);
	}
	catch(Exception exc){
		JOptionPane.showMessageDialog(null,"B≥πd przy odswiezaniu miast" + exc);
	}
}

public void ustawIloscMiejscWMiescie(Miasto przydzielone_miasto, int nowa_liczba_uchodzcow) throws SQLException {
	PreparedStatement myStmt = null;
	
	try{
		myStmt = myConn.prepareStatement("update miasta"
				+ " set liczba_uchodzcow=? where id=?");
		
		myStmt.setInt(1, nowa_liczba_uchodzcow);
		myStmt.setInt(2, przydzielone_miasto.getId());
		
		myStmt.executeUpdate();
		
	}
	finally{
		close(myStmt);
	}
}

public Miasto getMiasto(int przydzielone_miasto) throws SQLException {
	Miasto miasto = null;
	
	List<Miasto> lista = new ArrayList<Miasto>();
	lista = getAllMiasta();
	
	for(Miasto m : lista)
	{
		if(m.getId() == przydzielone_miasto) {miasto = m;};//JOptionPane.showMessageDialog(null, przydzielone_miasto);}
	}
	
	return miasto;
}

}
