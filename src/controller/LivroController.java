package controller;

import javax.swing.JOptionPane;

import model.Livro;

public class LivroController {
private Livro l ;
    
    
    //Public ArrayList<Livro> Object carregarLivros(){
       // Livro l = (Livro) new livro();
        //return ((model.Livro) l).carregarLivros();
    //}

    public static Livro ProcurarLivro(int cod){
        Livro l = new Livro();
        return l.procurarLivro(cod);
    }
    
    public void RemoverLivro(int cod){
        Livro p = new Livro();
        boolean ver = p.RemoverLivro(cod);
        
        if(ver == true){
            JOptionPane.showMessageDialog(null, "Livro removido");
        } else{
            JOptionPane.showMessageDialog(null, "Ops! Erro na remoção do Livro");
        }
        
    }
    
    public void editarLivro(int cod){
        Livro p = new Livro();
        Livro ver = p.procurarLivro(cod);
        
        //if(ver == true){
            //JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso");
        //} else{
            //JOptionPane.showMessageDialog(null, "Ops! Erro na atualização do Livro");
       //}
        
    }
    
    public void cadastrarLivro(Livro Livro){
        Livro p = new Livro();
        boolean ver = p.cadastrarLivro(Livro);
        
        if(ver == true){
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
        } else{
            JOptionPane.showMessageDialog(null, "Ops! Erro no cadastro do Livro");
        }
    }
}
