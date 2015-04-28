package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	Connection c = null;
    Statement stmt = null;
	
    // wywo³anie metod 
    public static void main( String args[] )
    {
    	ConnectDB db = new ConnectDB();
    	db.initConnection();
    	
    	db.dropTableBookstore();
    	db.createTableBookstore();
    	db.addRecordToBookstore(1, "Z Jav¹ przez œwiat", "Aga Jasiu", "Nowa Era", 2001);
    	
    	db.closeConnection();
    }
    
    //deklaracja metody po³¹czenia z baz¹ danych 
    public void initConnection() {
    	try {
			Class.forName("org.sqlite.JDBC");
			this.c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    	this.stmt = this.c.createStatement();
	    	System.out.println("Opened database successfully");
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
    	
    }
    //deklaracja metody zamkniêcia po³¹czenia z  baz¹ danych
    public void closeConnection() {
    	try {
			this.stmt.close();
			this.c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	  // usuniêcie bazy
    public void dropTableBookstore() {
		String sql = "DROP TABLE BOOKSTORE";
		
		try {
			this.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     //stworzenie table w bazie danych
	  public void createTableBookstore() {
		    try {
		      String sql = "CREATE TABLE BOOKSTORE " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " nazwa          TEXT    NOT NULL, " + 
		                   " autor          TEXT     NOT NULL, " + 
		                   " wydawnictwo    TEXT     NOT NULL," + 
		                   " rokWydania        INT)"; 
		      this.stmt.executeUpdate(sql);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
	  }
	  //dodanie rekordu do tabeli w bazie 
	  public void addRecordToBookstore(int id, String nazwa, String autor, String wydawnictwo, int rokWydania){
		   try {
			 String sql = "INSERT INTO BOOKSTORE (ID, nazwa, autor, wydawnictwo, rokWydania)" +
					 		"VALUES (" + id + ",'" + nazwa + "','" + autor + "','" + wydawnictwo + "'," + rokWydania +")";
			 this.stmt.executeUpdate(sql);
			 
		   }catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			    }
			    System.out.println("Records created successfully");
	  }
}
