package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.LivroController;
import dao.LivroDAO;

public class Livro {
    private int codigo;
    private String nome;
    private double preco;
    private String genero;

    public Livro(int codigo, String nome, double preco, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.genero = genero;
    }

    public Livro() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Livro> getLivro() {
        LivroDAO p = new LivroDAO();
        return p.getLivro();

    }

    public boolean RemoverLivro(int cod) {
        boolean verificador = false;
        ArrayList<Livro> lista = carregarLivros();
        Livro p = LivroController.ProcurarLivro(cod);
        LivroDAO pd = new LivroDAO();
        try {
            pd.excluir(p);
            verificador = true;
        } catch (Exception e) {

        }
        return verificador;

    }

    //public boolean editarLivro(int cod) {
        //boolean verificador = false;
        //LivroDAO p = new LivroDAO();
        //try {
            //p.editar(cod);
            //verificador = true;
        //} catch (Exception e) {

        //}
        //return verificador;
    //}

    public boolean cadastrarLivro(Livro Livro) {
        boolean verificador = false;
        try {
            LivroDAO p = new LivroDAO();
            p.cadastrarLivro(Livro);
            verificador = true;
        } catch (Exception e) {

        }
        return verificador;
    }

    public ArrayList<Livro> carregarLivros() {

        LivroDAO p = new LivroDAO();
        return p.getLivro();
    }

    public static Livro procurarLivro(int cod) {
        Livro p = new Livro();
        ArrayList<Livro> lista = p.getLivro();
        for (Livro pe : lista) {
            if (pe.getCodigo() == cod) {
                return pe;
            } else {

            }

        }
        JOptionPane.showMessageDialog(null, "ID do Livro não encontrado");
        return null;
    }

}
