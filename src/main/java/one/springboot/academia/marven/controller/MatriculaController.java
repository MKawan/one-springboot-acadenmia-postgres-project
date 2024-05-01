package one.springboot.academia.marven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.springboot.academia.marven.entity.Matricula;
import one.springboot.academia.marven.entity.form.MatriculaForm;
import one.springboot.academia.marven.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	private MatriculaServiceImpl impl;
	
	@PostMapping
	public Matricula create(@RequestBody MatriculaForm form) {
		return impl.create(form);
	}
}
