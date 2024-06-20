package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;

public class Leiloes {
    private ArrayList<LeilaoManual> leiloes;

    public Leiloes () {
        this.leiloes = new ArrayList<>();
    }

    public void add (LeilaoManual leilao) {
        leiloes.add(leilao);
    }

    public int tamanho () {
        return leiloes.size();
    }

    public Leilao recupera (int id) {
        return leiloes.get(id);
    }

}
