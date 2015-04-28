package entities;

public class Product {
	private String nazwa, autor, wydawnictwo;
	private int rokWydania;
	
	
	
	
	public Product(String nazwa, String autor, String wydawnictwo,
			int rokWydania) {
		this.nazwa = nazwa;
		this.autor = autor;
		this.wydawnictwo = wydawnictwo;
		this.rokWydania = rokWydania;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getWydawnictwo() {
		return wydawnictwo;
	}
	public void setWydawnictwo(String wydawnictwo) {
		this.wydawnictwo = wydawnictwo;
	}
	public int getRokWydania() {
		return rokWydania;
	}
	public void setRokWydania(int rokWydania) {
		this.rokWydania = rokWydania;
	}
	
	
}
