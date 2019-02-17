package leiloreira;

import java.time.LocalDateTime;


public class Leiloeira {
	
	private Cliente primCliente;
	
	public Leiloeira() {
		
		primCliente = null;
		
		
	}
	
	public Leilao procurarLeilao(String leilaoComItemALicitarT) {
		
		Cliente tempCliente = primCliente;
		
		while (tempCliente != null) {
			
			//System.out.println(tempCliente);
			
			Leilao tempLeilao = tempCliente.getTopLeilao();
			
			while (tempLeilao != null) {
				
				//System.out.println(tempLeilao);
				
				if (tempLeilao.getItemLeiloado().getNomeItem().toLowerCase().contains(leilaoComItemALicitarT.toLowerCase())) {
					
					//System.out.println(tempLeilao);
					pesquisarMoverClienteFrente(tempCliente);
					return tempLeilao;
				}
				
				tempLeilao = tempLeilao.getProximoLeilao();
			}
			
			tempCliente = tempCliente.getProximoCliente();
		}
		
		
		
		
		return null;
	}
	
	public void inserirDadosTeste() {
		
		Cliente ana = new Cliente("Ana Anastácio", LocalDateTime.now(), "ana@gmail.com", "aaaaa");
		Cliente beta = new Cliente("Beta Bizantino", LocalDateTime.now(), "beta@gmail.com", "bbbbb");
		Cliente carla = new Cliente("Carla Castro", LocalDateTime.now(), "carla@gmail.com", "ccccc");
		Cliente daniel = new Cliente("Daniel Dias", LocalDateTime.now(), "novo@gmail.com", "ddddd");
		Cliente elisa = new Cliente("Elisa Elos", LocalDateTime.now(), "eliza@gmail.com", "eeeee");
		
		this.inserirClienteFim(ana);
		this.inserirClienteFim(beta);
		this.inserirClienteFim(carla);
		this.inserirClienteFim(daniel);
		this.inserirClienteFim(elisa);
		
		this.pesquisarMoverClienteFrente(elisa);
		this.pesquisarMoverClienteFrente(daniel);
		this.pesquisarMoverClienteFrente(carla);
		
		Cliente marta = new Cliente("Marta Matias", LocalDateTime.now(), "marta@gmail.com", "mmmmm");
		this.inserirClienteFim(marta);
		
		Item livroC = new Item("Linguagem C por Luís Damas", 21.0, 15.5, 2.3, "Bom estado", "Um livro acerca de programação C", "livro");
		Item spaceEmpiresIV = new Item("Space Empires IV", 17.0, 12.3, 2.0, "Bom estado", "Um jogo de estratégia de PC", "jogo");
		Item telemovel = new Item("Samsung Galaxy Note 7", 13.0, 8.2, 1.5, "Bom estado", "Telemóvel topo de gama", "telemóvel");
		Item portatil = new Item("Potátil Compaq", 31.0, 21.2, 3, "Bom estado", "Computador Portátil com 5 anos", "computador");
		Item camisola = new Item("Camisola da lã", 100, 70.6, 5, "Bom estado", "Camisola vermelha de Natal", "roupa");
		Item cadeira = new Item("Cadeira Clássica", 45, 50, 90, "Médio estado", "Cadeira de madeira clássica", "mobília");
		
		
		Leilao leilao01 = new Leilao(livroC, 1, 5, 20, LocalDateTime.of(2016, 12, 30, 12, 0, 0));
		Leilao leilao02 = new Leilao(spaceEmpiresIV, 1, 3, 15, LocalDateTime.of(2016, 12, 30, 12, 0, 0));
		Leilao leilao03 = new Leilao(telemovel, 1, 100, 200, LocalDateTime.of(2016, 12, 30, 12, 0, 0));
		
		Leilao leilao04 = new Leilao(portatil, 1, 500, 1000, LocalDateTime.of(2016, 12, 30, 12, 0, 0));
		Leilao leilao05 = new Leilao(camisola, 1, 20, 50, LocalDateTime.of(2016, 12, 30, 12, 0, 0));
		Leilao leilao06 = new Leilao(cadeira, 1, 10, 30, LocalDateTime.of(2016, 12, 30, 12, 0, 0));
		
		carla.inserirLeilaoPush(leilao01);
		carla.inserirLeilaoPush(leilao02);
		carla.inserirLeilaoPush(leilao03);
		
		marta.inserirLeilaoPush(leilao04);
		marta.inserirLeilaoPush(leilao05);
		
		elisa.inserirLeilaoPush(leilao06);
		
		
		ana.licitarNoLeilao(leilao03, 100);
		elisa.licitarNoLeilao(leilao03, 120);
		daniel.licitarNoLeilao(leilao03, 170);
		
		
		//this.imprimirClientes();
		System.out.println("\n");
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public Cliente pesquisarMoverClienteFrente(Cliente clienteAPesquisarT) {
		
		Cliente clienteAMover;
		
		
		if( primCliente == null) {
			
			return null;
			
		} else if ( primCliente.getNomeCliente().toLowerCase().equals(clienteAPesquisarT.getNomeCliente().toLowerCase()) && 
				primCliente.getEmailCliente().equals(clienteAPesquisarT.getEmailCliente())) {
			
			return primCliente;
			
		} else {
			
			Cliente tempCliente = primCliente.getProximoCliente();
			
			Cliente anteriorCliente = primCliente;
			
			while( tempCliente != null && 
					( !tempCliente.getNomeCliente().equalsIgnoreCase(clienteAPesquisarT.getNomeCliente()) && !tempCliente.getEmailCliente().equalsIgnoreCase(clienteAPesquisarT.getEmailCliente()) ))  {
				
				anteriorCliente = tempCliente;
				tempCliente = tempCliente.getProximoCliente();
			}
			
			if (tempCliente == null) {
				
				return null;
			} else {
				
				clienteAMover = tempCliente;
				anteriorCliente.setProximoCliente(tempCliente.getProximoCliente());
				clienteAMover.setProximoCliente(primCliente);
				primCliente = clienteAMover;
				
				return primCliente;
				
				
			}
			
			
		}

		
	}
	
	public void imprimirClientes() {
		
		Cliente tempCliente = primCliente;
		
		while (tempCliente != null) {
			
			//System.out.println(tempCliente);
			
			Leilao tempLeilao = tempCliente.getTopLeilao();
			
			while (tempLeilao != null) {
				
				System.out.println("\n");
				System.out.println(tempLeilao);
				
				Licitacao tempLicitacao = tempLeilao.getTopLicitacao();
				
				while (tempLicitacao != null) {
					
					System.out.println(tempLicitacao);
					
					tempLicitacao = tempLicitacao.getProxLicitacao();
					
					
				}
				
				
				tempLeilao = tempLeilao.getProximoLeilao();
				
				
			}
			
			tempCliente = tempCliente.getProximoCliente();
			
		}
		
		
		
		
	}
	
	public void inserirClienteFim(Cliente novoClienteT) {
		
		if (primCliente == null) {
			
			primCliente = novoClienteT;
			
		} else {
			
			Cliente tempCliente = primCliente;
			
			while (tempCliente.getProximoCliente() != null) {
				
				tempCliente = tempCliente.getProximoCliente();
				
			}
			
			tempCliente.setProximoCliente(novoClienteT);
			
			
			
			
		}
		
	}

	public Cliente getPrimCliente() {
		return primCliente;
	}

	public void setPrimCliente(Cliente primCliente) {
		this.primCliente = primCliente;
	}

}

/*
 * public Cliente pesquisarMoverClienteFrente(Cliente clienteAPesquisarT) {
		
		Cliente clienteAMover;
		
		
		if( primCliente == null) {
			
			return null;
			
		} else if ( primCliente.getNomeCliente().toLowerCase().equals(clienteAPesquisarT.getNomeCliente().toLowerCase()) && 
				primCliente.getEmailCliente().equals(clienteAPesquisarT.getEmailCliente())) {
			
			return primCliente;
			
		} else {
			
			Cliente tempCliente = primCliente.getProximoCliente();
			
			Cliente anteriorCliente = primCliente;
			
			while( tempCliente != null && 
					( !tempCliente.getNomeCliente().equalsIgnoreCase(clienteAPesquisarT.getNomeCliente()) && !tempCliente.getEmailCliente().equalsIgnoreCase(clienteAPesquisarT.getEmailCliente()) ))  {
				
				anteriorCliente = tempCliente;
				tempCliente = tempCliente.getProximoCliente();
			}
			
			if (tempCliente == null) {
				
				return null;
			} else {
				
				clienteAMover = tempCliente;
				anteriorCliente.setProximoCliente(tempCliente.getProximoCliente());
				clienteAMover.setProximoCliente(primCliente);
				primCliente = clienteAMover;
				
				return primCliente;
				
				
			}
			
			
		}

		
	}
	*/
