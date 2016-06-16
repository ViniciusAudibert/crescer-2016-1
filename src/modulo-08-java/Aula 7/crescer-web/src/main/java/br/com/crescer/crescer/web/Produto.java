package br.com.crescer.crescer.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author vinicius.audibert
 */
@ManagedBean
@ViewScoped
public class Produto implements Serializable {

    private String nome;
    private int qtd;
    private String descricao;

    private static ArrayList<Produto> produtoList = new ArrayList<Produto>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto() {
    }

    
    
    public Produto(String nome, int qtd, String descricao) {
        this.nome = nome;
        this.qtd = qtd;
        this.descricao = descricao;
    }

    public static ArrayList<Produto> getProdutoList() {
        return produtoList;
    }

    public void addToList(String nome, int qtd, String desc) {
        Produto.produtoList.add(new Produto(nome, qtd, desc));
    }

    public static void setProdutoList(ArrayList<Produto> produtoList) {
        Produto.produtoList = produtoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
