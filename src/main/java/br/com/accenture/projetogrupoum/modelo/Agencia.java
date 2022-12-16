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
@Table(name = "Agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAgencia")
    private Long IdAgencia;

    @Column(name = "NomeAgencia", nullable = false)
    private String NomeAgencia;

    @Column(name = "Endereco", nullable = false)
    private String Endereco;

    @Column(name = "Telefone", nullable = false)
    private String Telefone;

    public Agencia(){

    }

    @JsonCreator
    public Agencia(@JsonProperty("idAgencia") Long IdAgencia, @JsonProperty("nomeAgencia") String NomeAgencia, @JsonProperty("endereco") String Endereco, @JsonProperty("telefone") String Telefone){
        this.IdAgencia = IdAgencia;
        this.NomeAgencia = NomeAgencia;
        this.Endereco = Endereco;
        this.Telefone = Telefone;
    }

    public Long getIdAgencia() {
        return this.IdAgencia;
    }

    public void setIdAgencia(Long IdAgencia) {
        this.IdAgencia = IdAgencia;
    }

    public String getNomeAgencia() {
        return this.NomeAgencia;
    }

    public void setNomeAgencia(String NomeAgencia) {
        this.NomeAgencia = NomeAgencia;
    }

    public String getEndereco() {
        return this.Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return this.Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Agencia)) {
            return false;
        }
        Agencia agencia = (Agencia) o;
        return Objects.equals(IdAgencia, agencia.IdAgencia);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "{" +
            " IdAgencia='" + getIdAgencia() + "'" +
            ", NomeAgencia='" + getNomeAgencia() + "'" +
            ", Endereco='" + getEndereco() + "'" +
            ", Telefone='" + getTelefone() + "'" +
            "}";
    }


}
