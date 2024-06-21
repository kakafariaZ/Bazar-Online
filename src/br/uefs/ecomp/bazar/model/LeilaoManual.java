package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import java.util.ArrayList;

public class LeilaoManual extends Leilao {

    private double valorAtual;
    private ArrayList<Lance> lances = new ArrayList<>();
    private ArrayList<Usuario> participantes = new ArrayList<Usuario>();

    public LeilaoManual(double precoMinimo, double incrementoMinimo, Usuario vendedor, Produto produto) {
        super(precoMinimo, incrementoMinimo, vendedor, produto);
        this.valorAtual = precoMinimo;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void iniciar() {
        if (status == CADASTRADO) {
            this.status = INICIADO;
        }
    }

    @Override
    public void encerrar() {
        if (status == INICIADO) {
            this.status = ENCERRADO;
            if (!lances.isEmpty()) {
                ultimoLance = getUltimoLance();
                venda = new Venda(ultimoLance.getValor(), vendedor, ultimoLance.getParticipante(), produto, this);
                produto.setVendido();
            }
        }
    }

    @Override
    public void darLanceMinimo() {
        double novoValor = valorAtual + incrementoMinimo;
        Lance lance = new Lance(novoValor, participantes.get(0));
        lances.add(lance);
        valorAtual = novoValor;
    }

    @Override
    public void cadastrarParticipante(Usuario participante) {
        participantes.add(participante);
    }

    @Override
    public Lance getUltimoLance() {
        if (lances.isEmpty()) {
            return null;
        }
        return lances.get(lances.size() - 1);
    }

    @Override
    public double getIncrementoMinimo() {
        return incrementoMinimo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    @Override
    public boolean darLance(Usuario participante, double valor) {
        try {
            if (status != INICIADO || !participantesCadastrados.contains(participante)) {
                throw new LanceInvalidoException("Usuário não pode dar lance.");
            }
            if (valor > valorAtual + incrementoMinimo) {
                Lance lance = new Lance(valor, participante);
                lances.add(lance);
                valorAtual = valor;
                return true;
            }
            return false;
        } catch (LanceInvalidoException e) {
            return false;
        }
    }

    @Override
    public Venda getVenda() {
        return venda;
    }
}
