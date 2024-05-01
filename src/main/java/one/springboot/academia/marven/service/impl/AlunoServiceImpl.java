package one.springboot.academia.marven.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.springboot.academia.marven.entity.Aluno;
import one.springboot.academia.marven.entity.form.AlunoForm;
import one.springboot.academia.marven.entity.form.AlunoUpdateForm;
import one.springboot.academia.marven.repository.AlunoRepository;
import one.springboot.academia.marven.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService{

	@Autowired
	private AlunoRepository alunoRepository ;
	
	@Override
	public Aluno create(AlunoForm form) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		aluno.setId(form.getId());
		aluno.setNome(form.getNome());
		aluno.setBairro(form.getBairro());
		aluno.setCpf(form.getCpf());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno getAlunoId(Long id) {
		// TODO Auto-generated method stub
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.get();
	}

	@Override
	public Iterable<Aluno> getAll(String dataDeNascimento) {
		// TODO Auto-generated method stub
		   if(dataDeNascimento == null) {
			   	return alunoRepository.findAll();
		    } else {
			    	DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			    	LocalDate localDate = LocalDate.parse(dataDeNascimento, formatado);
		      		
			    	return alunoRepository.findByDataDeNascimento(localDate);
		    }
	}

	@Override
	public Aluno update(AlunoUpdateForm form, Long id) {
		// TODO Auto-generated method stub
//
//		        Aluno aluno = alunoRepository.findById(id)
//		            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
//	
//		        // Copiar os campos permitidos do alunoRequest para o aluno existente
//		        BeanUtils.copyProperties(form, aluno, "nome", "bairro", "dataDeNascimento");
//	
//		        // Salvar as alterações no banco de dados
//		        return alunoRepository.save(aluno);
	        Aluno aluno = alunoRepository.findById(id)
	    	            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
	    		    
    		        aluno.setNome(form.getNome());
    		        aluno.setBairro(form.getBairro());
    		        aluno.setDataDeNascimento(form.getDataDeNascimento());
    		        return alunoRepository.save(aluno);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	        Aluno aluno = alunoRepository.findById(id)
		    	            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
		alunoRepository.delete(aluno);
	}

}
