package br.com.accenture.projetogrupoum.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.accenture.projetogrupoum.excecao.DepositoInvalidoException;
import br.com.accenture.projetogrupoum.excecao.EstouroSaqueException;
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

    public Optional<ContaCorrente> listarcontacorrente(long idContaCorrente){
        return contaCorrenteRepositorio.findById(idContaCorrente);
    }

    public ResponseEntity<?> cadastroContaCorrente(ContaCorrente contaCorrente, String status){
        
        if(contaCorrente.getContaCorrenteNumero().equals("")){
            retorno.setMsg("Númeor da Conta vazio. Necessário Preenchimeto..");
            return new ResponseEntity<Retorno>(retorno,HttpStatus.BAD_REQUEST);
        } else if(contaCorrente.getSaldo().equals("")){
            retorno.setMsg("Saldo da Conta vazio. Necessário Preenchimeto.");
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
        retorno.setMsg("Conta deletada com sucesso.");
        return new ResponseEntity<Retorno>(retorno,HttpStatus.OK);
    }

    public ResponseEntity<?> sacarEntity(long idContaCorrente, Double valor){

        Optional<ContaCorrente> contaCorrente = contaCorrenteRepositorio.findById(idContaCorrente);
    
        try {
            contaCorrente.get().Sacar(valor);

        } catch (EstouroSaqueException e) {
            retorno.setMsg(e.getMessage());
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ContaCorrente>(contaCorrenteRepositorio.save(contaCorrente.get()), HttpStatus.OK);
    }

    public ResponseEntity<?> depositarEntity(long idContaCorrente, Double valor){

        Optional<ContaCorrente> contaCorrente = contaCorrenteRepositorio.findById(idContaCorrente);
    
        try {
            contaCorrente.get().Depositar(valor);

        } catch (DepositoInvalidoException e) {
            retorno.setMsg(e.getMessage());
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ContaCorrente>(contaCorrenteRepositorio.save(contaCorrente.get()), HttpStatus.OK);
    }

    public ResponseEntity<?> transferirEntity(long idContaOrigem, long idContaDestino, Double valor){

        Optional<ContaCorrente> contaOrigem = contaCorrenteRepositorio.findById(idContaOrigem);
        Optional<ContaCorrente> contaDestino = contaCorrenteRepositorio.findById(idContaDestino);
    
        try {
            contaOrigem.get().Transferir(contaDestino.get(), valor);
        } catch (DepositoInvalidoException | EstouroSaqueException e) {
            retorno.setMsg(e.getMessage());
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<ContaCorrente>(contaCorrenteRepositorio.save(contaDestino.get()), HttpStatus.OK);
    }   
    
}
