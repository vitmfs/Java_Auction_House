package leiloreira;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Scanner;

public class MainLeiloeira {
	
	public static void main(String[] args) {
		
		Leiloeira leiloeira = new Leiloeira();
		leiloeira.inserirDadosTeste();
		
		System.out.println("Bem-vindo ao programa de gestão de leilões!");
		
		Scanner scanner = new Scanner(System.in);
		
		Cliente clienteAtual = login(leiloeira);
		
		System.out.println("Bem-vindo " + clienteAtual);
		
		System.out.println("**************************************************************************************************");
		
		//leiloeira.imprimirClientes();
		
		
		
		
		
		
		int opcaoEscolhida = 0;
		
		
		do {
			
			try {
				
				imprimeOpcoes();
				opcaoEscolhida = Integer.parseInt(scanner.next());
				
				
			} catch (Exception e) {
				
				opcaoEscolhida = 999;
				System.out.println("Tem de escolher uma opção válida!");
				
			}
			
			
		} while (opcaoEscolhida != 1 &&
				opcaoEscolhida != 2 &&
				opcaoEscolhida != 3 &&
				opcaoEscolhida != 0);
		
		
		
		
		while (opcaoEscolhida != 0) {
			
			
			
			switch (opcaoEscolhida) {
			
				case 1:
					System.out.println("Leilões disponíveis: ");
					leiloeira.imprimirClientes();
					break;
					
				case 2:
					System.out.println("Licitar no leilão de que Item? ");
					String itemAlicitar = scanner.next();
					scanner.nextLine();
					
					Leilao leilaoALicitar = leiloeira.procurarLeilao(itemAlicitar);;
					
					if (leilaoALicitar != null) {
						
						System.out.println("Vai licitar em: " + leilaoALicitar);
						
					} else {
						
						System.out.println("Esse leilão não existe!");
					}
					
					System.out.print("Insira o valor da licitação:");
					
					double valorLicitado = Double.parseDouble(scanner.next());
					
					leilaoALicitar.inserirNovaLicitacaoPush(new Licitacao(leilaoALicitar, clienteAtual, valorLicitado));
					
					if (valorLicitado >= leilaoALicitar.getValorCompraImediata()) {
						
						leilaoALicitar.setArrebatadoPor(clienteAtual);
						System.out.println("Arrebatado por " + clienteAtual.getNomeCliente());
						System.out.println(leilaoALicitar);
						
					}
					
					//leiloeira.imprimirClientes();
					
					
					break;
					
				case 3:
					System.out.println("Escolheu a opção 3");
					// Item(String nomeItemT, double comprimentoT, double larguraT, double alturaT, String condicaoT, String descricaoT, String tipoT)
					
					
					String nomeDoItem = "";
					System.out.print("Insira o nome do Item a leiloar: ");
					nomeDoItem = scanner.next();
					scanner.nextLine();
					
					double comprimentoDoItem = 0;
					System.out.print("Insira o comprimento do Item a leiloar: ");
					comprimentoDoItem = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					double larguraDoItem = 0;
					System.out.print("Insira a largura do Item a leiloar: ");
					larguraDoItem = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					double alturaDoItem = 0;
					System.out.print("Insira a altura do Item a leiloar: ");
					alturaDoItem = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					String condicaoDoItem = "";
					System.out.print("Insira a condição do Item a leiloar: ");
					condicaoDoItem = scanner.next();
					scanner.nextLine();
					
					String descricaoDoItem = "";
					System.out.print("Insira a descrição do Item a leiloar: ");
					descricaoDoItem = scanner.next();
					scanner.nextLine();
					
					String tipoDoItem = "";
					System.out.print("Insira o tipo do Item a leiloar: ");
					tipoDoItem = scanner.next();
					scanner.nextLine();
					
					Item itemACriar = new Item(nomeDoItem, comprimentoDoItem, larguraDoItem, alturaDoItem, condicaoDoItem, descricaoDoItem, tipoDoItem);
					
					// Leilao(Item itemLeiloadoT, int quantidadeT, double valorlicitacaoMinimaT, double valorCompraImediataT, LocalDateTime dataFimLeilaoT)
					
					double valorLicMin = 0;
					System.out.print("Insira o valor de licitação mínima: ");
					valorLicMin = Double.parseDouble(scanner.next());
					
					double valorCompraImediata = 0;
					System.out.print("Insira o valor de compra imediata: ");
					valorCompraImediata = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					String dataFim = "";
					System.out.print("Insira a data limite do leilão (dia/mês/ano): ");
					dataFim = scanner.next();
					scanner.nextLine();
					String[] partesDataFim = dataFim.split("/");
					int anoFim = Integer.parseInt(partesDataFim[2]);
					int mesFim = Integer.parseInt(partesDataFim[1]);
					int diaFim = Integer.parseInt(partesDataFim[0]);
					
					Leilao leilaoACriar = new Leilao(itemACriar, 1, valorLicMin, valorCompraImediata,  LocalDateTime.of(anoFim, mesFim, diaFim, 0, 0, 0));
					
					clienteAtual.inserirLeilaoPush(leilaoACriar);
					
					break;
					
					
				default:
					System.out.println("Não existe essa opção!");
					break;
			
			
			}
			
			
			
			do {
				
				try {
					
					imprimeOpcoes();
					opcaoEscolhida = Integer.parseInt(scanner.next());
					
					
				} catch (Exception e) {
					
					opcaoEscolhida = 999;
					System.out.println("Tem de escolher uma opção válida!");
					
				}
				
				
			} while (opcaoEscolhida != 1 &&
					opcaoEscolhida != 2 &&
					opcaoEscolhida != 3 &&
					opcaoEscolhida != 0);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scanner.close();
		
		System.out.println("Tenha um bom dia! Não se esqueça de nos visitar brevemente!");
		
	}
	
	public static void imprimeOpcoes() {
		
		System.out.println("\n");
		
		System.out.println("1) Ver todos os leilões");
		System.out.println("2) Fazer uma licitação");
		System.out.println("3) Criar um leilão");
		System.out.println("0) Sair");
		
		System.out.println("\n");
		
		System.out.print("Opção escolhida: ");
		
	}
	
	public static Cliente login(Leiloeira leiloeiraT) {
		
		Scanner scanner2 = new Scanner(System.in);
		
		String registadoSimOuNao = "";
		
		Cliente cliente = null;
		
		do {
			
			System.out.print("É um utilizador registado? (S)im (N)ão: ");
			
			registadoSimOuNao = scanner2.next();
			scanner2.nextLine();
			
			
		} while (registadoSimOuNao.toLowerCase().charAt(0) != 's' && registadoSimOuNao.toLowerCase().charAt(0) != 'n');
		
		if (registadoSimOuNao.toLowerCase().charAt(0) == 's') {
			
			String emailInserido = "";
			String passInserida = "";
			
			System.out.print("Insira o seu email: ");
			emailInserido = scanner2.next();
			scanner2.nextLine();
			
			System.out.print("Insira a sua password: ");
			passInserida = scanner2.next(); 
			scanner2.nextLine();
			
			System.out.println("email: " + emailInserido + "pass: " + passInserida);
			
			//System.out.println(leiloeiraT.pesquisarMoverClienteFrente(new Cliente("", LocalDateTime.now(), emailInserido, "")));
			
			cliente = leiloeiraT.pesquisarMoverClienteFrente(new Cliente("", LocalDateTime.now(), emailInserido, ""));
			//System.out.println(cliente);
			
		} else {
			
			System.out.println("Registe-se!");
			
			String nomeInserido = "";
			System.out.print("Insira o seu nome completo: ");
			nomeInserido = scanner2.next();
			scanner2.nextLine();
			
			String dataNascimento = "";
			System.out.print("Insira a sua data de nascimento (dia/mês/ano): ");
			dataNascimento = scanner2.next();
			scanner2.nextLine();
			String[] partesDataNasc = dataNascimento.split("/");
			int anoNasc = Integer.parseInt(partesDataNasc[2]);
			int mesNasc = Integer.parseInt(partesDataNasc[1]);
			int diaNasc = Integer.parseInt(partesDataNasc[0]);
			
			String emailInserido = "";
			String passInserida = "";
			
			System.out.print("Insira o seu email: ");
			emailInserido = scanner2.next();
			scanner2.nextLine();
			
			System.out.print("Insira a sua password: ");
			passInserida = scanner2.next(); 
			scanner2.nextLine();
			
			cliente = new Cliente(nomeInserido, LocalDateTime.of(anoNasc, mesNasc, diaNasc, 0, 0, 0), emailInserido, passInserida);
			
			leiloeiraT.inserirClienteFim(cliente);
			cliente = leiloeiraT.pesquisarMoverClienteFrente(cliente);
			
			//Cliente(String nomeClienteT, LocalDateTime dataDeNascimentoT, String emailClienteT, String passwordT)
			
			
		}
		
		
		//scanner2.close();
		return cliente;
	}
	
	

}



/*
 package leiloreira;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Scanner;

public class MainLeiloeira {
	
	public static void main(String[] args) {
		
		Leiloeira leiloeira = new Leiloeira();
		leiloeira.inserirDadosTeste();
		
		System.out.println("Bem-vindo ao programa de gestão de leilões!");
		
		Scanner scanner = new Scanner(System.in);
		
		Cliente clienteAtual = login(leiloeira);
		
		System.out.println("Bem-vindo " + clienteAtual);
		
		System.out.println("*******************************************************************************************");
		
		//leiloeira.imprimirClientes();
		
		
		
		
		
		
		int opcaoEscolhida = 0;
		
		
		do {
			
			try {
				
				imprimeOpcoes();
				opcaoEscolhida = Integer.parseInt(scanner.next());
				
				
			} catch (Exception e) {
				
				opcaoEscolhida = 999;
				System.out.println("Tem de escolher uma opção válida!");
				
			}
			
			
		} while (opcaoEscolhida != 1 &&
				opcaoEscolhida != 2 &&
				opcaoEscolhida != 3 &&
				opcaoEscolhida != 4 &&
				opcaoEscolhida != 5 &&
				opcaoEscolhida != 6 &&
				opcaoEscolhida != 7 &&
				opcaoEscolhida != 8 &&
				opcaoEscolhida != 9 &&
				opcaoEscolhida != 0);
		
		
		
		
		while (opcaoEscolhida != 0) {
			
			
			
			switch (opcaoEscolhida) {
			
				case 1:
					System.out.println("Leilões disponíveis: ");
					leiloeira.imprimirClientes();
					break;
					
				case 2:
					System.out.println("Licitar no leilão de que Item? ");
					String itemAlicitar = scanner.next();
					scanner.nextLine();
					
					Leilao leilaoALicitar = leiloeira.procurarLeilao(itemAlicitar);;
					
					if (leilaoALicitar != null) {
						
						System.out.println("Vai licitar em: " + leilaoALicitar);
						
					} else {
						
						System.out.println("Esse leilão não existe!");
					}
					
					System.out.print("Insira o valor da licitação:");
					
					double valorLicitado = Double.parseDouble(scanner.next());
					
					leilaoALicitar.inserirNovaLicitacaoPush(new Licitacao(leilaoALicitar, clienteAtual, valorLicitado));
					
					if (valorLicitado >= leilaoALicitar.getValorCompraImediata()) {
						
						leilaoALicitar.setArrebatadoPor(clienteAtual);
						System.out.println("Arrebatado por " + clienteAtual.getNomeCliente());
						System.out.println(leilaoALicitar);
						
					}
					
					//leiloeira.imprimirClientes();
					
					
					break;
					
				case 3:
					System.out.println("Escolheu a opção 3");
					// Item(String nomeItemT, double comprimentoT, double larguraT, double alturaT, String condicaoT, String descricaoT, String tipoT)
					
					
					String nomeDoItem = "";
					System.out.print("Insira o nome do Item a leiloar: ");
					nomeDoItem = scanner.next();
					scanner.nextLine();
					
					double comprimentoDoItem = 0;
					System.out.print("Insira o comprimento do Item a leiloar: ");
					comprimentoDoItem = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					double larguraDoItem = 0;
					System.out.print("Insira a largura do Item a leiloar: ");
					larguraDoItem = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					double alturaDoItem = 0;
					System.out.print("Insira a altura do Item a leiloar: ");
					alturaDoItem = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					String condicaoDoItem = "";
					System.out.print("Insira a condição do Item a leiloar: ");
					condicaoDoItem = scanner.next();
					scanner.nextLine();
					
					String descricaoDoItem = "";
					System.out.print("Insira a descrição do Item a leiloar: ");
					descricaoDoItem = scanner.next();
					scanner.nextLine();
					
					String tipoDoItem = "";
					System.out.print("Insira o tipo do Item a leiloar: ");
					tipoDoItem = scanner.next();
					scanner.nextLine();
					
					Item itemACriar = new Item(nomeDoItem, comprimentoDoItem, larguraDoItem, alturaDoItem, condicaoDoItem, descricaoDoItem, tipoDoItem);
					
					// Leilao(Item itemLeiloadoT, int quantidadeT, double valorlicitacaoMinimaT, double valorCompraImediataT, LocalDateTime dataFimLeilaoT)
					
					double valorLicMin = 0;
					System.out.print("Insira o valor de licitação mínima: ");
					valorLicMin = Double.parseDouble(scanner.next());
					
					double valorCompraImediata = 0;
					System.out.print("Insira o valor de compra imediata: ");
					valorCompraImediata = Double.parseDouble(scanner.next());
					scanner.nextLine();
					
					String dataFim = "";
					System.out.print("Insira a data limite do leilão (dia/mês/ano): ");
					dataFim = scanner.next();
					scanner.nextLine();
					String[] partesDataFim = dataFim.split("/");
					int anoFim = Integer.parseInt(partesDataFim[2]);
					int mesFim = Integer.parseInt(partesDataFim[1]);
					int diaFim = Integer.parseInt(partesDataFim[0]);
					
					Leilao leilaoACriar = new Leilao(itemACriar, 1, valorLicMin, valorCompraImediata,  LocalDateTime.of(anoFim, mesFim, diaFim, 0, 0, 0));
					
					clienteAtual.inserirLeilaoPush(leilaoACriar);
					
					break;
					
				case 4:
					System.out.println("Escolheu a opção 4");
					break;
					
				case 5:
					System.out.println("Escolheu a opção 5");
					break;
					
				case 6:
					System.out.println("Escolheu a opção 6");
					break;
					
				case 7:
					System.out.println("Escolheu a opção 7");
					break;
					
				case 8:
					System.out.println("Escolheu a opção 8");
					break;
					
				case 9:
					System.out.println("Escolheu a opção 9");
					break;
					
				default:
					System.out.println("Não existe essa opção!");
					break;
			
			
			}
			
			
			
			do {
				
				try {
					
					imprimeOpcoes();
					opcaoEscolhida = Integer.parseInt(scanner.next());
					
					
				} catch (Exception e) {
					
					opcaoEscolhida = 999;
					System.out.println("Tem de escolher uma opção válida!");
					
				}
				
				
			} while (opcaoEscolhida != 1 &&
					opcaoEscolhida != 2 &&
					opcaoEscolhida != 3 &&
					opcaoEscolhida != 4 &&
					opcaoEscolhida != 5 &&
					opcaoEscolhida != 6 &&
					opcaoEscolhida != 7 &&
					opcaoEscolhida != 8 &&
					opcaoEscolhida != 9 &&
					opcaoEscolhida != 0);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scanner.close();
		
		System.out.println("Tenha um bom dia! Não se esqueça de nos visitar brevemente!");
		
	}
	
	public static void imprimeOpcoes() {
		
		System.out.println("\n");
		
		System.out.println("1) Ver todos os leilões");
		System.out.println("2) Fazer uma licitação");
		System.out.println("3) Criar um leilão");
		System.out.println("4) Opção 4");
		System.out.println("5) Opção 5");
		System.out.println("6) Opção 6");
		System.out.println("7) Opção 7");
		System.out.println("8) Opção 8");
		System.out.println("9) Opção 9");
		System.out.println("0) Sair");
		
		System.out.println("\n");
		
		System.out.print("Opção escolhida: ");
		
	}
	
	public static Cliente login(Leiloeira leiloeiraT) {
		
		Scanner scanner2 = new Scanner(System.in);
		
		String registadoSimOuNao = "";
		
		Cliente cliente = null;
		
		do {
			
			System.out.print("É um utilizador registado? (S)im (N)ão: ");
			
			registadoSimOuNao = scanner2.next();
			scanner2.nextLine();
			
			
		} while (registadoSimOuNao.toLowerCase().charAt(0) != 's' && registadoSimOuNao.toLowerCase().charAt(0) != 'n');
		
		if (registadoSimOuNao.toLowerCase().charAt(0) == 's') {
			
			String emailInserido = "";
			String passInserida = "";
			
			System.out.print("Insira o seu email: ");
			emailInserido = scanner2.next();
			scanner2.nextLine();
			
			System.out.print("Insira a sua password: ");
			passInserida = scanner2.next(); 
			scanner2.nextLine();
			
			System.out.println("email: " + emailInserido + "pass: " + passInserida);
			
			//System.out.println(leiloeiraT.pesquisarMoverClienteFrente(new Cliente("", LocalDateTime.now(), emailInserido, "")));
			
			cliente = leiloeiraT.pesquisarMoverClienteFrente(new Cliente("", LocalDateTime.now(), emailInserido, ""));
			//System.out.println(cliente);
			
		} else {
			
			System.out.println("Registe-se!");
			
			String nomeInserido = "";
			System.out.print("Insira o seu nome completo: ");
			nomeInserido = scanner2.next();
			scanner2.nextLine();
			
			String dataNascimento = "";
			System.out.print("Insira a sua data de nascimento (dia/mês/ano): ");
			dataNascimento = scanner2.next();
			scanner2.nextLine();
			String[] partesDataNasc = dataNascimento.split("/");
			int anoNasc = Integer.parseInt(partesDataNasc[2]);
			int mesNasc = Integer.parseInt(partesDataNasc[1]);
			int diaNasc = Integer.parseInt(partesDataNasc[0]);
			
			String emailInserido = "";
			String passInserida = "";
			
			System.out.print("Insira o seu email: ");
			emailInserido = scanner2.next();
			scanner2.nextLine();
			
			System.out.print("Insira a sua password: ");
			passInserida = scanner2.next(); 
			scanner2.nextLine();
			
			cliente = new Cliente(nomeInserido, LocalDateTime.of(anoNasc, mesNasc, diaNasc, 0, 0, 0), emailInserido, passInserida);
			
			leiloeiraT.inserirClienteFim(cliente);
			cliente = leiloeiraT.pesquisarMoverClienteFrente(cliente);
			
			//Cliente(String nomeClienteT, LocalDateTime dataDeNascimentoT, String emailClienteT, String passwordT)
			
			
		}
		
		
		//scanner2.close();
		return cliente;
	}
	
	

}


*/
