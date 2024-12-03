package trabalho;


import java.util.*;

public class Produtos{
	private double  preco, peso;
	private String nome, marca;
	private int qtde_produtos;
	
	//construtor
	public Produtos(String nome,String marca, double preco, double peso, int qtde_produtos) {
		this.marca = marca;
		this.nome = nome;
		this.peso = peso;
		this.preco = preco;
		this.qtde_produtos = qtde_produtos;
	}
	//Função para cadastrar produtos
	public static void Cadastrar_produto(ArrayList<Produtos> estoque, Produtos produto){
		estoque.add(produto);
	} 
	
	//Função para reallizar a atualização de estoque
	public static void Atualizar_estoque(ArrayList<Produtos> estoque, String nome, String marca, int acao, int remessa){
		//chegada de produtos
		if(acao == 1){
			for(int i=0; i< estoque.size(); i++){
				if (estoque.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) && estoque.get(i).getMarca().toLowerCase().equals(marca.toLowerCase())){
					Produtos produto = estoque.get(i);
					produto.setQtde_produtos(produto.getQtde_produtos() + remessa);
					return;
				}
			}
		}
		//Saída de produtos
		else if (acao == 2){
			for(int i=0; i< estoque.size(); i++){
				if (estoque.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) &&  estoque.get(i).getMarca().toLowerCase().equals(marca.toLowerCase())){
					Produtos produto = estoque.get(i);
					produto.setQtde_produtos(produto.getQtde_produtos() - remessa);
					if(produto.getQtde_produtos() < 0){
						produto.setQtde_produtos(0);
						return;
					}
					return;
				}
			}
		}
		System.out.println("\nNão foi possivel encontrar este produto na base de dados!");
	}
	//Função para remover produto do estoque
	public static void Remover_produto(ArrayList<Produtos> estoque, String nome, String marca){
		for (int i=0; i <= (estoque.size()+1); i++){
			if(i < estoque.size() && estoque.get(i).getNome().toLowerCase().equals(nome.toLowerCase()) && estoque.get(i).getMarca().toLowerCase().equals(marca.toLowerCase())){
				estoque.remove(i);
				System.out.println("\n\tProduto removido com sucesso!");
				break;
			}
			else if(i >= estoque.size()){
				System.out.println("\nNão foi possivel encontrar o produto na base de dados!");
				break;
			}
		}
	}
	//Função para mostrar o estoque
	public static void Exibir_estoque(ArrayList<Produtos> estoque){
		System.out.println();
		System.out.println("Produto | Marca | Preço | Peso(KG)/Litro(L) | Quantidade em estoque");
		for(int i=0; i<estoque.size(); i++){
			Produtos produto = estoque.get(i);
			System.out.print(produto.getNome() + " | ");
			System.out.print(produto.getMarca() + " | ");
			System.out.print(produto.getPreco() + " | ");
			System.out.print(produto.getPeso() + " | ");
			System.out.print(produto.getQtde_produtos() + " | ");
			System.out.println();
		}
	}


	// Gets e Sets
	public int getQtde_produtos() {
		return qtde_produtos;
	}

	public void setQtde_produtos(int qtde_produtos) {
		this.qtde_produtos = qtde_produtos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

}

