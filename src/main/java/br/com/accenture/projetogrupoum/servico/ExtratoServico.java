package br.com.accenture.projetogrupoum.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.accenture.projetogrupoum.modelo.Extrato;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.repositorio.ExtratoRepositorio;

@Service
public class ExtratoServico {
    
    @Autowired
    private ExtratoRepositorio extratoRepositorio;

    @Autowired
    private Retorno retorno;

    public Iterable<Extrato> listar(){
        return extratoRepositorio.findAll();
    }

    public Optional<Extrato> listarextratos(long idExtrato){
        return extratoRepositorio.findById(idExtrato);
    }

    public ResponseEntity<?> cadastroExtrato(Extrato extrato, String status){

        if (extrato.getOperacao().equals("")){
            retorno.setMsg("Operação vazio. Necessário Preenchimeto.");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else if (extrato.getValorOperacao().equals("")){
            retorno.setMsg("Valor vazio. Necessário Preenchimeto.");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else {
            if (status.equals("cadastrar")){
                return new ResponseEntity<Extrato>(extratoRepositorio.save(extrato), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Extrato>(extratoRepositorio.save(extrato), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<Retorno> removerExtrato(long idExtrato){
        extratoRepositorio.deleteById(idExtrato);
        retorno.setMsg("Extrato deletado com sucesso!");
        return new ResponseEntity<Retorno>(retorno, HttpStatus.OK);
    }


}
