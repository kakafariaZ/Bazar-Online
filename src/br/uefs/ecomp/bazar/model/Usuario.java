package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Usuario {

    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Leilao leilao;
    private Leilao leilaoAtivo;
    private Leilao participacaoLeilao;

    public Usuario(String login, String nome, String senha, String cpf, String endereco, String telefone) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Produto getUltimoProduto() {
        return produtos.get(produtos.size() - 1);
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public Leilao getLeilaoAtivo() {
        return leilaoAtivo;
    }

    //Metodos
    public Iterator<Produto> listarProdutosCadastrados() {
        return produtos.iterator();
    }

    public void cadastrarProduto(String tipo, String descricaoResumida, String descricao) {
        Produto produto = new Produto(tipo, descricaoResumida, descricao, this);
        produtos.add(produto);
    }

    public Leilao cadastrarLeilaoManual(double valor, double incremento, Produto produto) {
        this.leilao = new LeilaoManual(valor, incremento, this, produto);
        return leilao;
    }

    public void iniciarLeilao(Leilao leilao) {
        leilao.iniciar();
    }

    public Venda encerrarLeilaoAtivo() {
        if (leilao.getStatus() == Leilao.INICIADO) {
            leilao.encerrar();
            return leilao.getVenda();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Usuario usuario = (Usuario) o;

        return login.equals(usuario.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    public void participarLeilao(Leilao leilao) {
        leilao.cadastrarParticipante(this);
        this.participacaoLeilao = leilao;
    }

    public void darLanceMinimo() throws LanceInvalidoException {
        if (participacaoLeilao != null) {
            participacaoLeilao.darLanceMinimo();
        } else {
            throw new LanceInvalidoException("Não há leilão ativo para dar lance mínimo.");
        }
    }
}
