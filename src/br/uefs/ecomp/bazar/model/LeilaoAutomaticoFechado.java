package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;

public class LeilaoAutomaticoFechado extends Leilao {

    private ArrayList<Lance> lances = new ArrayList<>();

    public LeilaoAutomaticoFechado(double precoMinimo, double incrementoMinimo, Usuario vendedor, Produto produto) {
        super(precoMinimo, incrementoMinimo, vendedor, produto);
    }

    @Override
    public void darLanceMinimo() {
        double lanceMinimo = precoMinimo + incrementoMinimo;
        Lance lance = new Lance(lanceMinimo, participantesCadastrados.get(0)); // Primeiro participante cadastrado
        lances.add(lance);
        ultimoLance = lance;
        precoMinimo += incrementoMinimo;
    }

    @Override
    public boolean darLance(Usuario participante, double valor) {
        if (valor > ultimoLance.getValor() && valor >= precoMinimo) {
            Lance lance = new Lance(valor, participante);
            lances.add(lance);
            ultimoLance = lance;
            precoMinimo = valor + incrementoMinimo;
            return true;
        }
        return false;
    }
}
