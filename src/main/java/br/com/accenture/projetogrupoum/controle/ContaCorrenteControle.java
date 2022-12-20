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

import br.com.accenture.projetogrupoum.modelo.ContaCorrente;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.servico.ContaCorrenteServico;

@RestController
@CrossOrigin(origins = "*")
public class ContaCorrenteControle{

  @Autowired
  private ContaCorrenteServico contaCorrenteServico;

  @GetMapping("/carlos")
  public String rota(){
    return "Ola Mundo";
  }

  @GetMapping("/allcontas")
  private Iterable<ContaCorrente> listar(){
    return contaCorrenteServico.listar();
  }

  @PostMapping(value = "/cadastratarconta", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> cadastrarContaCorrente(@RequestBody ContaCorrente contaCorrente){
    return contaCorrenteServico.cadastroContaCorrente(contaCorrente, "cadastrar");
  }

  @PutMapping(value = "/alteraconta", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> alterarContaCorrente(@RequestBody ContaCorrente contaCorrente){
    return contaCorrenteServico.cadastroContaCorrente(contaCorrente, "alterar");
  }

  @DeleteMapping(value = "/removerconta/{idContaCorrente}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Retorno> removerContaEntity(@PathVariable Long idContaCorrente){
    return contaCorrenteServico.removerContaCorrente(idContaCorrente);
  }

  @GetMapping("/conta/{idContaCorrente}")
  private Optional<ContaCorrente> getAgencEntity(@PathVariable long idContaCorrente){
      return contaCorrenteServico.listarcontacorrente(idContaCorrente);
  }
  
}