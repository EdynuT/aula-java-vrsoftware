import java.util.Scanner;

public class Exercicio4 {
    public static final Scanner scanner = new Scanner(System.in);

    public static String[][] produtos = new String[100][4];
    public static int totalProdutos;

    public static String[] categorias = new String[2];
    public static int totalCategorias;

    public static int ESTOQUE_BAIXO = 5;

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
                    gerarRelatorios();
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }

// ========= Gerenciar Produtos ========

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
                    // Chamar método para excluir produto
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);
    }

    public static void cadastrarProduto() {
        String nome;
        String categoria;
        double preco;
        int quantidade;

        System.out.print("Nome do produto: ");
        nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        preco = scanner.nextDouble();
        System.out.print("Quantidade de produtos: ");
        quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.print("Categoria do produto: ");
        categoria = scanner.nextLine();
        if (!categoriaExiste(categoria)) {
            System.out.println("Categoria não existe. Por favor, cadastre a categoria antes de cadastrar o produto.\n");
            return;
        }

        produtos[totalProdutos][0] = nome;
        produtos[totalProdutos][1] = String.valueOf(preco);
        produtos[totalProdutos][2] = String.valueOf(quantidade);
        produtos[totalProdutos][3] = String.valueOf(categoria);
        totalProdutos++;
        System.out.println("\nProduto cadastrado com sucesso!\n");
        return;
    }

    public static void listarProdutos() {
        System.out.println("===== LISTA DE PRODUTOS =====");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.println((i + 1) + ". " + produtos[i][0] + " | R$" + produtos[i][1] + " | Qtde: " + produtos[i][2] + " | " + produtos[i][3]);
        }
        System.out.println();
    }

    public static void alterarProduto() {
        System.out.print("Numero do produto: ");
        int numeroProduto = scanner.nextInt();
        System.out.print("Novo preço: ");
        double novoPreco = scanner.nextDouble();

        if (numeroProduto < 1 || numeroProduto > totalProdutos) {
            System.out.println("Número de produto inválido.\n");
            return;
        }
        produtos[numeroProduto - 1][1] = String.valueOf(novoPreco);
        System.out.println("Preço do produto atualizado com sucesso.\n");
    
    }

// ========= Gerenciar Categorias ========

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

    public static void cadastrarCategoria() {
        System.out.print("Nome: ");
        String nomeCategoria = scanner.nextLine();
        if (categoriaExiste(nomeCategoria)) {
            System.out.println("Categoria já existe. Por favor, escolha outro nome.\n");
            return;
        }
        String[] novaCategoria = new String[categorias.length + 1];
        for (int i = 0; i < categorias.length; i++) {
            novaCategoria[i] = categorias[i];
        }
        novaCategoria[categorias.length - 2] = nomeCategoria;
        categorias = novaCategoria;
        totalCategorias++;
        System.out.println("\nCategoria cadastrada com sucesso!\n");
    }

    public static void listarCategorias() {
        System.out.println("===== LISTA DE CATEGORIAS =====");
        for (int i = 0; i < totalCategorias; i++) {
            System.out.println((i + 1) + ". " + categorias[i] + " (" + contarProdutosPorCategoria(i) + " itens)");
        }
        System.out.println();
    }

// ========= Relatórios ========

    public static void gerarRelatorios() {
        System.out.println("=== RELATÓRIO DE ESTOQUE ===");
        System.out.println("Total de produtos: " + totalProdutos);
        System.out.printf("Valor total em estoque: R$%.2f%n", calcularValorTotalEstoque());
        System.out.println("Produtos com estoque baixo: " + contarProdutosEstoqueBaixo());
        System.out.println("\nValor por categoria:");
        for (int i = 0; i < categorias.length; i++) {
            double valorCategoria = 0.0;
            for (int j = 0; j < totalProdutos; j++) {
                if (Integer.parseInt(produtos[j][3]) == i) {
                    double preco = Double.parseDouble(produtos[j][1]);
                    int quantidade = Integer.parseInt(produtos[j][2]);
                    valorCategoria += preco * quantidade;
                }
            }
            System.out.printf("%s: R$%.2f%n (%d itens)%n", categorias[i], valorCategoria, contarProdutosPorCategoria(i));
        }
    }

// ####################################
// # ------ MÉTODOS AUXILIARES ------ #
// ####################################

    public static double calcularValorTotalEstoque() {
        double valorTotal = 0.0;
        for (int i = 0; i < totalProdutos; i++) {
            double preco = Double.parseDouble(produtos[i][1]);
            int quantidade = Integer.parseInt(produtos[i][2]);
            valorTotal += preco * quantidade;
        }
        return valorTotal;
    }

    public static int contarProdutosEstoqueBaixo() {
        int contador = 0;
        for (int i = 0; i < totalProdutos; i++) {
            int quantidade = Integer.parseInt(produtos[i][2]);
            if (quantidade < ESTOQUE_BAIXO) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarProdutosPorCategoria(int categoriaIndex) {
        int contador = 0;
        for (int i = 0; i < totalProdutos; i++) {
            if (Integer.parseInt(produtos[i][3]) == categoriaIndex) {
                contador++;
            }
        }
        return contador;
    }

    public static boolean categoriaExiste(String categoria) {
        for (int i = 0; i < categorias.length; i++) {
            if (categorias[i] == null) {
                continue;
            }
            else if (categorias[i].equalsIgnoreCase(categoria)) {
                return true;
            }
            else {
                continue;
            }
        }
        return false;
    }
}