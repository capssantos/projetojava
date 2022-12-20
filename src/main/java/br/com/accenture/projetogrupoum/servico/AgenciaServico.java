package br.com.accenture.projetogrupoum.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.accenture.projetogrupoum.modelo.Agencia;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.repositorio.AgenciaRepositorio;

@Service
public class AgenciaServico {
    
    @Autowired
    private AgenciaRepositorio agenciaRepositorio;

    @Autowired
    private Retorno retorno;

    public Iterable<Agencia> listar(){
        return agenciaRepositorio.findAll();
    }

    public Optional<Agencia> listaragencia(long idAgencia){
        return agenciaRepositorio.findById(idAgencia);
    }

    public ResponseEntity<?> cadastroAgencia(Agencia agencia, String status){

        if (agencia.getNomeAgencia().equals("")){
            retorno.setMsg("Nome da Agencia vazio. Necessário Preenchimeto.");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else if (agencia.getEndereco().equals("")){
            retorno.setMsg("Endereço vazio. Necessário Preenchimeto");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else if (agencia.getTelefone().equals("")){
            retorno.setMsg("Telefone vazio. Necessário Preenchimeto");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else {
            if (status.equals("cadastrar")){
                return new ResponseEntity<Agencia>(agenciaRepositorio.save(agencia), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Agencia>(agenciaRepositorio.save(agencia), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<Retorno> removerAgencia(long idAgencia){

        agenciaRepositorio.deleteById(idAgencia);
        retorno.setMsg("Agencia deletada com sucesso!");
        return new ResponseEntity<Retorno>(retorno, HttpStatus.OK);

    }

}
