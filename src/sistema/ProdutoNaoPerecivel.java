package sistema;

public class ProdutoNaoPerecivel extends Produto {
    protected String garantia;

    public ProdutoNaoPerecivel(
        String nome, 
        double preco, 
        int quantidade, 
        String categoria,
        String garantia
    ) {
        super(nome, preco, quantidade, categoria);
        this.garantia = garantia;
    }

    public String getGarantia() {
        return this.garantia;
    }
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
}
