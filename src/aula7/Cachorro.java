package aula7;

public class Cachorro extends Animal {

    public Cachorro (String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emiteSom(){
        System.out.println(nome + " fez Au Au!");
    }

    public String getNome() {
        return nome;
    }
}