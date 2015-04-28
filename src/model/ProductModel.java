package model;

import java.util.*;
import entities.*;
import java.sql.*;

public class ProductModel {

	public List<Product> findAll(){
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select * from BOOKSTORE");
		} catch (Exception e) {
			return null;
		}
	}
}
