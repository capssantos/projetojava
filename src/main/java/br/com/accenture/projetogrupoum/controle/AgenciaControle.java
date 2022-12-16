package br.com.accenture.projetogrupoum.controle;

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

import br.com.accenture.projetogrupoum.modelo.Agencia;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.servico.AgenciaServico;

@RestController
@CrossOrigin(origins = "*")
public class AgenciaControle {
    
    @Autowired
    private AgenciaServico agenciaServico;

    @DeleteMapping(value = "/removeragencia/{IdAgencia}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Retorno> removerAgencEntity(@PathVariable long idAgencia){
        return agenciaServico.removerAgencia(idAgencia);
    }


    @PutMapping(value = "/alteraragencia", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> alterarAgenciaEntity(@RequestBody Agencia agencia){
        return agenciaServico.cadastroAgencia(agencia, "alterar");
    }

    @PostMapping(value = "/cadastraragencia", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> cadastrarAgenciaEntity(@RequestBody Agencia agencia){
        return agenciaServico.cadastroAgencia(agencia, "cadastrar");
    }

    @GetMapping("/allagencias")
    private Iterable<Agencia> listar(){
        return agenciaServico.listar();
    }
    
    @GetMapping("/")
    public String rota(){
        return "Hello World";
    }

}
