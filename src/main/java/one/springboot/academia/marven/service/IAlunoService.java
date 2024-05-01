package one.springboot.academia.marven.service;

import one.springboot.academia.marven.entity.Aluno;
import one.springboot.academia.marven.entity.form.AlunoForm;
import one.springboot.academia.marven.entity.form.AlunoUpdateForm;

public interface IAlunoService {
	
	Iterable<Aluno> getAll(String dataDeNascimento);
	
//	Aluno update(Long Id, Aluno aluno);
	
	void delete(Long id);

	Aluno create(AlunoForm form);

	Aluno getAlunoId(Long id);

	Aluno update(AlunoUpdateForm form, Long id);
}
