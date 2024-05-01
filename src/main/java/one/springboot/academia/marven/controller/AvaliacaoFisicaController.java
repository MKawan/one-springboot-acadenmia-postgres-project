package one.springboot.academia.marven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.springboot.academia.marven.entity.AvaliacaoFisica;
import one.springboot.academia.marven.entity.form.AvaliacaoFisicaForm;
import one.springboot.academia.marven.entity.form.AvaliacaoFisicaUpdateFrom;
import one.springboot.academia.marven.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	@Autowired
	private AvaliacaoFisicaServiceImpl serviceImpl;
	
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form)
	{
		return serviceImpl.create(form);
	}
	/*@GetMapping
	public Iterable<AvaliacaoFisica> getAll(){
		return serviceImpl.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<AvaliacaoFisica> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(serviceImpl.getAvaliacoesId(id));
	}*/
	
	@PatchMapping("/{id}")
	public AvaliacaoFisica update(@RequestBody AvaliacaoFisicaUpdateFrom form, @PathVariable Long id) {
		 return serviceImpl.update(form, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AvaliacaoFisica> delete(@PathVariable Long id){
		serviceImpl.delete(id);
		return ResponseEntity.ok(serviceImpl.getAvaliacoesId(id));
	}
}
