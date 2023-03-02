package org.corsojava.foto.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Foto {
    
	
	
	@Id  // IDENTIFICA LA CHIAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String titoloFoto ;
	private String descrizione;
	private String url;
	private boolean visibile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitoloFoto() {
		return titoloFoto;
	}
	public void setTitoloFoto(String titoloFoto) {
		this.titoloFoto = titoloFoto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isVisibile() {
		return visibile;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	
	
	public List<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}



	@ManyToMany(cascade = CascadeType.ALL)
	private List<Categoria> categorie;
	
	
}
