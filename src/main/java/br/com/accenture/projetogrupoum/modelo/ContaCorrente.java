package br.com.accenture.projetogrupoum.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacorrente")
public class ContaCorrente {

    @Id
    @Column(name = "idContaCorrente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaCorrente;

    @Column(name = "idAgencia", nullable = false)
    private Long idAgencia;

    @Column(name = "contaCorrenteNumero", nullable = false)
    private String contaCorrenteNumero;

    @Column(name = "contaCorrenteSaldo", nullable = false)
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
