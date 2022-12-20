package br.com.accenture.projetogrupoum.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaCorrente;

    @Column(nullable = false)
    private Long idAgencia;

    @Column(nullable = false)
    private String contaCorrenteNumero;

    @Column(nullable = false)
    private Float contaCorrenteSaldo;

    public ContaCorrente(){

    }
    
    @JsonCreator
    public ContaCorrente(@JsonProperty("idContaCorrente") Long idContaCorrente, @JsonProperty("idAgencia") Long idAgencia,  @JsonProperty("contaCorrenteNumero") String contaCorrenteNumero,  @JsonProperty("contaCorrenteSaldo") Float contaCorrenteSaldo ){

        this.idContaCorrente = idContaCorrente;
        this.idAgencia = idAgencia;
        this.contaCorrenteNumero = contaCorrenteNumero;
        this.contaCorrenteSaldo = contaCorrenteSaldo;
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

    public String getContaCorrenteNumero() {
        return this.contaCorrenteNumero;
    }

    public void setContaCorrenteNumero(String contaCorrenteNumero) {
        this.contaCorrenteNumero = contaCorrenteNumero;
    }

    public Float getContaCorrenteSaldo() {
        return this.contaCorrenteSaldo;
    }

    public void setContaCorrenteSaldo(Float contaCorrenteSaldo) {
        this.contaCorrenteSaldo = contaCorrenteSaldo;
    }
   

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContaCorrente)) {
            return false;
        }
        ContaCorrente contaCorrente = (ContaCorrente) o;
        return idContaCorrente == contaCorrente.idContaCorrente;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "{" +
            " idContaCorrente='" + getIdContaCorrente() + "'" +
            ", idAgencia='" + getIdAgencia() + "'" +
            ", contaCorrenteNumero='" + getContaCorrenteNumero() + "'" +
            ", contaCorrenteSaldo='" + getContaCorrenteSaldo() + "'" +
            "}";
    }

    
}
