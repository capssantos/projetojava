package br.com.accenture.projetogrupoum.modelo;

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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.accenture.projetogrupoum.excecao.DepositoInvalidoException;
import br.com.accenture.projetogrupoum.excecao.EstouroSaqueException;


@Entity
@Table(name = "conta_corrente")
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta_corrente")
    private Long idContaCorrente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_agencia")
    private Agencia idAgencia;

    @Column(name = "conta_corrente_numero",nullable = false, length = 7)
    private String contaCorrenteNumero;

    @Column(name = "saldo",nullable = false)
    private Double saldo;

    public ContaCorrente(){

    }
    
    @JsonCreator
    public ContaCorrente(@JsonProperty("idContaCorrente") Long idContaCorrente, @JsonProperty("idAgencia") Agencia idAgencia,  @JsonProperty("contaCorrenteNumero") String contaCorrenteNumero,  @JsonProperty("saldo") Double saldo ){

        this.idContaCorrente = idContaCorrente;
        this.idAgencia = idAgencia;
        this.contaCorrenteNumero = contaCorrenteNumero;
        this.saldo = saldo;
    }

    public Long getIdContaCorrente() {
        return this.idContaCorrente;
    }

    public void setIdContaCorrente(Long idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Agencia getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(Agencia idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getContaCorrenteNumero() {
        return this.contaCorrenteNumero;
    }

    public void setContaCorrenteNumero(String contaCorrenteNumero) {
        this.contaCorrenteNumero = contaCorrenteNumero;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContaCorrente)) {
            return false;
        }
        ContaCorrente contaCorrente = (ContaCorrente) o;
        return Objects.equals(idContaCorrente, contaCorrente.idContaCorrente);
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
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

    
    public void Depositar(Double valor) throws DepositoInvalidoException {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito de R$ " + valor + " na conta " + this.contaCorrenteNumero);			
		} else {
			throw new DepositoInvalidoException("Este valor é negativo: " + valor);
		}		
	}

	public void Sacar(Double valor) throws EstouroSaqueException {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Saque de R$ " + valor + " da conta " + this.contaCorrenteNumero);
			
		} else {
			throw new EstouroSaqueException("Não tem saldo suficiente para completar essa transação!");
		}
	}
	
	public void Transferir(ContaCorrente destino, Double valor) throws EstouroSaqueException, DepositoInvalidoException {
		System.out.println("Transferindo R$ " + valor + " da conta " + this.contaCorrenteNumero + " para a conta " + destino.getContaCorrenteNumero());

		try {
			this.Sacar(valor);
			destino.Depositar(valor);
		} catch (EstouroSaqueException e1) {
			//e1.printStackTrace();
			System.out.println("EstouroSaqueException = " + e1.getMessage());
			throw e1;
		} catch (DepositoInvalidoException e2) {
			//e2.printStackTrace();
			System.out.println("DepositoInvalidoException = " + e2.getMessage());
			// defazer o saque origem(this)
			this.Depositar(valor);
			throw e2;
		} 
	}

}
