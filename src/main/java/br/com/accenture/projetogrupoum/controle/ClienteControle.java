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

import br.com.accenture.projetogrupoum.modelo.Cliente;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.servico.ClienteServico;

@RestController
@CrossOrigin(origins = "*")
public class ClienteControle {

    @Autowired
    private ClienteServico clienteServico;

    @DeleteMapping("/removercliente/{idCliente}")
    public ResponseEntity<Retorno> removerAgencEntity(@PathVariable long idCliente){
        return clienteServico.removerCliente(idCliente);
    }

    @PutMapping("/alterarcliente")
    public ResponseEntity<?> alterarClienteEntity(@RequestBody Cliente cliente){
        return clienteServico.cadastroCliente(cliente, "alterar");
    }

    @PostMapping("/cadastrarcliente")
    public ResponseEntity<?> cadastrarClienteEntity(@RequestBody Cliente cliente){
        return clienteServico.cadastroCliente(cliente, "cadastrar");
    }

    @GetMapping("/allclientes")
    private Iterable<Cliente> listar(){
        return clienteServico.listar();
    }

    @GetMapping("/cliente/{idCliente}")
    private Optional<Cliente> getAgencEntity(@PathVariable long idCliente){
        return clienteServico.listarcliente(idCliente);
    }

    @GetMapping("/breno")
    public String rota(){
        return "Alô mundo!";
    }

}
