package br.com.accenture.projetogrupoum.modelo;

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


}
