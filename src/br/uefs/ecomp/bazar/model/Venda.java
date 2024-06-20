package br.uefs.ecomp.bazar.model;

public class Venda {
    private Produto produto;
    private double valor;
    private Usuario comprador;
    private Usuario vendedor;
    private LeilaoManual leilao;

    public Venda(double valor, Usuario comprador, Usuario vendedor, Produto produto, LeilaoManual leilao) {
        this.valor = valor;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.produto = produto;
        this.valor = valor;
        this.leilao = leilao;
    }

    public double getValor() {
        return valor;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public LeilaoManual getLeilao() {
        return leilao;
    }

    public Produto getProduto() {
        return produto;
    }
}
