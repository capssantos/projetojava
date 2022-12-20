package br.com.accenture.projetogrupoum.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.accenture.projetogrupoum.modelo.Extrato;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.servico.ExtratoServico;

@RestController
@CrossOrigin(origins = "*")
public class ExtratoControle {
    
    @Autowired
    private ExtratoServico extratoServico;

    @DeleteMapping(value = "removerextrato/{idExtrato}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Retorno> removerExtrato(@PathVariable long idExtrato){
        return extratoServico.removerExtrato(idExtrato);
    }

    @PutMapping(value = "/alterarextrato", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> alterarExtraEntraEntity(@RequestBody Extrato extrato){
        return extratoServico.cadastroExtrato(extrato, "alterar");
    }

    @PostMapping(value = "/cadastrarextrato", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> cadastrarExtraEntity(@RequestBody Extrato extrato){
        return extratoServico.cadastroExtrato(extrato, "cadastrar");
    }

    @GetMapping("/allextrato")
    private Iterable<Extrato> listar(){
        return extratoServico.listar();
    }

    @GetMapping("/extrato/{idExtrato}")
    private Optional<Extrato> getExtratoEntity(@PathVariable long idExtrato){
        return extratoServico.listarextratos(idExtrato);
    }

    @GetMapping("/ana")
    public String rota(){
        return "Hello World";
    }

}
