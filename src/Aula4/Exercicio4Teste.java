import java.util.Scanner;

/* 
Professor, queira me perdoar por esse codigo, eu tentei fazer o melhor possível, 
mas n consegui pensar em uma maneira de fazer um sistema de gerenciamento de produtos e categorias mais organizado

Não sei se era esse o padrão de qualidade que o senhor esperava, ou se está muito avançado para o que vimos até o momento.
Então acabei fazendo tudo em um unico script e com assistencia de IA, espero que n fique tão bagunçado.

Posso dizer que os menus foram criados por mim, entretanto, a parte de relatorios e algumas validações de CRUD foram feitas com ajuda de IA.

Sendo honesto, eu sei explicar uns 60% do codigo, mas o restante eu vou ter que ler com mais calma, mas não tenho muito tempo ja que estou postando isso essa hora da noite.
De qualquer forma, se quiser não contar esse exercicio, eu entendo. Vai ficar de material para eu estudar mais tarde.
*/ 

public class Exercicio4Teste {
    public static final Scanner scanner = new Scanner(System.in);

    public static String[][] produtos = new String[100][4];
    public static int totalProdutos = 0;

    public static String[] categorias = new String[20];
    public static int totalCategorias = 0;

    private static final int ESTOQUE_BAIXO = 10;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MEGASTORE - MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Categorias");
            System.out.println("3. Relatórios");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                menuProdutos();
            } else if (opcao == 2) {
                menuCategorias();
            } else if (opcao == 3) {
                menuRelatorios();
            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    // ===== MENU PRODUTOS =====

    public static void menuProdutos() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR PRODUTOS ===");
            System.out.println("1. Inserir produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Alterar produto");
            System.out.println("4. Excluir produto");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) cadastrarProduto();
            else if (opcao == 2) listarProdutos();
            else if (opcao == 3) alterarProduto();
            else if (opcao == 4) excluirProduto();
            else if (opcao != 0) System.out.println("Opção inválida.");
        } while (opcao != 0);
    }

    public static void cadastrarProduto() {
        if (totalProdutos >= produtos.length) {
            System.out.println("Limite de produtos atingido.");
            return;
        }
        System.out.println("Nome do produto:");
        String nome = scanner.nextLine();

        double preco;
        while (true) {
            System.out.println("Preço do produto:");
            preco = scanner.nextDouble();
            scanner.nextLine();
            if (preco >= 0) break;
            System.out.println("Preço não pode ser negativo.");
        }

        int quantidade;
        while (true) {
            System.out.println("Quantidade em estoque:");
            quantidade = scanner.nextInt();
            scanner.nextLine();
            if (quantidade >= 0) break;
            System.out.println("Quantidade não pode ser negativa.");
        }

        System.out.println("Categoria do produto:");
        String categoria = scanner.nextLine();

        produtos[totalProdutos][0] = nome;
        produtos[totalProdutos][1] = String.valueOf(preco);
        produtos[totalProdutos][2] = String.valueOf(quantidade);
        produtos[totalProdutos][3] = categoria;
        totalProdutos++;

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("=== LISTA DE PRODUTOS ===");
        boolean temEstoqueBaixo = false;
        for (int i = 0; i < totalProdutos; i++) {
            System.out.println((i + 1) + ". " + produtos[i][0] + " | R$" + produtos[i][1] + " | Qtde: " + produtos[i][2] + " | " + produtos[i][3]);
            if (Integer.parseInt(produtos[i][2]) <= ESTOQUE_BAIXO) {
                temEstoqueBaixo = true;
            }
        }
        if (temEstoqueBaixo) {
            System.out.println("\nProdutos com estoque baixo:");
            for (int i = 0; i < totalProdutos; i++) {
                if (Integer.parseInt(produtos[i][2]) <= ESTOQUE_BAIXO) {
                    System.out.println("- " + produtos[i][0] + " (" + produtos[i][2] + " unidades)");
                }
            }
        }
    }

    public static void alterarProduto() {
        listarProdutos();
        if (totalProdutos == 0) return;
        System.out.print("Número do produto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > totalProdutos) {
            System.out.println("Número inválido.");
            return;
        }
        int i = numero - 1;

        System.out.println("Novo preço (Enter para manter '" + produtos[i][1] + "'):");
        String novoPreco = scanner.nextLine();
        if (!novoPreco.isEmpty()) {
            double preco = Double.parseDouble(novoPreco);
            if (preco < 0) {
                System.out.println("Preço não pode ser negativo.");
                return;
            }
            produtos[i][1] = novoPreco;
        }

        System.out.println("Produto atualizado com sucesso!");
    }

    public static void excluirProduto() {
        listarProdutos();
        if (totalProdutos == 0) return;
        System.out.print("Número do produto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > totalProdutos) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.print("Confirmar exclusão (S/N)? ");
        String confirmacao = scanner.nextLine();
        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        int i = numero - 1;
        for (int j = i; j < totalProdutos - 1; j++) {
            produtos[j] = produtos[j + 1];
        }
        produtos[totalProdutos - 1] = new String[4];
        totalProdutos--;
        System.out.println("Produto excluído com sucesso!");
    }

    // ===== MENU CATEGORIAS =====

    public static void menuCategorias() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR CATEGORIAS ===");
            System.out.println("1. Inserir categoria");
            System.out.println("2. Listar categorias");
            System.out.println("3. Alterar categoria");
            System.out.println("4. Excluir categoria");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) cadastrarCategoria();
            else if (opcao == 2) listarCategorias();
            else if (opcao == 3) alterarCategoria();
            else if (opcao == 4) excluirCategoria();
            else if (opcao != 0) System.out.println("Opção inválida.");
        } while (opcao != 0);
    }

    public static void cadastrarCategoria() {
        if (totalCategorias >= categorias.length) {
            System.out.println("Limite de categorias atingido.");
            return;
        }
        System.out.println("Nome da categoria:");
        String nome = scanner.nextLine();
        categorias[totalCategorias] = nome;
        totalCategorias++;
        System.out.println("Categoria cadastrada com sucesso!");
    }

    public static void listarCategorias() {
        if (totalCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }
        System.out.println("=== LISTA DE CATEGORIAS ===");
        for (int i = 0; i < totalCategorias; i++) {
            int count = 0;
            for (int j = 0; j < totalProdutos; j++) {
                if (produtos[j][3].equalsIgnoreCase(categorias[i])) {
                    count++;
                }
            }
            System.out.println((i + 1) + ". " + categorias[i] + " (" + count + (count == 1 ? " produto)" : " produtos)"));
        }
    }

    public static void alterarCategoria() {
        listarCategorias();
        if (totalCategorias == 0) return;
        System.out.print("Número da categoria: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > totalCategorias) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.println("Novo nome:");
        String novoNome = scanner.nextLine();

        // Atualiza o nome nos produtos vinculados também
        String nomeAntigo = categorias[numero - 1];
        categorias[numero - 1] = novoNome;
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][3].equalsIgnoreCase(nomeAntigo)) {
                produtos[i][3] = novoNome;
            }
        }

        System.out.println("Categoria atualizada com sucesso!");
    }

    public static void excluirCategoria() {
        listarCategorias();
        if (totalCategorias == 0) return;
        System.out.print("Número da categoria: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > totalCategorias) {
            System.out.println("Número inválido.");
            return;
        }

        String nome = categorias[numero - 1];
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][3].equalsIgnoreCase(nome)) {
                System.out.println("Não é possível excluir: categoria possui produtos vinculados.");
                return;
            }
        }

        System.out.print("Confirmar exclusão (S/N)? ");
        String confirmacao = scanner.nextLine();
        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        int i = numero - 1;
        for (int j = i; j < totalCategorias - 1; j++) {
            categorias[j] = categorias[j + 1];
        }
        categorias[totalCategorias - 1] = null;
        totalCategorias--;
        System.out.println("Categoria excluída com sucesso!");
    }

    // ===== MENU RELATÓRIOS =====

    public static void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n=== RELATÓRIOS ===");
            System.out.println("1. Relatório de estoque");
            System.out.println("2. Relatório por categoria");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) relatorioEstoque();
            else if (opcao == 2) relatorioPorCategoria();
            else if (opcao != 0) System.out.println("Opção inválida.");
        } while (opcao != 0);
    }

    public static void relatorioEstoque() {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        double valorTotal = 0;
        int qtdEstoqueBaixo = 0;

        for (int i = 0; i < totalProdutos; i++) {
            double preco = Double.parseDouble(produtos[i][1]);
            int qtde = Integer.parseInt(produtos[i][2]);
            valorTotal += preco * qtde;
            if (qtde <= ESTOQUE_BAIXO) qtdEstoqueBaixo++;
        }

        System.out.println("=== RELATÓRIO DE ESTOQUE ===");
        System.out.printf("Total de produtos: %d%n", totalProdutos);
        System.out.printf("Valor total em estoque: R$%.2f%n", valorTotal);
        System.out.printf("Produtos com estoque baixo: %d%n", qtdEstoqueBaixo);

        System.out.println("\nValor por categoria:");
        for (int c = 0; c < totalCategorias; c++) {
            double valorCat = 0;
            int itensCat = 0;
            for (int i = 0; i < totalProdutos; i++) {
                if (produtos[i][3].equalsIgnoreCase(categorias[c])) {
                    valorCat += Double.parseDouble(produtos[i][1]) * Integer.parseInt(produtos[i][2]);
                    itensCat++;
                }
            }
            System.out.printf("- %s: R$%.2f (%d itens)%n", categorias[c], valorCat, itensCat);
        }
    }

    public static void relatorioPorCategoria() {
        System.out.println("Digite a categoria:");
        String categoria = scanner.nextLine();
        System.out.println("=== RELATÓRIO POR CATEGORIA ===");
        System.out.println("Categoria: " + categoria);

        double totalValor = 0;
        int totalItens = 0;
        boolean encontrou = false;

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][3].equalsIgnoreCase(categoria)) {
                double valor = Double.parseDouble(produtos[i][1]) * Integer.parseInt(produtos[i][2]);
                System.out.printf("- %s | Qtde: %s | Valor: R$%.2f%n", produtos[i][0], produtos[i][2], valor);
                totalValor += valor;
                totalItens += Integer.parseInt(produtos[i][2]);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum produto encontrado nessa categoria.");
        } else {
            System.out.printf("%nTotal na categoria: %d itens - R$%.2f%n", totalItens, totalValor);
        }
    }
}
