package leiloreira;

public class Item {
	
	

	private String nomeItem;
	private double comprimento;
	private double largura;
	private double altura;
	private String condicao;
	private String descricao;
	private String tipo;
	
	public Item(String nomeItemT, double comprimentoT, double larguraT, double alturaT, String condicaoT, String descricaoT, String tipoT) {
		
		nomeItem = nomeItemT;
		comprimento = comprimentoT;
		largura = larguraT;
		altura = alturaT;
		condicao = condicaoT;
		descricao = descricaoT;
		tipo = tipoT;

	}
	
	@Override
	public String toString() {
		return "[" + nomeItem + ", " + comprimento + "x" + largura + "x"
				+ altura + " cm, condição: " + condicao  + ",\n tipo: " + tipo + ", descrição: " + descricao +"]";
	}

	public String getNomeItem() {
		
		return nomeItem;
		
	}

	public void setNomeItem(String nomeItemT) {
		
		nomeItem = nomeItemT;
		
	}

	public double getComprimento() {
		
		return comprimento;
		
	}

	public void setComprimento(double comprimentoT) {
		
		comprimento = comprimentoT;
		
	}

	public double getLargura() {
		
		return largura;
		
	}

	public void setLargura(double larguraT) {
		
		largura = larguraT;
		
	}

	public double getAltura() {
		
		return altura;
		
	}

	public void setAltura(double alturaT) {
		
		altura = alturaT;
		
	}

	public String getCondicao() {
		
		return condicao;
		
	}

	public void setCondicao(String condicaoT) {
		
		condicao = condicaoT;
		
	}

	public String getDescricao() {
		
		return descricao;
		
	}

	public void setDescricao(String descricaoT) {
		
		descricao = descricaoT;
		
	}

	public String getTipo() {
		
		return tipo;
		
	}

	public void setTipo(String tipoT) {
		
		tipo = tipoT;
		
	}
	
	

}

/*
 * @Override
	public String toString() {
		return "Item [Nome do Item: " + nomeItem + ", comprimento: " + comprimento + " cm, largura: " + largura + " cm, altura: "
				+ altura + " cm, condição: " + condicao  + ", tipo: " + tipo + ", descrição: " + descricao +"]";
	}
	*/
