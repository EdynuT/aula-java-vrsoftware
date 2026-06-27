package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static List<ProdutoPerecivel> produtos = new ArrayList<>(Arrays.asList());

    public static List<Categoria> categorias = new ArrayList<>(Arrays.asList());

    public static int ESTOQUE_BAIXO = 10;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("===== MEGASTORE - Menu Principal =====");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Categorias");
            System.out.println("3. Relatórios");
            System.out.println("0. Sair\n");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 0:
                    System.out.println("Sistema encerrado.\n");
                    break;
                case 1:
                    gerenciarProdutos();
                    break;
                case 2:
                    gerenciarCategorias();
                    break;
                case 3:
                    gerenciarRelatorios();
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }

//  ================ Gerenciamento de Produtos =================

    public static void gerenciarProdutos() {
        int opcao;
        do{
            System.out.println("===== Gerenciar Produtos =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Editar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("0. Voltar ao Menu Principal\n");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 0:
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    alterarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }


    public static void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o valor do produto: ");
        double valorProduto = scanner.nextDouble();
        if (valorProduto <= 0) {
            System.out.println("O preço do produto deve ser maior do que zero! ");
            return;
        }
        System.out.print("Digite a quantidade do produto: ");
        int quantidadeProduto = scanner.nextInt();
        System.out.print("O produto é perecível? [s/n]: ");
        String ehPerecivel = scanner.nextLine();
        boolean perecivel;
        String validade;
        String garantia;
        if (ehPerecivel.toLowerCase().equals("s")) {
            perecivel = true;
            System.out.print("Digite o prazo de validade: ");
            validade = scanner.nextLine();
        } else {
            perecivel = false;
            System.out.print("Digite o prazo de garantia: ");
            garantia = scanner.nextLine();
        }
        //System.out.print("Digite a categoria do produto: ");
        //String categoriaProduto = scanner.nextLine();
        scanner.nextLine();

        ProdutoPerecivel novoProduto = new ProdutoPerecivel(nomeProduto, valorProduto, quantidadeProduto, perecivel, validade, garantia);
        produtos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso.\n");
    }


    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }

        System.out.println("\n===== Lista de Produtos =====");
        
        Collections.sort(produtos);

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoPerecivel produto = produtos.get(i);
            System.out.printf((i + 1) + ". %s%n | R$ %.2f%n | Qtde: %d%n | Perceivel: %b%n | (Categoria)\n", produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getProdutoPerecivel());
        }
    }


    public static void alterarProduto() {
        System.out.println("==== Lista de Produtos ====");

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoPerecivel produto = produtos.get(i);
            System.out.printf((i + 1) + ". %s%n | Preço: R$ %.2f%n", produto.getNome(), produto.getPreco());
        }
        System.out.print("Numero do produto: ");
        int numeroProduto = scanner.nextInt();
        System.out.print("Novo preço: ");
        double novoPreco = scanner.nextDouble();

        if (numeroProduto < 1 || numeroProduto > produtos.size()) {
            System.out.println("Número de produto inválido.\n");
            return;
        }
        produtos.get(numeroProduto - 1).setPreco(novoPreco);
        System.out.println("Preço do produto atualizado com sucesso.\n");
    }


    public static void excluirProduto() {
       if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }

       System.out.println("==== Lista de Produtos ====");
        for (int i = 0; i < produtos.size(); i++) {
            ProdutoPerecivel produto = produtos.get(i);
            System.out.printf((i + 1) + ". %s%n", produto.getNome());
        }
        System.out.print("Numero do produto a ser excluído: ");
        int numeroProduto = scanner.nextInt();

        if (numeroProduto < 1 || numeroProduto > produtos.size()) {
            System.out.println("Número de produto inválido.\n");
        } else {
            System.out.print("Comfirmar exclusão [s/n]: ");
            String confirmar = scanner.nextLine();

            if (confirmar.toLowerCase().equals("s")) {
                int indiceRemover = numeroProduto - 1;
                produtos.remove(indiceRemover);

                System.out.println("Produto excluído com sucesso.\n");
            }
        }
    }

//  ================ Gerenciamento de Categorias =================

    public static void gerenciarCategorias() {
        int opcao;
        do{
            System.out.println("===== Gerenciar Categorias =====");
            System.out.println("1. Cadastrar Categoria");
            System.out.println("2. Listar Categorias");
            System.out.println("3. Editar Categoria");
            System.out.println("4. Excluir Categoria");
            System.out.println("0. Voltar ao Menu Principal\n");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 0:
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                case 1:
                    //cadastrarCategoria();
                    break;
                case 2:
                    //listarCategorias();
                    break;
                case 3:
                    // Chamar método para editar categoria
                    break;
                case 4:
                    // Chamar método para excluir categoria
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }

//  ================ Gerenciamento de Relatórios =================

    public static void gerenciarRelatorios() {
        int opcao;
        do{
            System.out.println("===== Gerenciar Categorias =====");
            System.out.println("1. Gerar Relatorio de Estoque");
            System.out.println("2. Gerar Relatorio de Categorias");
            System.out.println("0. Voltar ao Menu Principal\n");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 0:
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                case 1:
                    //gerarRelatorioEstoque();
                    break;
                case 2:
                    //gerarRelatorioCategoria();
                    break;
            }
        } while (opcao != 0);
    }
}