package br.com.accenture.projetogrupoum.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "cliente_nome",nullable = false, length = 80)
    private String clienteNome;

    @Column(name = "cliente_cpf",nullable = false, length = 14)
    private String clienteCPF;

    @Column(name = "cliente_fone",nullable = false, length = 20)
    private String clienteFone;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_conta_corrente")
    private ContaCorrente idContaCorrente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_agencia")
    private Agencia idAgencia;

    public Cliente(){

    }

    @JsonCreator
    public Cliente(@JsonProperty("idCliente") Long idCliente, @JsonProperty("clienteNome") String clienteNome, @JsonProperty("clienteCPF") String clienteCPF, @JsonProperty("clienteFone") String clienteFone, @JsonProperty("idContaCorrente") ContaCorrente idContaCorrente, @JsonProperty("idAgencia") Agencia idAgencia ){
        this.idCliente = idCliente;
        this.clienteNome = clienteNome;
        this.clienteCPF = clienteCPF;
        this.clienteFone = clienteFone;
        this.idContaCorrente = idContaCorrente;
        this.idAgencia = idAgencia;
    }


    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getClienteNome() {
        return this.clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCPF() {
        return this.clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public String getClienteFone() {
        return this.clienteFone;
    }

    public void setClienteFone(String clienteFone) {
        this.clienteFone = clienteFone;
    }

    public ContaCorrente getIdContaCorrente() {
        return this.idContaCorrente;
    }

    public void setIdContaCorrente(ContaCorrente idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Agencia getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(Agencia idAgencia) {
        this.idAgencia = idAgencia;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "{" +
            " idCliente='" + getIdCliente() + "'" +
            ", clienteNome='" + getClienteNome() + "'" +
            ", clienteCPF='" + getClienteCPF() + "'" +
            ", clienteFone='" + getClienteFone() + "'" +
            ", idContaCorrente='" + getIdContaCorrente() + "'" +
            ", idAgencia='" + getIdAgencia() + "'" +
            "}";
    }

}
