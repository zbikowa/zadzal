package model;

import java.util.*;

import entities.*;

import java.sql.*;

public class ProductModel {

	public List<Product> findAll() {
		try {
			List<Product> listProducts = new ArrayList<>();
			{
			}
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(
					"select * from BOOKSTORE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setNazwa(rs.getString("nazwa"));
				p.setAutor(rs.getString("autor"));
				p.setWydawnictwo(rs.getString("wydawnictwo")); 
				p.setRokWydania(rs.getInt("rokWydania"));
				listProducts.add(p);
			}
			return listProducts;
		} catch (Exception e) {
			return null;
		}
	}

	public Product find(int ID) {
		try {
			Product p = new Product();
			{
			}
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(
					"select * from BOOKSTORE where id=?");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p.setNazwa(rs.getString("nazwa"));
				p.setAutor(rs.getString("autor"));
				p.setWydawnictwo(rs.getString("wydawnictwo"));
				p.setRokWydania(rs.getInt("rokWydania"));
			}
			return p;
		} catch (Exception e) {
			return null;
		}
	}
}