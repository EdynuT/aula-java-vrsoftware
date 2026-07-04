package sistema;

public class Categoria {
    String nomeCategoria;

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNome() { 
        return this.nomeCategoria; 
    }

    public void setNome(String nomeCategoria) { 
        this.nomeCategoria = nomeCategoria; 
    }
}
