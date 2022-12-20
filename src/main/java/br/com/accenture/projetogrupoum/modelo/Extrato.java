package br.com.accenture.projetogrupoum.modelo;

import java.sql.Timestamp;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Extrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExtrato;

    @Column(nullable = false)
    private Long idContaCorrente;

    @CreationTimestamp
    private Timestamp dataMovimento;
    
    @Column(nullable = false)
    private String operacao;

    @Column(nullable = false)
    private Float valorOperacao;

    public Extrato(){

    }

    @JsonCreator
    public Extrato(@JsonProperty("idExtrato") Long idExtrato, @JsonProperty("idContaCorrente") Long idContaCorrente,  @JsonProperty("dataMovimento") Timestamp dataMovimento,  @JsonProperty("operacao") String operacao, @JsonProperty("valorOperacao") Float valorOperacao){
        this.idExtrato = idExtrato;
        this.idContaCorrente = idContaCorrente;
        this.dataMovimento = dataMovimento;
        this.operacao = operacao;
        this.valorOperacao = valorOperacao;
    }


    public Long getIdExtrato() {
        return this.idExtrato;
    }

    public void setIdExtrato(Long idExtrato) {
        this.idExtrato = idExtrato;
    }

    public Long getIdContaCorrente() {
        return this.idContaCorrente;
    }

    public void setIdContaCorrente(Long idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Timestamp getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(Timestamp dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Float getValorOperacao() {
        return this.valorOperacao;
    }

    public void setValorOperacao(Float valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Extrato)) {
            return false;
        }
        Extrato extrato = (Extrato) o;
        return Objects.equals(idExtrato, extrato.idExtrato);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
