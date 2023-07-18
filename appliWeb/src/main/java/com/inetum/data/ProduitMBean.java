package com.inetum.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class ProduitMBean {
	private List<Produit> produits;
	private String categorie=null;
	private List<String> listCategorie;
	private static Map<String, List<Produit>> mapCategorieProduits;
	
	static {
		mapCategorieProduits = new HashMap<String, List<Produit>>();
		var listLivre = new ArrayList<Produit>();
		listLivre.add(new Produit("qew", "La quète d'Ewilan", 13.56, "LIVRE"));
		listLivre.add(new Produit("nt1", "Naruto tome 1", 7.00, "LIVRE"));
		listLivre.add(new Produit("nt2", "Naruto tome 2", 7.00, "LIVRE"));
		listLivre.add(new Produit("nt3", "Naruto tome 3", 7.00, "LIVRE"));
		mapCategorieProduits.put("LIVRE", listLivre);
		
		var listCd = new ArrayList<Produit>();
		listCd.add(new Produit("irm", "Iron Maiden", 5.98, "CD"));
		listCd.add(new Produit("tkh", "Tokyo hotel best-of", 13.56, "CD"));
		mapCategorieProduits.put("CD", listCd);
		
		var listJeux = new ArrayList<Produit>();
		listJeux.add(new Produit("sc2", "StarCraft 2", 59.99, "JEUX"));
		listJeux.add(new Produit("adb", "Adibou", 6.50, "JEUX"));
		listJeux.add(new Produit("mpa", "Ma pension d'animaux", 18.42, "JEUX"));
		mapCategorieProduits.put("JEUX", listJeux);
	}
	
	public ProduitMBean() {
		this.listCategorie = new ArrayList<String>();
		this.listCategorie.add("LIVRE");
		this.listCategorie.add("CD");
		this.listCategorie.add("JEUX");
		
		this.produits = new ArrayList<Produit>();
		this.produits.add(new Produit("qew", "La quète d'Ewilan", 13.56, "LIVRE"));
		this.produits.add(new Produit("ela", "Elenna", 18.0, "LIVRE"));
		this.produits.add(new Produit("irm", "Iron Maiden", 5.98, "CD"));
		this.produits.add(new Produit("sc2", "StarCraft 2", 59.99, "JEUX"));
		this.produits.add(new Produit("tkh", "Tokyo hotel best-of", 13.56, "CD"));
		this.produits.add(new Produit("adb", "Adibou", 6.50, "JEUX"));
		this.produits.add(new Produit("nt1", "Naruto tome 1", 7.00, "LIVRE"));
		this.produits.add(new Produit("nt2", "Naruto tome 2", 7.00, "LIVRE"));
		this.produits.add(new Produit("nt3", "Naruto tome 3", 7.00, "LIVRE"));
		this.produits.add(new Produit("mpa", "Ma pension d'animaux", 18.42, "JEUX"));
	}
	
	public String selectionnerCategorie() {
		this.produits = mapCategorieProduits.get(categorie);
		return null;
	}
	
	public void onSelectionnerCategorie(ValueChangeEvent e) {
		this.categorie = (String) e.getNewValue();
		this.produits = mapCategorieProduits.get(categorie);
	}

	
	//GETTERS SETTERS
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<String> getListCategorie() {
		return listCategorie;
	}

	public void setListCategorie(List<String> listCategorie) {
		this.listCategorie = listCategorie;
	}

	public static Map<String, List<Produit>> getMapCategorieProduits() {
		return mapCategorieProduits;
	}

	public static void setMapCategorieProduits(Map<String, List<Produit>> mapCategorieProduits) {
		ProduitMBean.mapCategorieProduits = mapCategorieProduits;
	}

}
