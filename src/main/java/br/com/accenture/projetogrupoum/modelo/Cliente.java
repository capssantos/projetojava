package br.com.accenture.projetogrupoum.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    private String clienteNome;

    @Column(nullable = false)
    private String clienteCPF;

    @Column(nullable = false)
    private String clienteFone;

    @Column(nullable = false)
    private Long idContaCorrente;

    @Column(nullable = false)
    private Long idAgencia;

    public Cliente(){

    }

    @JsonCreator
    public Cliente(@JsonProperty("idCliente") Long idCliente, @JsonProperty("clienteNome") String clienteNome, @JsonProperty("clienteCPF") String clienteCPF, @JsonProperty("clienteFone") String clienteFone, @JsonProperty("idContaCorrente") Long idContaCorrente, @JsonProperty("idAgencia") Long idAgencia ){
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

    public Long getIdContaCorrente() {
        return this.idContaCorrente;
    }

    public void setIdContaCorrente(Long idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Long getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
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
