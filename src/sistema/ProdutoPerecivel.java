package sistema;

public class ProdutoPerecivel extends Produto {
    protected boolean produtoPerecivel;
    protected String validade;
    protected String garantia;

    public ProdutoPerecivel(
        String nome, 
        double preco, 
        int quantidade, 
        String categoria,
        boolean produtoPerecivel,
        String validade,
        String garantia
    ) {
        super(nome, preco, quantidade, categoria);
        this.produtoPerecivel = produtoPerecivel;
        this.validade = validade;
        this.garantia = garantia;
    }

    public boolean getProdutoPerecivel() {
        return produtoPerecivel;
    }
    public void setProdutoPerecivel(boolean produtoPerecivel) {
        this.produtoPerecivel = produtoPerecivel;
    }

    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getGarantia() {
        return garantia;
    }
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
}
