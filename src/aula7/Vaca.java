package aula7;

public class Vaca extends Animal {

    public Vaca (String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emiteSom(){
        System.out.println(nome + " fez Muuuu!");
    }
}