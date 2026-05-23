import java.util.Scanner;

// Gerenciamento de listagem de produtos e preços

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] produtos = {
            {"Arroz",        "25.90"},
            {"Feijão",       "8.50"},
            {"Sabonete",     "3.99"},
            {"Shampoo",      "18.75"},
            {"Macarrão",     "4.30"},
            {"Detergente",   "2.80"},
            {"Notebook",     "3500.00"},
            {"Caneta",       "1.50"},
            {"Mochila",      "79.90"},
            {"Caderno",      "22.00"}
        };
        
        System.out.println("=== Lista de Produtos ===");
        for (int i = 0; i < produtos.length; i++) {
            System.out.println(produtos[i][0] + " - R$ " + produtos[i][1]);
        }

        System.out.print("\nDigite o produto que deseja buscar: ");
        String busca = scanner.nextLine();

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i][0].equalsIgnoreCase(busca)) {
                System.out.println("Encontrado: " + produtos[i][0] + " - R$ " + produtos[i][1]);
            }
            else {
                System.out.println("Produto '" + busca + "' não encontrado.");
                break;
            }
        }
        
        System.out.println("\n=== Produtos ordenados por preço ===");
        for (int i = 0; i < produtos.length - 1; i++) {
            for (int j = 0; j < produtos.length - 1 - i; j++) {
                double precoAtual  = Double.parseDouble(produtos[j][1]);
                double precoProximo = Double.parseDouble(produtos[j + 1][1]);
                if (precoAtual > precoProximo) {
                    String[] temp = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < produtos.length; i++) {
            System.out.println(produtos[i][0] + " - R$ " + produtos[i][1]);
        }

        System.out.println("\n=== Produtos abaixo de R$ 50 ===");
        for (int i = 0; i < produtos.length; i++) {
            double preco = Double.parseDouble(produtos[i][1]);
            if (preco < 50.0) {
                System.out.println(produtos[i][0] + " - R$ " + produtos[i][1]);
            }
        }
    }
}
// Eu n tenho certeza se eu entendi exatamente as circunstancias dos filtros 
// ou se era para fazer uma unica lista com todos os produtos e as opções de filtro, 
// Mas aqui está o código para o exercício 4
