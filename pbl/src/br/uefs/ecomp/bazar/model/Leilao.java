package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Leilao {

    protected double precoMinimo;
    protected double incrementoMinimo;
    protected Usuario vendedor;
    protected Produto produto;
    protected int status;
    protected ArrayList<Usuario> participantesCadastrados = new ArrayList<>();
    protected Lance ultimoLance;
    protected Venda venda;
    protected Calendar horaInicio;
    protected Calendar horaTermino;

    public static final int CADASTRADO = 0;
    public static final int INICIADO = 1;
    public static final int ENCERRADO = 2;

    public Leilao(double precoMinimo, double incrementoMinimo, Usuario vendedor, Produto produto) {
        this.precoMinimo = precoMinimo;
        this.incrementoMinimo = incrementoMinimo;
        this.vendedor = vendedor;
        this.produto = produto;
        this.status = CADASTRADO;
    }

    public double getIncrementoMinimo() {
        return incrementoMinimo;
    }

    public int getStatus() {
        return status;
    }

    public Lance getUltimoLance() {
        return ultimoLance;
    }

    public Venda getVenda() {
        return venda;
    }

    public void cadastrarParticipante(Usuario participante) {
        participantesCadastrados.add(participante);
    }

    public abstract void darLanceMinimo() throws LanceInvalidoException;

    public abstract boolean darLance(Usuario participante, double valor);

    public void iniciar() {
        if (status == CADASTRADO) {
            status = INICIADO;
            horaInicio = Calendar.getInstance();
        }
    }

    public void encerrar() {
        if (status == INICIADO) {
            status = ENCERRADO;
            horaTermino = Calendar.getInstance();
        }
    }
}
