package org.corsojava.foto.controller;

import java.util.List;

import org.corsojava.foto.model.Foto;
import org.corsojava.foto.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/foto")
public class FotoController {
	
	
	@Autowired
	FotoRepository fotorep ;
	
	@GetMapping	
	public String index(@RequestParam(name="keyword", required = false) String keyword,Model model) {		
		List<Foto> elencofoto;
		
		if (keyword!=null && !keyword.isEmpty()) //RICERCA NOME FOTO
			elencofoto = fotorep.findByTitoloFotoLike("%"+ keyword + "%"); 
		else
			elencofoto = fotorep.findAll();	
		model.addAttribute("foto", elencofoto);
		return "index";
	}
}
