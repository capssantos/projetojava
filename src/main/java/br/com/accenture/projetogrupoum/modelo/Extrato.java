package br.com.accenture.projetogrupoum.modelo;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.accenture.projetogrupoum.util.EnumOperacao;


@Entity
@Table(name = "extrato")
public class Extrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extrato")
    private Long idExtrato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_conta_corrente")
    private ContaCorrente idContaCorrente;

    @CreationTimestamp
    @Column(name = "data_movimento",nullable = false)
    private Timestamp dataMovimento;
    
   @Column(name = "operacao",nullable = false)
    private EnumOperacao operacao;

   @Column(name = "valor_operacao",nullable = false)
    private Double valorOperacao;

    public Extrato(){

    }

    @JsonCreator
    public Extrato(@JsonProperty("idExtrato") Long idExtrato, @JsonProperty("idContaCorrente") ContaCorrente idContaCorrente,  @JsonProperty("dataMovimento") Timestamp dataMovimento,  @JsonProperty("operacao") EnumOperacao operacao, @JsonProperty("valorOperacao") Double valorOperacao){
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

    public ContaCorrente getIdContaCorrente() {
        return this.idContaCorrente;
    }

    public void setIdContaCorrente(ContaCorrente idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Timestamp getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(Timestamp dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public EnumOperacao getOperacao() {
        return this.operacao;
    }

    public void setOperacao(EnumOperacao operacao) {
        this.operacao = operacao;
    }

    public Double getValorOperacao() {
        return this.valorOperacao;
    }

    public void setValorOperacao(Double valorOperacao) {
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
