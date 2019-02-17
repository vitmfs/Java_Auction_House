package leiloreira;

import java.time.LocalDateTime;

public class Leilao {
	
	private Item itemLeiloado;
	private int quantidade;
	private double valorlicitacaoMinima;
	private double valorCompraImediata;
	private LocalDateTime dataInicioLeilao;
	private LocalDateTime dataFimLeilao;
	private Cliente arrebatadoPor;
	private Licitacao topLicitacao;
	private Leilao proximoLeilao;
	
	public Leilao(Item itemLeiloadoT, int quantidadeT, double valorlicitacaoMinimaT, double valorCompraImediataT, LocalDateTime dataFimLeilaoT) {
		
		
		itemLeiloado = itemLeiloadoT;
		quantidade = quantidadeT;
		valorlicitacaoMinima = valorlicitacaoMinimaT;
		valorCompraImediata = valorCompraImediataT;
		dataInicioLeilao = LocalDateTime.now();
		dataFimLeilao = dataFimLeilaoT;
		arrebatadoPor = null;
		topLicitacao = null;
		proximoLeilao = null;
		
		
		
	}
	
	public void inserirNovaLicitacaoPush(Licitacao licitacaoT) {
		
		if(topLicitacao == null) {
			
			topLicitacao = licitacaoT;
			
			
		} else {
			
			if (licitacaoT.getValor() > topLicitacao.getValor() && licitacaoT.getValor() >= valorlicitacaoMinima) {
				
				licitacaoT.setProxLicitacao(topLicitacao);
				topLicitacao = licitacaoT;
				
				
			} else {
				
				System.out.println("O valor da nova licitação tem de ser maior do que " + topLicitacao.getValor() + " euros.");
				
				
			}
			
			
			
		}
		
		
		
		
		
	}

	public Licitacao getTopLicitacao() {
		return topLicitacao;
	}

	public void setTopLicitacao(Licitacao topLicitacao) {
		this.topLicitacao = topLicitacao;
	}

	@Override
	public String toString() {
		return "Leilao [" + itemLeiloado + ",\n quantidade: " + quantidade + ", licitação mínima: "
				+ valorlicitacaoMinima + " euros, Compra Imediata: " + valorCompraImediata + 
				", acaba a: " + dataFimLeilao + ", Arrebatado por: " + arrebatadoPor + "]";
	}

	public Leilao getProximoLeilao() {
		return proximoLeilao;
	}

	public void setProximoLeilao(Leilao proximoLeilao) {
		this.proximoLeilao = proximoLeilao;
	}

	public Item getItemLeiloado() {
		return itemLeiloado;
	}

	public void setItemLeiloado(Item itemLeiloado) {
		this.itemLeiloado = itemLeiloado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorlicitacaoMinima() {
		return valorlicitacaoMinima;
	}

	public void setValorlicitacaoMinima(double valorlicitacaoMinima) {
		this.valorlicitacaoMinima = valorlicitacaoMinima;
	}

	public double getValorCompraImediata() {
		return valorCompraImediata;
	}

	public void setValorCompraImediata(double valorCompraImediata) {
		this.valorCompraImediata = valorCompraImediata;
	}

	public LocalDateTime getDataInicioLeilao() {
		return dataInicioLeilao;
	}

	public void setDataInicioLeilao(LocalDateTime dataInicioLeilao) {
		this.dataInicioLeilao = dataInicioLeilao;
	}

	public LocalDateTime getDataFimLeilao() {
		return dataFimLeilao;
	}

	public void setDataFimLeilao(LocalDateTime dataFimLeilao) {
		this.dataFimLeilao = dataFimLeilao;
	}

	public Cliente getArrebatadoPor() {
		return arrebatadoPor;
	}

	public void setArrebatadoPor(Cliente arrebatadoPor) {
		this.arrebatadoPor = arrebatadoPor;
	}
	

}
