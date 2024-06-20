package br.uefs.ecomp.bazar.facade;

import br.uefs.ecomp.bazar.model.ControllerBazar;
import br.uefs.ecomp.bazar.model.Leilao;
import br.uefs.ecomp.bazar.model.Produto;
import br.uefs.ecomp.bazar.model.Usuario;
import br.uefs.ecomp.bazar.model.Venda;
import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import br.uefs.ecomp.bazar.model.exception.LoginFalhouException;
import br.uefs.ecomp.bazar.model.exception.ProdutoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.UsuarioNaoCadastrouException;
import java.util.Date;
import java.util.Iterator;

public class BazarFacade {

    private ControllerBazar cb;

    public BazarFacade() {
        this.cb = new ControllerBazar();
    }

    public Usuario cadastrarUsuario(String login, String nome, String senha, String cpf, String endereco, String telefone) throws UsuarioNaoCadastrouException {
        return cb.cadastrarUsuario(login, nome, senha, cpf, endereco, telefone);
    }

    public Usuario fazerLogin(String login, String senha) throws LoginFalhouException {
        return cb.fazerLogin(login, senha);
    }

    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException {
        return cb.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
    }

    public Iterator<Produto> listarProdutosCadastrados() {
        return cb.listarProdutosCadastrados();
    }

    public Leilao cadastrarLeilao(Produto produto, double precoMinimo, double incrementoMinimo) throws IllegalArgumentException {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        return cb.cadastrarLeilao(produto, precoMinimo, incrementoMinimo);
    }

    public Leilao cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date inicio, Date termino) throws IllegalArgumentException {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (inicio == null || termino == null) {
            throw new IllegalArgumentException("Datas de início e término não podem ser nulas.");
        }
        Leilao leilao = new Leilao(produto, precoMinimo, incrementoMinimo, inicio, termino, true, true);
        cb.adicionarLeilao(leilao);  // Assumindo que ControllerBazar tem esse método
        return leilao;
    }

    public void iniciarLeilao(Leilao leilao) throws IllegalArgumentException, IllegalStateException {
        if (leilao == null) {
            throw new IllegalArgumentException("Leilão não pode ser nulo.");
        }
        cb.iniciarLeilao(leilao);
    }

    public Iterator<Leilao> listarLeiloesIniciados() {
        return cb.listarLeiloesIniciados();
    }

    public void participarLeilao(Leilao leilao) throws IllegalArgumentException, IllegalStateException {
        if (leilao == null) {
            throw new IllegalArgumentException("Leilão não pode ser nulo.");
        }
        cb.participarLeilao(leilao);
    }

    public void darLanceMinimo() throws LanceInvalidoException, IllegalStateException {
        cb.darLanceMinimo();
    }

    public void darLance(double valor) throws LanceInvalidoException, IllegalStateException {
        cb.darLance(valor);
    }

    public Venda encerrarLeilao() throws IllegalStateException {
        return cb.encerrarLeilao();
    }
}
