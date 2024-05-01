package one.springboot.academia.marven.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.springboot.academia.marven.entity.Aluno;
import one.springboot.academia.marven.entity.Matricula;
import one.springboot.academia.marven.entity.form.MatriculaForm;
import one.springboot.academia.marven.repository.AlunoRepository;
import one.springboot.academia.marven.repository.MatriculaRepository;
import one.springboot.academia.marven.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private MatriculaRepository repository;
	
	@Autowired
	private AlunoRepository repositoryAluno;
	
	@Override
	public Matricula create(MatriculaForm form) {
		// TODO Auto-generated method stub
		Matricula matricula = new Matricula();
		Aluno aluno = repositoryAluno.findById(form.getAlunoId()).get();
		
		matricula.setAluno(aluno);
		matricula.setMatricula(form.getMatricula());
		return repository.save(matricula);
	}

	@Override
	public Matricula getMatriculaId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Matricula> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matricula update(Long id, MatriculaForm fromUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
