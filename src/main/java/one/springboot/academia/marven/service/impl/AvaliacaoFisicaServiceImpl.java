package one.springboot.academia.marven.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.springboot.academia.marven.entity.Aluno;
import one.springboot.academia.marven.entity.AvaliacaoFisica;
import one.springboot.academia.marven.entity.form.AvaliacaoFisicaForm;
import one.springboot.academia.marven.entity.form.AvaliacaoFisicaUpdateFrom;
import one.springboot.academia.marven.repository.AlunoRepository;
import one.springboot.academia.marven.repository.AvaliacaoFisicaRepository;
import one.springboot.academia.marven.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{
	@Autowired
	private AvaliacaoFisicaRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		// TODO Auto-generated method stub
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());
		
		return repository.save(avaliacaoFisica);
	}

	@Override
	public Iterable<AvaliacaoFisica> getAll() {
		
		return repository.findAll();
	}

	@Override
	public AvaliacaoFisica update(AvaliacaoFisicaUpdateFrom form, Long id) {
		// TODO Auto-generated method stub
		AvaliacaoFisica avaliacaoFisica = repository.findById(id)
	    	            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
	    		    
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());
	        return repository.save(avaliacaoFisica);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	        AvaliacaoFisica avaliacaoFisica = repository.findById(id)
		    	            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
		repository.delete(avaliacaoFisica);
	}

	public AvaliacaoFisica getAvaliacoesId(Long id) {
		// TODO Auto-generated method stub
		Optional<AvaliacaoFisica> avaliacoesFisicas = repository.findById(id);
		return avaliacoesFisicas.get();
	}
	
}
