package org.corsojava.foto.api;

import java.util.List;
import java.util.Optional;

import org.corsojava.foto.model.Foto;
import org.corsojava.foto.repository.CategoriaRepository;
import org.corsojava.foto.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	FotoRepository fotorep;
	
	@Autowired
	CategoriaRepository caterep;
	
	@GetMapping() 
	public List<Foto> index(){
		return fotorep.findAll();
	}
	
	@GetMapping("{id}")		  //recupero dettaglio
	public ResponseEntity<Foto> detail(@PathVariable("id") Integer id) {
		Optional<Foto> res= fotorep.findById(id);
		if (res.isPresent()) 
			return new ResponseEntity<Foto>(res.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<Foto>(HttpStatus.NOT_FOUND);
	}
	
}
