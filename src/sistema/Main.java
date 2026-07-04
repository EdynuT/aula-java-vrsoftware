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
            garantia = "Não há garantia";
        } else {
            perecivel = false;
            System.out.print("Digite o prazo de garantia: ");
            garantia = scanner.nextLine();
            validade = "Não há validade";
        }

        System.out.print("Digite a categoria do produto: ");
        String categoriaProduto = scanner.nextLine();
        if (categorias.contains(categoriaProduto)){
            ProdutoPerecivel novoProduto = new ProdutoPerecivel(nomeProduto, valorProduto, quantidadeProduto, categoriaProduto, perecivel, validade, garantia);
            produtos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso.\n");
        } else {
            System.out.println("Categoria de produto não cadastrada.\n Cadastre essa categoria priimeiro.");
            System.out.println("Deseja cadastrar a categoria? [s/n]: ");
            String escolha = scanner.nextLine();

            if (escolha.toLowerCase().equals("s")) {
                gerenciarCategorias();
            }
        }
        scanner.nextLine();
    }


    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }

        System.out.println("\n===== Lista de Produtos =====");        

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoPerecivel produto = produtos.get(i);
            System.out.printf("%d. %s | R$ %.2f | Qtde: %d | Perceivel: %b | %s%n", i + 1, produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getProdutoPerecivel(), produto.getCategoria());
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
                produtos.remove(numeroProduto - 1);

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
                    cadastrarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    alterarCategoria();
                    break;
                case 4:
                    excluirCategoria();
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }


    public static void cadastrarCategoria() {
        System.out.print("Digite o nome da Categoria: ");
        String nomeCategoria = scanner.nextLine();

        Categoria novaCategoria = new Categoria(nomeCategoria);
        categorias.add(novaCategoria);
    }


    public static void listarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.\n");
            return;
        }

        System.out.println("==== Lista de Categorias ====");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);

            int numProdutos = 0;
            for (ProdutoPerecivel produto : produtos) {
                if (produto.getCategoria().equalsIgnoreCase(categoria.getNome())) {
                    numProdutos++;
                }
            }

            if (numProdutos == 1) {
                System.out.printf("%d. %s (%d produto)%n", i + 1, categoria.getNome(), numProdutos);
            } else {
                System.out.printf("%d. %s (%d produtos)%n", i + 1, categoria.getNome(), numProdutos);
            }
        }
    }

    
    public static void alterarCategoria() {
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.\n");
            return;
        }

        System.out.println("==== Lista de Categorias ====");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);

            System.out.printf("%d. %s", i + 1, categoria.getNome());
        }

        System.out.print("Numero da categoria: ");
        int escolha = scanner.nextInt();

        if (escolha < 1 || escolha > categorias.size()) {
            System.out.println("Categoria inexistente");
            return;
        }

        System.out.print("Novo nome da categoria: ");
        String novoNome = scanner.nextLine();
        categorias.get(escolha - 1).setNome(novoNome);
        System.out.println("Nome de categoria alterado");
    }


    public static void excluirCategoria() {
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.\n");
            return;
        }

        int numProdutos = 0;

        System.out.println("==== Lista de Categorias ====");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            System.out.printf("%d. %s", i + 1, categoria.getNome());
        }
        
        System.out.print("Numero da categoria: ");
        int escolha = scanner.nextInt();
        
        if (escolha < 1 || escolha > categorias.size()) {
            System.out.println("Número de categoria inválido");
            return;
        } else {
            System.out.print("Comfirmar exclusão [s/n]: ");
            String confirmar = scanner.nextLine();

            if (confirmar.toLowerCase().equals("s")) {
                
                categorias.remove(escolha - 1);

                System.out.println("Categoria excluída com sucesso");
            }
        }
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


    public static void gerarRelatorioEstoque() {

    }
}