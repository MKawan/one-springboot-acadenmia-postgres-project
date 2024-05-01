package one.springboot.academia.marven.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	@Column(unique = true)
	private int matricula; 
	
	private LocalDateTime dataDaMatriculaDateTime = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public LocalDateTime getDataDaMatriculaDateTime() {
		return dataDaMatriculaDateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setDataDaMatriculaDateTime(LocalDateTime dataDaMatriculaDateTime) {
		this.dataDaMatriculaDateTime = dataDaMatriculaDateTime;
	}

	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}
