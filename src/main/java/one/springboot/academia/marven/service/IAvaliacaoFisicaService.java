package one.springboot.academia.marven.service;

import one.springboot.academia.marven.entity.AvaliacaoFisica;
import one.springboot.academia.marven.entity.form.AvaliacaoFisicaForm;
import one.springboot.academia.marven.entity.form.AvaliacaoFisicaUpdateFrom;

public interface IAvaliacaoFisicaService {
	AvaliacaoFisica create(AvaliacaoFisicaForm from);
	AvaliacaoFisica getAvaliacoesId(Long id);
	Iterable<AvaliacaoFisica> getAll();
	AvaliacaoFisica update(AvaliacaoFisicaUpdateFrom from, Long id);
	void delete(Long id);
}
