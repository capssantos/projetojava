package br.com.accenture.projetogrupoum.modelo;

import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "IdContaCorrente", nullable = false)
    private Long IdContaCorrente;

    @Column(name="dataMovimento", nullable = false)
    private DateTimeFormat dataMovimento;
    
    @Column(name="Operacao", nullable = false)
    private String Operacao;

    @Column(name="valorOperacao", nullable = false)
    private Float valorOperacao;

    public Extrato(){

    }

    @JsonCreator
    public Extrato(@JsonProperty("IdExtrato") Long IdExtrato, @JsonProperty("IdContaCorrente") Long IdContaCorrente,  @JsonProperty("dataMovimento") DateTimeFormat dataMovimento,  @JsonProperty("Operacao") String Operacao, @JsonProperty("valorOperacao") Float valorOperacao){
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

    public DateTimeFormat getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(DateTimeFormat dataMovimento) {
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
            " IdExtrato='" + getIdExtrato() + "'" +
            ", IdContaCorrente='" + getIdContaCorrente() + "'" +
            ", dataMovimento='" + getDataMovimento() + "'" +
            ", Operacao='" + getOperacao() + "'" +
            ", valorOperacao='" + getValorOperacao() + "'" +
            "}";
    }


}
