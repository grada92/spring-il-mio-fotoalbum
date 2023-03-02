package org.corsojava.foto.controller;

import java.util.List;

import org.corsojava.foto.model.Categoria;
import org.corsojava.foto.model.Foto;
import org.corsojava.foto.repository.CategoriaRepository;
import org.corsojava.foto.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/foto")
public class FotoController {
	
	
	@Autowired
	FotoRepository fotorep ;
	
	@Autowired
	CategoriaRepository catrep ;
	
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
	
	@GetMapping("/{id}")   // GESTISCE LE RICHIESTE DI TIPO /foto/id
	public String detail(@PathVariable("id") Integer id , Model model) {
	Foto f = fotorep.getReferenceById(id);
	model.addAttribute("detail" , f );
	return "detail";
	}
	
	@GetMapping("/create") // GESTISCE LE RICHIESTE GET TIPO /FOTO/CREATE
	public String create(Model model) {

		Foto f = new Foto();
		List<Categoria> CateList=catrep.findAll();
		model.addAttribute("foto", f);
		model.addAttribute("categorie", CateList);

		return "create";
	}
	
	@PostMapping("/create") //GESTISCE LE RICHIESTE POST /FOTO/CREATE
	public String store(
			@Valid @ModelAttribute("foto") Foto formFoto,
			BindingResult bindingResult,
			Model model) {	
		
			if(bindingResult.hasErrors()) {
				return "create";
				
			}
			fotorep.save(formFoto);
			
			return "redirect:/foto"; 
			
		
	}
	
	@GetMapping("/edit/{id}") //GESTISCE LE RICHIESTEDEL TIPO /FOTO/EDIT/ID
	public String edit(@PathVariable("id") Integer id,Model model ) {
		
		Foto f;
		List<Categoria> CateList= catrep.findAll();
		f = fotorep.getReferenceById(id);
		model.addAttribute("categorie", CateList);
		model.addAttribute("foto", f);
		
	
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute Foto formFoto,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors())
			return "edit";
		
		fotorep.save(formFoto);
		
		return "redirect:/foto";
		
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		fotorep.deleteById(id);
		
		return "redirect:/foto";
	}
	
	
}
