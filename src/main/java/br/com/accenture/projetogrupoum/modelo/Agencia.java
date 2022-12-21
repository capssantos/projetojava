package br.com.accenture.projetogrupoum.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_agencia")
    private Long idAgencia;

    @Column(name = "nome_agencia",nullable = false, length = 45)
    private String nomeAgencia;

    @Column(name = "endereco",nullable = false, length = 150)
    private String endereco;

    @Column(name = "telefone",nullable = false, length = 15)
    private String telefone;


    
    public Agencia(){

    }

    @JsonCreator
    public Agencia(@JsonProperty("idAgencia") Long idAgencia, @JsonProperty("nomeAgencia") String nomeAgencia, @JsonProperty("endereco") String endereco, @JsonProperty("telefone") String telefone){
        this.idAgencia = idAgencia;
        this.nomeAgencia = nomeAgencia;
        this.endereco = endereco;
        this.telefone = telefone;
    }


    public Long getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNomeAgencia() {
        return this.nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Agencia)) {
            return false;
        }
        Agencia agencia = (Agencia) o;
        return Objects.equals(idAgencia, agencia.idAgencia);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    

    @Override
    public String toString() {
        return "{" +
            " idAgencia='" + getIdAgencia() + "'" +
            ", nomeAgencia='" + getNomeAgencia() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", telefone='" + getTelefone() + "'" +
            "}";
    }

}
