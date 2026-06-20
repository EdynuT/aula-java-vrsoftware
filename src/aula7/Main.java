package aula7;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void emitirSom(Animal animal) {
        animal.emiteSom();
    }

    public static void main(String[] args) {
//        System.out.print("Nome do cachorro: ");
//        String nomeCachorro = scanner.nextLine();
//        System.out.print("Idade do cachorro: ");
//        int idadeCachorro = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println();
//
//        System.out.print("Nome do gato: ");
//        String nomeGato = scanner.nextLine();
//        System.out.print("Idade do gato: ");
//        int idadeGato = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println();
//
//        System.out.print("Nome da vaca: ");
//        String nomeVaca = scanner.nextLine();
//        System.out.print("Idade da Vaca: ");
//        int idadeVaca = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println();
//
        Cachorro cachorro = new Cachorro("Max", 8);
        Gato gato = new Gato("Jade", 14);
        Vaca vaca = new Vaca("Mimosa", 25);
//
//        cachorro.emiteSom();
//        System.out.println();
//        gato.emiteSom();
//        System.out.println();
//        vaca.emiteSom();

        Animal[] animais = {cachorro, gato, vaca};

        for (Animal a : animais) {
            emitirSom(a);
        }
    }
}
