package br.com.accenture.projetogrupoum.modelo;

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
    private Long IdCliente;

    @Column(nullable = false)
    private String ClienteNome;

    @Column(nullable = false)
    private String ClienteCPF;

    @Column(nullable = false)
    private String ClienteFone;

    @Column(nullable = false)
    private Long IdContaCorrente;

    @Column(nullable = false)
    private Long IdAgencia;

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

}
