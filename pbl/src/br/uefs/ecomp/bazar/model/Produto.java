package br.uefs.ecomp.bazar.model;

import java.util.Objects;

public class Produto {
    private String tipo;
    private String descricaoDetalhada;
    private String descricaoResumida;
    private Usuario vendedor;
    private boolean vendido;

    public Produto(String tipo, String descricaoResumida, String descricaoDetalhada, Usuario vendedor) {
        this.tipo = tipo;
        this.descricaoDetalhada = descricaoDetalhada;
        this.descricaoResumida = descricaoResumida;
        this.vendedor = vendedor;
        this.vendido = false;
    }

    public String getTipo(){
        return tipo;
    }

    public String getDescricaoResumida(){
        return descricaoResumida;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido() {
        vendido = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(tipo, produto.tipo) &&
               Objects.equals(descricaoResumida, produto.descricaoResumida) &&
               Objects.equals(descricaoDetalhada, produto.descricaoDetalhada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, descricaoResumida, descricaoDetalhada);
    }
}
