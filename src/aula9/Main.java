package aula9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Teclado", 19.99, 15, "Informatica"));
        produtos.add(new Produto("Mouse", 10.99, 5, "Informatica"));
        produtos.add(new Produto("CPU", 1500.99, 12, "Informatica"));

        for (String p : produtos) {
            System.out.println(p.getNome());
        }

        Collections.sort(produtos);
    }
}
