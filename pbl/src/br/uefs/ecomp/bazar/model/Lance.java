package br.uefs.ecomp.bazar.model;

public class Lance {
    private double valor;
    private Usuario participante;

    public Lance(double lance, Usuario participante) {
        this.valor = lance;
        this.participante = participante;
    }

    // Getters e Setters
    public double getValor() {
        return valor;
    }

    public Usuario getParticipante() {
        return participante;
    }
}
