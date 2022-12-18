package br.com.accenture.projetogrupoum.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.accenture.projetogrupoum.modelo.Cliente;
import br.com.accenture.projetogrupoum.modelo.Retorno;
import br.com.accenture.projetogrupoum.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private Retorno retorno;

    public Iterable<Cliente> listar(){
        return clienteRepositorio.findAll();
    }

    public Optional<Cliente> listarcliente(long idCliente){
        return clienteRepositorio.findById(idCliente);
    }

    public ResponseEntity<?> cadastroCliente(Cliente cliente, String status){

        if (cliente.getClienteNome().equals("")){
            retorno.setMsg("Nome do Cliente vazio. Necessário Preenchimeto.");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else if (cliente.getClienteCPF().equals("")){
            retorno.setMsg("CPF vazio. Necessário Preenchimeto");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else if (cliente.getClienteFone().equals("")){
            retorno.setMsg("Telefone vazio. Necessário Preenchimeto");
            return new ResponseEntity<Retorno>(retorno, HttpStatus.BAD_REQUEST);
        } else {
            if (status.equals("cadastrar")){
                return new ResponseEntity<Cliente>(clienteRepositorio.save(cliente), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Cliente>(clienteRepositorio.save(cliente), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<Retorno> removerCliente(long IdCliente){

        clienteRepositorio.deleteById(IdCliente);
        retorno.setMsg("Agencia deletada com sucesso!");
        return new ResponseEntity<Retorno>(retorno, HttpStatus.OK);

    }

}
