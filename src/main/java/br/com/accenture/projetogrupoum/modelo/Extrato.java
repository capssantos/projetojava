package br.com.accenture.projetogrupoum.modelo;

import java.sql.Timestamp;
import java.util.Objects;

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
    private Long IdExtrato;

    @Column(nullable = false)
    private Long IdContaCorrente;

    @Column(nullable = false)
    private Timestamp dataMovimento;
    
    @Column(nullable = false)
    private String Operacao;

    @Column(nullable = false)
    private Float valorOperacao;

    public Extrato(){

    }

    @JsonCreator
    public Extrato(@JsonProperty("idExtrato") Long IdExtrato, @JsonProperty("idContaCorrente") Long IdContaCorrente,  @JsonProperty("dataMovimento") Timestamp dataMovimento,  @JsonProperty("operacao") String Operacao, @JsonProperty("valorOperacao") Float valorOperacao){
        this.IdExtrato = IdExtrato;
        this.IdContaCorrente = IdContaCorrente;
        this.dataMovimento = dataMovimento;
        this.Operacao = Operacao;
        this.valorOperacao = valorOperacao;
    }


    public Long getIdExtrato() {
        return this.IdExtrato;
    }

    public void setIdExtrato(Long IdExtrato) {
        this.IdExtrato = IdExtrato;
    }

    public Long getIdContaCorrente() {
        return this.IdContaCorrente;
    }

    public void setIdContaCorrente(Long IdContaCorrente) {
        this.IdContaCorrente = IdContaCorrente;
    }

    public Timestamp  getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(Timestamp  dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getOperacao() {
        return this.Operacao;
    }

    public void setOperacao(String Operacao) {
        this.Operacao = Operacao;
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
        return Objects.equals(IdExtrato, extrato.IdExtrato);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "{" +
            " idExtrato='" + getIdExtrato() + "'" +
            ", idContaCorrente='" + getIdContaCorrente() + "'" +
            ", dataMovimento='" + getDataMovimento() + "'" +
            ", operacao='" + getOperacao() + "'" +
            ", valorOperacao='" + getValorOperacao() + "'" +
            "}";
    }


}
