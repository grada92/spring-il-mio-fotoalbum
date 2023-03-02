package org.corsojava.foto.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Foto {
    
	
	
	@Id  // IDENTIFICA LA CHIAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@Size(min = 5, max = 13, message = "non può essere più di 13 caratteri e meno di 5")
	@NotNull(message="il nome non può essere nullo")
	@NotEmpty(message="Il nome non deve essere vuoto")
	private String titoloFoto ;
	
	@Size(min = 4, max = 20, message = "non può essere più di 20 caratteri e meno di 4")
	@NotNull(message="il tag non può essere nullo")
	@NotEmpty(message="Il tag non deve essere vuoto")
	private String tag;
	
	@Size(min = 20, max = 500, message = "non può essere più di 500 caratteri e meno di 20")
	@NotNull(message="la descrizione non può essere nullo")
	@NotEmpty(message="la descrizione non deve essere vuoto")
	private String descrizione;
	
	private String url;
	
	private boolean visibile;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	
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
