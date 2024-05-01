package one.springboot.academia.marven.service;

import one.springboot.academia.marven.entity.Matricula;
import one.springboot.academia.marven.entity.form.MatriculaForm;

public interface IMatriculaService {
	Matricula create(MatriculaForm from);
	Matricula getMatriculaId(Long id);
	Iterable<Matricula> getAll();
	Matricula update(Long id, MatriculaForm fromUpdate);
	void delete(Long id);
}
