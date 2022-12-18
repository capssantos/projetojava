package br.com.accenture.projetogrupoum.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.accenture.projetogrupoum.modelo.ContaCorrente;

@Repository
public interface ContaCorrenteRepositorio extends CrudRepository<ContaCorrente, Long>{

}
