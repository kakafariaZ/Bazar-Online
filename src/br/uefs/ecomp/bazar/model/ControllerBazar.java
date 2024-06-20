package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import br.uefs.ecomp.bazar.model.exception.ProdutoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.UsuarioNaoCadastrouException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ControllerBazar {

    public HashMap<String, Usuario> usuarios = new HashMap<>();
    private ArrayList<Leilao> leiloesIniciados = new ArrayList<>();
    public ArrayList<Leilao> leiloes = new ArrayList<>();
    private Usuario usuarioLogado;

    // Método para cadastrar um novo usuário
    public Usuario cadastrarUsuario(String login, String nome, String senha, String cpf, String endereco, String telefone) throws UsuarioNaoCadastrouException {
        if (usuarios.containsKey(login)) {
            throw new UsuarioNaoCadastrouException("Usuário já cadastrado");
        } else {
            Usuario usuario = new Usuario(login, nome, senha, cpf, endereco, telefone);
            usuarios.put(usuario.getLogin(), usuario);
            return usuario;
        }
    }

    // Método para fazer login de um usuário
    public Usuario fazerLogin(String login, String senha) {
        Usuario usuario = usuarios.get(login);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            usuarioLogado = usuario;
            return usuarioLogado;
        }
        return null;
    }

    // Método para cadastrar um novo produto
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException {
        if (tipo == null || descricaoResumida == null || descricaoDetalhada == null) {
            throw new ProdutoNaoCadastrouException("Parâmetros não podem ser nulos.");
        }
        Produto produto = new Produto(tipo, descricaoResumida, descricaoDetalhada, usuarioLogado);
        usuarioLogado.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
        return produto;
    }

    // Método para listar produtos cadastrados pelo usuário logado
    public Iterator<Produto> listarProdutosCadastrados() {
        return usuarioLogado.listarProdutosCadastrados();
    }

    // Método para cadastrar um novo leilão
    public Leilao cadastrarLeilao(Produto produto, double precoMinimo, double incrementoMinimo) {
        if (produto == null || usuarioLogado == null) {
            throw new IllegalArgumentException("Produto ou usuário não pode ser nulo.");
        }
        Leilao leilao = new LeilaoManual(precoMinimo, incrementoMinimo, usuarioLogado, produto);
        leiloes.add(leilao);
        return leilao;
    }

    // Método para iniciar um leilão
    public void iniciarLeilao(Leilao leilao) {
        if (leilao != null && !leiloesIniciados.contains(leilao)) {
            leilao.iniciar();
            leiloesIniciados.add(leilao);
        }
    }

    // Método para listar leilões iniciados
    public Iterator<Leilao> listarLeiloesIniciados() {
        return leiloesIniciados.iterator();
    }

    // Método para o usuário logado participar de um leilão
    public void participarLeilao(Leilao leilao) {
        if (leilao != null) {
            leilao.cadastrarParticipante(usuarioLogado);
            usuarioLogado.participarLeilao(leilao);
        }
    }

    // Método para dar lance mínimo em um leilão
    public void darLanceMinimo() throws LanceInvalidoException {
        Leilao leilao = usuarioLogado.getLeilao();
        if (leilao == null) {
            throw new LanceInvalidoException("Leilão do usuário não foi iniciado corretamente.");
        } else {
            leilao.darLanceMinimo();
        }
    }

    // Método para dar um lance com valor específico em um leilão
    public void darLance(double valor) throws LanceInvalidoException {
        Leilao leilao = usuarioLogado.getLeilao();
        if (leilao != null) {
            if (!leilao.darLance(usuarioLogado, valor)) {
                throw new LanceInvalidoException("Lance inválido.");
            }
        } else {
            throw new LanceInvalidoException("Leilão do usuário não foi iniciado corretamente.");
        }
    }

    // Método para encerrar um leilão ativo do usuário logado
    public Venda encerrarLeilao() {
        return usuarioLogado.encerrarLeilaoAtivo();
    }
}
