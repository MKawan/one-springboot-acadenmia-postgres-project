package one.springboot.academia.marven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import one.springboot.academia.marven.entity.Aluno;
import one.springboot.academia.marven.entity.AvaliacaoFisica;
import one.springboot.academia.marven.entity.form.AlunoForm;
import one.springboot.academia.marven.entity.form.AlunoUpdateForm;
import one.springboot.academia.marven.service.impl.AlunoServiceImpl;
import one.springboot.academia.marven.service.impl.AvaliacaoFisicaServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoServiceImpl service;
	
	@Autowired
	private AvaliacaoFisicaServiceImpl serviceImpl;
	
	@GetMapping("/dataDeNascimento")
	public Iterable<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
		return service.getAll(dataDeNascimento);
	}
	
	@PostMapping()
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.getAlunoId(id));
	}
	
	@GetMapping("/avaliacoes/{id}")
	public ResponseEntity<AvaliacaoFisica> buscarAvaliacoesPorId(@PathVariable Long id){
		return ResponseEntity.ok(serviceImpl.getAvaliacoesId(id));
	}
	
	@PatchMapping("/{id}")
	public Aluno update(@RequestBody AlunoUpdateForm form, @PathVariable Long id) {
		 return service.update(form, id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
