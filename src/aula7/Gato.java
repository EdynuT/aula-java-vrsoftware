package aula7;

public class Gato extends Animal {

    public Gato (String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emiteSom(){
        System.out.println(nome + " fez Miau!");
    }
}