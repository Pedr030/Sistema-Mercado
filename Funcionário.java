package trabalho;

import java.util.*;

public class Funcionário {
	private String id,senha,cargo,nome,email;
	private double salario;
	private Map <String, String> cadastro = new HashMap<String, String>();
	
	//Função que valida o accesso do usuário, Usando a estrutura HashMap para armazenar os Ids e Senhas
	public static String Login(Map <String, String> cadastro, String id, String senha) {
		//Verificando se o ID informado pelo usuário está presente nos dados
		if(cadastro.containsKey(id)) {
			// Verificando se a senha informada pelo usuario, corresponde a senha atrelada ao ID
			if(cadastro.get(id).equals(senha) ) {	
				return "Acesso Permitido";
			}
		}
		return "Acesso Negado";
	}
	
	//Construtor
	public Funcionário(String nome, String cargo, String id, String senha, String email,double salario){
		this.cargo = cargo;
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.senha = senha;
		this.email = email;
	}
	//Função que permite realizar o cadastro de funcionários
	public static void Cadastrar_funcionario(Funcionário funcionario, ArrayList<Funcionário> lista, Map<String,String> cadastro) {
		lista.add(funcionario);
		cadastro.put(funcionario.getId(), funcionario.getSenha());
	}
	//Função que permite mudar os dados do funcionário
	public static void Atualizar_funcionario(ArrayList<Funcionário> lista, String nome, String id, int acao, Object novo_dado){
		boolean encontrado = false;
		if (acao == 1){
			for(int i=0; i <lista.size(); i++){
				if (lista.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) && lista.get(i).getId().equals(id)){
					Funcionário funcionário = lista.get(i);
					switch (acao) {
						case 1:
							funcionário.setEmail((String)novo_dado);
							System.out.println("\nEmail alterado com sucesso!");
							encontrado = true;
						break;
						default:
						System.out.println("\nNão foi possivel alterar os dados, verifique se o formulário foi preenchido corretamente");
							break;
					}
				}
			}
		}
		//Função para mudar o cargo
		else if (acao == 2) {
			for(int i=0; i <lista.size(); i++){
				if (lista.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) && lista.get(i).getId().equals(id)){
					Funcionário funcionário = lista.get(i);
					switch (acao) {
						case 2:
							funcionário.setCargo((String)novo_dado);
							System.out.println("\nCargo alterado com sucesso!");
							encontrado = true;
						break;
						default:
						System.out.println("\nNão foi possivel alterar os dados, verifique se o formulário foi preenchido corretamente");
							break;
		}
	}
	}
}
		
		//Função para mudar salário
	else if (acao == 3) {
		for(int i=0; i <lista.size(); i++){
			if (lista.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) && lista.get(i).getId().equals(id)){
				Funcionário funcionário = lista.get(i);
				switch (acao) {
					case 3:
						funcionário.setSalario((double) novo_dado);;
						System.out.println("\nSalário alterado com sucesso!");
						encontrado = true;
					break;
					default:
					System.out.println("Não foi possivel alterar os dados, verifique se o formulário foi preenchido corretamente");
						break;
				}
			}
		}
	}
	else{
		System.out.println("Comando Inválido!");
	}
	if(encontrado == false){
		System.out.println("\n\tNão foi possivel encontrar nenhum funcionário com esta combinação de Nome e ID na base de dados!");
	}
	}
	
	//Função para remover funcionários
	public static void Remover_funcionario(ArrayList<Funcionário> lista,Map<String, String>cadastro, String nome, String id){
		boolean encontrado = false;
		for (int i=0; i < lista.size(); i++){
			if(lista.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) && lista.get(i).getId().equals(id)){
				lista.remove(i);
				cadastro.remove(id);
				System.out.println("\n\tFuncionário removido com sucesso!");
				encontrado = true;
				break;
			}
			
		}
		if(encontrado == false){
			System.out.println("\n\tNão foi possivel encontrar nenhum funcionário com esta combinação de Nome e ID na base de dados!");
		}
	}
	
	//Função para exibir a lista de funcionários
	public static void Exibir_funcionarios(ArrayList<Funcionário> lista){
		System.out.println();
		System.out.println("Nome | Cargo | ID | E-mail | Salário");
		for(int i=0; i<lista.size(); i++){
			Funcionário funcionario = lista.get(i);
			System.out.print(funcionario.getNome() + " | ");
			System.out.print(funcionario.getCargo() + " | ");
			System.out.print(funcionario.getId() + " | ");
			System.out.print(funcionario.getEmail() + " | ");
			System.out.print(funcionario.getSalario() + " | ");
			System.out.println();
		}
	}
	// Gets e Sets
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Map<String, String> getCadastro() {
		return cadastro;
	}

	public void setCadastro(Map<String, String> cadastro) {
		this.cadastro = cadastro;
	}
}
			
