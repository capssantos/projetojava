package br.com.accenture.projetogrupoum.modelo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCliente")
    private Long IdCliente;

    @Column(name = "ClienteNome",nullable = false)
    private String ClienteNome;

    @Column(name = "ClienteCPF",nullable = false)
    private String ClienteCPF;

    @Column(name = "ClienteFone",nullable = false)
    private String ClienteFone;

    @Column(name = "IdContaCorrente",nullable = false)
    private Long IdContaCorrente;

    @Column(name = "IdAgencia",nullable = false)
    private Long IdAgencia;

    public Cliente(){

    }

    @JsonCreator
    public Cliente(@JsonProperty("idCliente") Long IdCliente, @JsonProperty("clienteNome") String ClienteNome, @JsonProperty("clienteCPF") String ClienteCPF, @JsonProperty("clienteFone") String ClienteFone, @JsonProperty("idContaCorrente") Long IdContaCorrente, @JsonProperty("idAgencia") Long IdAgencia ){
        this.IdCliente = IdCliente;
        this.ClienteNome = ClienteNome;
        this.ClienteCPF = ClienteCPF;
        this.ClienteFone = ClienteFone;
        this.IdContaCorrente = IdContaCorrente;
        this.IdAgencia = IdAgencia;
    }


    public Long getIdCliente() {
        return this.IdCliente;
    }

    public void setIdCliente(Long IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getClienteNome() {
        return this.ClienteNome;
    }

    public void setClienteNome(String ClienteNome) {
        this.ClienteNome = ClienteNome;
    }

    public String getClienteCPF() {
        return this.ClienteCPF;
    }

    public void setClienteCPF(String ClienteCPF) {
        this.ClienteCPF = ClienteCPF;
    }

    public String getClienteFone() {
        return this.ClienteFone;
    }

    public void setClienteFone(String ClienteFone) {
        this.ClienteFone = ClienteFone;
    }

    public Long getIdContaCorrente() {
        return this.IdContaCorrente;
    }

    public void setIdContaCorrente(Long IdContaCorrente) {
        this.IdContaCorrente = IdContaCorrente;
    }

    public Long getIdAgencia() {
        return this.IdAgencia;
    }

    public void setIdAgencia(Long IdAgencia) {
        this.IdAgencia = IdAgencia;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(IdCliente, cliente.IdCliente);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    

    @Override
    public String toString() {
        return "{" +
            " IdCliente='" + getIdCliente() + "'" +
            ", ClienteNome='" + getClienteNome() + "'" +
            ", ClienteCPF='" + getClienteCPF() + "'" +
            ", ClienteFone='" + getClienteFone() + "'" +
            ", IdContaCorrente='" + getIdContaCorrente() + "'" +
            ", IdAgencia='" + getIdAgencia() + "'" +
            "}";
    }

}
