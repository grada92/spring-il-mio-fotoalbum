package org.corsojava.foto.repository;


import java.util.List;

import org.corsojava.foto.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto , Integer>{
	
	public List<Foto>  findByTitoloFotoLike(String keyword);
}
