package one.springboot.academia.marven.entity.form;

import java.util.Random;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaForm {
	
	@NotNull(message = "preencha os campos corretamente")
	@Positive(message = "o campo precisa ter numero inteiro positivo")
	private Long alunoId;
	
	private int matricula; 
	
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public Long getAlunoId() {
		// TODO Auto-generated method stub
		return alunoId;
	}

	public int getMatricula() {
		Random random = new Random();
		matricula = random.nextInt(90000000) + 10000000;;
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}
