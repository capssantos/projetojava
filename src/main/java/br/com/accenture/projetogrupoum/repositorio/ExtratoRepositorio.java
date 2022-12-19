package br.com.accenture.projetogrupoum.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.accenture.projetogrupoum.modelo.Extrato;

@Repository
public interface ExtratoRepositorio extends CrudRepository<Extrato, Long> {
    
}
