package leiloreira;

import java.time.LocalDateTime;

public class Cliente {
	
	private String 			nomeCliente;
	private LocalDateTime 	dataDeNascimento;
	private String 			emailCliente;
	private String 			password;
	private Leilao 			topLeilao;
	private Cliente 		proximoCliente;
	
	public Cliente(	String 			nomeClienteT, 
					LocalDateTime 	dataDeNascimentoT, 
					String 			emailClienteT, 
					String 			passwordT			) {
		
		nomeCliente 		= nomeClienteT;
		dataDeNascimento 	= dataDeNascimentoT;
		emailCliente 		= emailClienteT;
		password 			= passwordT;
		topLeilao 			= null;
		proximoCliente 		= null;
		
	}
	
	public void licitarNoLeilao(	Leilao 	leitaoALicitarT, 
									double 	valorT				) {
		
		leitaoALicitarT.inserirNovaLicitacaoPush( new Licitacao( leitaoALicitarT, this, valorT ) );

	}
	
	
	
	
	
	public void inserirLeilaoPush( Leilao novoLeilaoT ) {
		
		if ( topLeilao == null ) {
			
			topLeilao = novoLeilaoT;
			
		} else {
			
			novoLeilaoT.setProximoLeilao( topLeilao );
			topLeilao = novoLeilaoT;
			
			
		}
		
		
		
	}

	public Leilao 			getTopLeilao() 			{ return topLeilao; 		}
	public Cliente 			getProximoCliente() 	{ return proximoCliente; 	}
	public String 			getNomeCliente() 		{ return nomeCliente; 		}
	public LocalDateTime 	getDataDeNascimento() 	{ return dataDeNascimento; 	}
	public String 			getEmailCliente() 		{ return emailCliente; 		}
	public String 			getPassword() 			{ return password; 			}
	
	public void setTopLeilao( Leilao topLeilao ) {
		
		this.topLeilao = topLeilao;
	}
	

	public void setProximoCliente( Cliente proximoCliente ) {
		
		this.proximoCliente = proximoCliente;
	}
	

	public void setNomeCliente( String nomeCliente ) {
		
		this.nomeCliente = nomeCliente;
	}


	public void setDataDeNascimento( LocalDateTime dataDeNascimento ) {
		
		this.dataDeNascimento = dataDeNascimento;
	}

	
	public void setEmailCliente( String emailCliente ) {
		
		this.emailCliente = emailCliente;
	}

	
	public void setPassword( String password ) {
		
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Cliente [" + nomeCliente + ", Data de Nascimento: " + dataDeNascimento + ", email: "
				+ emailCliente + "]";
	}

	


	
	
	
	
	
	

}
