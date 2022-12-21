package br.com.accenture.projetogrupoum.util;

public enum EnumOperacao {
	SACAR(0, "Saque"), 
	DEPOSITAR(1, "Depósito"), 
	TRANSFERIR(2, "Transferéncia entre contas do mesmo banco"),
	TRANSFERIR_TED(3, "Transferéncia via TED"),
	TRANSFERIR_DOC(4, "Transferéncia via DOC"),
	TRANSFERIR_PIX(5, "Transferéncia via PIX");

	private final int valor;
	private final String descricao;

	EnumOperacao(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return this.valor;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
