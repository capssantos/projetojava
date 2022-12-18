package br.com.accenture.projetogrupoum.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.accenture.projetogrupoum.modelo.ContaCorrente;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.repositorio.ContaCorrenteRepositorio;

@Service
public class ContaCorrenteServico {

    @Autowired
    private ContaCorrenteRepositorio contaCorrenteRepositorio;

    @Autowired
    private Retorno retorno;

    public Iterable<ContaCorrente> listar(){

        return contaCorrenteRepositorio.findAll();
    }

    public ResponseEntity<?> cadastroContaCorrente(ContaCorrente contaCorrente, String status){
        
        if(contaCorrente.getContaCorrenteNumero().equals("")){
            retorno.setMsg("Numero da conta necessário.");
            return new ResponseEntity<Retorno>(retorno,HttpStatus.BAD_REQUEST);
        } else if(contaCorrente.getContaCorrenteSaldo().equals("")){
            retorno.setMsg("Saldo da conta necessário.");
            return new ResponseEntity<Retorno>(retorno,HttpStatus.BAD_REQUEST);
        } else{
            if(status.equals("cadastrar")){
                return new ResponseEntity<ContaCorrente>(contaCorrenteRepositorio.save(contaCorrente), HttpStatus.CREATED);
            } else{
                return new ResponseEntity<ContaCorrente>(contaCorrenteRepositorio.save(contaCorrente), HttpStatus.OK);
            }
        }
        
    }

    public ResponseEntity<Retorno> removerContaCorrente(long idContaCorrente){

        contaCorrenteRepositorio.deleteById(idContaCorrente);
        retorno.setMsg("Conta removida com sucesso.");
        return new ResponseEntity<Retorno>(retorno,HttpStatus.OK);
    }
    
}
