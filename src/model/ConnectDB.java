package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	Connection c = null;
	Statement stmt = null;

	// wywo�anie metod
	public static void main(String args[]) {
		ConnectDB db = new ConnectDB();
		db.setConnection();
		db.setStatement();
		
		db.dropTableBookstore();
		db.createTableBookstore();
		db.addRecordToBookstore(1, "Z Java przez swiat", "Aga Jasiu",
				"Nowa Era", 2001);

		db.closeConnection();
	}

	// deklaracja metody po��czenia z baz� danych
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			connection = null;
		}
		
		return connection;
	}
	
	public void setConnection() {
		try {
			this.c = ConnectDB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setStatement() {
		try {
			this.stmt = ConnectDB.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	// deklaracja metody zamkni�cia po��czenia z baz� danych
	public void closeConnection() {
		try {
			this.stmt.close();
			this.c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// usuni�cie bazy
	public void dropTableBookstore() {
		String sql = "DROP TABLE BOOKSTORE";

		try {
			this.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// stworzenie table w bazie danych
	public void createTableBookstore() {
		try {
			String sql = "CREATE TABLE BOOKSTORE "
					+ "(ID INT PRIMARY KEY     NOT NULL,"
					+ " nazwa          TEXT    NOT NULL, "
					+ " autor          TEXT     NOT NULL, "
					+ " wydawnictwo    TEXT     NOT NULL,"
					+ " rokWydania        INT)";
			this.stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	// dodanie rekordu do tabeli w bazie
	public void addRecordToBookstore(int id, String nazwa, String autor,
			String wydawnictwo, int rokWydania) {
		try {
			String sql = "INSERT INTO BOOKSTORE (ID, nazwa, autor, wydawnictwo, rokWydania)"
					+ "VALUES ("
					+ id
					+ ",'"
					+ nazwa
					+ "','"
					+ autor
					+ "','"
					+ wydawnictwo + "'," + rokWydania + ")";
			this.stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}
