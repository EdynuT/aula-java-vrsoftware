package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static List<Produto> todosProdutos = new ArrayList<>();

    public static List<ProdutoPerecivel> produtosPereciveis = new ArrayList<>();
    public static List<ProdutoNaoPerecivel> produtosNaoPereciveis = new ArrayList<>();

    public static List<Categoria> categorias = new ArrayList<>();

    public static final int ESTOQUE_BAIXO = 10;

    public static void main(String[] args) {
        int opcao;
        do {
            limparConsole();
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
                    gerenciarProdutosGUI();
                    break;
                case 2:
                    gerenciarCategoriasGUI();
                    break;
                case 3:
                    gerenciarRelatoriosGUI();
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }

//  ================ Gerenciamento de Produtos =================

    public static void gerenciarProdutosGUI() {
        int opcao;
        do{
            limparConsole();
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
        limparConsole();
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
        scanner.nextLine();
        String isPerecivel = scanner.nextLine();

        if (isPerecivel.toLowerCase().equals("s")) {
            System.out.print("Digite o prazo de validade: ");
            String validade = scanner.nextLine();
            System.out.print("Digite a categoria do produto: ");
            String categoriaProduto = scanner.nextLine();

            if (categoriaExiste(categoriaProduto)){
                ProdutoPerecivel novoProdutoPerecivel = new ProdutoPerecivel(nomeProduto, valorProduto, quantidadeProduto, categoriaProduto, validade);
                produtosPereciveis.add(novoProdutoPerecivel);
                System.out.println("Produto cadastrado com sucesso.\n");
            } else {
                System.out.println("Categoria de produto não cadastrada.\nCadastre essa categoria priimeiro.");
                System.out.print("Deseja cadastrar a categoria? [s/n]: ");
                String escolha = scanner.nextLine();
    
                if (escolha.toLowerCase().equals("s")) {
                    Categoria novaCategoria = new Categoria(categoriaProduto);
                    categorias.add(novaCategoria);

                    System.out.println("Categoria cadastrada com sucesso.\n");
                }
            }
        } else {
            System.out.print("Digite o prazo de garantia: ");
            String garantia = scanner.nextLine();
            System.out.print("Digite a categoria do produto: ");
            String categoriaProduto = scanner.nextLine();

            if (categoriaExiste(categoriaProduto)){
                ProdutoNaoPerecivel novoProdutoNaoPerecivel = new ProdutoNaoPerecivel(nomeProduto, valorProduto, quantidadeProduto, categoriaProduto, garantia);
                produtosNaoPereciveis.add(novoProdutoNaoPerecivel);
                System.out.println("Produto cadastrado com sucesso.\n");
            } else {
                System.out.println("Categoria de produto não cadastrada.\nCadastre essa categoria primeiro.");
                System.out.print("Deseja cadastrar a categoria? [s/n]: ");
                String escolha = scanner.nextLine();
    
                if (escolha.toLowerCase().equals("s")) {
                    Categoria novaCategoria = new Categoria(categoriaProduto);
                    categorias.add(novaCategoria);

                    System.out.println("Categoria cadastrada com sucesso.\n");
                }
            }
        }
        scanner.nextLine();
    }


    public static void listarProdutos() {
        limparConsole();
        todosProdutos.clear();
        todosProdutos.addAll(produtosPereciveis);
        todosProdutos.addAll(produtosNaoPereciveis);

        if (todosProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }

        System.out.println("\n===== Lista de Produtos =====");        

        for (int i = 0; i < todosProdutos.size(); i++) {
            Produto produto = todosProdutos.get(i);
            boolean perecivel = produto instanceof ProdutoPerecivel;
            if (perecivel) {
                ProdutoPerecivel produtoPerecivel = (ProdutoPerecivel) produto;
                System.out.printf(
                    "%d. %s | R$ %.2f | Qtde: %d | Perecivel: %b | Validade: %s | Categoria: %s%n",
                    i + 1,
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getQuantidade(),
                    perecivel,
                    produtoPerecivel.getValidade(),
                    produto.getCategoria()
                );
            } else {
                ProdutoNaoPerecivel produtoNaoPerecivel = (ProdutoNaoPerecivel) produto;
                System.out.printf(
                    "%d. %s | R$ %.2f | Qtde: %d | Perecivel: %b | Garantia: %s | Categoria: %s%n",
                    i + 1,
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getQuantidade(),
                    perecivel,
                    produtoNaoPerecivel.getGarantia(),
                    produto.getCategoria()
                );
            }
        }
        scanner.nextLine();
    }


    public static void alterarProduto() {
        limparConsole();
        if (todosProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }
        
        System.out.println("==== Lista de Produtos ====");

        for (int i = 0; i < todosProdutos.size(); i++) {
            Produto produto = todosProdutos.get(i);
            System.out.printf((i + 1) + ". %s%n | Preço: R$ %.2f%n", produto.getNome(), produto.getPreco());
        }
        System.out.print("Numero do produto: ");
        int numeroProduto = scanner.nextInt();
        System.out.print("Novo preço: ");
        double novoPreco = scanner.nextDouble();

        if (numeroProduto < 1 || numeroProduto > todosProdutos.size()) {
            System.out.println("Número de produto inválido.\n");
            return;
        }
        todosProdutos.get(numeroProduto - 1).setPreco(novoPreco);
        System.out.println("Preço do produto atualizado com sucesso.\n");
        scanner.nextLine();
    }


    public static void excluirProduto() {
        limparConsole();
        if (todosProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }

        System.out.println("==== Lista de Produtos ====");
        for (int i = 0; i < todosProdutos.size(); i++) {
            Produto produto = todosProdutos.get(i);
            System.out.printf((i + 1) + ". %s%n", produto.getNome());
        }
        System.out.print("Numero do produto a ser excluído: ");
        int numeroProduto = scanner.nextInt();

        if (numeroProduto < 1 || numeroProduto > todosProdutos.size()) {
            System.out.println("Número de produto inválido.\n");
        } else {
            System.out.print("Confirmar exclusão [s/n]: ");
            String confirmar = scanner.nextLine();

            if (confirmar.toLowerCase().equals("s")) {
                todosProdutos.remove(numeroProduto - 1);

                System.out.println("Produto excluído com sucesso.\n");
            }
        }
        scanner.nextLine();
    }

//  ================ Gerenciamento de Categorias =================

    public static void gerenciarCategoriasGUI() {
        int opcao;
        do{
            limparConsole();
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
        limparConsole();
        System.out.print("Digite o nome da Categoria: ");
        String nomeCategoria = scanner.nextLine();

        Categoria novaCategoria = new Categoria(nomeCategoria);
        categorias.add(novaCategoria);
        System.out.println();
        System.out.println("Categoria cadastrada com sucesso.\n");
        scanner.nextLine();
    }


    public static void listarCategorias() {
        limparConsole();
        todosProdutos.clear();
        todosProdutos.addAll(produtosPereciveis);
        todosProdutos.addAll(produtosNaoPereciveis);

        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.\n");
            return;
        }

        System.out.println("==== Lista de Categorias ====");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);

            StringBuilder produtosPorCategoria = new StringBuilder();
            for (Produto produto : todosProdutos) {
                if (produto.getCategoria().equalsIgnoreCase(categoria.getNome())) {
                    if (produtosPorCategoria.length() > 0) {
                        produtosPorCategoria.append(" | ");
                    }
                    produtosPorCategoria.append(produto.getQuantidade())
                            .append(" ")
                            .append(produto.getNome());
                }
            }

            if (produtosPorCategoria.length() == 0) {
                System.out.printf("%d. %s (sem produtos)%n", i + 1, categoria.getNome());
            } else {
                System.out.printf("%d. %s (%s)%n", i + 1, categoria.getNome(), produtosPorCategoria);
            }
        }
        scanner.nextLine();
    }

    
    public static void alterarCategoria() {
        limparConsole();
        todosProdutos.clear();
        todosProdutos.addAll(produtosPereciveis);
        todosProdutos.addAll(produtosNaoPereciveis);

        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.\n");
            return;
        }

        System.out.println("==== Lista de Categorias ====");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);

            System.out.printf("%d. %s%n", i + 1, categoria.getNome());
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

        for (Produto produto : todosProdutos) {
            if (produto.getCategoria().equalsIgnoreCase(categorias.get(escolha - 1).getNome())) {
                produto.setCategoria(novoNome);
            }
        }
        scanner.nextLine();
    }


    public static void excluirCategoria() {
        limparConsole();
        todosProdutos.clear();
        todosProdutos.addAll(produtosPereciveis);
        todosProdutos.addAll(produtosNaoPereciveis);

        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.\n");
            return;
        }

        System.out.println("==== Lista de Categorias ====");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            System.out.printf("%d. %s%n", i + 1, categoria.getNome());
        }
        
        System.out.print("Numero da categoria: ");
        int escolha = scanner.nextInt();
        
        if (escolha < 1 || escolha > categorias.size()) {
            System.out.println("Número de categoria inválido");
            return;
        } else {
            boolean possuiProdutos = false;
            for (Produto produto : todosProdutos) {
                if (produto.getCategoria().equalsIgnoreCase(categorias.get(escolha - 1).getNome())) {
                    possuiProdutos = true;
                    break;
                }
            }
            if (possuiProdutos) {
                System.out.println("Não é possível excluir uma categoria que possui produtos associados.");
                return;
            }
            
            System.out.print("Confirmar exclusão [s/n]: ");
            String confirmar = scanner.nextLine();

            if (confirmar.toLowerCase().equals("s")) {
                
                categorias.remove(escolha - 1);

                System.out.println("Categoria excluída com sucesso");
            }
        }
        scanner.nextLine();
    }

//  ================ Gerenciamento de Relatórios =================

    public static void gerenciarRelatoriosGUI() {
        int opcao;
        do{
            limparConsole();
            System.out.println("===== Gerenciar Relatórios =====");
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
        limparConsole();

    }

// ============== Helpers =================

    private static boolean categoriaExiste(String nomeCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nomeCategoria)) {
                return true;
            }
        }
        return false;
    }

    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Erro ao limpar o console: " + ex.getMessage());
        }
    }
}
