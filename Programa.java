package trabalho;

import java.util.*;

public class Programa {

	public static void main(String[] args) {
		//dando o tipo adequado para os atributos que serão utilizados 
		double preco, peso, salario;
		String nome, marca, cargo,email,id,senha;
		int acao, qtde_produtos;
		//Criação de estruturas de dados utilizadas para armazenar os objetos
		Scanner sc = new Scanner(System.in);
		Map <String, String> cadastro = new HashMap<String, String>();
		ArrayList<Funcionário> lista_funcionários = new ArrayList<Funcionário>();
		ArrayList<Produtos> estoque = new ArrayList<Produtos>();
		
		//Criando e cadastrando os funcionários
		Funcionário funcionario1 = new Funcionário("Pedro", "Gerente", "9846", "2", "pedro@gmail.com",3000);
		Funcionário funcionario2 = new Funcionário("Felipe", "Gerente", "9845", "190506", "felipe@gmail.com",2950);
		Funcionário funcionário3 = new Funcionário("Celso", "Caixa", "12", "190506", "celso@gmail.com", 2000);
		Funcionário funcionário4 = new Funcionário("Victor", "Segurança", "1", "2", "victor@gmail.com", 2300);
		Funcionário funcionário5 = new Funcionário("Mateus", "Caixa", "3", "4", "mateus@gmail.com", 2000);
		Funcionário funcionário6 = new Funcionário("Jorge", "Repositor", "12345", "54321", "jorge@gmail.com", 2300);
		Funcionário.Cadastrar_funcionario(funcionario1, lista_funcionários, cadastro);
		Funcionário.Cadastrar_funcionario(funcionario2, lista_funcionários, cadastro);
		Funcionário.Cadastrar_funcionario(funcionário3, lista_funcionários, cadastro);
		Funcionário.Cadastrar_funcionario(funcionário4, lista_funcionários, cadastro);
		Funcionário.Cadastrar_funcionario(funcionário5, lista_funcionários, cadastro);
		Funcionário.Cadastrar_funcionario(funcionário6, lista_funcionários, cadastro);
		
		// Criando e cadastrando alguns produtos para teste
		Produtos produto1 = new Produtos("Picanha", "Friboi", 40, 1, 50);
		Produtos produto2 = new Produtos("Fraldinha", "Friboi", 32, 1, 50);
		Produtos produto3 = new Produtos("Coca-Cola", "Coca", 7, 2, 100);
		Produtos.Cadastrar_produto(estoque, produto1);
		Produtos.Cadastrar_produto(estoque, produto2);
		Produtos.Cadastrar_produto(estoque, produto3);
		
		//Função para realizar a validação de login
		System.out.print("Insira seu ID de login: ");
		id = sc.next();
		System.out.print("\nInsira a sua senha: ");
		senha = sc.next();
		String login = Funcionário.Login(cadastro,id,senha);
		
		System.out.println("\n\t"+login+"\n___________________________________");
		//Execução do programa de controle de estoque, caso o acesso seja validado, de acordo com o retorno da função login
		if(login.equals("Acesso Permitido")) {
			
			//Usuário deve escolher uma das opções de continuidade 
			do {
				System.out.print("\nInsira a ação que deseja realizar\n(1)Gerenciar estoque\n(2)Gerenciar cadastro de funcionários\n(3)Sair: ");
				acao = sc.nextInt();
				System.out.println("________________________________________________________");
				switch (acao) {
					//Entrando na parte de controle de estoque	
				case 1:
					do {
						System.out.print("\nInsira a ação que deseja realizar\n(1)Cadastrar produto\n(2)Atualizar quantidade\n(3)Remover produto do estoque\n(4)Exibir estoque\n(5)Sair: ");
						acao = sc.nextInt();
						System.out.println("________________________________________________________");
						//cadrastrando produtos
						switch (acao) {
							case 1:
							System.out.print("\nInsira o nome do produto: ");
							nome = sc.next();
							System.out.print("Insira a marca do produto: ");
							marca = sc.next();
							System.out.print("Insira o preço do produto: ");
							preco = sc.nextDouble();
							System.out.print("Insira o peso(KG)/litros(L) do produto: ");
							peso = sc.nextDouble();
							System.out.print("Insira quantas unidades do produto estão em estoque: ");
							qtde_produtos = sc.nextInt();
							Produtos produto = new Produtos(nome, marca, preco, peso, qtde_produtos);
							Produtos.Cadastrar_produto(estoque, produto);
							System.out.println("________________________________________________________");
								break;
							//atualizar quantidades de cada produto
							case 2:
							System.out.print("\n(1)Registrar chegada de produtos\n(2)Registrar saída de produtos: ");
							acao = sc.nextInt();
							System.out.println("________________________________________________________");
								//produto ainda em estoque que chega uma nova remessa
							if (acao == 1) {
								System.out.print("\nInsira o nome do produto que deseja registrar a chegada de remessa: ");
								nome = sc.next();
								System.out.print("Insira a marca do produto: ");
								marca = sc.next();
								System.out.print("Insira o total de novas unidades: ");
								int remessa = sc.nextInt(); 
								Produtos.Atualizar_estoque(estoque, nome, marca, acao, remessa);
								System.out.println("________________________________________________________");
								} 
							//produto que é retirado
								else if (acao == 2) {
								System.out.print("\nInsira o nome do produto que deseja realizar baixar no sistema: ");
								nome = sc.next();
								System.out.print("Insira a marca do produto: ");
								marca = sc.next();
								System.out.print("Insira o total de saídas: ");
								int remessa = sc.nextInt();
								Produtos.Atualizar_estoque(estoque, nome, marca, acao, remessa);
								System.out.println("________________________________________________________");
								}
								else{
									System.out.println("Comando Inválido, Tente Novamente!");
								}
								break;
							//caso queira remover produto
							case 3:
							System.out.println();
							System.out.print("Insira o nome do produto que deseja remover do banco de dados: ");
							nome = sc.next();
							System.out.print("Insira a marca do produto: ");
							marca = sc.next();
							System.out.print("\nTem certeza que deseja remover este item\n(S)Sim\n(N)Não:");
							String confirmacao = sc.next();
							if(confirmacao.toUpperCase().equals("S")){
								Produtos.Remover_produto(estoque, nome, marca);
							}
							else if (confirmacao.toUpperCase().equals("N")) {
								System.out.println("\nRemoção cancelada!");
							}
							else{
								System.out.println("Comando Inválido, tente novamente!");
							}
							System.out.println("________________________________________________________");
							break;
							
							//exibir estoque
							case 4:
							Produtos.Exibir_estoque(estoque);
							System.out.println("________________________________________________________");
							break;

							case 5:
							break;
							default:
								//caso digite valor inválido
							System.out.println("\n\tComando Inválido, Tente novamente!");
							System.out.println("________________________________________________________");
								break;
							}
						
							}
					//fazendo com que o código rode enquanto o valor da acao for 5(botão de sair)
					while (acao!=5); 
						break;
				//Acessar a área de controle de funcionários	
				case 2:
					do {
						System.out.print("\nInsira a ação que deseja realizar\n(1)Cadastrar Funcionário\n(2)Atualizar dados de funcionário\n(3)Remover Funcionário\n(4)Exibir relação de funcionários\n(5)Sair: ");
						acao = sc.nextInt();
						System.out.println("________________________________________________________");
						switch (acao) {
							//Cadastrando funcionários
						case 1:
						System.out.print("\nInsira o nome do funcionário: ");
						nome = sc.next();
						System.out.print("\nInsira o cargo do funcionário: ");
						cargo = sc.next();
						System.out.print("\nInsira o ID do funcionário: ");
						id = sc.next();
						System.out.print("\nInsira a senha do funcionário: ");
						senha = sc.next();
						System.out.print("\nInsira o E-mail do funcionário: ");
						email = sc.next();
						System.out.print("\nInsira o salário do funcionário: ");
						salario = sc.nextDouble();
						Funcionário funcionario = new Funcionário(nome, cargo, id, senha, email, salario);
						Funcionário.Cadastrar_funcionario(funcionario, lista_funcionários, cadastro);
						System.out.println("________________________________________________________");
							break;
						//Modificando dados de funcionários 
						case 2:
						Object novo_dado;
						System.out.print("Insira qual dos dados deseja atualizar\n(1)E-mail\n(2)Cargo\n(3)Salário:");
						acao = sc.nextInt();
						if (acao <= 0 || acao > 3){
							System.out.println("\nComando Inválido!");
							novo_dado = null;
							break;
						}
						System.out.print("\nInsira o nome do Funcionário que deseja alterar os dados: ");
						nome = sc.next();
						System.out.print("\nInsira o ID do funcionário: " );
						id = sc.next();
						//caso for email
						if (acao == 1 ) {
							System.out.print("\nInsira o novo E-mail: ");
							novo_dado = sc.next();	
						}
						//caso for cargo
						else if(acao == 2){
							System.out.print("\nInsira o novo cargo: ");
							novo_dado = sc.next();
						}
						//caso for salário
						else if (acao == 3) {
							System.out.print("\nInsira o novo salário: ");
							novo_dado = sc.nextDouble();
						}
						//caso não escolha uma das opções anteriores
						else{
							novo_dado = null;
						}
						 
						Funcionário.Atualizar_funcionario(lista_funcionários, nome, id, acao, novo_dado);
						System.out.println("________________________________________________________");
						break;
						
						case 3:
						System.out.println("\n\t***FUNÇÃO PERMITIDA SOMENTE PARA GERENTES***\n");
						System.out.print("Insira seu ID de login: ");
						id = sc.next();
						System.out.print("\nInsira a sua senha: ");
						senha = sc.next();
						login = Funcionário.Login(cadastro,id,senha);
		
						System.out.println("\n\t"+login+"\n___________________________________");
						//Condicional que verifica se o ID corresponde a um ID de gerente, por meio do inicio do ID, que é padrão para todos os gerentes
						if(id.startsWith("984")){
							if(login.equals("Acesso Permitido")){
								System.out.print("\nInsira o nome do funcionário que deseja remover do sistema: ");
								nome = sc.next();
								System.out.print("Insira o ID do funcionário: ");
								id = sc.next();
								Funcionário.Remover_funcionario(lista_funcionários, cadastro, nome, id);
						}
							else{
								System.out.println("\n\tAcesso Negado!\n___________________________________");
						}
						}
						//Caso não corresponda, o usuário sera avisado que este ID não é válido para acesso
						else{
							System.out.println("\nSeu ID não pertence ao cargo de Gerente! Portanto não é possível acessar esta função!");
						}
						
						System.out.println("________________________________________________________");
						break;
						//Exibindo a lista de funcionários
						case 4:
						Funcionário.Exibir_funcionarios(lista_funcionários);
						System.out.println("________________________________________________________");
						break;
						case 5:
						break;
						//Caso o usuário insira um número que não corresponde a nenhuma das teclas de ação
						default: 
						System.out.println("\nComando Inválido, Tente Novamente!");
						System.out.println("________________________________________________________");
							break;
					}
						
					} while (acao != 5);
					case 3:
					break;
					default:
					System.out.println("\nComando Inválido, Tente Novamente!");
						System.out.println("________________________________________________________");
							break;
				}
			} while (acao !=3);
		}
		
		sc.close();
	}

}
