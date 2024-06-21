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
import java.util.Iterator;

public class BazarFacade {

    ControllerBazar cb;

    public BazarFacade() {
        this.cb = new ControllerBazar();
    }

    //chamadas do cb do usuario
    public Usuario cadastrarUsuario(String login, String nome, String senha,
            String cpf, String endereco, String telefone) throws UsuarioNaoCadastrouException {
        return cb.cadastrarUsuario(login, nome, senha, cpf, endereco, telefone);
    }
    
    public Usuario fazerLogin(String login, String senha) throws LoginFalhouException {
        return cb.fazerLogin(login, senha);
    }

    public Produto cadastrarProduto(String tipo, String descricaoResumida,
            String descricaoDetalhada) throws ProdutoNaoCadastrouException {
        return cb.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
    }

    public Iterator listarProdutosCadastrados() {
        return this.cb.listarProdutosCadastrados();
    }

    public Leilao cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) {
        return this.cb.cadastrarLeilao(produto, precoMinimo, incrementoMinimo);
    }
    

    public void iniciarLeilao(Leilao leilao) {
        this.cb.iniciarLeilao(leilao);
    }

    public Iterator listarLeiloesIniciados() {
        return this.cb.listarLeiloesIniciados();
    }

    public void participarLeilao(Leilao leilao) {
        this.cb.participarLeilao(leilao);
    }

    public void darLanceMinimo() throws LanceInvalidoException {
        this.cb.darLanceMinimo();
    }

    public void darLance(double valor) throws LanceInvalidoException {
        this.cb.darLance(valor);
    }

    public Venda encerrarLeilao() {
        return this.cb.encerrarLeilao();
    }
}
