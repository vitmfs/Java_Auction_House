package leiloreira;

import java.time.LocalDateTime;

public class Licitacao {
	
	private Leilao leilao;
	private Cliente cliente;
	private double valor;
	private LocalDateTime dataHora;
	private Licitacao proxLicitacao;
	
	public Licitacao(Leilao leilaoT, Cliente clienteT, double valorT) {
		
		leilao = leilaoT;
		cliente = clienteT;
		valor = valorT;
		dataHora = LocalDateTime.now();
		proxLicitacao = null;
		
		
	}

	public Licitacao getProxLicitacao() {
		return proxLicitacao;
	}

	public void setProxLicitacao(Licitacao proxLicitacao) {
		this.proxLicitacao = proxLicitacao;
	}

	

	@Override
	public String toString() {
		return "Licitação [" + leilao.getItemLeiloado().getNomeItem() + ", " + valor + " euros, por: " + cliente.getNomeCliente()  + ", em " + dataHora + "]";
	}

	public Leilao getLeilao() {
		return leilao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public double getValor() {
		return valor;
	}


	public LocalDateTime getDataHora() {
		return dataHora;
	}


}
