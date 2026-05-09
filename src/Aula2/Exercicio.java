/*
Programa de cadastro de usuário, onde o usuário deve inserir seu nome, idade e email. 
O programa deve validar os dados inseridos e exibir mensagens de erro caso os dados sejam inválidos. 
Caso os dados sejam válidos, o programa deve exibir uma mensagem de sucesso.
*/ 

import java.util.Scanner;

public class Exercicio{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o seu email: ");
        scanner.nextLine();
        String email = scanner.nextLine();
        
        if (nome.equals("")){
            System.out.println("\nNome inválido, tente novamente.\n");
        } 
        else if (idade <= 0){
            System.out.println("\nIdade inválida, tente novamente.\n");
        } 
        else if (!email.contains("@")){
            System.out.println("\nEmail inválido, tente novamente.\n");
        } 
        else {
            System.out.println("\nUsuário cadastrado com sucesso!\n");
        }
        scanner.close();
    }
}

/* 
System.out.println(nome.equals("")); Verifica se é igual a uma condição
System.out.println(nome.contains("")); Verifica se contem algo em uma string
*/ 
